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


    public void fill(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer rootContainer) {
    }

    private void fillCornersBlock(Set<BookFutureMatchCoeff> futureMatchCoeffs, CoeffContainer totalContainer) {
        fillCornersTotalOverBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TOTAL_OVER),
                totalContainer.findByType(TOTAL_OVER));

        fillCornersTotalUnderBlock(findByShortNameId(futureMatchCoeffs, Book1xbetShortName.TOTAL_UNDER),
                totalContainer.findByType(TOTAL_UNDER));

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

    public void fillSpecialGroups(JSONObject matchCoeffsObject, CoeffContainer rootContainer) throws IOException {
        JSONArray specialGroups = matchCoeffsObject.getJSONObject("Value").getJSONArray("SG");


        JSONObject corners = findSpecialGroupByTG(specialGroups, "Угловые");
        if(corners != null) {
            fillCornersBlock(
                    getBookFutureMatchCoeffs(corners),
                    rootContainer.findByType(CORNERS)
            );
        }

    }


}

