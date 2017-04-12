/*
 * Copyright (c) 2017, AT-Consulting. All Rights Reserved.
 * Use is subject to license terms.
 */

package football;

import java.util.List;
import java.util.stream.Collectors;

import football.model.Card;
import lombok.*;
import org.jsoup.select.Elements;

/**
 * @author Savushkin Yauheni
 * @since 12.04.2017
 */
public class MatchParser {

    public static Dto parseGeneralInfo(Elements elements) {

        return new Dto(parseGoals(elements.select("div.soccer-ball")), null);
    }

    static List<Integer> parseGoals(Elements goalsDivs) {
        return goalsDivs
                .stream()
                .map(d -> Integer.valueOf(d.parent().select(".time-box").text().replaceAll("\\D+", "")))
                .collect(Collectors.toList());
    }

    @AllArgsConstructor
    public static class Dto {

        List<Integer> goals;

        List<Card> cards;
    }
}
