package com.savik.parser.hockey.coeffs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.savik.CoeffContainer;
import com.savik.coeffs.hockey.CoeffBlock;
import com.savik.hockey.model.HockeyFutureMatch;
import com.savik.hockey.repository.HockeyMatchRepository;
import com.savik.hockey.repository.HockeyTeamRepository;
import com.savik.parser.Downloader;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import static com.savik.ContainerType.*;


@Service
public class Hockey1xstavkaCoeffsMatchParser {

    @Autowired
    HockeyTeamRepository hockeyTeamRepository;

    @Autowired
    HockeyMatchRepository hockeyMatchRepository;

    @Autowired
    Downloader downloader;

    @Autowired
    HockeyDownloaderConfiguration hockeyDownloaderConfiguration;

    @Autowired
    ObjectMapper objectMapper;

    public void parse(HockeyFutureMatch hockeyFutureMatch) throws IOException {

        String json = downloader.getJson("https://1xecu.xyz/LineFeed/GetChampZip?lng=ru&champ=30619&tf=3000000&afterDays=0&tz=0&sport=2&country=1");
        JSONObject jsonObject = new JSONObject(json);
        Set<BookFutureMatchRepresentation> list = objectMapper.readValue(
                jsonObject.getJSONObject("Value").getJSONArray("G").toString(),
                new TypeReference<Set<BookFutureMatchRepresentation>>() {
                }
        );


        for (BookFutureMatchRepresentation matchRepresentation : list) {
            String matchCoeffsJson = downloader.getJson("https://1xecu.xyz/LineFeed/GetGameZip?lng=ru&cfview=0&isSubGames=true&GroupEvents=true&countevents=250&grMode=2&id=" + matchRepresentation.getCi());
            JSONObject matchCoeffsObject = new JSONObject(matchCoeffsJson);

            Set<BookFutureMatchCoeff> futureMatchCoeffs = objectMapper.readValue(
                    matchCoeffsObject.getJSONObject("Value").getJSONArray("E").toString(),
                    new TypeReference<Set<BookFutureMatchCoeff>>() {
                    }
            );

            JSONArray jsonArray = matchCoeffsObject.getJSONObject("Value").getJSONArray("GE");
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
            CoeffBlock coeffBlock = new CoeffBlock();
            fill(futureMatchCoeffs, coeffBlock);
            String a = "";

        }

        String a = "";

    }

    private void fill(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer rootContainer) {
        fillTotalBlock(futureMatchCoeffs, rootContainer.findByType(TOTAL));
        fillOtherBlock(futureMatchCoeffs, rootContainer.findByType(OTHER));
    }

