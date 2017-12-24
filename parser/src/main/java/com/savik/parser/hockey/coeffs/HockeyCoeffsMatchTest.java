package com.savik.parser.hockey.coeffs;

import com.savik.CoeffEntry;
import com.savik.coeffs.hockey.CoeffBlock;
import com.savik.hockey.model.HockeyChampionship;
import com.savik.hockey.model.HockeyFutureMatch;
import com.savik.hockey.repository.HockeyFutureMatchRepository;
import com.savik.parser.utils.CoeffTransformer;
import com.savik.repository.CoeffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class HockeyCoeffsMatchTest {

    @Autowired
    HockeyFutureMatchRepository hockeyFutureMatchRepository;

    @Autowired
    HockeyCoeffsMatchParser hockeyCoeffsMatchParser;

    @Autowired
    Hockey1xstavkaCoeffsMatchParser hockey1xstavkaCoeffsMatchParser;

    @Autowired
    CoeffRepository coeffRepository;

    public void parse() throws URISyntaxException, IOException {
        List<HockeyFutureMatch> all = hockeyFutureMatchRepository.findAll();
/*        parseLeague(all.stream().filter(m -> m.getMyscoreCode().equals("A3ymaIws")).collect(Collectors.toList()),
                "https://1xecu.xyz/LineFeed/GetChampZip?lng=ru&champ=30619&tf=3000000&afterDays=0&tz=0&sport=2&country=1");
        parseLeague(all.stream().filter(m -> m.getChampionship() == HockeyChampionship.NHL).collect(Collectors.toList()),
                "https://1xecu.xyz/LineFeed/GetChampZip?lng=ru&champ=30619&tf=3000000&afterDays=0&tz=0&sport=2&country=1");*/
        parseLeague(all.stream().filter(m -> m.getChampionship() == HockeyChampionship.KHL).collect(Collectors.toList()),
                "https://1xecu.xyz/LineFeed/GetChampZip?lng=ru&champ=3355&tf=3000000&afterDays=0&tz=0&sport=2&country=1");
        String a = "";
    }

    private void parseLeague(List<HockeyFutureMatch> matches, String leagueUrl) throws IOException {
        for (HockeyFutureMatch match : matches) {
            CoeffBlock coeffBlock = hockey1xstavkaCoeffsMatchParser.parse(match, leagueUrl);
            List<CoeffEntry> coeffEntries = CoeffTransformer.transformBlockToEntryWithoutAverageCoeffs(coeffBlock, match.getMyscoreCode());
            coeffRepository.deleteAllByMyscoreCode(match.getMyscoreCode());
            coeffRepository.save(coeffEntries);
            System.out.println("parsed = " + match.getMyscoreCode());

        }
    }
}
