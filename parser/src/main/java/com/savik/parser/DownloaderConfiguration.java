package com.savik.parser;

import javax.annotation.PostConstruct;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Savushkin Yauheni
 * @since 13.04.2017
 */
@Component
//@EnableConfigurationProperties
//@PropertySource("classpath:downloader-config.yml")
//@ConfigurationProperties("url")
@Configuration
@Getter
public class DownloaderConfiguration {

    @Value("${url.generalinfo}")
    private String infoUrlTemplate;

    @Value("${url.statsinfo}")
    private String statsUrlTemplate;

    @Value("${url.summary}")
    private String summaryUrlTemplate;

    @Value("${fsign}")
    private String fsign;

}
