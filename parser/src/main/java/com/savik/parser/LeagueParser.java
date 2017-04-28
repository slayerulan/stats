package com.savik.parser;

import static org.springframework.util.StringUtils.isEmpty;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.savik.parser.exception.ParseException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Savushkin Yauheni
 * @since 27.04.2017
 */
@Service
public class LeagueParser {

    @Autowired
    Downloader downloader;

    public List<String> findAllMatches(String resultPageUrl) {
        if (isEmpty(resultPageUrl)) {
            throw new IllegalArgumentException("resultPageUrl = " + resultPageUrl);
        }
        StringBuilder allMatchesHtml = new StringBuilder();
        Document document = downloader.download(resultPageUrl);
        Element matchesData = document.getElementById("tournament-page-data-results");
        if (matchesData == null) {
            throw new ParseException("tournament-page-data-results is empty, league url = " + resultPageUrl);
        }
        allMatchesHtml.append(matchesData.toString());

        Element currentTournament = document.select("ul.submenu li.active-tournament").first();
        if (currentTournament == null) {
            throw new ParseException("active-tournament element not found, league url = " + resultPageUrl);
        }
        if (isEmpty(currentTournament.attr("data-mt"))) {
            throw new ParseException("active tournament url is empty, league url = " + resultPageUrl);
        }
        String moreMatchesUrlPattern = new StringBuilder("http://d.myscore.ru/x/feed/tr_")
                .append(currentTournament.attr("data-mt"))
                .append("_167_%s_3_ru_1").toString();
        int counter = 1;
        while (true) {
            String moreMatchesUrl = String.format(moreMatchesUrlPattern, counter);
            Document moreMatchesHtml = downloader.download(moreMatchesUrl);
            if (!moreMatchesHtml.getElementsByTag("body").hasText()) {
                break;
            }
            allMatchesHtml.append(moreMatchesHtml.getElementsByTag("body").toString());
            counter++;
        }

        List<String> matchesIds = new ArrayList<>();

        Pattern pattern = Pattern.compile("AA÷(.{8})¬AD");
        Matcher matcher = pattern.matcher(allMatchesHtml.toString());
        while (matcher.find()) {
            matchesIds.add(matcher.group(1));
        }
        return matchesIds;
    }

}
