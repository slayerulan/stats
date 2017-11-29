package com.savik.rest;

import java.util.List;

import com.savik.GeneralBetContainer;
import com.savik.football.model.FootballMatch;
import com.savik.football.repository.FootballMatchRepository;
import com.savik.result_block.football.home.HomeBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class TestController {

    @Autowired
    FootballMatchRepository footballMatchRepository;

    @GetMapping
    public GeneralBetContainer getShortCard() {
        List<FootballMatch> all = footballMatchRepository.findAll();
        HomeBlock homeBlock = new HomeBlock();
        all.forEach(homeBlock::check);
        return homeBlock;
    }
}
