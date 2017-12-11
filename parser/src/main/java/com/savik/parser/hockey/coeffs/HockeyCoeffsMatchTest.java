package com.savik.parser.hockey.coeffs;

import com.savik.hockey.model.HockeyFutureMatch;
import com.savik.hockey.repository.HockeyFutureMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HockeyCoeffsMatchTest {

    @Autowired
    HockeyFutureMatchRepository hockeyFutureMatchRepository;

    @Autowired
    HockeyCoeffsMatchParser hockeyCoeffsMatchParser;


    public void parse() {
        List<HockeyFutureMatch> all = hockeyFutureMatchRepository.findAll();
        hockeyCoeffsMatchParser.parse(all.get(0));
        String a = "";
    }
}
