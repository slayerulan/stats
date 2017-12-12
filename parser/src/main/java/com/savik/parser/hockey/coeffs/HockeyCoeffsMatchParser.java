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

    public CoeffBlock parse(HockeyFutureMatch hockeyFutureMatch)  {

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

        fillTotalBlock(matchCoeffsTbodyTag, coeffBlock.findByType(ContainerType.TOTAL), hockeyFutureMatch);
        fillOtherBlock(matchCoeffsTbodyTag, coeffBlock.findByType(ContainerType.OTHER), hockeyFutureMatch);

        return coeffBlock;
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
                over4AndHalf.getCoeff().setValue(Double.valueOf(totalOver4AndHalfCoeff));
            }

            if (text.contains("(5.5) больше ")) {
                String totalOver5AndHalfCoeff = childNodes.get(i + 1).childNode(0).childNode(0).outerHtml();
                over5AndHalf.getCoeff().setValue(Double.valueOf(totalOver5AndHalfCoeff));
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
                under5AndHalf.getCoeff().setValue(Double.valueOf(totalUnder5AndHalfCoeff));
            }

            if (text.contains("(6.5) больше ")) {
                String totalUnder6AndHalfCoeff = childNodes.get(i + 3).childNode(0).childNode(0).outerHtml();
                under6AndHalf.getCoeff().setValue(Double.valueOf(totalUnder6AndHalfCoeff));
            }
        }
    }

    private void fillBothTeamsTotalOverBlock(Element element, CoeffContainer container) {

        Element over1AndHalfElementBlock = element.select("i:containsOwn(каждая команда забьет больше 1,5:)")
                .first();
        Element over1AndHalfPositiveElement = over1AndHalfElementBlock.nextElementSibling().child(0).child(0);
        Element over1AndHalfNegativelement = over1AndHalfElementBlock.nextElementSibling()
                .nextElementSibling().child(0).child(0);

        CoeffContainer over1AndHalfContainer = container.findByType(ContainerType.OVER_1_5);
        over1AndHalfContainer.getCoeff().set(
                Double.valueOf(over1AndHalfPositiveElement.text()),
                Double.valueOf(over1AndHalfNegativelement.text())
        );

        Element over2AndHalfElementBlock = element.select("i:containsOwn(каждая команда забьет больше 2,5:)")
                .first();
        Element over2AndHalfPositiveElement = over2AndHalfElementBlock.nextElementSibling().child(0).child(0);
        Element over2AndHalfNegativeElement = over2AndHalfElementBlock.nextElementSibling()
                .nextElementSibling().child(0).child(0);

        CoeffContainer over2AndHalfContainer = container.findByType(ContainerType.OVER_2_5);
        over2AndHalfContainer.getCoeff().set(
                Double.valueOf(over2AndHalfPositiveElement.text()),
                Double.valueOf(over2AndHalfNegativeElement.text())
        );


    }

    private void fillBothTeamsTotalUnderBlock(Element element, CoeffContainer container) {

        Element over1AndHalfElementBlock = element.select("i:containsOwn(каждая команда забьет меньше 2,5:)")
                .first();
        Element under2AndHalfPositiveElement = over1AndHalfElementBlock.nextElementSibling().child(0).child(0);
        Element under2AndHalfNegativelement = over1AndHalfElementBlock.nextElementSibling()
                .nextElementSibling().child(0).child(0);

        CoeffContainer under2AndHalfContainer = container.findByType(ContainerType.UNDER_2_5);
        under2AndHalfContainer.getCoeff().set(
                Double.valueOf(under2AndHalfPositiveElement.text()),
                Double.valueOf(under2AndHalfNegativelement.text())
        );

        Element under3AndHalfElementBlock = element.select("i:containsOwn(каждая команда забьет меньше 3,5:)")
                .first();
        Element under3AndHalfPositiveElement = under3AndHalfElementBlock.nextElementSibling().child(0).child(0);
        Element under3AndHalfNegativeElement = under3AndHalfElementBlock.nextElementSibling()
                .nextElementSibling().child(0).child(0);

        CoeffContainer over2AndHalfContainer = container.findByType(ContainerType.UNDER_3_5);
        over2AndHalfContainer.getCoeff().set(
                Double.valueOf(under3AndHalfPositiveElement.text()),
                Double.valueOf(under3AndHalfNegativeElement.text())
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
                over2AndHalf.getCoeff().setValue(Double.valueOf(totalOver2AndHalfCoeff));
            }

            if (text.contains("(3.5) больше")) {
                String totalOver3AndHalfCoeff = childNodes.get(i + 1).childNode(0).childNode(0).outerHtml();
                over3AndHalf.getCoeff().setValue(Double.valueOf(totalOver3AndHalfCoeff));
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
                under2AndHalf.getCoeff().setValue(Double.valueOf(underOver2AndHalfCoeff));
            }

            if (text.contains("(3.5) больше")) {
                String underOver3AndHalfCoeff = childNodes.get(i + 3).childNode(0).childNode(0).outerHtml();
                under3AndHalf.getCoeff().setValue(Double.valueOf(underOver3AndHalfCoeff));
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
    }


    private void fillPeriodAnyWinAndDiffEqualsBlock(Element element, CoeffContainer container) {

        Element diff1Block = element.select("i:containsOwn(победа любой команды в 1 шайбу)")
                .first();
        Element diff1PositiveElement = diff1Block.nextElementSibling().child(0).child(0);
        Element diff1Negativelement = diff1Block.nextElementSibling()
                .nextElementSibling().child(0).child(0);

        CoeffContainer diff1Container = container.findByType(ContainerType.DIFF_1);
        diff1Container.getCoeff().set(
                Double.valueOf(diff1PositiveElement.text()),
                Double.valueOf(diff1Negativelement.text())
        );

        Element diff2ElementBlock = element.select("i:containsOwn(победа любой команды в 2 шайбы)")
                .first();
        Element diff2PositiveElement = diff2ElementBlock.nextElementSibling().child(0).child(0);
        Element diff2NegativeElement = diff2ElementBlock.nextElementSibling()
                .nextElementSibling().child(0).child(0);

        CoeffContainer diff2Container = container.findByType(ContainerType.DIFF_2);
        diff2Container.getCoeff().set(
                Double.valueOf(diff2PositiveElement.text()),
                Double.valueOf(diff2NegativeElement.text())
        );


        Element diff3OrMoeElementBlock = element.select("i:containsOwn(победа любой команды в 3 или более шайбы)")
                .first();
        Element diff3OrMorePositiveElement = diff3OrMoeElementBlock.nextElementSibling().child(0).child(0);
        Element diff3OrMoreNegativeElement = diff3OrMoeElementBlock.nextElementSibling()
                .nextElementSibling().child(0).child(0);

        CoeffContainer diff3Container = container.findByType(ContainerType.DIFF_3_OR_MORE);
        diff3Container.getCoeff().set(
                Double.valueOf(diff3OrMorePositiveElement.text()),
                Double.valueOf(diff3OrMoreNegativeElement.text())
        );
    }

    private void fillTeamWinAndTotalOverBlock(Element element, CoeffContainer container, Team homeTeam) {

        Elements elements = element.select("i:containsOwn(победит и тотал больше 4.5)");

        for (int i = 0; i < elements.size(); i++) {
            Element child = elements.get(i);
            if(child.text().contains(homeTeam.getName())) {
                Element over1AndHalfPositiveElement = child.nextElementSibling().child(0).child(0);
                Element over1AndHalfNegativelement = child.nextElementSibling()
                        .nextElementSibling().child(0).child(0);

                CoeffContainer over4AndHalfContainer = container.findByType(ContainerType.OVER_4_5);
                over4AndHalfContainer.getCoeff().set(
                        Double.valueOf(over1AndHalfPositiveElement.text()),
                        Double.valueOf(over1AndHalfNegativelement.text())
                );
            }

        }

        elements = element.select("i:containsOwn(победит и тотал больше 5.5)");

        for (int i = 0; i < elements.size(); i++) {
            Element child = elements.get(i);
            if(child.text().contains(homeTeam.getName())) {
                Element over1AndHalfPositiveElement = child.nextElementSibling().child(0).child(0);
                Element over1AndHalfNegativelement = child.nextElementSibling()
                        .nextElementSibling().child(0).child(0);

                CoeffContainer over5AndHalfContainer = container.findByType(ContainerType.OVER_5_5);
                over5AndHalfContainer.getCoeff().set(
                        Double.valueOf(over1AndHalfPositiveElement.text()),
                        Double.valueOf(over1AndHalfNegativelement.text())
                );
            }

        }

    }


    private void fillTeamWinAndTotalUnderBlock(Element element, CoeffContainer container, Team homeTeam) {

        Elements elements = element.select("i:containsOwn(победит и тотал меньше 4.5)");

        for (int i = 0; i < elements.size(); i++) {
            Element child = elements.get(i);
            if(child.text().contains(homeTeam.getName())) {
                Element over1AndHalfPositiveElement = child.nextElementSibling().child(0).child(0);
                Element over1AndHalfNegativelement = child.nextElementSibling()
                        .nextElementSibling().child(0).child(0);

                CoeffContainer over4AndHalfContainer = container.findByType(ContainerType.UNDER_4_5);
                over4AndHalfContainer.getCoeff().set(
                        Double.valueOf(over1AndHalfPositiveElement.text()),
                        Double.valueOf(over1AndHalfNegativelement.text())
                );
            }

        }

        elements = element.select("i:containsOwn(победит и тотал меньше 5.5)");

        for (int i = 0; i < elements.size(); i++) {
            Element child = elements.get(i);
            if(child.text().contains(homeTeam.getName())) {
                Element over1AndHalfPositiveElement = child.nextElementSibling().child(0).child(0);
                Element over1AndHalfNegativelement = child.nextElementSibling()
                        .nextElementSibling().child(0).child(0);

                CoeffContainer over5AndHalfContainer = container.findByType(ContainerType.UNDER_5_5);
                over5AndHalfContainer.getCoeff().set(
                        Double.valueOf(over1AndHalfPositiveElement.text()),
                        Double.valueOf(over1AndHalfNegativelement.text())
                );
            }

        }

    }

    private void fillTeamNotLooseAndTotalOverBlock(Element element, CoeffContainer container, Team homeTeam) {

        Elements elements = element.select("i:containsOwn(не проиграет и тотал больше 4.5)");

        for (int i = 0; i < elements.size(); i++) {
            Element child = elements.get(i);
            if(child.text().contains(homeTeam.getName())) {
                Element over1AndHalfPositiveElement = child.nextElementSibling().child(0).child(0);
                Element over1AndHalfNegativelement = child.nextElementSibling()
                        .nextElementSibling().child(0).child(0);

                CoeffContainer over4AndHalfContainer = container.findByType(ContainerType.OVER_4_5);
                over4AndHalfContainer.getCoeff().set(
                        Double.valueOf(over1AndHalfPositiveElement.text()),
                        Double.valueOf(over1AndHalfNegativelement.text())
                );
            }

        }

        elements = element.select("i:containsOwn(не проиграет и тотал больше 5.5)");

        for (int i = 0; i < elements.size(); i++) {
            Element child = elements.get(i);
            if(child.text().contains(homeTeam.getName())) {
                Element over1AndHalfPositiveElement = child.nextElementSibling().child(0).child(0);
                Element over1AndHalfNegativelement = child.nextElementSibling()
                        .nextElementSibling().child(0).child(0);

                CoeffContainer over5AndHalfContainer = container.findByType(ContainerType.OVER_5_5);
                over5AndHalfContainer.getCoeff().set(
                        Double.valueOf(over1AndHalfPositiveElement.text()),
                        Double.valueOf(over1AndHalfNegativelement.text())
                );
            }

        }

    }

    private void fillTeamNotLooseAndTotalUnderBlock(Element element, CoeffContainer container, Team homeTeam) {

        Elements elements = element.select("i:containsOwn(не проиграет и тотал меньше 4.5)");

        for (int i = 0; i < elements.size(); i++) {
            Element child = elements.get(i);
            if(child.text().contains(homeTeam.getName())) {
                Element over1AndHalfPositiveElement = child.nextElementSibling().child(0).child(0);
                Element over1AndHalfNegativelement = child.nextElementSibling()
                        .nextElementSibling().child(0).child(0);

                CoeffContainer over4AndHalfContainer = container.findByType(ContainerType.UNDER_4_5);
                over4AndHalfContainer.getCoeff().set(
                        Double.valueOf(over1AndHalfPositiveElement.text()),
                        Double.valueOf(over1AndHalfNegativelement.text())
                );
            }

        }

        elements = element.select("i:containsOwn(не проиграет и тотал меньше 5.5)");

        for (int i = 0; i < elements.size(); i++) {
            Element child = elements.get(i);
            if(child.text().contains(homeTeam.getName())) {
                Element over1AndHalfPositiveElement = child.nextElementSibling().child(0).child(0);
                Element over1AndHalfNegativelement = child.nextElementSibling()
                        .nextElementSibling().child(0).child(0);

                CoeffContainer over5AndHalfContainer = container.findByType(ContainerType.UNDER_5_5);
                over5AndHalfContainer.getCoeff().set(
                        Double.valueOf(over1AndHalfPositiveElement.text()),
                        Double.valueOf(over1AndHalfNegativelement.text())
                );
            }

        }

    }
}

