package com.savik.parser.coeffs.x1stavka.football;

import com.savik.CoeffContainer;
import com.savik.parser.coeffs.x1stavka.Book1xbetShortName;
import com.savik.parser.coeffs.x1stavka.Sport1xstavkaCoeffsMatchParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Set;

import static com.savik.ContainerType.*;


@Service
public class Football1xstavkaCoeffsMatchParser extends Sport1xstavkaCoeffsMatchParser {

    public void fillSpecialGroups(JSONObject matchCoeffsObject, CoeffContainer rootContainer) throws IOException {
        JSONArray specialGroups = matchCoeffsObject.getJSONObject("Value").getJSONArray("SG");


        JSONObject matchCorners = findSpecialGroupByTGAndPN(specialGroups, "Угловые", null);
        if (matchCorners != null) {
            fillCornersBlock(
                    downloadAdditionalGroupCoeffs(matchCorners),
                    rootContainer.findByType(CORNERS).findByType(MATCH)
            );
        }

        JSONObject firstPeriodCorners = findSpecialGroupByTGAndPN(specialGroups, "Угловые", "1-й  Тайм");
        if (firstPeriodCorners != null) {
            fillCornersBlock(
                    downloadAdditionalGroupCoeffs(firstPeriodCorners),
                    rootContainer.findByType(CORNERS).findByType(FIRST_PERIOD)
            );
        }

        JSONObject secondPeriodCorners = findSpecialGroupByTGAndPN(specialGroups, "Угловые", "2-й  Тайм");
        if (secondPeriodCorners != null) {
            fillCornersBlock(
                    downloadAdditionalGroupCoeffs(secondPeriodCorners),
                    rootContainer.findByType(CORNERS).findByType(SECOND_PERIOD)
            );
        }

        JSONObject cards = findSpecialGroupByTGAndPN(specialGroups, "Желтые карточки", null);
        if (cards != null) {
            fillCardsBlock(
                    downloadAdditionalGroupCoeffs(cards),
                    rootContainer.findByType(CARDS).findByType(MATCH)
            );
        }

        JSONObject firstPeriodCards = findSpecialGroupByTGAndPN(specialGroups, "Желтые карточки", "1-й  Тайм");
        if (firstPeriodCards != null) {
            fillCardsBlock(
                    downloadAdditionalGroupCoeffs(firstPeriodCards),
                    rootContainer.findByType(CARDS).findByType(FIRST_PERIOD)
            );
        }

        JSONObject secondPeriodCards = findSpecialGroupByTGAndPN(specialGroups, "Желтые карточки", "2-й  Тайм");
        if (secondPeriodCards != null) {
            fillCardsBlock(
                    downloadAdditionalGroupCoeffs(secondPeriodCards),
                    rootContainer.findByType(CARDS).findByType(SECOND_PERIOD)
            );
        }

    }


    public void fill(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer rootContainer) {
    }

