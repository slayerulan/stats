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
import java.util.Objects;
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
/*        parseLeague(all.stream().filter(m -> m.getChampionship() == HockeyChampionship.NHL).collect(Collectors.toList()),
                "https://1xecu.xyz/LineFeed/GetChampZip?lng=ru&champ=30619&tf=3000000&afterDays=0&tz=0&sport=2&country=1", new HashMap<>());*/

        parseLeague(all.stream().filter(m -> m.getChampionship() == HockeyChampionship.SHL).collect(Collectors.toList()),
                "https://1xecu.xyz/LineFeed/GetChampZip?lng=ru&champ=1388257&tf=3000000&afterDays=0&tz=0&sport=2&country=1", shlMapping);

        parseLeague(all.stream().filter(m -> m.getChampionship() == HockeyChampionship.DEL).collect(Collectors.toList()),
                "https://1xecu.xyz/LineFeed/GetChampZip?lng=ru&champ=104035&tf=3000000&afterDays=0&tz=0&sport=2&country=1", delMapping);
/*       */


/*        parseLeague(all.stream().filter(m -> m.getChampionship() == HockeyChampionship.KHL).collect(Collectors.toList()),
                "https://1xecu.xyz/LineFeed/GetChampZip?lng=ru&champ=3355&tf=3000000&afterDays=0&tz=0&sport=2&country=1");*/
/*        parseLeague(all.stream().filter(m -> m.getChampionship() == HockeyChampionship.EXTRA).collect(Collectors.toList()),
                "https://1xecu.xyz/LineFeed/GetChampZip?lng=ru&champ=104959&tf=3000000&afterDays=0&tz=0&sport=2&country=1", extraMapping);*/

/*        */


/*        parseLeague(all.stream().filter(m -> Objects.equals(m.getMyscoreCode(), "MmxpjDlG")).collect(Collectors.toList()),
                "https://1xecu.xyz/LineFeed/GetChampZip?lng=ru&champ=3355&tf=3000000&afterDays=0&tz=0&sport=2&country=1");*/
    }

    private void parseLeague(List<HockeyFutureMatch> matches, String leagueUrl, Map<String, String> teamNameMapping) throws IOException {
        for (HockeyFutureMatch match : matches) {
            mapName(match.getHomeTeam(), teamNameMapping);
            mapName(match.getGuestTeam(), teamNameMapping);
            CoeffBlock coeffBlock = hockey1xstavkaCoeffsMatchParser.parse(match, leagueUrl);
            List<CoeffEntry> coeffEntries = CoeffTransformer.transformBlockToEntryWithoutAverageCoeffs(coeffBlock, match.getMyscoreCode());
            coeffRepository.deleteAllByMyscoreCode(match.getMyscoreCode());
            coeffRepository.save(coeffEntries);
            System.out.println("parsed = " + match.getMyscoreCode());

        }
    }

    private void mapName(Team team, Map<String, String> teamNameMapping) {
        if(teamNameMapping.containsKey(team.getName())) {
            team.setName(teamNameMapping.get(team.getName()));
        }
    }

    private static Map<String, String> extraMapping = new HashMap<String, String>(){
        {
            put("Тршинец", "Оцеларжи");
            put("Хомутов", "Пираты");
            put("Либерец", "Били Тигржи");
            put("Плзень", "Шкода Пльзень");
        }
    };

    private static Map<String, String> delMapping = new HashMap<String, String>(){
        {
            put("Адлер Мангейм", "Маннгейм");
            put("Бремерхавен", "Фиштаун Пингвинс");
            put("Стробинг Тайгерз", "Штраубинг Тайгерс");
            put("Айсбарен Берлин", "Айсберен");
            put("Аугсбюргер", "Аугсбургер Пантер");
            put("Нюрнберг Айс Тайгерс", "Томас Сабо Айс Тайгерс");
            put("Исерлон", "Изерлон Рустерс");
        }
    };

    private static Map<String, String> shlMapping = new HashMap<String, String>(){
        {
            put("Лулео", "Лулеo"); // разные o
            put("Эребру", "Оребро");
            put("Векшё", "Ваксё Лейкерс");
            put("Векшё", "Ваксё Лейкерс");
            put("Линчеппинг", "Линчопинг");
            put("Карлскрона", "Карлскруна");
            put("Мальмо", "Мальме Ред Хоукс");
        }
    };
}
