package com.savik.parser.hockey.coeffs;

import com.savik.CoeffContainer;
import com.savik.ContainerType;
import com.savik.Team;
import com.savik.coeffs.hockey.CoeffBlock;
import com.savik.hockey.model.HockeyFutureMatch;
import com.savik.hockey.model.HockeyTeam;
import com.savik.hockey.repository.HockeyMatchRepository;
import com.savik.hockey.repository.HockeyTeamRepository;
import com.savik.parser.Downloader;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


@Service
public class HockeyCoeffsMatchParser {

    @Autowired
    HockeyTeamRepository hockeyTeamRepository;

    @Autowired
    HockeyMatchRepository hockeyMatchRepository;

    @Autowired
    Downloader downloader;

    @Autowired
    HockeyDownloaderConfiguration hockeyDownloaderConfiguration;

    public CoeffBlock parse(HockeyFutureMatch hockeyFutureMatch) {

        Path statsPath = null, shotsPath = null, penaltiesPath = null;
        try {
            statsPath = Paths.get(getClass().getClassLoader()
                    .getResource("parimatch-nhl-example.html").toURI());

            shotsPath = Paths.get(getClass().getClassLoader()
                    .getResource("parimatch-nhl-shots-example.html").toURI());

            penaltiesPath = Paths.get(getClass().getClassLoader()
                    .getResource("parimatch-nhl-penalties-example.html").toURI());
        } catch (URISyntaxException e) {
        }
        Document statsHtml = downloader.downloadFile(new File(statsPath.toUri()));
        //Document html = downloader.download(hockeyDownloaderConfiguration.getNhlUr());

        HockeyTeam homeTeam = hockeyFutureMatch.getHomeTeam();

        CoeffBlock coeffBlock = new CoeffBlock();
        Element tempHref = statsHtml.select("a.om:containsOwn(" + homeTeam.getName() + ")").get(0);
        Element matchTbodyTag = tempHref.parent().parent().parent();
        Element matchCoeffsTbodyTag = matchTbodyTag.nextElementSibling();

        fillSomeSpecialBets(tempHref.parent().parent(), coeffBlock);
        fillTotalBlock(matchCoeffsTbodyTag, coeffBlock.findByType(ContainerType.TOTAL), hockeyFutureMatch);
        fillOtherBlock(matchCoeffsTbodyTag, coeffBlock.findByType(ContainerType.OTHER), hockeyFutureMatch);
        fillPeriodsBlock(matchCoeffsTbodyTag, coeffBlock.findByType(ContainerType.PERIODS), hockeyFutureMatch);


        Document shotsHtml = downloader.downloadFile(new File(shotsPath.toUri()));
        tempHref = shotsHtml.select("a.om:contains(" + homeTeam.getName() + ")").get(0);
        fillShotsSpecialBets(tempHref.parent().parent(), coeffBlock.findByType(ContainerType.STATS));
        fillShotsBets(
                tempHref.parent().parent().parent().nextElementSibling(),
                coeffBlock.findByType(ContainerType.STATS), hockeyFutureMatch
        );


        Document penaltiesHtml = downloader.downloadFile(new File(penaltiesPath.toUri()));
        tempHref = penaltiesHtml.select("td:contains(" + homeTeam.getName() + ")").get(0);
        fillPenaltiesSpecialBets(tempHref.parent().parent(), coeffBlock.findByType(ContainerType.STATS));


        return coeffBlock;
    }

    // which placed on parimatch main screen
    private void fillSomeSpecialBets(Element element, CoeffContainer container) {
        Elements tds = element.select("td");
        // total over
        if (tds.get(5) != null) {
            String totalOverText = tds.get(5).select("b").text();
            String totalOverCoeff = tds.get(6).select("u a").text();
            String totalUnderCoeff = tds.get(7).select("u a").text();
            CoeffContainer totalContainer = container.findByType(ContainerType.TOTAL);
            CoeffContainer totalOverContainer = totalContainer.findByType(ContainerType.TOTAL_OVER);
            CoeffContainer over4AndHalf = totalOverContainer.findByType(ContainerType.OVER_4_5);
            CoeffContainer over5AndHalf = totalOverContainer.findByType(ContainerType.OVER_5_5);
            CoeffContainer totalUnderContainer = totalContainer.findByType(ContainerType.TOTAL_UNDER);
            CoeffContainer under4AndHalf = totalUnderContainer.findByType(ContainerType.UNDER_4_5);
            CoeffContainer under5AndHalf = totalUnderContainer.findByType(ContainerType.UNDER_5_5);
            if (totalOverText.contains("4.5")) {
                over4AndHalf.getCoeff().set(Double.valueOf(totalOverCoeff));
                under4AndHalf.getCoeff().set(Double.valueOf(totalUnderCoeff));
            }

            if (totalOverText.contains("5.5")) {
                over5AndHalf.getCoeff().set(Double.valueOf(totalOverCoeff));
                under5AndHalf.getCoeff().set(Double.valueOf(totalUnderCoeff));
            }
        }
        if (tds.get(15) != null) {
            String totalOverText = tds.get(14).select("b").first().text();
            String totalOverCoeff = tds.get(15).select("u a").first().text();
            String totalUnderCoeff = tds.get(16).select("u a").first().text();
            CoeffContainer totalContainer = container.findByType(ContainerType.TOTAL);
            CoeffContainer teamTotalOverContainer = totalContainer.findByType(ContainerType.TEAM_TOTAL_OVER);
            CoeffContainer over2AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_2_5);
            CoeffContainer over3AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_3_5);
            CoeffContainer totalUnderContainer = totalContainer.findByType(ContainerType.TEAM_TOTAL_UNDER);
            CoeffContainer under2AndHalf = totalUnderContainer.findByType(ContainerType.UNDER_2_5);
            CoeffContainer under3AndHalf = totalUnderContainer.findByType(ContainerType.UNDER_3_5);
            if (totalOverText.contains("2.5")) {
                over2AndHalf.getCoeff().set(Double.valueOf(totalOverCoeff));
                under2AndHalf.getCoeff().set(Double.valueOf(totalUnderCoeff));
            }

