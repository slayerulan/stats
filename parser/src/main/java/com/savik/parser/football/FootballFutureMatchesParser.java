package com.savik.parser.football;

import java.util.List;

import com.savik.football.model.Championship;
import com.savik.football.model.FutureMatch;
import com.savik.football.model.Season;
import com.savik.football.repository.FutureMatchRepository;
import com.savik.football.repository.TeamRepository;
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
    FutureMatchRepository matchRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    FutureMatchesParser futureMatchesParser;

    public void parse() {
        List<EventItem> eventItems = futureMatchesParser.parse(1);
        eventItems.forEach(e -> {
            FutureMatch futureMatch = convert(e);
            matchRepository.save(futureMatch);
        });

    }

    private FutureMatch convert(EventItem eventItem) {
        Championship championship = convert(eventItem.getLeagueId());
        return FutureMatch.builder()
                          .championship(championship)
                          .date(eventItem.getEventDate())
                          .myscoreCode(eventItem.getEventId())
                          .homeTeam(teamRepository.findOneByNameAndChampionship(eventItem.getHomeName(), championship))
                          .guestTeam(teamRepository.findOneByNameAndChampionship(
                                  eventItem.getGuestName(),
                                  championship
                          ))
                          .season(Season.S2016) // TODO: правильное определение сезона
                          .build();
    }

    private Championship convert(String myscoreLeagueId) {
        return Championship.LA;
    }
}
