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
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
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
        List<BookFutureMatchRepresentation> list = objectMapper.readValue(
                jsonObject.getJSONObject("Value").getJSONArray("G").toString(),
                new TypeReference<List<BookFutureMatchRepresentation>>() {
                }
        );


        for (BookFutureMatchRepresentation matchRepresentation : list) {
            String matchCoeffsJson = downloader.getJson("https://1xecu.xyz/LineFeed/GetGameZip?lng=ru&cfview=0&isSubGames=true&GroupEvents=true&countevents=250&grMode=2&id=" + matchRepresentation.getCi());
            JSONObject matchCoeffsObject = new JSONObject(matchCoeffsJson);

            List<BookFutureMatchCoeff> futureMatchCoeffs = objectMapper.readValue(
                    matchCoeffsObject.getJSONObject("Value").getJSONArray("E").toString(),
                    new TypeReference<List<BookFutureMatchCoeff>>() {
                    }
            );
            CoeffBlock coeffBlock = new CoeffBlock();
            fill(futureMatchCoeffs, coeffBlock);
            String a = "";

        }

        String a = "";

    }

    void fill(List<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer rootContainer) {
        fillTotalBlock(futureMatchCoeffs, rootContainer.findByType(TOTAL));
    }

    void fillTotalBlock(List<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer totalContainer) {
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

    private void fillTotalOverBlock(List<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer totalOverContainer) {
        for (BookFutureMatchCoeff bookFutureMatchCoeff : futureMatchCoeffs) {
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_4_5), "4.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_5_5), "5.5");
        }
    }

    private void fillTotalUnderBlock(List<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer totalUnderContainer) {
        for (BookFutureMatchCoeff bookFutureMatchCoeff : futureMatchCoeffs) {
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalUnderContainer.findByType(UNDER_4_5), "4.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalUnderContainer.findByType(UNDER_5_5), "5.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalUnderContainer.findByType(UNDER_6_5), "6.5");
        }
    }

    private void fillBothTeamsTotalOverBlock(List<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                              List<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                              CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_1_5), "1.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_2_5), "2.5")
        );
    }

    private void fillBothTeamsTotalUnderBlock(List<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                              List<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                              CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(UNDER_2_5), "2.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(UNDER_3_5), "3.5")
        );
    }

    private void fillTeamTotalOverBlock(List<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer teamTotalOverContainer) {
        for (BookFutureMatchCoeff bookFutureMatchCoeff : futureMatchCoeffs) {
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, teamTotalOverContainer.findByType(OVER_1_5), "1.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, teamTotalOverContainer.findByType(OVER_2_5), "2.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, teamTotalOverContainer.findByType(OVER_3_5), "3.5");
        }
    }

    private void fillTeamTotalUnderBlock(List<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer teamTotalOverContainer) {
        for (BookFutureMatchCoeff bookFutureMatchCoeff : futureMatchCoeffs) {
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, teamTotalOverContainer.findByType(UNDER_1_5), "1.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, teamTotalOverContainer.findByType(UNDER_2_5), "2.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, teamTotalOverContainer.findByType(UNDER_3_5), "3.5");
        }
    }

    private void fillPosAndNegContainer(List<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                        List<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                        BiConsumer<BookFutureMatchCoeff, BookFutureMatchCoeff> ... biConsumers) {
        for (int i = 0; i < futureMatchPosCoeffs.size(); i++) {
            BookFutureMatchCoeff posCoeff = futureMatchPosCoeffs.get(i);
            BookFutureMatchCoeff negCoeff = futureMatchNegCoeffs.get(i);
            if(posCoeff.getKind().equals(negCoeff.getKind())) {
                for (BiConsumer<BookFutureMatchCoeff, BookFutureMatchCoeff> biConsumer : biConsumers) {
                    biConsumer.accept(posCoeff, negCoeff);
                }
            } else {
                System.out.printf("strange %s - %s, %s - %s",
                        posCoeff.getId(), posCoeff.getKind(), negCoeff.getId(), negCoeff.getKind());
            }

        }
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

    private List<BookFutureMatchCoeff> findByShortNameId(List<BookFutureMatchCoeff> futureMatchCoeffs, String id) {
        return futureMatchCoeffs.stream().filter(c -> c.getId().equals(id)).collect(Collectors.toList());
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
    }


}

