package com.savik.parser.hockey.matches;

import com.savik.Season;
import com.savik.hockey.model.HockeyChampionship;
import com.savik.hockey.model.HockeyFutureMatch;
import com.savik.hockey.repository.HockeyFutureMatchRepository;
import com.savik.hockey.repository.HockeyTeamRepository;
import com.savik.parser.EventItem;
import com.savik.parser.FutureMatchesParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Savushkin Yauheni
 * @since 12.04.2017
 */
@Service
public class HockeyFutureMatchesParser {

    @Autowired
    HockeyFutureMatchRepository matchRepository;

    @Autowired
    HockeyTeamRepository hockeyTeamRepository;

    @Autowired
    FutureMatchesParser futureMatchesParser;

    public void parse() {
        List<EventItem> eventItems = futureMatchesParser.parse(1);
        eventItems.forEach(e -> {
            HockeyFutureMatch footballFutureMatch = convert(e);
            if (footballFutureMatch != null &&
                    matchRepository.findByMyscoreCode(footballFutureMatch.getMyscoreCode()) == null) {
                matchRepository.save(footballFutureMatch);
            }
        });

    }

    private HockeyFutureMatch convert(EventItem eventItem) {
        HockeyChampionship championship = convert(eventItem.getLeagueId());
        if (championship == null) {
            return null;
        }
        return HockeyFutureMatch
                .builder()
                .championship(championship)
                .date(eventItem.getEventDate())
                .myscoreCode(eventItem.getEventId())
                .homeTeam(hockeyTeamRepository.findOneByNameAndChampionship(eventItem.getHomeName(), championship))
                .guestTeam(hockeyTeamRepository.findOneByNameAndChampionship(eventItem.getGuestName(), championship))
                .season(Season.S2017) // TODO: правильное определение сезона
                .build();
    }

    private HockeyChampionship convert(String myscoreLeagueId) {
        if (HockeyLeagueIds.NHL.equals(myscoreLeagueId)) {
            return HockeyChampionship.NHL;
        }
        if (HockeyLeagueIds.KHL.equals(myscoreLeagueId)) {
            return HockeyChampionship.KHL;
        }
        if (HockeyLeagueIds.EXTRA.equals(myscoreLeagueId)) {
            return HockeyChampionship.EXTRA;
        }
        if (HockeyLeagueIds.DEL.equals(myscoreLeagueId)) {
            return HockeyChampionship.DEL;
        }
        if (HockeyLeagueIds.SHL.equals(myscoreLeagueId)) {
            return HockeyChampionship.SHL;
        }
        return null;

    }
}
