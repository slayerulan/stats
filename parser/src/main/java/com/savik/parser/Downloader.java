package com.savik.parser;

import com.savik.parser.exception.ParseException;
import lombok.AllArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author Savushkin Yauheni
 * @since 13.04.2017
 */
@AllArgsConstructor
@Service
public class Downloader {

    @Autowired
    private DownloaderConfiguration configuration;

    public Document downloadGeneralInfo(String matchId) {
        return download(String.format(configuration.getInfoUrlTemplate(), matchId));
    }

    public Document downloadStatsInfo(String matchId) {
        return download(String.format(configuration.getStatsUrlTemplate(), matchId));
    }

    public Document downloadSummaryInfo(String matchId) {
        return download(String.format(configuration.getSummaryUrlTemplate(), matchId));
    }

    public Document downloadOddsInfo(String matchId) {
        return download(String.format(configuration.getOddsUrlTemplate(), matchId));
    }

    public Document downloadFootballMatchesSchedule(Integer day) {
        return download(String.format(configuration.getFootballMatchesScheduleTemplate(), day));
    }

    public Document downloadHockeyMatchesSchedule(Integer day) {
        return download(String.format(configuration.getHockeyMatchesScheduleTemplate(), day));
    }

    public Document download(String url) {
        try {
            return Jsoup.connect(url).header("X-Fsign", configuration.getFsign()).get();
        } catch (IOException e) {
            throw new ParseException(e);
        }
    }
}
