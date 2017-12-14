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

        Path path = null;
        try {
            path = Paths.get(getClass().getClassLoader()
                    .getResource("parimatch-nhl-example.html").toURI());
        } catch (URISyntaxException e) {
        }
        Document html = downloader.downloadFile(new File(path.toUri()));
        //Document html = downloader.download(hockeyDownloaderConfiguration.getNhlUr());

        HockeyTeam homeTeam = hockeyFutureMatch.getHomeTeam();

        CoeffBlock coeffBlock = new CoeffBlock();

        Element tempHref = html.select("a.om:containsOwn(" + homeTeam.getName() + ")").get(0);
        Element matchTbodyTag = tempHref.parent().parent().parent();
        Element matchCoeffsTbodyTag = matchTbodyTag.nextElementSibling();

        fillSomeSpecialBets(tempHref.parent().parent(), coeffBlock);
        fillTotalBlock(matchCoeffsTbodyTag, coeffBlock.findByType(ContainerType.TOTAL), hockeyFutureMatch);
        fillOtherBlock(matchCoeffsTbodyTag, coeffBlock.findByType(ContainerType.OTHER), hockeyFutureMatch);

        return coeffBlock;
    }

    // which placed on parimatch main screen
    private void fillSomeSpecialBets(Element element, CoeffContainer container) {
        Elements tds = element.select("td");
        // total over
        if(tds.get(5) != null) {
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
        if(tds.get(15) != null) {
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

        if(tds.get(15) != null) {
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

