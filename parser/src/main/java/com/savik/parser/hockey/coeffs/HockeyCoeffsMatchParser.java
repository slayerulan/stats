package com.savik.parser.hockey.coeffs;

import com.savik.hockey.model.HockeyFutureMatch;
import com.savik.hockey.model.HockeyTeam;
import com.savik.hockey.repository.HockeyMatchRepository;
import com.savik.hockey.repository.HockeyTeamRepository;
import com.savik.parser.Downloader;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    public void parse(HockeyFutureMatch hockeyFutureMatch) {

        Document html = downloader.download(hockeyDownloaderConfiguration.getNhlUr());

        HockeyTeam homeTeam = hockeyFutureMatch.getHomeTeam();

        Element tempHref = html.select("a.om:containsOwn(" + homeTeam.getName() + ")").get(0);
        Element matchTbodyTag = tempHref.parent().parent().parent();
        Element matchCoeffsTbodyTag = matchTbodyTag.nextElementSibling();

        String a = "";
    }
}
