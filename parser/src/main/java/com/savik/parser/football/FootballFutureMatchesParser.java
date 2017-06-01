package com.savik.parser.football;

import java.util.List;

import com.savik.football.model.FootballChampionship;
import com.savik.football.model.FootballFutureMatch;
import com.savik.football.model.Season;
import com.savik.football.repository.FootballFutureMatchRepository;
import com.savik.football.repository.FootballTeamRepository;
import com.savik.parser.EventItem;
import com.savik.parser.FutureMatchesParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void parse() {
        List<EventItem> eventItems = futureMatchesParser.parse(1);
        eventItems.forEach(e -> {
            FootballFutureMatch footballFutureMatch = convert(e);
            matchRepository.save(footballFutureMatch);
        });

    }

    private FootballFutureMatch convert(EventItem eventItem) {
        FootballChampionship championship = convert(eventItem.getLeagueId());
        return FootballFutureMatch
                .builder()
                .championship(championship)
                .date(eventItem.getEventDate())
                .myscoreCode(eventItem.getEventId())
                .homeTeam(footballTeamRepository.findOneByNameAndChampionship(eventItem.getHomeName(), championship))
                .guestTeam(footballTeamRepository.findOneByNameAndChampionship(eventItem.getGuestName(), championship))
                .season(Season.S2016) // TODO: правильное определение сезона
                .build();
    }

    private FootballChampionship convert(String myscoreLeagueId) {
        return FootballChampionship.LA;
    }
}