    private void fillTotalBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer totalContainer) {
        fillTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TOTAL_OVER),
                totalContainer.findByType(TOTAL_OVER));
        fillTotalUnderBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TOTAL_UNDER),
                totalContainer.findByType(TOTAL_UNDER));
        fillBothTeamsTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.BOTH_TEAMS_TOTAL_OVER_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.BOTH_TEAMS_TOTAL_OVER_NO),
                totalContainer.findByType(BOTH_TEAMS_TOTAL_OVER));
        fillBothTeamsTotalUnderBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.BOTH_TEAMS_TOTAL_UNDER_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.BOTH_TEAMS_TOTAL_UNDER_NO),
                totalContainer.findByType(BOTH_TEAMS_TOTAL_UNDER));

        fillTeamTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_TOTAL_OVER),
                totalContainer.findByType(TEAM_TOTAL_OVER));

        fillTeamTotalUnderBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_TOTAL_UNDER),
                totalContainer.findByType(TEAM_TOTAL_UNDER));

        fillTeamTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_TOTAL_OVER),
                totalContainer.findByType(OPPOSING_TEAM_TOTAL_OVER));

        fillTeamTotalUnderBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_TOTAL_UNDER),
                totalContainer.findByType(OPPOSING_TEAM_TOTAL_UNDER));

    }

    private void fillTotalOverBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer totalOverContainer) {
        for (BookFutureMatchCoeff bookFutureMatchCoeff : futureMatchCoeffs) {
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_4_5), "4.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_5_5), "5.5");
        }
    }

    private void fillTotalUnderBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer totalUnderContainer) {
        for (BookFutureMatchCoeff bookFutureMatchCoeff : futureMatchCoeffs) {
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalUnderContainer.findByType(UNDER_4_5), "4.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalUnderContainer.findByType(UNDER_5_5), "5.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalUnderContainer.findByType(UNDER_6_5), "6.5");
        }
    }

    private void fillBothTeamsTotalOverBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                             Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                              CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_1_5), "1.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_2_5), "2.5")
        );
    }

    private void fillBothTeamsTotalUnderBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                              Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                              CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(UNDER_2_5), "2.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(UNDER_3_5), "3.5")
        );
    }

    private void fillTeamTotalOverBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer teamTotalOverContainer) {
        for (BookFutureMatchCoeff bookFutureMatchCoeff : futureMatchCoeffs) {
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, teamTotalOverContainer.findByType(OVER_1_5), "1.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, teamTotalOverContainer.findByType(OVER_2_5), "2.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, teamTotalOverContainer.findByType(OVER_3_5), "3.5");
        }
    }

    private void fillTeamTotalUnderBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer teamTotalOverContainer) {
        for (BookFutureMatchCoeff bookFutureMatchCoeff : futureMatchCoeffs) {
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, teamTotalOverContainer.findByType(UNDER_1_5), "1.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, teamTotalOverContainer.findByType(UNDER_2_5), "2.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, teamTotalOverContainer.findByType(UNDER_3_5), "3.5");
        }
    }

    private void fillOtherBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer totalContainer) {
        fillTotalOverInAllPeriodsBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TOTAL_OVER_ALL_PERIODS),
                totalContainer.findByType(TOTAL_OVER_ALL_PERIODS));

        fillTotalUnderInAllPeriodsBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TOTAL_UNDER_ALL_PERIODS_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TOTAL_UNDER_ALL_PERIODS_NO),
                totalContainer.findByType(TOTAL_UNDER_ALL_PERIODS));

        fillTeamWinAndTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_WIN_AND_TOTAL_OVER_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_WIN_AND_TOTAL_OVER_NO),
                totalContainer.findByType(TEAM_WIN_AND_TOTAL_OVER));

        fillTeamWinAndTotalUnderBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_WIN_AND_TOTAL_UNDER_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_WIN_AND_TOTAL_UNDER_NO),
                totalContainer.findByType(TEAM_WIN_AND_TOTAL_UNDER));

        fillTeamWinAndTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_NOT_LOOSE_AND_TOTAL_OVER_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_NOT_LOOSE_AND_TOTAL_OVER_NO),
                totalContainer.findByType(TEAM_NOT_LOOSE_AND_TOTAL_OVER));

        fillTeamWinAndTotalUnderBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_NOT_LOOSE_AND_TOTAL_UNDER_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_NOT_LOOSE_AND_TOTAL_UNDER_NO),
                totalContainer.findByType(TEAM_NOT_LOOSE_AND_TOTAL_UNDER));

        fillTeamWinAndTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_WIN_AND_TOTAL_OVER_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_WIN_AND_TOTAL_OVER_NO),
                totalContainer.findByType(OPPOSING_TEAM_WIN_AND_TOTAL_OVER));

        fillTeamWinAndTotalUnderBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_WIN_AND_TOTAL_UNDER_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_WIN_AND_TOTAL_UNDER_NO),
                totalContainer.findByType(OPPOSING_TEAM_WIN_AND_TOTAL_UNDER));

        fillTeamWinAndTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_NOT_LOOSE_AND_TOTAL_OVER_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_NOT_LOOSE_AND_TOTAL_OVER_NO),
                totalContainer.findByType(OPPOSING_TEAM_NOT_LOOSE_AND_TOTAL_OVER));

        fillTeamWinAndTotalUnderBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_NOT_LOOSE_AND_TOTAL_UNDER_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_NOT_LOOSE_AND_TOTAL_UNDER_NO),
                totalContainer.findByType(OPPOSING_TEAM_NOT_LOOSE_AND_TOTAL_UNDER));


        fillTeamTotalOverInAllPeriodsBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_TOTAL_OVER_ALL_PERIODS_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_TOTAL_OVER_ALL_PERIODS_NO),
                totalContainer.findByType(TEAM_TOTAL_OVER_ALL_PERIODS));

        fillTeamTotalOverInAllPeriodsBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_TOTAL_OVER_ALL_PERIODS_YES),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_TOTAL_OVER_ALL_PERIODS_NO),
                totalContainer.findByType(OPPOSING_TEAM_TOTAL_OVER_ALL_PERIODS));



    }

    private void fillTotalOverInAllPeriodsBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer container) {
        for (BookFutureMatchCoeff bookFutureMatchCoeff : futureMatchCoeffs) {
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, container.findByType(OVER_0_5), "0.5");
        }
    }

    private void fillTotalUnderInAllPeriodsBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                             Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                             CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(UNDER_2_5), "2.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(UNDER_3_5), "3.5")
        );
    }

    private void fillTeamWinAndTotalOverBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                             Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                             CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_4_5), "4.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_5_5), "5.5")
        );
    }

    private void fillTeamWinAndTotalUnderBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                             Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                             CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(UNDER_4_5), "4.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(UNDER_5_5), "5.5")
        );
    }

    private void fillTeamTotalOverInAllPeriodsBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                               Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                               CoeffContainer container) {
        setYesOrNoCoeff(futureMatchPosCoeffs, futureMatchNegCoeffs, container.findByType(OVER_0_5));
    }

    private void fillPosAndNegContainer(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                        Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                        BiConsumer<BookFutureMatchCoeff, BookFutureMatchCoeff> ... biConsumers) {
        for (BookFutureMatchCoeff posCoeff : futureMatchPosCoeffs) {
            Optional<BookFutureMatchCoeff> negativeCoeff = futureMatchNegCoeffs.stream()
                    .filter(negCoeff -> negCoeff.getKind().equals(posCoeff.getKind())).findFirst();
            if(negativeCoeff.isPresent()) {
                for (BiConsumer<BookFutureMatchCoeff, BookFutureMatchCoeff> biConsumer : biConsumers) {
                    biConsumer.accept(posCoeff, negativeCoeff.get());
                }
            } else {
                System.out.printf("strange %s - %s", posCoeff.getId(), posCoeff.getKind());
            }
        }
    }

    private void setYesOrNoCoeff(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                        Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                        CoeffContainer container) {
        if(futureMatchNegCoeffs.size() != 1 ||  futureMatchNegCoeffs.size() != 1) {
            throw new RuntimeException("size should be equals 1");
        }
        BookFutureMatchCoeff posCoeff = futureMatchPosCoeffs.stream().findFirst().get();
        BookFutureMatchCoeff negCoeff = futureMatchNegCoeffs.stream().findFirst().get();
        container.getCoeff().set(
                Double.valueOf(posCoeff.getCoeff()), Double.valueOf(negCoeff.getCoeff())
        );
    }

    private void checkIfContainsKindAndSetCoeff(BookFutureMatchCoeff futureMatchCoeff, CoeffContainer coeffContainer, String option) {
        if (futureMatchCoeff.getKind().equals(option)) {
            coeffContainer.getCoeff().set(Double.valueOf(futureMatchCoeff.getCoeff()));
        }
    }

    private void checkIfContainsKindAndSetPosAndNegCoeff(BookFutureMatchCoeff posCoeff, BookFutureMatchCoeff negCoeff,
                                                         CoeffContainer coeffContainer, String option) {
        if (posCoeff.getKind().equals(option) && negCoeff.getKind().equals(option)) {
            coeffContainer.getCoeff().set(Double.valueOf(posCoeff.getCoeff()), Double.valueOf(negCoeff.getCoeff()));
        }
    }

    private Set<BookFutureMatchCoeff> findByShortNameId(Set<BookFutureMatchCoeff> futureMatchCoeffs, String id) {
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
    static class BookFutureMatchCoeff {

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

