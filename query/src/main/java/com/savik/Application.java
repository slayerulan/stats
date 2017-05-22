package com.savik;

import java.util.List;
import javax.annotation.PostConstruct;

import com.savik.football.model.Match;
import com.savik.football.repository.MatchRepository;
import com.savik.football.result_block.home.HomeBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String... args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    MatchRepository matchRepository;

    @PostConstruct
    public void test() {
        List<Match> all = matchRepository.findAll();
        HomeBlock homeBlock = new HomeBlock();
        all.forEach(homeBlock::check);
        String a = "";
    }
}
