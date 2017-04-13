package com.savik.parser;/*
 * Copyright (c) 2017, AT-Consulting. All Rights Reserved.
 * Use is subject to license terms.
 */

import lombok.*;
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

    public Document downloadGeneralInfo(String matchId) throws IOException {
        return download(String.format(configuration.getInfoUrlTemplate(), matchId));
    }

    public Document downloadStatsInfo(String matchId) throws IOException {
        return download(String.format(configuration.getStatsUrlTemplate(), matchId));
    }

    public Document downloadSummaryInfo(String matchId) throws IOException {
        return download(String.format(configuration.getSummaryUrlTemplate(), matchId));
    }

    private Document download(String url) throws IOException {
        return Jsoup.connect(url)
                    .header("X-Fsign", configuration.getFsign()).get();
    }
}
