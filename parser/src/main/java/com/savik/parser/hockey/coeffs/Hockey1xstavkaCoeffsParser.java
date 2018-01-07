package com.savik.parser.hockey.coeffs;

import com.savik.CoeffEntry;
import com.savik.Team;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.savik.parser.hockey.coeffs.Book1xbetConstants.*;


@Service
public class Hockey1xstavkaCoeffsParser {

    @Autowired
    HockeyFutureMatchRepository hockeyFutureMatchRepository;

    @Autowired
    HockeyParimatchCoeffsMatchParser hockeyParimatchCoeffsMatchParser;

    @Autowired
    Hockey1xstavkaCoeffsMatchParser hockey1XstavkaCoeffsMatchParser;

    @Autowired
    CoeffRepository coeffRepository;

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

    private void parseLeague(List<HockeyFutureMatch> matches, String leagueUrl, Map<String, String> teamNameMapping) throws IOException {
        for (HockeyFutureMatch match : matches) {
            mapName(match.getHomeTeam(), teamNameMapping);
            mapName(match.getGuestTeam(), teamNameMapping);
            CoeffBlock coeffBlock = hockey1XstavkaCoeffsMatchParser.parse(match, leagueUrl);
            List<CoeffEntry> coeffEntries = CoeffTransformer.transformBlockToEntryWithoutAverageCoeffs(coeffBlock, match.getMyscoreCode());
            coeffRepository.deleteAllByMyscoreCode(match.getMyscoreCode());
            coeffRepository.save(coeffEntries);
            System.out.println("parsed = " + match.getMyscoreCode());

        }
    }

    private void mapName(Team team, Map<String, String> teamNameMapping) {
        if (teamNameMapping.containsKey(team.getName())) {
            team.setName(teamNameMapping.get(team.getName()));
        }
    }
}
