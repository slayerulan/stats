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


        JSONObject corners = findSpecialGroupByTG(specialGroups, "Угловые");
        if (corners != null) {
            fillCornersBlock(
                    getBookFutureMatchCoeffs(corners),
                    rootContainer.findByType(CORNERS)
            );
        }

    }


    public void fill(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer rootContainer) {
    }

    private void fillCornersBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer cornersContainer) {
        fillCornersTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TOTAL_OVER),
                cornersContainer.findByType(TOTAL_OVER));

        fillCornersTotalUnderBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TOTAL_UNDER),
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
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_6_5), "6.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_7_5), "7.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_8_5), "8.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_9_5), "9.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_10_5), "10.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_11_5), "11.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(OVER_12_5), "12.5");
        }
    }

    private void fillCornersTotalUnderBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer totalOverContainer) {
        for (BookFutureMatchCoeff bookFutureMatchCoeff : futureMatchCoeffs) {
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_6_5), "6.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_7_5), "7.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_8_5), "8.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_9_5), "9.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_10_5), "10.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_11_5), "11.5");
            checkIfContainsKindAndSetCoeff(bookFutureMatchCoeff, totalOverContainer.findByType(UNDER_12_5), "12.5");
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


}

