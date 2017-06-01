package com.savik.parser.football;

import java.util.List;
import java.util.stream.Collectors;

import com.savik.football.model.FootballCard;
import com.savik.football.model.FootballGoal;
import com.savik.football.model.Who;
import lombok.*;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author Savushkin Yauheni
 * @since 12.04.2017
 */
public class MatchInfoParser {

    public static final String HOME = ".fl";

    public static final String GUEST = ".fr";

    public static GeneralInfoDto parseGeneralInfo(Elements elements) {

        return new GeneralInfoDto(
                parseGoals(elements.select("div.soccer-ball")),
                parseCards(elements.select("div.y-card,div.r-card,div.yr-card"))
        );
    }

    public static StatsInfoDto parseStats(Elements elements) {

        Elements possessionElement = elements.select(".score.stats:containsOwn(Владение мячом)");
        Elements cornersElement = elements.select(".score.stats:containsOwn(Угловые)");
        Elements hitsElement = elements.select(".score.stats:containsOwn(Удары)");
        Elements hitsOnTargetElement = elements.select(".score.stats:containsOwn(Удары в створ)");
        Elements foulsElement = elements.select(".score.stats:containsOwn(Фолы)");
        Elements offsidesElement = elements.select(".score.stats:containsOwn(Офсайды)");

        return StatsInfoDto
                .builder()
                .homePossession(getStat(possessionElement, HOME))
                .guestPossession(getStat(possessionElement, GUEST))
                .homeCorners(getStat(cornersElement, HOME))
                .guestCorners(getStat(cornersElement, GUEST))
                .homeHits(getStat(hitsElement, HOME))
                .guestHits(getStat(hitsElement, GUEST))
                .homeHitsOnTarget(getStat(hitsOnTargetElement, HOME))
                .guestHitsOnTarget(getStat(hitsOnTargetElement, GUEST))
                .homeFouls(getStat(foulsElement, HOME))
                .guestFouls(getStat(foulsElement, GUEST))
                .homeOffsides(getStat(offsidesElement, HOME))
                .guestOffsides(getStat(offsidesElement, GUEST))
                .build();

    }

    private static Integer getStat(Elements elements, String selector) {
        return elements.isEmpty() ? null : Integer.valueOf(elements.get(0)
                                                                   .parent()
                                                                   .select(selector)
                                                                   .text()
                                                                   .replaceAll("\\D+", ""));
    }

    static List<FootballGoal> parseGoals(Elements goalsDivs) {
        return goalsDivs
                .stream()
                .map(d -> FootballGoal.builder()
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

    static List<FootballCard> parseCards(Elements goalsDivs) {
        return goalsDivs
                .stream()
                .map(d -> FootballCard
                        .builder()
                        .who(d.parent().parent().hasClass("fl") ? Who.HOME : Who.GUEST)
                        .minute(calculateTime(d))
                        .type(d.hasClass("y-card") ? FootballCard.Type.YELLOW :
                                d.hasClass("r-card") ? FootballCard.Type.RED :
                                        d.hasClass("yr-card") ? FootballCard.Type.YELLOW_RED : null
                        )
                        .build())
                .collect(Collectors.toList());
    }

    @AllArgsConstructor
    @Getter
    public static class GeneralInfoDto {

        List<FootballGoal> footballGoals;

        List<FootballCard> footballCards;
    }

    @Getter
    @Builder
    public static class StatsInfoDto {

        Integer homeCorners;

        Integer guestCorners;

        Integer homeHits;

        Integer guestHits;

        Integer homeHitsOnTarget;

        Integer guestHitsOnTarget;

        Integer homePossession;

        Integer guestPossession;

        Integer homeOffsides;

        Integer guestOffsides;

        Integer homeFouls;

        Integer guestFouls;
    }
}