    private void fillCornersBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer cornersContainer) {
        fillCornersTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TOTAL_OVER),
                cornersContainer.findByType(TOTAL_OVER));

        fillCornersTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.THREE_WAY_TOTAL_OVER),
                cornersContainer.findByType(TOTAL_OVER));

        fillCornersTotalUnderBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TOTAL_UNDER),
                cornersContainer.findByType(TOTAL_UNDER));

        fillCornersTotalUnderBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.THREE_WAY_TOTAL_UNDER),
                cornersContainer.findByType(TOTAL_UNDER));

        fillTeamCornersTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_TOTAL_OVER),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_TOTAL_UNDER),
                cornersContainer.findByType(TEAM_TOTAL_OVER));

        fillTeamCornersTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_TOTAL_OVER),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_TOTAL_UNDER),
                cornersContainer.findByType(OPPOSING_TEAM_TOTAL_OVER));

        fillTeamCornersNotLoose(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_NOT_LOOSE),
                cornersContainer.findByType(TEAM_NOT_LOOSE));

        fillTeamCornersNotLoose(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_NOT_LOOSE),
                cornersContainer.findByType(OPPOSING_TEAM_NOT_LOOSE));

        fillTeamCornersHandicap(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_HANDICAP),
                cornersContainer.findByType(TEAM_HANDICAP));

        fillTeamCornersHandicap(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_HANDICAP),
                cornersContainer.findByType(OPPOSING_TEAM_HANDICAP));

    }

    private void fillCornersTotalOverBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer totalOverContainer) {
        for (BookFutureMatchCoeff bookFutureMatchCoeff : futureMatchCoeffs) {
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_3_5), "3.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_3_5), "3");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_4_5), "4.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_4_5), "4");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_5_5), "5.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_5_5), "5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_6_5), "6.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_6_5), "6");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_7_5), "7.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_7_5), "7");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_8_5), "8.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_8_5), "8");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_9_5), "9.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_9_5), "9");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_10_5), "10.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_10_5), "10");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_11_5), "11.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_11_5), "11");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_12_5), "12.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_12_5), "12");
        }
    }

    private void fillCornersTotalUnderBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer totalOverContainer) {
        for (BookFutureMatchCoeff bookFutureMatchCoeff : futureMatchCoeffs) {
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_4_5), "4.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_4_5), "5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_5_5), "5.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_5_5), "6");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_6_5), "6.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_6_5), "7");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_7_5), "7.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_7_5), "8");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_8_5), "8.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_8_5), "9");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_9_5), "9.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_9_5), "10");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_10_5), "10.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_10_5), "11");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_11_5), "11.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_11_5), "12");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_12_5), "12.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_12_5), "13");
        }
    }

    private void fillTeamCornersTotalOverBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                               Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                               CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_2_5), "2.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_3_5), "3.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_4_5), "4.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_5_5), "5.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_6_5), "6.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_7_5), "7.5")
        );
    }

    private void fillTeamCornersNotLoose(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer container) {
        setYesCoeff(futureMatchCoeffs, container);
    }

    private void fillTeamCornersHandicap(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer handicapContainer) {
        for (BookFutureMatchCoeff bookFutureMatchCoeff : futureMatchCoeffs) {
            if (bookFutureMatchCoeff.getKind() == null) {
                continue;
            }
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, handicapContainer.findByType(PLUS_4_5), "4.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, handicapContainer.findByType(PLUS_3_5), "3.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, handicapContainer.findByType(PLUS_2_5), "2.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, handicapContainer.findByType(PLUS_1_5), "1.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, handicapContainer.findByType(MINUS_1_5), "-1.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, handicapContainer.findByType(MINUS_2_5), "-2.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, handicapContainer.findByType(MINUS_3_5), "-3.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, handicapContainer.findByType(MINUS_4_5), "-4.5");
        }
    }

    private void fillCardsBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer cornersContainer) {
        fillYellowCardsWDTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TOTAL_OVER),
                cornersContainer.findByType(TOTAL_OVER));

        fillYellowCardsWDTotalUnderBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TOTAL_UNDER),
                cornersContainer.findByType(TOTAL_UNDER));


        fillTeamYellowCardsWDTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_TOTAL_OVER),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_TOTAL_UNDER),
                cornersContainer.findByType(TEAM_TOTAL_OVER));


        fillTeamYellowCardsWDTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_TOTAL_OVER),
                findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_TOTAL_UNDER),
                cornersContainer.findByType(OPPOSING_TEAM_TOTAL_OVER));

        fillTeamYellowCardsWDNotLoose(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_NOT_LOOSE),
                cornersContainer.findByType(TEAM_NOT_LOOSE));

        fillTeamYellowCardsWDNotLoose(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_NOT_LOOSE),
                cornersContainer.findByType(OPPOSING_TEAM_NOT_LOOSE));

        fillTeamYellowCardsWDHandicap(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TEAM_HANDICAP),
                cornersContainer.findByType(TEAM_HANDICAP));

        fillTeamYellowCardsWDHandicap(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.OPPOSING_TEAM_HANDICAP),
                cornersContainer.findByType(OPPOSING_TEAM_HANDICAP));

    }

    private void fillYellowCardsWDTotalOverBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer totalOverContainer) {
        for (BookFutureMatchCoeff bookFutureMatchCoeff : futureMatchCoeffs) {
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_3_5), "3.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_4_5), "4.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_5_5), "5.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_6_5), "6.5");
        }
    }

    private void fillYellowCardsWDTotalUnderBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer totalOverContainer) {
        for (BookFutureMatchCoeff bookFutureMatchCoeff : futureMatchCoeffs) {
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_3_5), "3.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_4_5), "4.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_5_5), "5.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_6_5), "6.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_7_5), "7.5");
        }
    }


    private void fillTeamYellowCardsWDTotalOverBlock(Set<BookFutureMatchCoeff> futureMatchPosCoeffs,
                                                     Set<BookFutureMatchCoeff> futureMatchNegCoeffs,
                                                     CoeffContainer container) {
        fillPosAndNegContainer(futureMatchPosCoeffs, futureMatchNegCoeffs,
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_1_5), "1.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_2_5), "2.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_3_5), "3.5"),
                (posCoeff, negCoeff) -> checkIfContainsKindAndSetPosAndNegCoeff(posCoeff, negCoeff, container.findByType(OVER_4_5), "4.5")
        );
    }

    private void fillTeamYellowCardsWDNotLoose(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer container) {
        setYesCoeff(futureMatchCoeffs, container);
    }

    private void fillTeamYellowCardsWDHandicap(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer handicapContainer) {
        for (BookFutureMatchCoeff bookFutureMatchCoeff : futureMatchCoeffs) {
            if (bookFutureMatchCoeff.getKind() == null) {
                continue;
            }
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, handicapContainer.findByType(PLUS_3_5), "3.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, handicapContainer.findByType(PLUS_2_5), "2.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, handicapContainer.findByType(PLUS_1_5), "1.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, handicapContainer.findByType(MINUS_1_5), "-1.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, handicapContainer.findByType(MINUS_2_5), "-2.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, handicapContainer.findByType(MINUS_3_5), "-3.5");
        }
    }


}

