/*
 * Copyright (c) 2017, AT-Consulting. All Rights Reserved.
 * Use is subject to license terms.
 */

package com.savik.parser;

import javax.annotation.PostConstruct;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Savushkin Yauheni
 * @since 13.04.2017
 */
@Component
@EnableConfigurationProperties
@PropertySource("classpath:test.properties")
@Getter
public class DownloaderConfiguration {

   /* @Value("${url}")
    private String url;*/

    @PostConstruct
    public void init() {
       // System.out.println(url);
    }

    @Value("${url.generalinfo}")
    private String INFO_URL_TEMPLATE;

   /*

    @Value("${url.statsinfo}")
    private String STATS_URL_TEMPLATE;

    @Value("${fsign}")
    private String FSIGN;*/
}
