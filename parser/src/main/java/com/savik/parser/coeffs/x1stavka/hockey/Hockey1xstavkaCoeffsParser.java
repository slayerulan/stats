package com.savik.parser.coeffs.x1stavka.hockey;

import com.savik.CoeffContainer;
import com.savik.coeffs.hockey.HockeyCoeffBlock;
import com.savik.hockey.model.HockeyChampionship;
import com.savik.hockey.model.HockeyFutureMatch;
import com.savik.hockey.repository.HockeyFutureMatchRepository;
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
public class Hockey1xstavkaCoeffsParser extends Sport1xstavkaCoeffsParser {

    @Autowired
    HockeyFutureMatchRepository hockeyFutureMatchRepository;

    @Autowired
    public void setFootball1xstavkaCoeffsMatchParser(Hockey1xstavkaCoeffsMatchParser hockey1xstavkaCoeffsMatchParser) {
        setSport1xstavkaCoeffsMatchParser(hockey1xstavkaCoeffsMatchParser);
    }


    public void parse() throws URISyntaxException, IOException {
        List<HockeyFutureMatch> all = hockeyFutureMatchRepository.findAll();
        parseLeague(all.stream().filter(m -> m.getChampionship() == HockeyChampionship.NHL).collect(Collectors.toList()),
                NHL, new HashMap<>());

        parseLeague(all.stream().filter(m -> m.getChampionship() == HockeyChampionship.SHL).collect(Collectors.toList()),
                SHL, shlMapping);

        parseLeague(all.stream().filter(m -> m.getChampionship() == HockeyChampionship.DEL).collect(Collectors.toList()),
                DEL, delMapping);

        parseLeague(all.stream().filter(m -> m.getChampionship() == HockeyChampionship.KHL).collect(Collectors.toList()),
                KHL, khlMapping);

        parseLeague(all.stream().filter(m -> m.getChampionship() == HockeyChampionship.EXTRA).collect(Collectors.toList()),
                EXTRA, extraMapping);
    }

    @Override
    protected CoeffContainer createCoeffContainer() {
        return new HockeyCoeffBlock();
    }
}
