package com.savik.parser.hockey.coeffs;

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
public class HockeyDownloaderConfiguration {

    @Value("${nhl.url}")
    private String nhlUr;

}