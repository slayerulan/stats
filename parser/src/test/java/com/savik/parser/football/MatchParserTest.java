package com.savik.parser.football;

import static com.savik.football.model.Card.Type.YELLOW;
import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

import com.savik.Application;
import com.savik.football.model.*;
import com.savik.football.repository.MatchRepository;
import com.savik.football.repository.TeamRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Savushkin Yauheni
 * @since 05.05.2017
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
public class MatchParserTest {

    @Autowired
    MatchParser matchParser;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    MatchRepository matchRepository;

    @Test
    public void test() {


        Match match = matchParser.parse("v9xniz5h", Championship.LA, Season.S2016);
        match = matchRepository.save(match);

        Team home = teamRepository.findOneByNameAndChampionship("Эспаньол", Championship.LA);
        Team guest = teamRepository.findOneByNameAndChampionship("Бетис", Championship.LA);

        assertEquals(match.getSeason(), Season.S2016);
        assertEquals(match.getMyscoreCode(), "v9xniz5h");
        assertEquals(match.getChampionship(), Championship.LA);
        assertEquals(match.getHomeTeam(), home);
        assertEquals(match.getGuestTeam(), guest);
        assertEquals(match.getDate(), LocalDateTime.of(2017,3,31,21,45));





        MatchInfo matchInfo = match.getMatchInfo();

        /*
         1 тайм 0-0, без карточек и нет статистики
        * */
        Period firstPeriod = matchInfo.getFirstPeriod();
        assertEquals(firstPeriod.getHomeScore().intValue(), 0);
        assertEquals(firstPeriod.getGuestScore().intValue(), 0);
        assertEquals(firstPeriod.getTotalScore().intValue(), 0);
        assertEquals(firstPeriod.getWinner(), Winner.DRAW);
        assertEquals(firstPeriod.getPeriodStatus(), Period.PeriodStatus.FIRST);
        assertEquals(firstPeriod.getGoals().size(), 0);
        assertEquals(firstPeriod.getCards().size(), 0);
        assertNull(firstPeriod.getHomeCorners());
        assertNull(firstPeriod.getGuestCorners());
        assertNull(firstPeriod.getHomeHits());
        assertNull(firstPeriod.getGuestHits());
        assertNull(firstPeriod.getHomePossession());
        assertNull(firstPeriod.getGuestPossession());
        assertNull(firstPeriod.getHomeOffsides());
        assertNull(firstPeriod.getGuestOffsides());
        assertNull(firstPeriod.getHomeFouls());
        assertNull(firstPeriod.getGuestFouls());


        /*
         2 тайм 2-1, 5 желтых карточек
        * */
        Period secondPeriod = matchInfo.getSecondPeriod();

        assertEquals(secondPeriod.getHomeScore().intValue(), 2);
        assertEquals(secondPeriod.getGuestScore().intValue(), 1);
        assertEquals(secondPeriod.getTotalScore().intValue(), 3);
        assertEquals(secondPeriod.getWinner(), Winner.HOME);
        assertEquals(secondPeriod.getPeriodStatus(), Period.PeriodStatus.SECOND);
        assertEquals(secondPeriod.getGoals().size(), 3);
        assertTrue(secondPeriod.getGoals().containsAll(new HashSet<>(Arrays.asList(
                Goal.builder().minute(78).whoScored(Who.GUEST).team(guest).build(),
                Goal.builder().minute(87).whoScored(Who.HOME).team(home).build(),
                Goal.builder().minute(90).whoScored(Who.HOME).team(home).build()
        ))));
        assertEquals(secondPeriod.getCards().size(), 5);
        assertTrue(secondPeriod.getCards().containsAll(new HashSet<>(Arrays.asList(
                Card.builder().minute(76).who(Who.HOME).team(home).type(YELLOW).build(),
                Card.builder().minute(82).who(Who.HOME).team(home).type(YELLOW).build(),
                Card.builder().minute(87).who(Who.GUEST).team(guest).type(YELLOW).build(),
                Card.builder().minute(88).who(Who.HOME).team(home).type(YELLOW).build(),
                Card.builder().minute(90).who(Who.GUEST).team(guest).type(YELLOW).build()
        ))));
        assertEquals(secondPeriod.getHomeCorners().intValue(), 4);
        assertEquals(secondPeriod.getGuestCorners().intValue(),4);
        assertEquals(secondPeriod.getHomeHits().intValue(),8);
        assertEquals(secondPeriod.getGuestHits().intValue(),10);
        assertNull(secondPeriod.getHomePossession());
        assertNull(secondPeriod.getGuestPossession());
        assertEquals(secondPeriod.getHomeOffsides().intValue(), 2);
        assertEquals(secondPeriod.getGuestOffsides().intValue(), 1);
        assertEquals(secondPeriod.getHomeFouls().intValue(), 16);
        assertEquals(secondPeriod.getGuestFouls().intValue(), 14);



         /*
          матч
        * */
        Period matchPeriod = matchInfo.getMatch();

        assertEquals(matchPeriod.getHomeScore().intValue(), 2);
        assertEquals(matchPeriod.getGuestScore().intValue(), 1);
        assertEquals(matchPeriod.getTotalScore().intValue(), 3);
        assertEquals(matchPeriod.getWinner(), Winner.HOME);
        assertEquals(matchPeriod.getPeriodStatus(), Period.PeriodStatus.MATCH);
        assertNull(matchPeriod.getGoals());
        assertNull(matchPeriod.getCards());
        assertEquals(matchPeriod.getHomeCorners().intValue(), 4);
        assertEquals(matchPeriod.getGuestCorners().intValue(),4);
        assertEquals(matchPeriod.getHomeHits().intValue(),8);
        assertEquals(matchPeriod.getGuestHits().intValue(),10);
        assertEquals(matchPeriod.getHomePossession().intValue(), 49);
        assertEquals(matchPeriod.getGuestPossession().intValue(), 51);
        assertEquals(matchPeriod.getHomeOffsides().intValue(), 2);
        assertEquals(matchPeriod.getGuestOffsides().intValue(), 1);
        assertEquals(matchPeriod.getHomeFouls().intValue(), 16);
        assertEquals(matchPeriod.getGuestFouls().intValue(), 14);

    }
}
