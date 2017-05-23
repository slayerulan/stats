package com.savik.rest;

import java.util.List;

import com.savik.football.blocks.GeneralBetContainer;
import com.savik.football.model.Match;
import com.savik.football.repository.MatchRepository;
import com.savik.football.result_block.home.HomeBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class TestController {

    @Autowired
    MatchRepository matchRepository;

    @GetMapping
    public GeneralBetContainer getShortCard() {
        List<Match> all = matchRepository.findAll();
        HomeBlock homeBlock = new HomeBlock();
        all.forEach(homeBlock::check);
        return homeBlock;
    }
}
