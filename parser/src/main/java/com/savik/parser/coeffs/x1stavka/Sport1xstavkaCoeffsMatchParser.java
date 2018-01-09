package com.savik.parser.coeffs.x1stavka;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.savik.CoeffContainer;
import com.savik.FutureMatch;
import com.savik.parser.Downloader;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import static com.savik.parser.coeffs.x1stavka.Book1xbetConstants.EVENT_URL;


@Service
public abstract class Sport1xstavkaCoeffsMatchParser {

    @Autowired
    Downloader downloader;

    @Autowired
    ObjectMapper objectMapper;

    public CoeffContainer parse(FutureMatch hockeyFutureMatch, String leagueUrl, CoeffContainer coeffContainer) throws IOException {

        String json = downloader.getJson(leagueUrl);
        JSONObject jsonObject = new JSONObject(json);
        Set<BookFutureMatchRepresentation> list = objectMapper.readValue(
                jsonObject.getJSONObject("Value").getJSONArray("G").toString(),
                new TypeReference<Set<BookFutureMatchRepresentation>>() {
                }
        );

        for (BookFutureMatchRepresentation matchRepresentation : list) {
            if (matchRepresentation.o1.contains(hockeyFutureMatch.getHomeTeam().getName()) && matchRepresentation.o2.contains(hockeyFutureMatch.getGuestTeam().getName())) {
                try {
                    String matchCoeffsJson = downloader.getJson(EVENT_URL + matchRepresentation.getCi());
                    JSONObject matchCoeffsObject = new JSONObject(matchCoeffsJson);

                    Set<BookFutureMatchCoeff> futureMatchCoeffs = getBookFutureMatchCoeffs(matchCoeffsObject.getJSONObject("Value"));
                    fill(futureMatchCoeffs, coeffContainer);
                    fillSpecialGroups(matchCoeffsObject, coeffContainer);
                    return coeffContainer;
                } catch (Exception ex) {
                    throw new RuntimeException("error while parsing, myscore code = " + hockeyFutureMatch.getMyscoreCode(), ex);
                }

            }
        }
        throw new RuntimeException("match not found,  myscore code = " + hockeyFutureMatch.getMyscoreCode());
    }

    protected Set<BookFutureMatchCoeff> downloadAdditionalGroupCoeffs(JSONObject group) throws IOException {
        BookFutureMatchRepresentation groupJsonRepresentation = objectMapper.readValue(
                group.toString(),
                BookFutureMatchRepresentation.class
        );
        String groupResponseJson = downloader.getJson(EVENT_URL + groupJsonRepresentation.getCi());
        Set<BookFutureMatchCoeff> groupCoeffs = getBookFutureMatchCoeffs(
                new JSONObject(groupResponseJson).getJSONObject("Value")
        );
        return groupCoeffs;
    }

    protected Set<BookFutureMatchCoeff> getBookFutureMatchCoeffs(JSONObject value) throws IOException {
        Set<BookFutureMatchCoeff> futureMatchCoeffs = value.has("E") ? objectMapper.readValue(
                value.getJSONArray("E").toString(),
                new TypeReference<Set<BookFutureMatchCoeff>>() {
                }
        ) : new HashSet<>();

        JSONArray jsonArray = value.getJSONArray("GE");
        for (Object o : jsonArray) {
            JSONArray temp1 = ((JSONObject) o).getJSONArray("E");
            List<List<BookFutureMatchCoeff>> lists = objectMapper.readValue(
                    temp1.toString(),
                    new TypeReference<List<List<BookFutureMatchCoeff>>>() {
                    }
            );
            List<BookFutureMatchCoeff> addtionalCoeffs = lists.stream()
                    .flatMap(List::stream)
                    .collect(Collectors.toList());
            futureMatchCoeffs.addAll(addtionalCoeffs);
        }
        return futureMatchCoeffs;
    }

    public abstract void fill(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer rootContainer);

    public abstract void fillSpecialGroups(JSONObject matchCoeffsObject, CoeffContainer rootContainer) throws IOException;

    protected JSONObject findPeriod(JSONArray periods, String periodNumber) {
        for (Object period : periods) {
            JSONObject jsonObject = (JSONObject) period;
            if (jsonObject.has("PN") && jsonObject.getString("PN").contains(periodNumber)) {
                return jsonObject;
            }
        }
        return null;
    }

    protected JSONObject findSpecialGroupByTG(JSONArray periods, String tg) {
        for (Object period : periods) {
            JSONObject jsonObject = (JSONObject) period;
            if (jsonObject.has("TG") && jsonObject.getString("TG").contains(tg)) {
                return jsonObject;
            }
        }
        return null;
    }

    protected JSONObject findSpecialGroupByTGAndTN(JSONArray periods, String tg, String tn) {
        for (Object period : periods) {
            JSONObject jsonObject = (JSONObject) period;
            if (jsonObject.has("TG") && jsonObject.getString("TG").contains(tg)) {
                if ((tn == null && !jsonObject.has("TN")) ||
                        (tn != null && jsonObject.has("TN") && jsonObject.getString("TN").contains(tn))) {
                    return jsonObject;
                }
            }
        }
        return null;
    }


