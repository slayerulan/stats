package com.savik.parser.coeffs.x1stavka;

import com.savik.CoeffContainer;
import com.savik.CoeffEntry;
import com.savik.Team;
import com.savik.coeffs.football.FootballCoeffBlock;
import com.savik.football.model.FootballFutureMatch;
import com.savik.parser.utils.CoeffTransformer;
import com.savik.repository.CoeffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;


@Service
public class Sport1xstavkaCoeffsParser {


    @Autowired
    CoeffRepository coeffRepository;

    Sport1xstavkaCoeffsMatchParser sport1xstavkaCoeffsMatchParser;

    public void setSport1xstavkaCoeffsMatchParser(Sport1xstavkaCoeffsMatchParser sport1xstavkaCoeffsMatchParser) {
        this.sport1xstavkaCoeffsMatchParser = sport1xstavkaCoeffsMatchParser;
    }

    protected void parseLeague(List<FootballFutureMatch> matches, String leagueUrl, Map<String, String> teamNameMapping) throws IOException {
        for (FootballFutureMatch match : matches) {
            mapName(match.getHomeTeam(), teamNameMapping);
            mapName(match.getGuestTeam(), teamNameMapping);
            CoeffContainer coeffBlock = sport1xstavkaCoeffsMatchParser.parse(match, leagueUrl, new FootballCoeffBlock());
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