            if (totalOverText.contains("3.5")) {
                over3AndHalf.getCoeff().set(Double.valueOf(totalOverCoeff));
                under3AndHalf.getCoeff().set(Double.valueOf(totalUnderCoeff));
            }
        }

        if (tds.get(15) != null) {
            String totalOverText = tds.get(14).select("b").get(1).text();
            String totalOverCoeff = tds.get(15).select("u a").get(1).text();
            String totalUnderCoeff = tds.get(16).select("u a").get(1).text();
            CoeffContainer totalContainer = container.findByType(ContainerType.TOTAL);
            CoeffContainer teamTotalOverContainer = totalContainer.findByType(ContainerType.OPPOSING_TEAM_TOTAL_OVER);
            CoeffContainer over2AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_2_5);
            CoeffContainer over3AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_3_5);
            CoeffContainer totalUnderContainer = totalContainer.findByType(ContainerType.OPPOSING_TEAM_TOTAL_UNDER);
            CoeffContainer under2AndHalf = totalUnderContainer.findByType(ContainerType.UNDER_2_5);
            CoeffContainer under3AndHalf = totalUnderContainer.findByType(ContainerType.UNDER_3_5);
            if (totalOverText.contains("2.5")) {
                over2AndHalf.getCoeff().set(Double.valueOf(totalOverCoeff));
                under2AndHalf.getCoeff().set(Double.valueOf(totalUnderCoeff));
            }

            if (totalOverText.contains("3.5")) {
                over3AndHalf.getCoeff().set(Double.valueOf(totalOverCoeff));
                under3AndHalf.getCoeff().set(Double.valueOf(totalUnderCoeff));
            }
        }
    }

    // which placed on parimatch main screen
    private void fillShotsSpecialBets(Element element, CoeffContainer container) {
        Elements tds = element.select("td");
        if (tds.get(3) != null) {
            String handicapText = tds.get(3).select("b").first().text();
            String handicapCoeff = tds.get(4).select("u a").first().text();
            CoeffContainer handicapBlock = container.findByType(ContainerType.TEAM_SHOTS_ON_TARGET_HANDICAP);
            CoeffContainer plus1AndHalf = handicapBlock.findByType(ContainerType.PLUS_1_5);
            CoeffContainer plus2AndHalf = handicapBlock.findByType(ContainerType.PLUS_2_5);
            CoeffContainer plus3AndHalf = handicapBlock.findByType(ContainerType.PLUS_3_5);
            CoeffContainer minus1AndHalf = handicapBlock.findByType(ContainerType.MINUS_1_5);
            CoeffContainer minus2AndHalf = handicapBlock.findByType(ContainerType.MINUS_2_5);
            CoeffContainer minus3AndHalf = handicapBlock.findByType(ContainerType.MINUS_3_5);

            if (handicapText.contains("+1.5")) {
                plus1AndHalf.getCoeff().set(Double.valueOf(handicapCoeff));
            }
            if (handicapText.contains("+2.5")) {
                plus2AndHalf.getCoeff().set(Double.valueOf(handicapCoeff));
            }
            if (handicapText.contains("+3.5")) {
                plus3AndHalf.getCoeff().set(Double.valueOf(handicapCoeff));
            }
            if (handicapText.contains("–1.5")) {
                minus1AndHalf.getCoeff().set(Double.valueOf(handicapCoeff));
            }
            if (handicapText.contains("–2.5")) {
                minus2AndHalf.getCoeff().set(Double.valueOf(handicapCoeff));
            }
            if (handicapText.contains("–3.5")) {
                minus3AndHalf.getCoeff().set(Double.valueOf(handicapCoeff));
            }
        }

        if (tds.get(3) != null) {
            String handicapText = tds.get(3).select("b").get(1).text();
            String handicapCoeff = tds.get(4).select("u a").get(1).text();
            CoeffContainer handicapBlock = container.findByType(ContainerType.OPPOSING_TEAM_SHOTS_ON_TARGET_HANDICAP);
            CoeffContainer plus1AndHalf = handicapBlock.findByType(ContainerType.PLUS_1_5);
            CoeffContainer plus2AndHalf = handicapBlock.findByType(ContainerType.PLUS_2_5);
            CoeffContainer plus3AndHalf = handicapBlock.findByType(ContainerType.PLUS_3_5);
            CoeffContainer minus1AndHalf = handicapBlock.findByType(ContainerType.MINUS_1_5);
            CoeffContainer minus2AndHalf = handicapBlock.findByType(ContainerType.MINUS_2_5);
            CoeffContainer minus3AndHalf = handicapBlock.findByType(ContainerType.MINUS_3_5);

            if (handicapText.contains("+1.5")) {
                plus1AndHalf.getCoeff().set(Double.valueOf(handicapCoeff));
            }
            if (handicapText.contains("+2.5")) {
                plus2AndHalf.getCoeff().set(Double.valueOf(handicapCoeff));
            }
            if (handicapText.contains("+3.5")) {
                plus3AndHalf.getCoeff().set(Double.valueOf(handicapCoeff));
            }
            if (handicapText.contains("–1.5")) {
                minus1AndHalf.getCoeff().set(Double.valueOf(handicapCoeff));
            }
            if (handicapText.contains("–2.5")) {
                minus2AndHalf.getCoeff().set(Double.valueOf(handicapCoeff));
            }
            if (handicapText.contains("–3.5")) {
                minus3AndHalf.getCoeff().set(Double.valueOf(handicapCoeff));
            }
        }

        if (tds.get(5) != null) {
            String totalText = tds.get(5).select("b").first().text();
            String totalOverCoeff = tds.get(6).select("u a").first().text();
            String totalUnderCoeff = tds.get(7).select("u a").first().text();
            CoeffContainer teamTotalOverContainer = container.findByType(ContainerType.SHOTS_ON_TARGET_OVER);
            CoeffContainer over59AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_59_5);
            CoeffContainer over60AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_60_5);
            CoeffContainer over61AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_61_5);
            CoeffContainer over62AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_62_5);
            CoeffContainer over63AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_63_5);

            Double overValue = Double.valueOf(totalOverCoeff);
            Double underValue = Double.valueOf(totalUnderCoeff);
            if (totalText.contains("59.5")) {
                over59AndHalf.getCoeff().set(overValue, underValue);
            }
            if (totalText.contains("60.5")) {
                over60AndHalf.getCoeff().set(overValue, underValue);
            }
            if (totalText.contains("61.5")) {
                over61AndHalf.getCoeff().set(overValue, underValue);
            }
            if (totalText.contains("62.5")) {
                over62AndHalf.getCoeff().set(overValue, underValue);
            }
            if (totalText.contains("63.5")) {
                over63AndHalf.getCoeff().set(overValue, underValue);
            }

        }

        if (tds.get(8) != null) {
            String coeff = tds.get(8).select("u a").first().text();
            CoeffContainer winContainer = container.findByType(ContainerType.TEAM_SHOTS_ON_TARGET_WIN);
            winContainer.getCoeff().set(Double.valueOf(coeff));
        }
        if (tds.get(10) != null) {
            String coeff = tds.get(10).select("u a").first().text();
            CoeffContainer winContainer = container.findByType(ContainerType.OPPOSING_TEAM_SHOTS_ON_TARGET_WIN);
            winContainer.getCoeff().set(Double.valueOf(coeff));
        }


        if (tds.get(14) != null) {
            String totalText = tds.get(14).select("b").first().text();
            String totalOverCoeff = tds.get(15).select("u a").first().text();
            String totalUnderCoeff = tds.get(7).select("u a").first().text();
            CoeffContainer teamTotalOverContainer = container.findByType(ContainerType.TEAM_SHOTS_ON_TARGET_OVER);
            CoeffContainer over28AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_28_5);
            CoeffContainer over30AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_30_5);
            CoeffContainer over32AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_32_5);

            Double overValue = Double.valueOf(totalOverCoeff);
            Double underValue = Double.valueOf(totalUnderCoeff);
            if (totalText.contains("28.5") || totalText.contains("28.0") || totalText.contains("29.0")) {
                over28AndHalf.getCoeff().set(overValue, underValue);
            }
            if (totalText.contains("30.5") || totalText.contains("30.0") || totalText.contains("31.0")) {
                over30AndHalf.getCoeff().set(overValue, underValue);
            }
            if (totalText.contains("32.5") || totalText.contains("33.0") || totalText.contains("34.0")) {
                over32AndHalf.getCoeff().set(overValue, underValue);
            }

        }

        if (tds.get(14) != null) {
            String totalText = tds.get(14).select("b").get(1).text();
            String totalOverCoeff = tds.get(15).select("u a").get(1).text();
            String totalUnderCoeff = tds.get(7).select("u a").first().text();
            CoeffContainer teamTotalOverContainer = container.findByType(ContainerType.OPPOSING_TEAM_SHOTS_ON_TARGET_OVER);
            CoeffContainer over28AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_28_5);
            CoeffContainer over30AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_30_5);
            CoeffContainer over32AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_32_5);

            Double overValue = Double.valueOf(totalOverCoeff);
            Double underValue = Double.valueOf(totalUnderCoeff);
            if (totalText.contains("28.5") || totalText.contains("28.0") || totalText.contains("29.0")) {
                over28AndHalf.getCoeff().set(overValue, underValue);
            }
            if (totalText.contains("30.5") || totalText.contains("30.0") || totalText.contains("31.0")) {
                over30AndHalf.getCoeff().set(overValue, underValue);
            }
            if (totalText.contains("32.5") || totalText.contains("33.0") || totalText.contains("34.0")) {
                over32AndHalf.getCoeff().set(overValue, underValue);
            }

        }
    }

    private void fillShotsBets(Element element, CoeffContainer container, HockeyFutureMatch match) {
        fillShotsTotalOverBlock(element, container);
        fillShotsHandicap(element, container, match.getHomeTeam(), ContainerType.TEAM_SHOTS_ON_TARGET_HANDICAP);
        fillShotsHandicap(element, container, match.getGuestTeam(), ContainerType.OPPOSING_TEAM_SHOTS_ON_TARGET_HANDICAP);
    }

    private void fillShotsTotalOverBlock(Element element, CoeffContainer container) {
        Element totalElementBlock = element.select("th:containsOwn(Дополнительные тоталы:)")
                .first().parent().nextElementSibling();

        Element generalTotalHtmlBlock = totalElementBlock.select("td:containsOwn(больше)").first();
        List<Node> childNodes = generalTotalHtmlBlock.childNodes();
        CoeffContainer teamTotalOverContainer = container.findByType(ContainerType.SHOTS_ON_TARGET_OVER);
        CoeffContainer over59AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_59_5);
        CoeffContainer over60AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_60_5);
        CoeffContainer over61AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_61_5);
        CoeffContainer over62AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_62_5);
        CoeffContainer over63AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_63_5);

        for (int i = 0; i < childNodes.size(); i++) {
            Node child = childNodes.get(i);
            if (!(child instanceof TextNode)) {
                continue;
            }
            String text = ((TextNode) child).text();
            Double overValue = null, underValue = null;
            if (i < childNodes.size() - 4) {
                String totalOverCoeff = childNodes.get(i + 1).childNode(0).childNode(0).outerHtml();
                String totalunderCoeff = childNodes.get(i + 3).childNode(0).childNode(0).outerHtml();
                overValue = Double.valueOf(totalOverCoeff);
                underValue = Double.valueOf(totalunderCoeff);
            }

            if (text.contains("59.5")) {
                over59AndHalf.getCoeff().set(overValue, underValue);
            }
            if (text.contains("60.5")) {
                over60AndHalf.getCoeff().set(overValue, underValue);
            }
            if (text.contains("61.5")) {
                over61AndHalf.getCoeff().set(overValue, underValue);
            }
            if (text.contains("62.5")) {
                over62AndHalf.getCoeff().set(overValue, underValue);
            }
            if (text.contains("63.5")) {
                over63AndHalf.getCoeff().set(overValue, underValue);
            }
        }
    }

    private void fillShotsHandicap(Element element, CoeffContainer container, HockeyTeam team, ContainerType type) {
        Element totalElementBlock = element.select("th:containsOwn(Дополнительные форы:)")
                .first().parent().nextElementSibling();


        Element temp = totalElementBlock.select("i:contains(" + team.getName() + ")").first();
        Element teamTotalBlock = temp.parent().nextElementSibling();
        List<Node> childNodes = teamTotalBlock.childNodes();

        CoeffContainer handicapBlock = container.findByType(type);
        CoeffContainer plus1AndHalf = handicapBlock.findByType(ContainerType.PLUS_1_5);
        CoeffContainer plus2AndHalf = handicapBlock.findByType(ContainerType.PLUS_2_5);
        CoeffContainer plus3AndHalf = handicapBlock.findByType(ContainerType.PLUS_3_5);
        CoeffContainer minus1AndHalf = handicapBlock.findByType(ContainerType.MINUS_1_5);
        CoeffContainer minus2AndHalf = handicapBlock.findByType(ContainerType.MINUS_2_5);
        CoeffContainer minus3AndHalf = handicapBlock.findByType(ContainerType.MINUS_3_5);


        for (int i = 0; i < childNodes.size(); i++) {
            Node child = childNodes.get(i);
            if (!(child instanceof TextNode)) {
                continue;
            }
            String handicapText = ((TextNode) child).text();
            Double value = null;
            if (i < childNodes.size() - 2) {
                String handicapCoeff = childNodes.get(i + 1).childNode(0).childNode(0).outerHtml();
                value = Double.valueOf(handicapCoeff);
            }

            if (handicapText.contains("+1.5")) {
                plus1AndHalf.getCoeff().set(value);
            }
            if (handicapText.contains("+2.5")) {
                plus2AndHalf.getCoeff().set(value);
            }
            if (handicapText.contains("+3.5")) {
                plus3AndHalf.getCoeff().set(value);
            }
            if (handicapText.contains("–1.5")) {
                minus1AndHalf.getCoeff().set(value);
            }
            if (handicapText.contains("–2.5")) {
                minus2AndHalf.getCoeff().set(value);
            }
            if (handicapText.contains("–3.5")) {
                minus3AndHalf.getCoeff().set(value);
            }
        }
    }

    // which placed on parimatch main screen
    private void fillPenaltiesSpecialBets(Element element, CoeffContainer container) {
        Elements tds = element.select("td");

        if (tds.get(5) != null) {
            String totalText = tds.get(5).select("b").first().text();
            String totalOverCoeff = tds.get(6).select("u a").first().text();
            String totalUnderCoeff = tds.get(7).select("u a").first().text();
            CoeffContainer teamTotalOverContainer = container.findByType(ContainerType.PENALTIES_TIME_OVER);
            CoeffContainer over13AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_13_5);
            CoeffContainer over14AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_14_5);
            CoeffContainer over15AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_15_5);

            Double overValue = Double.valueOf(totalOverCoeff);
            Double underValue = Double.valueOf(totalUnderCoeff);
            if (totalText.contains("13.5") || totalText.contains("14.0")) {
                over13AndHalf.getCoeff().set(overValue, underValue);
            }
            if (totalText.contains("14.5") || totalText.contains("15.0")) {
                over14AndHalf.getCoeff().set(overValue, underValue);
            }
            if (totalText.contains("15.5") || totalText.contains("16.0")) {
                over15AndHalf.getCoeff().set(overValue, underValue);
            }

        }

        if (tds.get(8) != null) {
            String coeff = tds.get(8).select("u a").first().text();
            CoeffContainer winContainer = container.findByType(ContainerType.TEAM_PENALTIES_TIME_WIN);
            winContainer.getCoeff().set(Double.valueOf(coeff));
        }
        if (tds.get(10) != null) {
            String coeff = tds.get(10).select("u a").first().text();
            CoeffContainer winContainer = container.findByType(ContainerType.OPPOSING_TEAM_PENALTIES_TIME_WIN);
            winContainer.getCoeff().set(Double.valueOf(coeff));
        }


        if (tds.get(14) != null) {
            String totalText = tds.get(14).select("b").first().text();
            String totalOverCoeff = tds.get(15).select("u a").first().text();
            String totalUnderCoeff = tds.get(16).select("u a").first().text();
            CoeffContainer teamTotalOverContainer = container.findByType(ContainerType.TEAM_PENALTIES_TIME_OVER);
            CoeffContainer over6AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_6_5);
            CoeffContainer over7AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_7_5);
            CoeffContainer over8AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_8_5);

            Double overValue = Double.valueOf(totalOverCoeff);
            Double underValue = Double.valueOf(totalUnderCoeff);
            if (totalText.contains("6.5") || totalText.contains("7.0")) {
                over6AndHalf.getCoeff().set(overValue, underValue);
            }
            if (totalText.contains("7.5") || totalText.contains("8.0")) {
                over7AndHalf.getCoeff().set(overValue, underValue);
            }
            if (totalText.contains("8.5") || totalText.contains("9.0")) {
                over8AndHalf.getCoeff().set(overValue, underValue);
            }

        }

        if (tds.get(14) != null) {
            String totalText = tds.get(14).select("b").get(1).text();
            String totalOverCoeff = tds.get(15).select("u a").get(1).text();
            String totalUnderCoeff = tds.get(16).select("u a").first().text();
            CoeffContainer teamTotalOverContainer = container.findByType(ContainerType.OPPOSING_TEAM_PENALTIES_TIME_OVER);
            CoeffContainer over6AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_6_5);
            CoeffContainer over7AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_7_5);
            CoeffContainer over8AndHalf = teamTotalOverContainer.findByType(ContainerType.OVER_8_5);

            Double overValue = Double.valueOf(totalOverCoeff);
            Double underValue = Double.valueOf(totalUnderCoeff);
            if (totalText.contains("6.5") || totalText.contains("7.0")) {
                over6AndHalf.getCoeff().set(overValue, underValue);
            }
            if (totalText.contains("7.5") || totalText.contains("8.0")) {
                over7AndHalf.getCoeff().set(overValue, underValue);
            }
            if (totalText.contains("8.5") || totalText.contains("9.0")) {
                over8AndHalf.getCoeff().set(overValue, underValue);
            }

        }
    }

    private void fillTotalBlock(Element element, CoeffContainer totalContainer, HockeyFutureMatch match) {
        fillTotalOverBlock(element, totalContainer.findByType(ContainerType.TOTAL_OVER));
        fillTotalUnderBlock(element, totalContainer.findByType(ContainerType.TOTAL_UNDER));
        fillBothTeamsTotalOverBlock(element, totalContainer.findByType(ContainerType.BOTH_TEAMS_TOTAL_OVER));
        fillBothTeamsTotalUnderBlock(element, totalContainer.findByType(ContainerType.BOTH_TEAMS_TOTAL_UNDER));
        fillTeamTotalOverBlock(element, totalContainer.findByType(ContainerType.TEAM_TOTAL_OVER), match.getHomeTeam());
        fillTeamTotalUnderBlock(element, totalContainer.findByType(ContainerType.TEAM_TOTAL_UNDER), match.getHomeTeam());
        fillTeamTotalOverBlock(element, totalContainer.findByType(ContainerType.OPPOSING_TEAM_TOTAL_OVER), match.getGuestTeam());
        fillTeamTotalUnderBlock(element, totalContainer.findByType(ContainerType.OPPOSING_TEAM_TOTAL_UNDER), match.getGuestTeam());
    }

    private void fillTotalOverBlock(Element element, CoeffContainer totalOverContainer) {

        Element totalElementBlock = element.select("th:containsOwn(Дополнительные тоталы:)")
                .first().parent().nextElementSibling();

        Element generalTotalHtmlBlock = totalElementBlock.select("td:containsOwn((4.5) больше )").first();
        List<Node> childNodes = generalTotalHtmlBlock.childNodes();
        CoeffContainer over4AndHalf = totalOverContainer.findByType(ContainerType.OVER_4_5);
        CoeffContainer over5AndHalf = totalOverContainer.findByType(ContainerType.OVER_5_5);
        for (int i = 0; i < childNodes.size(); i++) {
            Node child = childNodes.get(i);
            if (!(child instanceof TextNode)) {
                continue;
            }
            String text = ((TextNode) child).text();
            if (text.contains("(4.5) больше ")) {
                String totalOver4AndHalfCoeff = childNodes.get(i + 1).childNode(0).childNode(0).outerHtml();
                over4AndHalf.getCoeff().set(Double.valueOf(totalOver4AndHalfCoeff));
            }

            if (text.contains("(5.5) больше ")) {
                String totalOver5AndHalfCoeff = childNodes.get(i + 1).childNode(0).childNode(0).outerHtml();
                over5AndHalf.getCoeff().set(Double.valueOf(totalOver5AndHalfCoeff));
            }
        }
    }

    private void fillTotalUnderBlock(Element element, CoeffContainer totalUnderContainer) {

        Element totalElementBlock = element.select("th:containsOwn(Дополнительные тоталы:)")
                .first().parent().nextElementSibling();

        Element generalTotalHtmlBlock = totalElementBlock.select("td:containsOwn((4.5) больше )").first();
        List<Node> childNodes = generalTotalHtmlBlock.childNodes();
        CoeffContainer under5AndHalf = totalUnderContainer.findByType(ContainerType.UNDER_5_5);
        CoeffContainer under6AndHalf = totalUnderContainer.findByType(ContainerType.UNDER_6_5);
        for (int i = 0; i < childNodes.size(); i++) {
            Node child = childNodes.get(i);
            if (!(child instanceof TextNode)) {
                continue;
            }
            String text = ((TextNode) child).text();
            if (text.contains("(5.5) больше ")) {
                String totalUnder5AndHalfCoeff = childNodes.get(i + 3).childNode(0).childNode(0).outerHtml();
                under5AndHalf.getCoeff().set(Double.valueOf(totalUnder5AndHalfCoeff));
            }

            if (text.contains("(6.5) больше ")) {
                String totalUnder6AndHalfCoeff = childNodes.get(i + 3).childNode(0).childNode(0).outerHtml();
                under6AndHalf.getCoeff().set(Double.valueOf(totalUnder6AndHalfCoeff));
            }
        }
    }

    private void fillBothTeamsTotalOverBlock(Element element, CoeffContainer container) {
        fillBetWithSinglePossibleOption(
                element, container,
                Arrays.asList(
                        new BetEntry("каждая команда забьет больше 1,5", ContainerType.OVER_1_5),
                        new BetEntry("каждая команда забьет больше 2,5", ContainerType.OVER_2_5)
                )
        );
    }

    private void fillBothTeamsTotalUnderBlock(Element element, CoeffContainer container) {
        fillBetWithSinglePossibleOption(
                element, container,
                Arrays.asList(
                        new BetEntry("каждая команда забьет меньше 2,5", ContainerType.UNDER_2_5),
                        new BetEntry("каждая команда забьет меньше 3,5", ContainerType.UNDER_3_5)
                )
        );
    }

    private void fillTeamTotalOverBlock(Element element, CoeffContainer totalOverContainer, Team homeTeam) {

        Element totalElementBlock = element.select("th:containsOwn(Дополнительные тоталы:)")
                .first().parent().nextElementSibling();

        Element temp = totalElementBlock.select("i:containsOwn(" + homeTeam.getName() + ")").first();
        Element teamTotalBlock = temp.parent().nextElementSibling();
        List<Node> childNodes = teamTotalBlock.childNodes();
        CoeffContainer over2AndHalf = totalOverContainer.findByType(ContainerType.OVER_2_5);
        CoeffContainer over3AndHalf = totalOverContainer.findByType(ContainerType.OVER_3_5);
        for (int i = 0; i < childNodes.size(); i++) {
            Node child = childNodes.get(i);
            if (!(child instanceof TextNode)) {
                continue;
            }
            String text = ((TextNode) child).text();
            if (text.contains("(2.5) больше")) {
                String totalOver2AndHalfCoeff = childNodes.get(i + 1).childNode(0).childNode(0).outerHtml();
                over2AndHalf.getCoeff().set(Double.valueOf(totalOver2AndHalfCoeff));
            }

            if (text.contains("(3.5) больше")) {
                String totalOver3AndHalfCoeff = childNodes.get(i + 1).childNode(0).childNode(0).outerHtml();
                over3AndHalf.getCoeff().set(Double.valueOf(totalOver3AndHalfCoeff));
            }
        }
    }

    private void fillTeamTotalUnderBlock(Element element, CoeffContainer totalOverContainer, Team homeTeam) {

        Element totalElementBlock = element.select("th:containsOwn(Дополнительные тоталы:)")
                .first().parent().nextElementSibling();

        Element temp = totalElementBlock.select("i:containsOwn(" + homeTeam.getName() + ")").first();
        Element teamTotalBlock = temp.parent().nextElementSibling();
        List<Node> childNodes = teamTotalBlock.childNodes();
        CoeffContainer under2AndHalf = totalOverContainer.findByType(ContainerType.UNDER_2_5);
        CoeffContainer under3AndHalf = totalOverContainer.findByType(ContainerType.UNDER_3_5);
        for (int i = 0; i < childNodes.size(); i++) {
            Node child = childNodes.get(i);
            if (!(child instanceof TextNode)) {
                continue;
            }
            String text = ((TextNode) child).text();
            if (text.contains("(2.5) больше")) {
                String underOver2AndHalfCoeff = childNodes.get(i + 3).childNode(0).childNode(0).outerHtml();
                under2AndHalf.getCoeff().set(Double.valueOf(underOver2AndHalfCoeff));
            }

            if (text.contains("(3.5) больше")) {
                String underOver3AndHalfCoeff = childNodes.get(i + 3).childNode(0).childNode(0).outerHtml();
                under3AndHalf.getCoeff().set(Double.valueOf(underOver3AndHalfCoeff));
            }
        }
    }


    private void fillOtherBlock(Element element, CoeffContainer otherContainer, HockeyFutureMatch match) {
        fillPeriodAnyWinAndDiffEqualsBlock(element, otherContainer.findByType(ContainerType.ANY_WIN_AND_DIFFERENCE_EQUALS));

        fillTeamWinAndTotalOverBlock(element, otherContainer.findByType(ContainerType.TEAM_WIN_AND_TOTAL_OVER), match.getHomeTeam());
        fillTeamWinAndTotalUnderBlock(element, otherContainer.findByType(ContainerType.TEAM_WIN_AND_TOTAL_UNDER), match.getHomeTeam());
        fillTeamNotLooseAndTotalOverBlock(element, otherContainer.findByType(ContainerType.TEAM_NOT_LOOSE_AND_TOTAL_OVER), match.getHomeTeam());
        fillTeamNotLooseAndTotalUnderBlock(element, otherContainer.findByType(ContainerType.TEAM_NOT_LOOSE_AND_TOTAL_UNDER), match.getHomeTeam());

        fillTeamWinAndTotalOverBlock(element, otherContainer.findByType(ContainerType.OPPOSING_TEAM_WIN_AND_TOTAL_OVER), match.getGuestTeam());
        fillTeamWinAndTotalUnderBlock(element, otherContainer.findByType(ContainerType.OPPOSING_TEAM_WIN_AND_TOTAL_UNDER), match.getGuestTeam());
        fillTeamNotLooseAndTotalOverBlock(element, otherContainer.findByType(ContainerType.OPPOSING_TEAM_NOT_LOOSE_AND_TOTAL_OVER), match.getGuestTeam());
        fillTeamNotLooseAndTotalUnderBlock(element, otherContainer.findByType(ContainerType.OPPOSING_TEAM_NOT_LOOSE_AND_TOTAL_UNDER), match.getGuestTeam());

        fillTotalOverInAllPeriodsBlock(element, otherContainer.findByType(ContainerType.TOTAL_OVER_ALL_PERIODS));
        fillTeamTotalOverInAllPeriodsBlock(element, otherContainer.findByType(ContainerType.TEAM_TOTAL_OVER_ALL_PERIODS), match.getHomeTeam());
        fillTeamTotalOverInAllPeriodsBlock(element, otherContainer.findByType(ContainerType.OPPOSING_TEAM_TOTAL_OVER_ALL_PERIODS), match.getGuestTeam());

        fillTotalUnderInAllPeriodsBlock(element, otherContainer.findByType(ContainerType.TOTAL_UNDER_ALL_PERIODS));

        fillTeamWinAtLeastNPeriodsBlock(element, otherContainer.findByType(ContainerType.TEAM_WIN_AT_LEAST_N_PERIODS), match.getHomeTeam());
        fillTeamWinAtLeastNPeriodsBlock(element, otherContainer.findByType(ContainerType.OPPOSING_TEAM_WIN_AT_LEAST_N_PERIODS), match.getGuestTeam());

        fillDrawAtLeastNPeriodsBlock(element, otherContainer.findByType(ContainerType.DRAW_AT_LEAST_N_PERIODS));
        fillMostEffectivePeriodTotalOverBlock(element, otherContainer.findByType(ContainerType.MOST_EFFECTIVE_PERIOD_TOTAL_OVER));

        fillTeamFirstScoredAndWinBlock(element, otherContainer.findByType(ContainerType.TEAM_FIRST_SCORED_AND_WIN), ContainerType.TEAM_FIRST_SCORED_AND_WIN, match.getHomeTeam());
        fillTeamFirstScoredAndWinBlock(element, otherContainer.findByType(ContainerType.OPPOSING_TEAM_FIRST_SCORED_AND_WIN), ContainerType.OPPOSING_TEAM_FIRST_SCORED_AND_WIN, match.getGuestTeam());

        fillAnyComebackMatchBlock(element, otherContainer.findByType(ContainerType.ANY_COMEBACK));


    }

    private void fillPeriodsBlock(Element element, CoeffContainer periodsContainer, HockeyFutureMatch match) {

        fillBetWithPossibleOptionsForTeamPeriodTotal(
                element, periodsContainer.findByType(ContainerType.FIRST_PERIOD).findByType(ContainerType.TEAM_TOTAL_OVER),
                Arrays.asList(
                        new BetEntry("в первом периоде", ContainerType.OVER_0_5)
                ), match.getHomeTeam()
        );

        fillBetWithPossibleOptionsForTeamPeriodTotal(
                element, periodsContainer.findByType(ContainerType.FIRST_PERIOD).findByType(ContainerType.OPPOSING_TEAM_TOTAL_OVER),
                Arrays.asList(
                        new BetEntry("в первом периоде", ContainerType.OVER_0_5)
                ), match.getGuestTeam()
        );

        fillBetWithSinglePossibleOption(
                element, periodsContainer.findByType(ContainerType.FIRST_PERIOD).findByType(ContainerType.BOTH_TEAMS_TOTAL_OVER),
                Arrays.asList(
                        new BetEntry("обе команды забьют в первом периоде", ContainerType.OVER_0_5)
                )
        );



        fillBetWithPossibleOptionsForTeamPeriodTotal(
                element, periodsContainer.findByType(ContainerType.SECOND_PERIOD).findByType(ContainerType.TEAM_TOTAL_OVER),
                Arrays.asList(
                        new BetEntry("во втором периоде", ContainerType.OVER_0_5)
                ), match.getHomeTeam()
        );

        fillBetWithPossibleOptionsForTeamPeriodTotal(
                element, periodsContainer.findByType(ContainerType.SECOND_PERIOD).findByType(ContainerType.OPPOSING_TEAM_TOTAL_OVER),
                Arrays.asList(
                        new BetEntry("во втором периоде", ContainerType.OVER_0_5)
                ), match.getGuestTeam()
        );

        fillBetWithSinglePossibleOption(
                element, periodsContainer.findByType(ContainerType.SECOND_PERIOD).findByType(ContainerType.BOTH_TEAMS_TOTAL_OVER),
                Arrays.asList(
                        new BetEntry("обе команды забьют во втором периоде", ContainerType.OVER_0_5)
                )
        );



        fillBetWithPossibleOptionsForTeamPeriodTotal(
                element, periodsContainer.findByType(ContainerType.THIRD_PERIOD).findByType(ContainerType.TEAM_TOTAL_OVER),
                Arrays.asList(
                        new BetEntry("в третьем периоде", ContainerType.OVER_0_5)
                ), match.getHomeTeam()
        );

        fillBetWithPossibleOptionsForTeamPeriodTotal(
                element, periodsContainer.findByType(ContainerType.THIRD_PERIOD).findByType(ContainerType.OPPOSING_TEAM_TOTAL_OVER),
                Arrays.asList(
                        new BetEntry("в третьем периоде", ContainerType.OVER_0_5)
                ), match.getGuestTeam()
        );

        fillBetWithSinglePossibleOption(
                element, periodsContainer.findByType(ContainerType.THIRD_PERIOD).findByType(ContainerType.BOTH_TEAMS_TOTAL_OVER),
                Arrays.asList(
                        new BetEntry("обе команды забьют в третьем периоде", ContainerType.OVER_0_5)
                )
        );
    }


    private void fillPeriodAnyWinAndDiffEqualsBlock(Element element, CoeffContainer container) {
        fillBetWithSinglePossibleOption(
                element, container,
                Arrays.asList(
                        new BetEntry("победа любой команды в 1 шайбу", ContainerType.DIFF_1),
                        new BetEntry("победа любой команды в 2 шайбы", ContainerType.DIFF_2),
                        new BetEntry("победа любой команды в 3 или более шайбы", ContainerType.DIFF_3_OR_MORE)
                )
        );
    }

    private void fillTeamWinAndTotalOverBlock(Element element, CoeffContainer container, Team team) {
        fillBetWithPossibleOptionsForTeam(
                element, container,
                Arrays.asList(
                        new BetEntry("победит и тотал больше 4.5", ContainerType.OVER_4_5),
                        new BetEntry("победит и тотал больше 5.5", ContainerType.OVER_5_5)
                ), team
        );
    }


    private void fillTeamWinAndTotalUnderBlock(Element element, CoeffContainer container, Team team) {
        fillBetWithPossibleOptionsForTeam(
                element, container,
                Arrays.asList(
                        new BetEntry("победит и тотал меньше 4.5", ContainerType.UNDER_4_5),
                        new BetEntry("победит и тотал меньше 5.5", ContainerType.UNDER_5_5)
                ), team
        );
    }

    private void fillTeamNotLooseAndTotalOverBlock(Element element, CoeffContainer container, Team team) {
        fillBetWithPossibleOptionsForTeam(
                element, container,
                Arrays.asList(
                        new BetEntry("не проиграет и тотал больше 4.5", ContainerType.OVER_4_5),
                        new BetEntry("не проиграет и тотал больше 5.5", ContainerType.OVER_5_5)
                ), team
        );
    }

    private void fillTeamNotLooseAndTotalUnderBlock(Element element, CoeffContainer container, Team team) {
        fillBetWithPossibleOptionsForTeam(
                element, container,
                Arrays.asList(
                        new BetEntry("не проиграет и тотал меньше 4.5", ContainerType.UNDER_4_5),
                        new BetEntry("не проиграет и тотал меньше 5.5", ContainerType.UNDER_5_5)
                ), team
        );
    }

    private void fillTotalOverInAllPeriodsBlock(Element element, CoeffContainer container) {

        fillBetWithSinglePossibleOption(
                element, container,
                Arrays.asList(
                        new BetEntry("Тотал самого нерезультативного периода больше 0,5", ContainerType.OVER_0_5)
                )
        );

    }

    private void fillTeamTotalOverInAllPeriodsBlock(Element element, CoeffContainer container, Team team) {

        fillBetWithPossibleOptionsForTeam(
                element, container,
                Arrays.asList(new BetEntry("забьет в каждом периоде:", ContainerType.OVER_0_5)), team
        );

    }


    private void fillTotalUnderInAllPeriodsBlock(Element element, CoeffContainer container) {

        fillBetWithSinglePossibleOption(
                element, container,
                Arrays.asList(
                        new BetEntry("каждый период меньше 2,5", ContainerType.UNDER_2_5),
                        new BetEntry("каждый период меньше 3,5", ContainerType.UNDER_3_5)
                )
        );

    }

    private void fillTeamWinAtLeastNPeriodsBlock(Element element, CoeffContainer container, Team team) {
        fillBetWithPossibleOptionsForTeam(
                element, container,
                Arrays.asList(
                        new BetEntry("выиграет хотя бы один период", ContainerType.NUMBER_1),
                        new BetEntry("выиграет хотя бы два периода", ContainerType.NUMBER_2)
                ), team
        );
    }

    private void fillDrawAtLeastNPeriodsBlock(Element element, CoeffContainer container) {

        fillBetWithSinglePossibleOption(
                element, container,
                Arrays.asList(
                        new BetEntry("Ничья хотя бы в одном периоде", ContainerType.NUMBER_1),
                        new BetEntry("Ничья хотя бы в двух периодах", ContainerType.NUMBER_2)
                )
        );

    }

    private void fillMostEffectivePeriodTotalOverBlock(Element element, CoeffContainer container) {

        fillBetWithSinglePossibleOption(
                element, container,
                Arrays.asList(
                        new BetEntry("Тотал самого результативного периода больше 2,5", ContainerType.OVER_2_5),
                        new BetEntry("Тотал самого результативного периода больше 3,5", ContainerType.OVER_3_5)
                )
        );

    }

    private void fillTeamFirstScoredAndWinBlock(Element element, CoeffContainer container, ContainerType type, Team team) {
        fillBetWithPossibleOptionsForTeam(
                element, container,
                Arrays.asList(
                        new BetEntry("забросит шайбу первой и выиграет", type)
                ), team
        );
    }

    private void fillAnyComebackMatchBlock(Element element, CoeffContainer container) {

        fillBetWithSinglePossibleOption(
                element, container,
                Arrays.asList(
                        new BetEntry("волевая победа в матче", ContainerType.ANY_COMEBACK)
                )
        );

    }


    private void fillBetWithPossibleOptionsForTeam(Element element, CoeffContainer container, List<BetEntry> betEntries, Team team) {
        for (BetEntry betEntry : betEntries) {

            Elements elements = element.select("i:containsOwn(" + betEntry.getBetName() + ")");

            for (int i = 0; i < elements.size(); i++) {
                Element child = elements.get(i);
                if (child.text().contains(team.getName())) {
                    Element positiveElement = child.nextElementSibling().child(0).child(0);
                    Element negativeElement = child.nextElementSibling()
                            .nextElementSibling().child(0).child(0);

                    CoeffContainer coeffContainer = container.findByType(betEntry.getContainerType());
                    coeffContainer.getCoeff().set(
                            Double.valueOf(positiveElement.text()),
                            Double.valueOf(negativeElement.text())
                    );
                }
            }
        }
    }

    private void fillBetWithPossibleOptionsForTeamPeriodTotal(Element element, CoeffContainer container, List<BetEntry> betEntries, Team team) {
        for (BetEntry betEntry : betEntries) {

            Elements elements = element.select("i:containsOwn(" + betEntry.getBetName() + ")");

            for (int i = 0; i < elements.size(); i++) {
                Element child = elements.get(i);
                if (child.text().contains(team.getName())) {
                    Element positiveElement = child.nextElementSibling().nextElementSibling().child(0).child(0);
                    Element negativeElement = child.nextElementSibling().child(0).child(0);

                    CoeffContainer coeffContainer = container.findByType(betEntry.getContainerType());
                    coeffContainer.getCoeff().set(
                            Double.valueOf(positiveElement.text()),
                            Double.valueOf(negativeElement.text())
                    );
                }
            }
        }
    }

    private void fillBetWithSinglePossibleOption(Element element, CoeffContainer container, List<BetEntry> betEntries) {
        for (BetEntry betEntry : betEntries) {

            Element elementBlock = element.select("i:containsOwn(" + betEntry.getBetName() + ")")
                    .first();
            Element positiveElement = elementBlock.nextElementSibling().child(0).child(0);
            Element negativeElement = elementBlock.nextElementSibling()
                    .nextElementSibling().child(0).child(0);

            CoeffContainer coeffContainer = container.findByType(betEntry.getContainerType());
            coeffContainer.getCoeff().set(
                    Double.valueOf(positiveElement.text()),
                    Double.valueOf(negativeElement.text())
            );
        }
    }

    @AllArgsConstructor
    @Getter
    class BetEntry {
        private String betName;
        private ContainerType containerType;
    }


}

