package com.savik.parser.hockey.coeffs;

import com.savik.Coeff;
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
import java.util.List;

import static com.savik.ContainerType.*;
import static java.util.Arrays.asList;


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

        Path statsPath = null;
        Path shotsPath = null;
        Path penaltiesPath = null;
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
        HockeyTeam guestTeam = hockeyFutureMatch.getGuestTeam();

        CoeffBlock coeffBlock = new CoeffBlock();
        Element tempHref = null;
        if (!statsHtml.select("a.om:containsOwn(" + homeTeam.getName() + ")").isEmpty()) {
            tempHref = statsHtml.select(String.format("a.om:containsOwn(%s)", homeTeam.getName())).get(0);
        }
        if (tempHref == null && !statsHtml.select(String.format("a.om:containsOwn(%s)", guestTeam.getName())).isEmpty()) {
            tempHref = statsHtml.select(String.format("a.om:containsOwn(%s)", guestTeam.getName())).get(0);
        }
        Element matchTbodyTag = tempHref.parent().parent().parent();
        Element matchCoeffsTbodyTag = matchTbodyTag.nextElementSibling();

        fillSomeSpecialBets(tempHref.parent().parent(), coeffBlock);
        fillTotalBlock(matchCoeffsTbodyTag, coeffBlock.findByType(TOTAL), hockeyFutureMatch);
        fillOtherBlock(matchCoeffsTbodyTag, coeffBlock.findByType(OTHER), hockeyFutureMatch);
        fillHandicapBlock(matchCoeffsTbodyTag, coeffBlock.findByType(HANDICAP), hockeyFutureMatch);
        fillPeriodsBlock(matchCoeffsTbodyTag, coeffBlock.findByType(PERIODS), hockeyFutureMatch);


        Document shotsHtml = downloader.downloadFile(new File(shotsPath.toUri()));
        if (!shotsHtml.select(String.format("a.om:contains(%s)", homeTeam.getName())).isEmpty()) {
            tempHref = shotsHtml.select(String.format("a.om:contains(%s)", homeTeam.getName())).get(0);
            fillShotsSpecialBets(tempHref.parent().parent(), coeffBlock.findByType(STATS));
            fillShotsBets(
                    tempHref.parent().parent().parent().nextElementSibling(),
                    coeffBlock.findByType(STATS), hockeyFutureMatch
            );
        }

        Document penaltiesHtml = downloader.downloadFile(new File(penaltiesPath.toUri()));
        if (!penaltiesHtml.select(String.format("td:contains(%s)", homeTeam.getName())).isEmpty()) {
            tempHref = penaltiesHtml.select(String.format("td:contains(%s)", homeTeam.getName())).get(0);
            fillPenaltiesSpecialBets(tempHref.parent().parent(), coeffBlock.findByType(STATS));
        }


        return coeffBlock;
    }

    // which placed on parimatch main screen
    private void fillSomeSpecialBets(Element element, CoeffContainer container) {
        Elements tds = element.select("td");
        // total over/under
        if (tds.get(5) != null) {
            String totalOverText = tds.get(5).select("b").text();
            String totalOverCoeff = tds.get(6).select("u a").text();
            String totalUnderCoeff = tds.get(7).select("u a").text();
            CoeffContainer totalContainer = container.findByType(TOTAL);
            CoeffContainer totalOverContainer = totalContainer.findByType(TOTAL_OVER);
            CoeffContainer over4AndHalf = totalOverContainer.findByType(OVER_4_5);
            CoeffContainer over5AndHalf = totalOverContainer.findByType(OVER_5_5);
            CoeffContainer totalUnderContainer = totalContainer.findByType(TOTAL_UNDER);
            CoeffContainer under4AndHalf = totalUnderContainer.findByType(UNDER_4_5);
            CoeffContainer under5AndHalf = totalUnderContainer.findByType(UNDER_5_5);
            checkIfContainsAndSetOverAndUnder(totalOverText, over4AndHalf, under4AndHalf, "4.5", Double.valueOf(totalOverCoeff), Double.valueOf(totalUnderCoeff));
            checkIfContainsAndSetOverAndUnder(totalOverText, over5AndHalf, under5AndHalf, "5.5", Double.valueOf(totalOverCoeff), Double.valueOf(totalUnderCoeff));
        }
        // team total over/under
        if (tds.get(15) != null) {
            String totalOverText = tds.get(14).select("b").first().text();
            String totalOverCoeff = tds.get(15).select("u a").first().text();
            String totalUnderCoeff = tds.get(16).select("u a").first().text();
            CoeffContainer totalContainer = container.findByType(TOTAL);
            CoeffContainer teamTotalOverContainer = totalContainer.findByType(TEAM_TOTAL_OVER);
            CoeffContainer over1AndHalf = teamTotalOverContainer.findByType(OVER_1_5);
            CoeffContainer over2AndHalf = teamTotalOverContainer.findByType(OVER_2_5);
            CoeffContainer over3AndHalf = teamTotalOverContainer.findByType(OVER_3_5);
            CoeffContainer totalUnderContainer = totalContainer.findByType(TEAM_TOTAL_UNDER);
            CoeffContainer under1AndHalf = totalUnderContainer.findByType(UNDER_1_5);
            CoeffContainer under2AndHalf = totalUnderContainer.findByType(UNDER_2_5);
            CoeffContainer under3AndHalf = totalUnderContainer.findByType(UNDER_3_5);

            checkIfContainsAndSetOverAndUnder(totalOverText, over1AndHalf, under1AndHalf, asList("1.5", "1.0"),
                    Double.valueOf(totalOverCoeff), Double.valueOf(totalUnderCoeff));

            checkIfContainsAndSetOverAndUnder(totalOverText, over2AndHalf, under2AndHalf, asList("2.5", "2.0"),
                    Double.valueOf(totalOverCoeff), Double.valueOf(totalUnderCoeff));

            checkIfContainsAndSetOverAndUnder(totalOverText, over3AndHalf, under3AndHalf, asList("3.5", "3.0"),
                    Double.valueOf(totalOverCoeff), Double.valueOf(totalUnderCoeff));
        }
        //  opposing team total over/under
        if (tds.get(15) != null) {
            String totalOverText = tds.get(14).select("b").get(1).text();
            String totalOverCoeff = tds.get(15).select("u a").get(1).text();
            String totalUnderCoeff = tds.get(16).select("u a").get(1).text();
            CoeffContainer totalContainer = container.findByType(TOTAL);
            CoeffContainer teamTotalOverContainer = totalContainer.findByType(OPPOSING_TEAM_TOTAL_OVER);
            CoeffContainer over1AndHalf = teamTotalOverContainer.findByType(OVER_1_5);
            CoeffContainer over2AndHalf = teamTotalOverContainer.findByType(OVER_2_5);
            CoeffContainer over3AndHalf = teamTotalOverContainer.findByType(OVER_3_5);
            CoeffContainer totalUnderContainer = totalContainer.findByType(OPPOSING_TEAM_TOTAL_UNDER);
            CoeffContainer under1AndHalf = totalUnderContainer.findByType(UNDER_1_5);
            CoeffContainer under2AndHalf = totalUnderContainer.findByType(UNDER_2_5);
            CoeffContainer under3AndHalf = totalUnderContainer.findByType(UNDER_3_5);

            checkIfContainsAndSetOverAndUnder(totalOverText, over1AndHalf, under1AndHalf, asList("1.5", "1.0"),
                    Double.valueOf(totalOverCoeff), Double.valueOf(totalUnderCoeff));

            checkIfContainsAndSetOverAndUnder(totalOverText, over2AndHalf, under2AndHalf, asList("2.5", "2.0"),
                    Double.valueOf(totalOverCoeff), Double.valueOf(totalUnderCoeff));

            checkIfContainsAndSetOverAndUnder(totalOverText, over3AndHalf, under3AndHalf, asList("3.5", "3.0"),
                    Double.valueOf(totalOverCoeff), Double.valueOf(totalUnderCoeff));
        }
    }

    private void checkIfContainsAndSetOverAndUnder(String text, CoeffContainer overContainer,
                                                   CoeffContainer underContainer, List<String> options, Double over, Double under) {
        for (String option : options) {
            checkIfContainsAndSetValue(text, overContainer, option, over);
            checkIfContainsAndSetValue(text, underContainer, option, under);
        }

    }

    private void checkIfContainsAndSetOverAndUnder(String text, CoeffContainer overContainer,
                                                   CoeffContainer underContainer, String option, Double over, Double under) {
        checkIfContainsAndSetOverAndUnder(text, overContainer, underContainer, asList(option), over, under);
    }

    private void checkIfContainsAndSetValue(String text, CoeffContainer container, String option, Double coeff) {
        if (text.contains(option)) {
            container.getCoeff().set(coeff);
        }
    }

    private void checkIfContainsAndSetPosAndNeg(String text, CoeffContainer container,
                                                String option, Double posCoeff, Double negCoeff) {
        checkIfContainsAndSetPosAndNeg(text, container, asList(option), posCoeff, negCoeff);
    }

    private void checkIfContainsAndSetPosAndNeg(String text, CoeffContainer container,
                                                List<String> options, Double posCoeff, Double negCoeff) {
        for (String option : options) {
            if (text.contains(option)) {
                container.getCoeff().set(posCoeff, negCoeff);
            }
        }
    }


    // which placed on parimatch main screen
    private void fillShotsSpecialBets(Element element, CoeffContainer container) {
        Elements tds = element.select("td");
        // shots on target handicap
        if (tds.get(3) != null) {
            String teamHandicapText = tds.get(3).select("b").first().text();
            String teamHandicapCoeff = tds.get(4).select("u a").first().text();
            CoeffContainer teamHandicapBlock = container.findByType(TEAM_SHOTS_ON_TARGET_HANDICAP);
            fillShotsHandicap(teamHandicapText, Double.valueOf(teamHandicapCoeff), teamHandicapBlock);

            String oppTeamHandicapText = tds.get(3).select("b").get(1).text();
            String oppTeamHandicapCoeff = tds.get(4).select("u a").get(1).text();
            CoeffContainer oppTeamHandicapBlock = container.findByType(OPPOSING_TEAM_SHOTS_ON_TARGET_HANDICAP);
            fillShotsHandicap(oppTeamHandicapText, Double.valueOf(oppTeamHandicapCoeff), oppTeamHandicapBlock);
        }

        // shots on target total over
        if (tds.get(5) != null) {
            String totalText = tds.get(5).select("b").first().text();
            String totalOverCoeff = tds.get(6).select("u a").first().text();
            String totalUnderCoeff = tds.get(7).select("u a").first().text();
            CoeffContainer teamTotalOverContainer = container.findByType(SHOTS_ON_TARGET_OVER);
            CoeffContainer over57AndHalf = teamTotalOverContainer.findByType(OVER_57_5);
            CoeffContainer over59AndHalf = teamTotalOverContainer.findByType(OVER_59_5);
            CoeffContainer over60AndHalf = teamTotalOverContainer.findByType(OVER_60_5);
            CoeffContainer over61AndHalf = teamTotalOverContainer.findByType(OVER_61_5);
            CoeffContainer over62AndHalf = teamTotalOverContainer.findByType(OVER_62_5);
            CoeffContainer over63AndHalf = teamTotalOverContainer.findByType(OVER_63_5);

            Double overValue = Double.valueOf(totalOverCoeff);
            Double underValue = Double.valueOf(totalUnderCoeff);

            checkIfContainsAndSetPosAndNeg(totalText, over57AndHalf, "57.5", overValue, underValue);
            checkIfContainsAndSetPosAndNeg(totalText, over59AndHalf, "59.5", overValue, underValue);
            checkIfContainsAndSetPosAndNeg(totalText, over60AndHalf, "60.5", overValue, underValue);
            checkIfContainsAndSetPosAndNeg(totalText, over61AndHalf, "61.5", overValue, underValue);
            checkIfContainsAndSetPosAndNeg(totalText, over62AndHalf, "62.5", overValue, underValue);
            checkIfContainsAndSetPosAndNeg(totalText, over63AndHalf, "63.5", overValue, underValue);

        }

        if (tds.get(8) != null) {
            String coeff = tds.get(8).select("u a").first().text();
            CoeffContainer winContainer = container.findByType(TEAM_SHOTS_ON_TARGET_WIN);
            winContainer.getCoeff().set(Double.valueOf(coeff));
        }
        if (tds.get(10) != null) {
            String coeff = tds.get(10).select("u a").first().text();
            CoeffContainer winContainer = container.findByType(OPPOSING_TEAM_SHOTS_ON_TARGET_WIN);
            winContainer.getCoeff().set(Double.valueOf(coeff));
        }


        if (tds.get(14) != null) {
            String totalText = tds.get(14).select("b").first().text();
            String totalOverCoeff = tds.get(15).select("u a").first().text();
            String totalUnderCoeff = tds.get(16).select("u a").first().text();
            CoeffContainer teamTotalOverContainer = container.findByType(TEAM_SHOTS_ON_TARGET_OVER);
            fillShotsTotalOver(totalText, totalOverCoeff, totalUnderCoeff, teamTotalOverContainer);
        }

        if (tds.get(14) != null) {
            String totalText = tds.get(14).select("b").get(1).text();
            String totalOverCoeff = tds.get(15).select("u a").get(1).text();
            String totalUnderCoeff = tds.get(16).select("u a").get(1).text();
            CoeffContainer teamTotalOverContainer = container.findByType(OPPOSING_TEAM_SHOTS_ON_TARGET_OVER);
            fillShotsTotalOver(totalText, totalOverCoeff, totalUnderCoeff, teamTotalOverContainer);

        }
    }

    private void fillShotsTotalOver(String totalText, String totalOverCoeff, String totalUnderCoeff, CoeffContainer teamTotalOverContainer) {
        CoeffContainer over28AndHalf = teamTotalOverContainer.findByType(OVER_28_5);
        CoeffContainer over30AndHalf = teamTotalOverContainer.findByType(OVER_30_5);
        CoeffContainer over32AndHalf = teamTotalOverContainer.findByType(OVER_32_5);

        Double overValue = Double.valueOf(totalOverCoeff);
        Double underValue = Double.valueOf(totalUnderCoeff);

        checkIfContainsAndSetPosAndNeg(totalText, over28AndHalf, asList("28.5", "28.0", "29.0", "29.5"), overValue, underValue);
        checkIfContainsAndSetPosAndNeg(totalText, over30AndHalf, asList("30.5", "30.0", "31.0", "31.5"), overValue, underValue);
        checkIfContainsAndSetPosAndNeg(totalText, over32AndHalf, asList("32.5", "32.0", "33.0", "34.0"), overValue, underValue);
    }

    private void fillShotsHandicap(String handicapText, Double handicapCoeff, CoeffContainer handicapBlock) {
        CoeffContainer plus1AndHalf = handicapBlock.findByType(PLUS_1_5);
        CoeffContainer plus2AndHalf = handicapBlock.findByType(PLUS_2_5);
        CoeffContainer plus3AndHalf = handicapBlock.findByType(PLUS_3_5);
        CoeffContainer plus4AndHalf = handicapBlock.findByType(PLUS_4_5);
        CoeffContainer plus5AndHalf = handicapBlock.findByType(PLUS_5_5);
        CoeffContainer minus1AndHalf = handicapBlock.findByType(MINUS_1_5);
        CoeffContainer minus2AndHalf = handicapBlock.findByType(MINUS_2_5);
        CoeffContainer minus3AndHalf = handicapBlock.findByType(MINUS_3_5);
        CoeffContainer minus4AndHalf = handicapBlock.findByType(MINUS_4_5);
        CoeffContainer minus5AndHalf = handicapBlock.findByType(MINUS_5_5);

        checkIfContainsAndSetValue(handicapText, plus1AndHalf, "+1.5", handicapCoeff);
        checkIfContainsAndSetValue(handicapText, plus2AndHalf, "+2.5", handicapCoeff);
        checkIfContainsAndSetValue(handicapText, plus3AndHalf, "+3.5", handicapCoeff);
        checkIfContainsAndSetValue(handicapText, plus4AndHalf, "+4.5", handicapCoeff);
        checkIfContainsAndSetValue(handicapText, plus5AndHalf, "+5.5", handicapCoeff);

        checkIfContainsAndSetValue(handicapText, minus1AndHalf, "–1.5", handicapCoeff);
        checkIfContainsAndSetValue(handicapText, minus2AndHalf, "–2.5", handicapCoeff);
        checkIfContainsAndSetValue(handicapText, minus3AndHalf, "–3.5", handicapCoeff);
        checkIfContainsAndSetValue(handicapText, minus4AndHalf, "–4.5", handicapCoeff);
        checkIfContainsAndSetValue(handicapText, minus5AndHalf, "–5.5", handicapCoeff);
    }

    private void fillShotsBets(Element element, CoeffContainer container, HockeyFutureMatch match) {
        fillShotsTotalOverBlock(element, container);
        fillShotsHandicap(element, container, match.getHomeTeam(), TEAM_SHOTS_ON_TARGET_HANDICAP);
        fillShotsHandicap(element, container, match.getGuestTeam(), OPPOSING_TEAM_SHOTS_ON_TARGET_HANDICAP);
    }

    private void fillShotsTotalOverBlock(Element element, CoeffContainer container) {
        Element totalElementBlock = element.select("th:containsOwn(Дополнительные тоталы:)")
                .first().parent().nextElementSibling();

        Element generalTotalHtmlBlock = totalElementBlock.select("td:containsOwn(больше)").first();
        List<Node> childNodes = generalTotalHtmlBlock.childNodes();
        CoeffContainer teamTotalOverContainer = container.findByType(SHOTS_ON_TARGET_OVER);
        CoeffContainer over57AndHalf = teamTotalOverContainer.findByType(OVER_57_5);
        CoeffContainer over59AndHalf = teamTotalOverContainer.findByType(OVER_59_5);
        CoeffContainer over60AndHalf = teamTotalOverContainer.findByType(OVER_60_5);
        CoeffContainer over61AndHalf = teamTotalOverContainer.findByType(OVER_61_5);
        CoeffContainer over62AndHalf = teamTotalOverContainer.findByType(OVER_62_5);
        CoeffContainer over63AndHalf = teamTotalOverContainer.findByType(OVER_63_5);

        for (int i = 0; i < childNodes.size(); i++) {
            Node child = childNodes.get(i);
            if (!(child instanceof TextNode)) {
                continue;
            }
            String text = ((TextNode) child).text();
            Double overValue = null;
            Double underValue = null;
            if (i < childNodes.size() - 4) {
                String totalOverCoeff = childNodes.get(i + 1).childNode(0).childNode(0).outerHtml();
                String totalunderCoeff = childNodes.get(i + 3).childNode(0).childNode(0).outerHtml();
                overValue = Double.valueOf(totalOverCoeff);
                underValue = Double.valueOf(totalunderCoeff);
            }

            checkIfContainsAndSetPosAndNeg(text, over57AndHalf, "57.5", overValue, underValue);
            checkIfContainsAndSetPosAndNeg(text, over59AndHalf, "59.5", overValue, underValue);
            checkIfContainsAndSetPosAndNeg(text, over60AndHalf, "60.5", overValue, underValue);
            checkIfContainsAndSetPosAndNeg(text, over61AndHalf, "61.5", overValue, underValue);
            checkIfContainsAndSetPosAndNeg(text, over62AndHalf, "62.5", overValue, underValue);
            checkIfContainsAndSetPosAndNeg(text, over63AndHalf, "63.5", overValue, underValue);
        }
    }

    private void fillShotsHandicap(Element element, CoeffContainer container, HockeyTeam team, ContainerType type) {
        Element totalElementBlock = element.select("th:containsOwn(Дополнительные форы:)")
                .first().parent().nextElementSibling();


        Element temp = totalElementBlock.select(String.format("i:contains(%s)", team.getName())).first();
        Element teamTotalBlock = temp.parent().nextElementSibling();
        List<Node> childNodes = teamTotalBlock.childNodes();
        CoeffContainer handicapBlock = container.findByType(type);


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

            fillShotsHandicap(handicapText, value, handicapBlock);
        }
    }

    // which placed on parimatch main screen
    private void fillPenaltiesSpecialBets(Element element, CoeffContainer container) {
        Elements tds = element.select("td");

        if (tds.get(5) != null) {
            String totalText = tds.get(5).select("b").first().text();
            String totalOverCoeff = tds.get(6).select("u a").first().text();
            String totalUnderCoeff = tds.get(7).select("u a").first().text();
            CoeffContainer teamTotalOverContainer = container.findByType(PENALTIES_TIME_OVER);
            CoeffContainer over13AndHalf = teamTotalOverContainer.findByType(OVER_13_5);
            CoeffContainer over14AndHalf = teamTotalOverContainer.findByType(OVER_14_5);
            CoeffContainer over15AndHalf = teamTotalOverContainer.findByType(OVER_15_5);

            Double overValue = Double.valueOf(totalOverCoeff);
            Double underValue = Double.valueOf(totalUnderCoeff);

            checkIfContainsAndSetPosAndNeg(totalText, over13AndHalf, asList("13.5", "14.0"), overValue, underValue);
            checkIfContainsAndSetPosAndNeg(totalText, over14AndHalf, asList("14.5", "15.0"), overValue, underValue);
            checkIfContainsAndSetPosAndNeg(totalText, over15AndHalf, asList("15.5", "16.0"), overValue, underValue);
        }

        if (tds.get(8) != null) {
            String coeff = tds.get(8).select("u a").first().text();
            CoeffContainer winContainer = container.findByType(TEAM_PENALTIES_TIME_WIN);
            winContainer.getCoeff().set(Double.valueOf(coeff));
        }
        if (tds.get(10) != null) {
            String coeff = tds.get(10).select("u a").first().text();
            CoeffContainer winContainer = container.findByType(OPPOSING_TEAM_PENALTIES_TIME_WIN);
            winContainer.getCoeff().set(Double.valueOf(coeff));
        }


        if (tds.get(14) != null) {
            String totalText = tds.get(14).select("b").first().text();
            String totalOverCoeff = tds.get(15).select("u a").first().text();
            String totalUnderCoeff = tds.get(16).select("u a").first().text();
            CoeffContainer teamTotalOverContainer = container.findByType(TEAM_PENALTIES_TIME_OVER);
            CoeffContainer over6AndHalf = teamTotalOverContainer.findByType(OVER_6_5);
            CoeffContainer over7AndHalf = teamTotalOverContainer.findByType(OVER_7_5);
            CoeffContainer over8AndHalf = teamTotalOverContainer.findByType(OVER_8_5);

            Double overValue = Double.valueOf(totalOverCoeff);
            Double underValue = Double.valueOf(totalUnderCoeff);

            checkIfContainsAndSetPosAndNeg(totalText, over6AndHalf, asList("6.5", "7.0"), overValue, underValue);
            checkIfContainsAndSetPosAndNeg(totalText, over7AndHalf, asList("7.5", "8.0"), overValue, underValue);
            checkIfContainsAndSetPosAndNeg(totalText, over8AndHalf, asList("8.5", "9.0"), overValue, underValue);
        }

        if (tds.get(14) != null) {
            String totalText = tds.get(14).select("b").get(1).text();
            String totalOverCoeff = tds.get(15).select("u a").get(1).text();
            String totalUnderCoeff = tds.get(16).select("u a").get(1).text();
            CoeffContainer teamTotalOverContainer = container.findByType(OPPOSING_TEAM_PENALTIES_TIME_OVER);
            CoeffContainer over6AndHalf = teamTotalOverContainer.findByType(OVER_6_5);
            CoeffContainer over7AndHalf = teamTotalOverContainer.findByType(OVER_7_5);
            CoeffContainer over8AndHalf = teamTotalOverContainer.findByType(OVER_8_5);

            Double overValue = Double.valueOf(totalOverCoeff);
            Double underValue = Double.valueOf(totalUnderCoeff);
            checkIfContainsAndSetPosAndNeg(totalText, over6AndHalf, asList("6.5", "7.0"), overValue, underValue);
            checkIfContainsAndSetPosAndNeg(totalText, over7AndHalf, asList("7.5", "8.0"), overValue, underValue);
            checkIfContainsAndSetPosAndNeg(totalText, over8AndHalf, asList("8.5", "9.0"), overValue, underValue);

        }
    }

    private void fillHandicapBlock(Element element, CoeffContainer handicapContainer, HockeyFutureMatch match) {
        fillMatchesHandicap(element, handicapContainer.findByType(TEAM_HANDICAP), match.getHomeTeam());
        fillMatchesHandicap(element, handicapContainer.findByType(OPPOSING_TEAM_HANDICAP), match.getGuestTeam());
    }


    private void fillMatchesHandicap(Element element, CoeffContainer container, HockeyTeam team) {
        Element totalElementBlock = element.select("th:containsOwn(Дополнительные форы:)")
                .first().parent().nextElementSibling();

        Element temp = totalElementBlock.select(String.format("i:contains(%s)", team.getName())).first();
        Element teamTotalBlock = temp.parent().nextElementSibling();
        List<Node> childNodes = teamTotalBlock.childNodes();

        CoeffContainer plus1AndHalf = container.findByType(PLUS_1_5);
        CoeffContainer plus2AndHalf = container.findByType(PLUS_2_5);

        CoeffContainer minus1AndHalf = container.findByType(MINUS_1_5);
        CoeffContainer minus2AndHalf = container.findByType(MINUS_2_5);


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

            checkIfContainsAndSetValue(handicapText, plus1AndHalf, "+1.5", value);
            checkIfContainsAndSetValue(handicapText, plus2AndHalf, "+2.5", value);

            checkIfContainsAndSetValue(handicapText, minus1AndHalf, "–1.5", value);
            checkIfContainsAndSetValue(handicapText, minus2AndHalf, "–2.5", value);
        }
    }

    private void fillTotalBlock(Element element, CoeffContainer totalContainer, HockeyFutureMatch match) {
        fillTotalOverBlock(element, totalContainer.findByType(TOTAL_OVER));
        fillTotalUnderBlock(element, totalContainer.findByType(TOTAL_UNDER));
        fillBothTeamsTotalOverBlock(element, totalContainer.findByType(BOTH_TEAMS_TOTAL_OVER));
        fillBothTeamsTotalUnderBlock(element, totalContainer.findByType(BOTH_TEAMS_TOTAL_UNDER));
        fillTeamTotalOverBlock(element, totalContainer.findByType(TEAM_TOTAL_OVER), match.getHomeTeam());
        fillTeamTotalUnderBlock(element, totalContainer.findByType(TEAM_TOTAL_UNDER), match.getHomeTeam());
        fillTeamTotalOverBlock(element, totalContainer.findByType(OPPOSING_TEAM_TOTAL_OVER), match.getGuestTeam());
        fillTeamTotalUnderBlock(element, totalContainer.findByType(OPPOSING_TEAM_TOTAL_UNDER), match.getGuestTeam());
    }

    private void fillTotalOverBlock(Element element, CoeffContainer totalOverContainer) {

        Element totalElementBlock = element.select("th:containsOwn(Дополнительные тоталы:)")
                .first().parent().nextElementSibling();

        Element generalTotalHtmlBlock = totalElementBlock.select("td:containsOwn(больше )").first();
        List<Node> childNodes = generalTotalHtmlBlock.childNodes();
        CoeffContainer over4AndHalf = totalOverContainer.findByType(OVER_4_5);
        CoeffContainer over5AndHalf = totalOverContainer.findByType(OVER_5_5);
        for (int i = 0; i < childNodes.size(); i++) {
            Node child = childNodes.get(i);
            if (!(child instanceof TextNode)) {
                continue;
            }
            String text = ((TextNode) child).text();
            Double value = null;
            if (i < childNodes.size() - 4 && childNodes.get(i + 1).childNodeSize() > 0) {
                value = Double.valueOf(childNodes.get(i + 1).childNode(0).childNode(0).outerHtml());
            }

            checkIfContainsAndSetValue(text, over4AndHalf, "(4.5) больше", value);
            checkIfContainsAndSetValue(text, over5AndHalf, "(5.5) больше", value);
        }
    }

    private void fillTotalUnderBlock(Element element, CoeffContainer totalUnderContainer) {

        Element totalElementBlock = element.select("th:containsOwn(Дополнительные тоталы:)")
                .first().parent().nextElementSibling();

        Element generalTotalHtmlBlock = totalElementBlock.select("td:containsOwn(больше )").first();
        List<Node> childNodes = generalTotalHtmlBlock.childNodes();
        CoeffContainer under5AndHalf = totalUnderContainer.findByType(UNDER_5_5);
        CoeffContainer under6AndHalf = totalUnderContainer.findByType(UNDER_6_5);
        for (int i = 0; i < childNodes.size(); i++) {
            Node child = childNodes.get(i);
            if (!(child instanceof TextNode)) {
                continue;
            }
            String text = ((TextNode) child).text();
            Double value = null;
            if (i < childNodes.size() - 4 && childNodes.get(i + 3).childNodeSize() > 0) {
                value = Double.valueOf(childNodes.get(i + 3).childNode(0).childNode(0).outerHtml());
            }

            checkIfContainsAndSetValue(text, under5AndHalf, "(5.5) больше", value);
            checkIfContainsAndSetValue(text, under6AndHalf, "(6.5) больше", value);
        }
    }

    private void fillBothTeamsTotalOverBlock(Element element, CoeffContainer container) {
        fillBetWithSinglePossibleOption(
                element, container,
                asList(
                        new BetEntry("каждая команда забьет больше 1,5", OVER_1_5),
                        new BetEntry("каждая команда забьет больше 2,5", OVER_2_5)
                )
        );
    }

    private void fillBothTeamsTotalUnderBlock(Element element, CoeffContainer container) {
        fillBetWithSinglePossibleOption(
                element, container,
                asList(
                        new BetEntry("каждая команда забьет меньше 2,5", UNDER_2_5),
                        new BetEntry("каждая команда забьет меньше 3,5", UNDER_3_5)
                )
        );
    }

    private void fillTeamTotalOverBlock(Element element, CoeffContainer totalOverContainer, Team homeTeam) {

        Element totalElementBlock = element.select("th:containsOwn(Дополнительные тоталы:)")
                .first().parent().nextElementSibling();

        Element temp = totalElementBlock.select(String.format("i:containsOwn(%s)", homeTeam.getName())).first();
        Element teamTotalBlock = temp.parent().nextElementSibling();
        List<Node> childNodes = teamTotalBlock.childNodes();
        CoeffContainer over1AndHalf = totalOverContainer.findByType(OVER_1_5);
        CoeffContainer over2AndHalf = totalOverContainer.findByType(OVER_2_5);
        CoeffContainer over3AndHalf = totalOverContainer.findByType(OVER_3_5);
        for (int i = 0; i < childNodes.size(); i++) {
            Node child = childNodes.get(i);
            if (!(child instanceof TextNode)) {
                continue;
            }
            String text = ((TextNode) child).text();
            Double value = null;
            if (i < childNodes.size() - 4 && childNodes.get(i + 1).childNodeSize() > 0) {
                value = Double.valueOf(childNodes.get(i + 1).childNode(0).childNode(0).outerHtml());
            }

            checkIfContainsAndSetValue(text, over1AndHalf, "(1.5) больше", value);
            checkIfContainsAndSetValue(text, over2AndHalf, "(2.5) больше", value);
            checkIfContainsAndSetValue(text, over3AndHalf, "(3.5) больше", value);
        }
    }

    private void fillTeamTotalUnderBlock(Element element, CoeffContainer totalOverContainer, Team homeTeam) {

        Element totalElementBlock = element.select("th:containsOwn(Дополнительные тоталы:)")
                .first().parent().nextElementSibling();

        Element temp = totalElementBlock.select(String.format("i:containsOwn(%s)", homeTeam.getName())).first();
        Element teamTotalBlock = temp.parent().nextElementSibling();
        List<Node> childNodes = teamTotalBlock.childNodes();
        CoeffContainer under1AndHalf = totalOverContainer.findByType(UNDER_1_5);
        CoeffContainer under2AndHalf = totalOverContainer.findByType(UNDER_2_5);
        CoeffContainer under3AndHalf = totalOverContainer.findByType(UNDER_3_5);
        for (int i = 0; i < childNodes.size(); i++) {
            Node child = childNodes.get(i);
            if (!(child instanceof TextNode)) {
                continue;
            }
            String text = ((TextNode) child).text();
            Double value = null;
            if (i < childNodes.size() - 4 && childNodes.get(i + 3).childNodeSize() > 0) {
                value = Double.valueOf(childNodes.get(i + 3).childNode(0).childNode(0).outerHtml());
            }

            checkIfContainsAndSetValue(text, under1AndHalf, "(1.5) больше", value);
            checkIfContainsAndSetValue(text, under2AndHalf, "(2.5) больше", value);
            checkIfContainsAndSetValue(text, under3AndHalf, "(3.5) больше", value);
        }
    }


    private void fillOtherBlock(Element element, CoeffContainer otherContainer, HockeyFutureMatch match) {
        fillTotalOverInAllPeriodsBlock(element, otherContainer.findByType(TOTAL_OVER_ALL_PERIODS));
        fillTotalUnderInAllPeriodsBlock(element, otherContainer.findByType(TOTAL_UNDER_ALL_PERIODS));

        fillAnyWinAndDiffEqualsBlock(element, otherContainer.findByType(ANY_WIN_AND_DIFFERENCE_EQUALS));
        fillGoalsTimeBlock(element, otherContainer);

        fillTeamWinAndTotalOverBlock(element, otherContainer.findByType(TEAM_WIN_AND_TOTAL_OVER), match.getHomeTeam());
        fillTeamWinAndTotalUnderBlock(element, otherContainer.findByType(TEAM_WIN_AND_TOTAL_UNDER), match.getHomeTeam());
        fillTeamNotLooseAndTotalOverBlock(element, otherContainer.findByType(TEAM_NOT_LOOSE_AND_TOTAL_OVER), match.getHomeTeam());
        fillTeamNotLooseAndTotalUnderBlock(element, otherContainer.findByType(TEAM_NOT_LOOSE_AND_TOTAL_UNDER), match.getHomeTeam());

        fillTeamWinAndTotalOverBlock(element, otherContainer.findByType(OPPOSING_TEAM_WIN_AND_TOTAL_OVER), match.getGuestTeam());
        fillTeamWinAndTotalUnderBlock(element, otherContainer.findByType(OPPOSING_TEAM_WIN_AND_TOTAL_UNDER), match.getGuestTeam());
        fillTeamNotLooseAndTotalOverBlock(element, otherContainer.findByType(OPPOSING_TEAM_NOT_LOOSE_AND_TOTAL_OVER), match.getGuestTeam());
        fillTeamNotLooseAndTotalUnderBlock(element, otherContainer.findByType(OPPOSING_TEAM_NOT_LOOSE_AND_TOTAL_UNDER), match.getGuestTeam());

        fillTeamTotalOverInAllPeriodsBlock(element, otherContainer.findByType(TEAM_TOTAL_OVER_ALL_PERIODS), match.getHomeTeam());
        fillTeamTotalOverInAllPeriodsBlock(element, otherContainer.findByType(OPPOSING_TEAM_TOTAL_OVER_ALL_PERIODS), match.getGuestTeam());


        fillTeamWinAtLeastNPeriodsBlock(element, otherContainer.findByType(TEAM_WIN_AT_LEAST_N_PERIODS), match.getHomeTeam());
        fillTeamWinAtLeastNPeriodsBlock(element, otherContainer.findByType(OPPOSING_TEAM_WIN_AT_LEAST_N_PERIODS), match.getGuestTeam());
        fillDrawAtLeastNPeriodsBlock(element, otherContainer.findByType(DRAW_AT_LEAST_N_PERIODS));

        fillMostEffectivePeriodTotalOverBlock(element, otherContainer.findByType(MOST_EFFECTIVE_PERIOD_TOTAL_OVER));
        fillTeamFirstScoredAndWinBlock(element, otherContainer.findByType(TEAM_FIRST_SCORED_AND_WIN), TEAM_FIRST_SCORED_AND_WIN, match.getHomeTeam());
        fillTeamFirstScoredAndWinBlock(element, otherContainer.findByType(OPPOSING_TEAM_FIRST_SCORED_AND_WIN), OPPOSING_TEAM_FIRST_SCORED_AND_WIN, match.getGuestTeam());
        fillAnyComebackMatchBlock(element, otherContainer.findByType(ANY_COMEBACK));
    }

    private void fillPeriodsBlock(Element element, CoeffContainer periodsContainer, HockeyFutureMatch match) {
        fillPeriodTeamsTotal(element, periodsContainer.findByType(FIRST_PERIOD), match, "в первом периоде", "обе команды забьют в первом периоде");
        fillPeriodTeamsTotal(element, periodsContainer.findByType(SECOND_PERIOD), match, "во втором периоде", "обе команды забьют во втором периоде");
        fillPeriodTeamsTotal(element, periodsContainer.findByType(THIRD_PERIOD), match, "в третьем периоде", "обе команды забьют в третьем периоде");

        Elements trs = element.select(">tr");
        fillPeriodTotal(trs.subList(0, 3), periodsContainer.findByType(FIRST_PERIOD));
        fillPeriodTotal(trs.subList(3, 6), periodsContainer.findByType(SECOND_PERIOD));
        fillPeriodTotal(trs.subList(6, 8), periodsContainer.findByType(THIRD_PERIOD));
    }

    private void fillPeriodTeamsTotal(Element element, CoeffContainer container, HockeyFutureMatch match, String teamTotalString,
                                      String bothTeamsTotalString) {
        fillBetWithPossibleOptionsForTeamPeriodTotal(
                element, container.findByType(TEAM_TOTAL_OVER),
                teamTotalString, match.getHomeTeam()
        );

        fillBetWithPossibleOptionsForTeamPeriodTotal(
                element, container.findByType(OPPOSING_TEAM_TOTAL_OVER),
                teamTotalString, match.getGuestTeam()
        );

        fillBetWithSinglePossibleOption(
                element, container.findByType(BOTH_TEAMS_TOTAL_OVER),
                asList(
                        new BetEntry(bothTeamsTotalString, OVER_0_5)
                )
        );
    }

    private void fillPeriodTotal(List<Element> trs, CoeffContainer container) {
        for (Element tr : trs) {
            Elements tds = tr.select("td");
            if (tds.get(4) != null) {
                String totalOverText = tds.get(4).select("b").text();
                String totalOverCoeff = tds.get(5).select("u a").text();
                String totalUnderCoeff = tds.get(6).select("u a").text();
                CoeffContainer totalOverContainer = container.findByType(TOTAL_OVER);
                CoeffContainer over0AndHalf = totalOverContainer.findByType(OVER_0_5);
                CoeffContainer over1AndHalf = totalOverContainer.findByType(OVER_1_5);
                CoeffContainer totalUnderContainer = container.findByType(TOTAL_UNDER);
                CoeffContainer under1AndHalf = totalUnderContainer.findByType(UNDER_1_5);
                CoeffContainer under2AndHalf = totalUnderContainer.findByType(UNDER_2_5);
                checkIfContainsAndSetValue(totalOverText, over0AndHalf, "0.5", Double.valueOf(totalOverCoeff));
                checkIfContainsAndSetOverAndUnder(totalOverText, over1AndHalf, under1AndHalf, "1.5", Double.valueOf(totalOverCoeff), Double.valueOf(totalUnderCoeff));
                checkIfContainsAndSetValue(totalOverText, under2AndHalf, "2.5", Double.valueOf(totalUnderCoeff));

            }
            if (tds.size() > 10) {
                if (tds.get(8) != null) {
                    String coeff = tds.get(8).select("u a").first().text();
                    CoeffContainer drawContainer = container.findByType(DRAW);
                    drawContainer.getCoeff().set(Double.valueOf(coeff));
                }
            }
            if (tds.size() > 12) {

                if (tds.get(10) != null) {
                    String coeff = tds.get(10).select("u a").first().text();
                    CoeffContainer teamNotLooseContainer = container.findByType(TEAM_NOT_LOOSE);
                    teamNotLooseContainer.getCoeff().set(Double.valueOf(coeff));
                }
                if (tds.get(11) != null) {
                    String coeff = tds.get(11).select("u a").first().text();
                    CoeffContainer anyWinContainer = container.findByType(ANY_WIN);
                    anyWinContainer.getCoeff().set(Double.valueOf(coeff));
                }
                if (tds.get(12) != null) {
                    String coeff = tds.get(12).select("u a").first().text();
                    CoeffContainer teamNotLooseContainer = container.findByType(OPPOSING_TEAM_NOT_LOOSE);
                    teamNotLooseContainer.getCoeff().set(Double.valueOf(coeff));
                }
            }

        }

    }

    private void fillAnyWinAndDiffEqualsBlock(Element element, CoeffContainer container) {
        fillBetWithSinglePossibleOption(
                element, container,
                asList(
                        new BetEntry("победа любой команды в 1 шайбу", DIFF_1),
                        new BetEntry("победа любой команды в 2 шайбы", DIFF_2),
                        new BetEntry("победа любой команды в 3 или более шайбы", DIFF_3_OR_MORE)
                )
        );
    }

    private void fillGoalsTimeBlock(Element element, CoeffContainer container) {
        Element elementBlock = element.select("th:containsOwn(Голы)").first();
        Element goalsBlock = elementBlock.parent().nextElementSibling();
        Element td = goalsBlock.select("td>i:containsOwn(Обе забьют)").first().parent();
        List<Node> childNodes = td.childNodes();

        CoeffContainer firstGoalBefore = container.findByType(FIRST_GOAL_BEFORE);
        CoeffContainer under9 = firstGoalBefore.findByType(UNDER_9);
        CoeffContainer under10 = firstGoalBefore.findByType(UNDER_10);
        CoeffContainer under11 = firstGoalBefore.findByType(UNDER_11);
        CoeffContainer under12 = firstGoalBefore.findByType(UNDER_12);

        CoeffContainer lastGoalAfter = container.findByType(LAST_GOAL_AFTER);
        CoeffContainer over54 = lastGoalAfter.findByType(OVER_54);
        CoeffContainer over55 = lastGoalAfter.findByType(OVER_55);


        for (int i = 1; i < childNodes.size(); i++) {
            Node child = childNodes.get(i);
            if (!(child instanceof TextNode)) {
                continue;
            }
            String text = ((TextNode) child).text();
            Double coeff = null;
            if (i < childNodes.size() - 2 && childNodes.get(i + 1).childNodeSize() > 0 && childNodes.get(i + 1).childNode(0).childNodeSize() > 0) {
                String coefText = childNodes.get(i + 1).childNode(0).childNode(0).outerHtml();
                coeff = Double.valueOf(coefText);
            }

            checkIfContainsAndSetPosAndNeg(text, under9, "1 по 8 мин", coeff, coeff);
            checkIfContainsAndSetPosAndNeg(text, under10, "1 по 9 мин", coeff, coeff);
            checkIfContainsAndSetPosAndNeg(text, under11, "1 по 10 мин", coeff, coeff);
            checkIfContainsAndSetPosAndNeg(text, under12, "1 по 11 мин", coeff, coeff);

            checkIfContainsAndSetPosAndNeg(text, over54, "55 по 60 мин", coeff, coeff);
            checkIfContainsAndSetPosAndNeg(text, over55, "56 по 60 мин", coeff, coeff);
        }
    }

    private void fillTeamWinAndTotalOverBlock(Element element, CoeffContainer container, Team team) {
        fillBetWithPossibleOptionsForTeam(
                element, container,
                asList(
                        new BetEntry("победит и тотал больше 4.5", OVER_4_5),
                        new BetEntry("победит и тотал больше 5.5", OVER_5_5)
                ), team
        );
    }


    private void fillTeamWinAndTotalUnderBlock(Element element, CoeffContainer container, Team team) {
        fillBetWithPossibleOptionsForTeam(
                element, container,
                asList(
                        new BetEntry("победит и тотал меньше 4.5", UNDER_4_5),
                        new BetEntry("победит и тотал меньше 5.5", UNDER_5_5)
                ), team
        );
    }

    private void fillTeamNotLooseAndTotalOverBlock(Element element, CoeffContainer container, Team team) {
        fillBetWithPossibleOptionsForTeam(
                element, container,
                asList(
                        new BetEntry("не проиграет и тотал больше 4.5", OVER_4_5),
                        new BetEntry("не проиграет и тотал больше 5.5", OVER_5_5)
                ), team
        );
    }

    private void fillTeamNotLooseAndTotalUnderBlock(Element element, CoeffContainer container, Team team) {
        fillBetWithPossibleOptionsForTeam(
                element, container,
                asList(
                        new BetEntry("не проиграет и тотал меньше 4.5", UNDER_4_5),
                        new BetEntry("не проиграет и тотал меньше 5.5", UNDER_5_5)
                ), team
        );
    }

    private void fillTotalOverInAllPeriodsBlock(Element element, CoeffContainer container) {

        fillBetWithSinglePossibleOption(
                element, container,
                asList(
                        new BetEntry("Тотал самого нерезультативного периода больше 0,5", OVER_0_5)
                )
        );

    }

    private void fillTeamTotalOverInAllPeriodsBlock(Element element, CoeffContainer container, Team team) {

        fillBetWithPossibleOptionsForTeam(
                element, container,
                asList(new BetEntry("забьет в каждом периоде:", OVER_0_5)), team
        );

    }


    private void fillTotalUnderInAllPeriodsBlock(Element element, CoeffContainer container) {

        fillBetWithSinglePossibleOption(
                element, container,
                asList(
                        new BetEntry("каждый период меньше 2,5", UNDER_2_5),
                        new BetEntry("каждый период меньше 3,5", UNDER_3_5)
                )
        );

    }

    private void fillTeamWinAtLeastNPeriodsBlock(Element element, CoeffContainer container, Team team) {
        fillBetWithPossibleOptionsForTeam(
                element, container,
                asList(
                        new BetEntry("выиграет хотя бы один период", NUMBER_1),
                        new BetEntry("выиграет хотя бы два периода", NUMBER_2)
                ), team
        );
    }

    private void fillDrawAtLeastNPeriodsBlock(Element element, CoeffContainer container) {

        fillBetWithSinglePossibleOption(
                element, container,
                asList(
                        new BetEntry("Ничья хотя бы в одном периоде", NUMBER_1),
                        new BetEntry("Ничья хотя бы в двух периодах", NUMBER_2)
                )
        );

    }

    private void fillMostEffectivePeriodTotalOverBlock(Element element, CoeffContainer container) {

        fillBetWithSinglePossibleOption(
                element, container,
                asList(
                        new BetEntry("Тотал самого результативного периода больше 2,5", OVER_2_5),
                        new BetEntry("Тотал самого результативного периода больше 3,5", OVER_3_5)
                )
        );

    }

    private void fillTeamFirstScoredAndWinBlock(Element element, CoeffContainer container, ContainerType type, Team team) {
        fillBetWithPossibleOptionsForTeam(
                element, container,
                asList(
                        new BetEntry("забросит шайбу первой и выиграет", type)
                ), team
        );
    }

    private void fillAnyComebackMatchBlock(Element element, CoeffContainer container) {

        fillBetWithSinglePossibleOption(
                element, container,
                asList(
                        new BetEntry("волевая победа в матче", ANY_COMEBACK)
                )
        );

    }


    private void fillBetWithPossibleOptionsForTeam(Element element, CoeffContainer container, List<BetEntry> betEntries, Team team) {
        for (BetEntry betEntry : betEntries) {

            Elements elements = element.select(String.format("i:containsOwn(%s)", betEntry.getBetName()));

            for (Element child : elements) {
                if (child.text().contains(team.getName())) {
                    Element positiveElement = child.nextElementSibling().child(0).child(0);
                    Element negativeElement = null;
                    if (child.nextElementSibling().nextElementSibling() != null) {
                        negativeElement = child.nextElementSibling()
                                .nextElementSibling().child(0).child(0);
                    }

                    CoeffContainer coeffContainer = container.findByType(betEntry.getContainerType());
                    coeffContainer.getCoeff().set(
                            Double.valueOf(positiveElement.text()),
                            negativeElement != null ? Double.valueOf(negativeElement.text()) : Coeff.UNKNOWN
                    );
                }
            }
        }
    }

    private void fillBetWithPossibleOptionsForTeamPeriodTotal(Element element, CoeffContainer container, String periodName, Team team) {

        Elements elements = element.select(String.format("i:containsOwn(%s)", periodName));

        for (Element child : elements) {
            if (child.text().contains(team.getName())) {
                Element tdParent = child.parent();

                fillTeamPeriodTotal(container, tdParent, "0.5", OVER_0_5);
                fillTeamPeriodTotal(container, tdParent, "1.5", OVER_1_5);
            }
        }
    }

    private void fillTeamPeriodTotal(CoeffContainer container, Element tdParent, String total, ContainerType type) {
        Element underCoeff = tdParent.select(String.format("nobr:containsOwn(%s)", total)).first();
        String underCoeffText = underCoeff.select("u a").first().text();

        Element overCoeff = underCoeff.nextElementSibling();
        String overCoeffText = overCoeff.select("u a").first().text();


        CoeffContainer coeffContainer = container.findByType(type);
        coeffContainer.getCoeff().set(
                Double.valueOf(overCoeffText),
                Double.valueOf(underCoeffText)
        );
    }

    private void fillBetWithSinglePossibleOption(Element element, CoeffContainer container, List<BetEntry> betEntries) {
        for (BetEntry betEntry : betEntries) {

            Element elementBlock = element.select(String.format("i:containsOwn(%s)", betEntry.getBetName()))
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
    private static class BetEntry {
        private String betName;
        private ContainerType containerType;
    }


}