    protected void fillPosAndNegContainer(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                          Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                          BiConsumer<BookFutureMatchCoeff, BookFutureMatchCoeff>... biConsumers) {
        for (BookFutureMatchCoeff posCoeff : futureMatchPosCoeffs) {
            Optional<BookFutureMatchCoeff> negativeCoeff = futureMatchNegCoeffs.stream()
                    .filter(negCoeff -> negCoeff.getKind().equals(posCoeff.getKind())).findFirst();
            if (negativeCoeff.isPresent()) {
                for (BiConsumer<BookFutureMatchCoeff, BookFutureMatchCoeff> biConsumer : biConsumers) {
                    biConsumer.accept(posCoeff, negativeCoeff.get());
                }
            } else {
                System.out.println(String.format("strange %s - %s", posCoeff.getId(), posCoeff.getKind()));
            }
        }
    }

    protected void setYesOrNoCoeff(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                   Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                   CoeffContainer container) {
        if (futureMatchPosCoeffs.isEmpty() && futureMatchNegCoeffs.isEmpty()) {
            System.out.println("strange" + futureMatchPosCoeffs);
            return;
        } else if (futureMatchNegCoeffs.size() != 1 || futureMatchNegCoeffs.size() != 1) {
            throw new RuntimeException("size should be equals 1");
        }
        BookFutureMatchCoeff posCoeff = futureMatchPosCoeffs.stream().findFirst().get();
        BookFutureMatchCoeff negCoeff = futureMatchNegCoeffs.stream().findFirst().get();
        container.getCoeff().set(
                Double.valueOf(posCoeff.getCoeff()), Double.valueOf(negCoeff.getCoeff())
        );
    }

    protected void setYesCoeff(Set<BookFutureMatchCoeff> futureMatchPosCoeffs, CoeffContainer container) {
        if (futureMatchPosCoeffs.isEmpty()) {
            System.out.println("strange" + futureMatchPosCoeffs);
            return;
        } else if (futureMatchPosCoeffs.size() != 1) {
            throw new RuntimeException("size should be equals 1");
        }
        BookFutureMatchCoeff posCoeff = futureMatchPosCoeffs.stream().findFirst().get();
        container.getCoeff().set(
                Double.valueOf(posCoeff.getCoeff())
        );
    }

    protected void checkIfContainsKindAndSetCoeff(BookFutureMatchCoeff futureMatchCoeff, CoeffContainer coeffContainer, String option) {
        if (futureMatchCoeff.getKind().equals(option)) {
            if(coeffContainer.getCoeff().hasValue()) {
                return;
            }
            coeffContainer.getCoeff().set(Double.valueOf(futureMatchCoeff.getCoeff()));
        }
    }

    protected void checkIfContainsKindAndSetPosAndNegCoeff(BookFutureMatchCoeff posCoeff, BookFutureMatchCoeff negCoeff,
                                                           CoeffContainer coeffContainer, String option) {
        if (posCoeff.getKind().equals(option) && negCoeff.getKind().equals(option)) {
            coeffContainer.getCoeff().set(Double.valueOf(posCoeff.getCoeff()), Double.valueOf(negCoeff.getCoeff()));
        }
    }

    protected void checkIfPosContainsKindAndSetPosAndNegCoeff(BookFutureMatchCoeff posCoeff, BookFutureMatchCoeff negCoeff,
                                                              CoeffContainer coeffContainer, String option) {
        if (posCoeff.getKind().equals(option)) {
            coeffContainer.getCoeff().set(Double.valueOf(posCoeff.getCoeff()), Double.valueOf(negCoeff.getCoeff()));
        }
    }

    protected Set<BookFutureMatchCoeff> findByShortNameId(Set<BookFutureMatchCoeff> futureMatchCoeffs, String id) {
        return futureMatchCoeffs.stream().filter(c -> c.getId().equals(id)).collect(Collectors.toSet());
    }

    @Setter
    @Getter
    @NoArgsConstructor
    static class BookFutureMatchRepresentation {

        @JsonProperty(value = "CI", required = true)
        private String ci;

        @JsonProperty(value = "O1", required = true)
        private String o1;

        @JsonProperty(value = "O2", required = true)
        private String o2;
    }

    @Setter
    @Getter
    @NoArgsConstructor
    protected static class BookFutureMatchCoeff {

        @JsonProperty(value = "C", required = true)
        private String coeff;

        @JsonProperty("P")
        private String kind;

        @JsonProperty(value = "T", required = true)
        private String id;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            BookFutureMatchCoeff that = (BookFutureMatchCoeff) o;

            if (kind != null ? !kind.equals(that.kind) : that.kind != null) return false;
            return id.equals(that.id);
        }

        @Override
        public int hashCode() {
            int result = kind != null ? kind.hashCode() : 0;
            result = 31 * result + id.hashCode();
            return result;
        }
    }


}

