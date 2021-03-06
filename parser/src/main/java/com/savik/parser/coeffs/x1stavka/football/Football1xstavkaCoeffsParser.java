package com.savik.parser.coeffs.x1stavka.football;

import com.savik.CoeffContainer;
import com.savik.coeffs.football.FootballCoeffBlock;
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

import static com.savik.parser.coeffs.x1stavka.Book1xbetConstants.*;


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
        parseLeague(all.stream().filter(m -> m.getChampionship() == FootballChampionship.SERIE_A).collect(Collectors.toList()),
                SERIE_A, new HashMap<>());
        parseLeague(all.stream().filter(m -> m.getChampionship() == FootballChampionship.AUSTRALIA_A).collect(Collectors.toList()),
                AUSTRALIA_A, new HashMap<>());
        parseLeague(all.stream().filter(m -> m.getChampionship() == FootballChampionship.PORTUGAL_PREMIER).collect(Collectors.toList()),
                PORTUGAL_PREMIER, portugalPremierMapping);
        parseLeague(all.stream().filter(m -> m.getChampionship() == FootballChampionship.INDIA_SUPERLIGA).collect(Collectors.toList()),
                INDIA_SUPERLIGA, indiaSuperligaMapping);
        parseLeague(all.stream().filter(m -> m.getChampionship() == FootballChampionship.BUNDESLIGA).collect(Collectors.toList()),
                BUNDESLIGA, bundesligaMapping);
        parseLeague(all.stream().filter(m -> m.getChampionship() == FootballChampionship.FRANCE_1).collect(Collectors.toList()),
                FRANCE_1, new HashMap<>());
/*        parseLeague(all.stream().filter(m -> m.getChampionship() == FootballChampionship.FRANCE_2).collect(Collectors.toList()),
                FRANCE_2, france2Mapping);
        parseLeague(all.stream().filter(m -> m.getChampionship() == FootballChampionship.HOLLAND_1).collect(Collectors.toList()),
                HOLLAND_1, holland1Mapping);
        parseLeague(all.stream().filter(m -> m.getChampionship() == FootballChampionship.HOLLAND_EREDIVISIE).collect(Collectors.toList()),
                HOLLAND_EREDIVISIE, hollandSuperligaMapping);*/
        parseLeague(all.stream().filter(m -> m.getChampionship() == FootballChampionship.ENGLAND_PREMIER).collect(Collectors.toList()),
                ENGLAND_PREMIER, englandPremierMapping);
/*        parseLeague(all.stream().filter(m -> m.getChampionship() == FootballChampionship.GREECE_SUPERLIGA).collect(Collectors.toList()),
                GREECE_SUPERLIGA, greeceSuperligaMapping);
        parseLeague(all.stream().filter(m -> m.getChampionship() == FootballChampionship.CYPRUS_1).collect(Collectors.toList()),
                CYPRUS_1, cyprusMapping);*/
        parseLeague(all.stream().filter(m -> m.getChampionship() == FootballChampionship.BELGIUM).collect(Collectors.toList()),
                BELGIUM, belgiumMapping);
    }

    @Override
    protected CoeffContainer createCoeffContainer() {
        return new FootballCoeffBlock();
    }
}
