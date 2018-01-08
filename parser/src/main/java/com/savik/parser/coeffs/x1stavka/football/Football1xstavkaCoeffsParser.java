package com.savik.parser.coeffs.x1stavka.football;

import com.savik.football.model.FootballChampionship;
import com.savik.football.model.FootballFutureMatch;
import com.savik.football.repository.FootballFutureMatchRepository;
import com.savik.parser.coeffs.x1stavka.Sport1xstavkaCoeffsParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static com.savik.parser.coeffs.x1stavka.Book1xbetConstants.LA;


@Service
public class Football1xstavkaCoeffsParser extends Sport1xstavkaCoeffsParser {

    @Autowired
    FootballFutureMatchRepository footballFutureMatchRepository;

    @Autowired
    public void setFootball1xstavkaCoeffsMatchParser(Football1xstavkaCoeffsMatchParser football1xstavkaCoeffsMatchParser) {
        setSport1xstavkaCoeffsMatchParser(football1xstavkaCoeffsMatchParser);
    }

    public void parse() throws URISyntaxException, IOException {
        List<FootballFutureMatch> all = footballFutureMatchRepository.findAll();
        parseLeague(all.stream().filter(m -> m.getChampionship() == FootballChampionship.LA).collect(Collectors.toList()),
                LA, new HashMap<>());
    }
}
