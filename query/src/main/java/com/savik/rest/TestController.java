package com.savik.rest;

import java.util.List;

import com.savik.GeneralBetContainer;
import com.savik.football.model.FootballMatch;
import com.savik.football.repository.FootballMatchRepository;
import com.savik.hockey.model.HockeyMatch;
import com.savik.hockey.repository.HockeyMatchRepository;
import com.savik.result_block.hockey.home.HomeBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class TestController {

    @Autowired
    FootballMatchRepository footballMatchRepository;


    @Autowired
    HockeyMatchRepository hockeyMatchRepository;

    @GetMapping
    public GeneralBetContainer getShortCard() {
        List<HockeyMatch> all = hockeyMatchRepository.findAll();
        HomeBlock homeBlock = new HomeBlock();
        all.forEach(homeBlock::check);
        return homeBlock;
    }
}
