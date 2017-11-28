package com.savik.parser.hockey;

import com.savik.Who;
import com.savik.hockey.model.HockeyGoal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Savushkin Yauheni
 * @since 12.04.2017
 */
public class HockeyMatchInfoParser {

    public static final String HOME = ".fl";

    public static final String GUEST = ".fr";

    public static GeneralInfoDto parseGeneralInfo(Elements elements, Integer period) {

        return new GeneralInfoDto(
                parseGoals(elements.select("div.hockey-ball"), period)
        );
    }

    public static StatsInfoDto parseStats(Elements elements) {
        return StatsInfoDto
                .builder()
                .build();
    }

    private static Integer getStat(Elements elements, String selector) {
        return elements.isEmpty() ? null : Integer.valueOf(elements.get(0)
                .parent()
                .select(selector)
                .text()
                .replaceAll("\\D+", ""));
    }

    static List<HockeyGoal> parseGoals(Elements goalsDivs, Integer period) {
        return goalsDivs
                .stream()
                .map(d -> HockeyGoal.builder()
                        .minute(period != null ? calculateTime(d) + 20 * (period - 1) : null)
                        .whoScored(d.parent().parent().hasClass("fl") ? Who.HOME : Who.GUEST)
                        .build())
                .collect(Collectors.toList());
    }

    static Integer calculateTime(Element element) {
        Integer minute =
                Integer.valueOf(element.parent().select(".time-box,.time-box-wide").text().replaceAll("\\D+", ""));
        return minute / 100;
    }

    @AllArgsConstructor
    @Getter
    public static class GeneralInfoDto {
        List<HockeyGoal> hockeyGoals;

    }

    @Getter
    @Builder
    public static class StatsInfoDto {

    }
}
