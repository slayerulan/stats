package com.savik.parser.football;

import java.util.List;
import java.util.stream.Collectors;

import com.savik.football.model.Card;
import com.savik.football.model.Goal;
import com.savik.football.model.Who;
import lombok.*;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author Savushkin Yauheni
 * @since 12.04.2017
 */
public class MatchInfoParser {

    public static GeneralInfoDto parseGeneralInfo(Elements elements) {

        return new GeneralInfoDto(
                parseGoals(elements.select("div.soccer-ball")),
                parseCards(elements.select("div.y-card,div.r-card,div.yr-card"))
        );
    }

    public static StatsInfoDto parseStats(Elements elements) {

        Element possesionElement = elements.select(".score.stats:containsOwn(Владение мячом)").get(0);
        Element cornersElement = elements.select(".score.stats:containsOwn(Угловые)").get(0);
        Element hitsElement = elements.select(".score.stats:containsOwn(Удары)").get(0);
        Element foulsElement = elements.select(".score.stats:containsOwn(Фолы)").get(0);
        Element offsidesElement = elements.select(".score.stats:containsOwn(Офсайды)").get(0);

        return StatsInfoDto.builder()
                           .homePossession(Integer.valueOf(possesionElement
                                   .parent()
                                   .select(".fl")
                                   .text()
                                   .replaceAll("\\D+", "")))
                           .guestPossession(Integer.valueOf(possesionElement
                                   .parent()
                                   .select(".fr")
                                   .text()
                                   .replaceAll("\\D+", "")))
                           .homeCorners(Integer.valueOf(cornersElement
                                   .parent()
                                   .select(".fl")
                                   .text()
                                   .replaceAll("\\D+", "")))
                           .guestCorners(Integer.valueOf(cornersElement
                                   .parent()
                                   .select(".fr")
                                   .text()
                                   .replaceAll("\\D+", "")))
                           .homeHits(Integer.valueOf(hitsElement.parent().select(".fl").text().replaceAll("\\D+", "")))
                           .guestHits(Integer.valueOf(hitsElement.parent().select(".fr").text().replaceAll("\\D+", "")))
                           .homeFouls(Integer.valueOf(foulsElement
                                   .parent()
                                   .select(".fl")
                                   .text()
                                   .replaceAll("\\D+", "")))
                           .guestFouls(Integer.valueOf(foulsElement
                                   .parent()
                                   .select(".fr")
                                   .text()
                                   .replaceAll("\\D+", "")))
                           .homeOffsides(Integer.valueOf(offsidesElement
                                   .parent()
                                   .select(".fl")
                                   .text()
                                   .replaceAll("\\D+", "")))
                           .guestOffsides(Integer.valueOf(offsidesElement
                                   .parent()
                                   .select(".fr")
                                   .text()
                                   .replaceAll("\\D+", "")))
                           .build();

    }

    static List<Goal> parseGoals(Elements goalsDivs) {
        return goalsDivs
                .stream()
                .map(d -> Goal.builder()
                              .minute(calculateTime(d))
                              .whoScored(d.parent().parent().hasClass("fl") ? Who.HOME : Who.GUEST)
                              .build())
                .collect(Collectors.toList());
    }

    static Integer calculateTime(Element element) {
        Integer minute =
                Integer.valueOf(element.parent().select(".time-box,.time-box-wide").text().replaceAll("\\D+", ""));
        return minute > 90 ? (minute / 10 + minute % 10) : minute;
    }

    static List<Card> parseCards(Elements goalsDivs) {
        return goalsDivs
                .stream()
                .map(d -> Card
                        .builder()
                        .who(d.parent().parent().hasClass("fl") ? Who.HOME : Who.GUEST)
                        .minute(calculateTime(d))
                        .type(d.hasClass("y-card") ? Card.Type.YELLOW :
                                d.hasClass("r-card") ? Card.Type.RED :
                                        d.hasClass("yr-card") ? Card.Type.YELLOW_RED : null
                        )
                        .build())
                .collect(Collectors.toList());
    }

    @AllArgsConstructor
    @Getter
    public static class GeneralInfoDto {

        List<Goal> goals;

        List<Card> cards;
    }

    @Getter
    @Builder
    public static class StatsInfoDto {

        Integer homeCorners;

        Integer guestCorners;

        Integer homeHits;

        Integer guestHits;

        Integer homePossession;

        Integer guestPossession;

        Integer homeOffsides;

        Integer guestOffsides;

        Integer homeFouls;

        Integer guestFouls;
    }
}
