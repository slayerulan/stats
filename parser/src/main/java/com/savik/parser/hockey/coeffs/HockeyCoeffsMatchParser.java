package com.savik.parser.hockey.coeffs;

import com.savik.CoeffContainer;
import com.savik.ContainerType;
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

        fillTotalBlock(matchCoeffsTbodyTag, coeffBlock.findByType(ContainerType.TOTAL));
        String a = "";


    }

    private void fillTotalBlock(Element element, CoeffContainer totalContainer) {
        fillTotalOverBlock(element, totalContainer.findByType(ContainerType.TOTAL_OVER));
        fillTotalUnderBlock(element, totalContainer.findByType(ContainerType.TOTAL_UNDER));
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
}
