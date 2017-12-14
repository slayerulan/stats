package com.savik.parser.hockey.coeffs;

import com.savik.hockey.model.HockeyFutureMatch;
import com.savik.hockey.repository.HockeyFutureMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;


@Service
public class HockeyCoeffsMatchTest {

    @Autowired
    HockeyFutureMatchRepository hockeyFutureMatchRepository;

    @Autowired
    HockeyCoeffsMatchParser hockeyCoeffsMatchParser;


    public void parse() throws URISyntaxException {
        HockeyFutureMatch futureMatch = hockeyFutureMatchRepository.findByMyscoreCode("O2kusvJl");
        hockeyCoeffsMatchParser.parse(futureMatch);
        String a = "";
    }
}
