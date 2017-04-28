package com.savik.parser;

import java.io.IOException;

import com.savik.parser.exception.ParseException;
import lombok.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Document download(String url) {
        try {
            return Jsoup.connect(url).header("X-Fsign", configuration.getFsign()).get();
        } catch (IOException e) {
            throw new ParseException(e);
        }
    }
}
