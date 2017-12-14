package com.savik.parser.hockey.matches;

import com.savik.Who;
import com.savik.hockey.model.HockeyGoal;
import lombok.*;
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
                parseGoals(elements.select("div.hockey-ball"), period),
                parseMinorPenalties(elements.select("td.fl div.hockey-penalty-2")),
                parseMinorPenalties(elements.select("td.fr div.hockey-penalty-2"))
        );
    }

    public static StatsInfoDto parseStats(Elements elements) {
        Elements shotsOnTarget = elements.select(".score.stats:containsOwn(Броски в створ ворот)");
        Elements penaltiesTime = elements.select(".score.stats:containsOwn(Штрафное время)");
        Elements shotHandedGoals = elements.select(".score.stats:containsOwn(Шайбы в меньшинстве)");
        Elements powerplayGoals = elements.select(".score.stats:containsOwn(Шайбы в большинстве)");


        return StatsInfoDto
                .builder()
                .homeShotsOnTarget(getStat(shotsOnTarget, HOME))
                .guestShotsOnTarget(getStat(shotsOnTarget, GUEST))
                .homePenaltiesTime(getStat(penaltiesTime, HOME))
                .guestPenaltiesTime(getStat(penaltiesTime, GUEST))
                .homeShotHandedGoals(getStat(shotHandedGoals, HOME))
                .guestShotHandedGoals(getStat(shotHandedGoals, GUEST))
                .homePowerplayGoals(getStat(powerplayGoals, HOME))
                .guestPowerplayGoals(getStat(powerplayGoals, GUEST))
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
                        .minute(period != null ? (calculateTime(d) / 100) + 20 * (period - 1) : null)
                        .seconds(period != null ? (calculateTime(d) % 100) : null)
                        .whoScored(d.parent().parent().hasClass("fl") ? Who.HOME : Who.GUEST)
                        .build())
                .collect(Collectors.toList());
    }

    static int parseMinorPenalties(Elements penaltiesDivs) {
        int amount = 0;
        for (int i = 0; i < penaltiesDivs.size(); i++) {
            Element element = penaltiesDivs.get(i);
            if(element.parent().select("div.hockey-penalty-2").size() == 1) {
                amount++;
            }
        }
        return amount;
    }

    static Integer calculateTime(Element element) {
        Integer minute =
                Integer.valueOf(element.parent().select(".time-box,.time-box-wide").text().replaceAll("\\D+", ""));
        return minute;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class GeneralInfoDto {
        List<HockeyGoal> hockeyGoals;
        int homeMinorPenaltiesAmount;
        int guestMinorPenaltiesAmount;
    }

    @Getter
    @Setter
    @Builder
    public static class StatsInfoDto {

        Integer homeShotsOnTarget;

        Integer guestShotsOnTarget;

        // в меньшинстве
        Integer homeShotHandedGoals;

        Integer guestShotHandedGoals;

        // в большинстве
        Integer homePowerplayGoals;

        Integer guestPowerplayGoals;


        Integer homePenaltiesTime;

        Integer guestPenaltiesTime;
    }
}
