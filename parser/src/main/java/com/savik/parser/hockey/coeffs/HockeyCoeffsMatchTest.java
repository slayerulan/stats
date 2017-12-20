package com.savik.parser.hockey.coeffs;

import com.savik.hockey.model.HockeyFutureMatch;
import com.savik.hockey.repository.HockeyFutureMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;


@Service
public class HockeyCoeffsMatchTest {

    @Autowired
    HockeyFutureMatchRepository hockeyFutureMatchRepository;

    @Autowired
    HockeyCoeffsMatchParser hockeyCoeffsMatchParser;

    @Autowired
    Hockey1xstavkaCoeffsMatchParser hockey1xstavkaCoeffsMatchParser;

    public void parse() throws URISyntaxException, IOException {
        HockeyFutureMatch futureMatch = hockeyFutureMatchRepository.findByMyscoreCode("O2kusvJl");
        //hockeyCoeffsMatchParser.parse(futureMatch);
        hockey1xstavkaCoeffsMatchParser.parse(futureMatch);
        String a = "";
    }
}
