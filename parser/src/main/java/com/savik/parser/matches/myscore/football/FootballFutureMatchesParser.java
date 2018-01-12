package com.savik.parser.matches.myscore.football;

import com.savik.Season;
import com.savik.football.model.FootballChampionship;
import com.savik.football.model.FootballFutureMatch;
import com.savik.football.repository.FootballFutureMatchRepository;
import com.savik.football.repository.FootballTeamRepository;
import com.savik.parser.Downloader;
import com.savik.parser.EventItem;
import com.savik.parser.FutureMatchesParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Savushkin Yauheni
 * @since 12.04.2017
 */
@Service
public class FootballFutureMatchesParser {

    @Autowired
    FootballFutureMatchRepository matchRepository;

    @Autowired
    FootballTeamRepository footballTeamRepository;

    @Autowired
    FutureMatchesParser futureMatchesParser;

    private static final int TODAY = 0;
    private static final int TOMORROW = 1;
    private static final int DAY_AFTER_TOMORROW = 2;

    @Autowired
    Downloader downloader;

    // todo: убрать отсюда
    @PostConstruct
    public void deleteFinishedFutureMatches() {
        matchRepository.deleteByDateBefore(LocalDateTime.now());
    }

    public void parse() {
        parseDay(TODAY);
        parseDay(TOMORROW);
        //parseDay(DAY_AFTER_TOMORROW);
    }

    private void parseDay(int day) {
        String response = downloader.downloadFootballMatchesSchedule(day).body().html();
        List<EventItem> eventItems = futureMatchesParser.parse(response);
        eventItems.forEach(e -> {
            FootballFutureMatch footballFutureMatch = convert(e);
            if (footballFutureMatch != null &&
                    matchRepository.findByMyscoreCode(footballFutureMatch.getMyscoreCode()) == null &&
                    footballFutureMatch.getDate().isAfter(LocalDateTime.now())) {
                matchRepository.save(footballFutureMatch);
            }
        });
    }

    private FootballFutureMatch convert(EventItem eventItem) {
        FootballChampionship championship = convert(eventItem.getLeagueId());
        if (championship == null) {
            return null;
        }
        return FootballFutureMatch
                .builder()
                .championship(championship)
                .date(eventItem.getEventDate())
                .myscoreCode(eventItem.getEventId())
                .homeTeam(footballTeamRepository.findOneByNameAndChampionship(eventItem.getHomeName(), championship))
                .guestTeam(footballTeamRepository.findOneByNameAndChampionship(eventItem.getGuestName(), championship))
                .season(Season.S2017) // TODO: правильное определение сезона
                .build();
    }

    private FootballChampionship convert(String myscoreLeagueId) {
        if (FootballLeagueIds.LA.equals(myscoreLeagueId)) {
            return FootballChampionship.LA;
        }
        if (FootballLeagueIds.AUSTRALIA_A.equals(myscoreLeagueId)) {
            return FootballChampionship.AUSTRALIA_A;
        }
        if (FootballLeagueIds.PORTUGAL_PREMIER.equals(myscoreLeagueId)) {
            return FootballChampionship.PORTUGAL_PREMIER;
        }
        if (FootballLeagueIds.INDIA_SUPERLIGA.equals(myscoreLeagueId)) {
            return FootballChampionship.INDIA_SUPERLIGA;
        }
        if (FootballLeagueIds.BUNDESLIGA.equals(myscoreLeagueId)) {
            return FootballChampionship.BUNDESLIGA;
        }
        if (FootballLeagueIds.HOLLAND_1.equals(myscoreLeagueId)) {
            return FootballChampionship.HOLLAND_1;
        }
        if (FootballLeagueIds.FRANCE_1.equals(myscoreLeagueId)) {
            return FootballChampionship.FRANCE_1;
        }
        if (FootballLeagueIds.HOLLAND_EREDIVISIE.equals(myscoreLeagueId)) {
            return FootballChampionship.HOLLAND_EREDIVISIE;
        }
        if (FootballLeagueIds.ENGLAND_PREMIER.equals(myscoreLeagueId)) {
            return FootballChampionship.ENGLAND_PREMIER;
        }
        return null;
    }
}
