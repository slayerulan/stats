package com.savik.parser;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author Savushkin Yauheni
 * @since 13.04.2017
 */
@Component
@Configuration
@Getter
public class DownloaderConfiguration {

    @Value("${url.generalinfo}")
    private String infoUrlTemplate;

    @Value("${url.statsinfo}")
    private String statsUrlTemplate;

    @Value("${url.summary}")
    private String summaryUrlTemplate;

    @Value("${url.odds}")
    private String oddsUrlTemplate;

    @Value("${url.snookerOdds}")
    private String snookerOddsTemplate;

    @Value("${url.footballMatches}")
    private String footballMatchesScheduleTemplate;

    @Value("${url.hockeyMatches}")
    private String hockeyMatchesScheduleTemplate;

    @Value("${fsign}")
    private String fsign;

}
