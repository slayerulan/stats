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

    public void parse(HockeyFutureMatch hockeyFutureMatch) throws URISyntaxException {

        Path path = Paths.get(getClass().getClassLoader()
                .getResource("parimatch-nhl-example.html").toURI());
        Document html = downloader.downloadFile(new File(path.toUri()));
        //Document html = downloader.download(hockeyDownloaderConfiguration.getNhlUr());

        HockeyTeam homeTeam = hockeyFutureMatch.getHomeTeam();

        CoeffBlock coeffBlock = new CoeffBlock();

        Element tempHref = html.select("a.om:containsOwn(" + homeTeam.getName() + ")").get(0);
        Element matchTbodyTag = tempHref.parent().parent().parent();
        Element matchCoeffsTbodyTag = matchTbodyTag.nextElementSibling();

        fillTotalBlock(matchCoeffsTbodyTag, coeffBlock.findByType(ContainerType.TOTAL), hockeyFutureMatch);
        String a = "";


    }

    private void fillTotalBlock(Element element, CoeffContainer totalContainer, HockeyFutureMatch match) {
        fillTotalOverBlock(element, totalContainer.findByType(ContainerType.TOTAL_OVER));
        fillTotalUnderBlock(element, totalContainer.findByType(ContainerType.TOTAL_UNDER));
        fillBothTeamsTotalOverBlock(element, totalContainer.findByType(ContainerType.BOTH_TEAMS_TOTAL_OVER));
        fillBothTeamsTotalUnderBlock(element, totalContainer.findByType(ContainerType.BOTH_TEAMS_TOTAL_UNDER));
        fillTeamTotalOverBlock(element, totalContainer.findByType(ContainerType.TEAM_TOTAL_OVER), match.getHomeTeam());
        fillTeamTotalUnderBlock(element, totalContainer.findByType(ContainerType.TEAM_TOTAL_UNDER), match.getHomeTeam());
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
            if (child instanceof TextNode && "(4.5) больше ".equals(((TextNode) child).text())) {
                String totalOver4AndHalfCoeff = childNodes.get(i + 1).childNode(0).childNode(0).outerHtml();
                over4AndHalf.getCoeff().setValue(Double.valueOf(totalOver4AndHalfCoeff));
            }

            if (child instanceof TextNode && "(5.5) больше ".equals(((TextNode) child).text())) {
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
            if (child instanceof TextNode && "(5.5) больше ".equals(((TextNode) child).text())) {
                String totalUnder5AndHalfCoeff = childNodes.get(i + 3).childNode(0).childNode(0).outerHtml();
                under5AndHalf.getCoeff().setValue(Double.valueOf(totalUnder5AndHalfCoeff));
            }

            if (child instanceof TextNode && "(6.5) больше ".equals(((TextNode) child).text())) {
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
}
