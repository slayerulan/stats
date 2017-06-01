package com.savik.parser.football;

import static com.savik.football.model.FootballCard.Type.RED;
import static com.savik.football.model.FootballCard.Type.YELLOW;
import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

import com.savik.Application;
import com.savik.football.model.*;
import com.savik.football.repository.FootballMatchRepository;
import com.savik.football.repository.FootballTeamRepository;
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
public class FootballMatchParserTest {

    @Autowired
    MatchParser matchParser;

    @Autowired
    FootballTeamRepository footballTeamRepository;

    @Autowired
    FootballMatchRepository footballMatchRepository;

    @Test
    public void testMatchWithoutFirstTimeStats() {
        FootballMatch match = matchParser.parse("v9xniz5h", FootballChampionship.LA, Season.S2016);
        match = footballMatchRepository.save(match);

        FootballTeam home = footballTeamRepository.findOneByNameAndChampionship("Эспаньол", FootballChampionship.LA);
        FootballTeam guest = footballTeamRepository.findOneByNameAndChampionship("Бетис", FootballChampionship.LA);

        assertEquals(match.getSeason(), Season.S2016);
        assertEquals(match.getMyscoreCode(), "v9xniz5h");
        assertEquals(match.getChampionship(), FootballChampionship.LA);
        assertEquals(match.getHomeTeam(), home);
        assertEquals(match.getGuestTeam(), guest);
        assertEquals(match.getBookieStats().getHomeRate(), Double.valueOf(2.2));
        assertEquals(match.getBookieStats().getDrawRate(), Double.valueOf(3.2));
        assertEquals(match.getBookieStats().getGuestRate(), Double.valueOf(3.5));
        assertEquals(match.getDate(), LocalDateTime.of(2017, 3, 31, 21, 45));


        FootballMatchInfo footballMatchInfo = match.getMatchInfo();

        /*
         1 тайм 0-0, без карточек и нет статистики
        * */
        Period firstPeriod = footballMatchInfo.getFirstPeriod();
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
        Period secondPeriod = footballMatchInfo.getSecondPeriod();

        assertEquals(secondPeriod.getHomeScore().intValue(), 2);
        assertEquals(secondPeriod.getGuestScore().intValue(), 1);
        assertEquals(secondPeriod.getTotalScore().intValue(), 3);
        assertEquals(secondPeriod.getWinner(), Winner.HOME);
        assertEquals(secondPeriod.getPeriodStatus(), Period.PeriodStatus.SECOND);
        assertEquals(secondPeriod.getGoals().size(), 3);
        assertTrue(secondPeriod.getGoals().containsAll(new HashSet<>(Arrays.asList(
                FootballGoal.builder().minute(78).whoScored(Who.GUEST).team(guest).build(),
                FootballGoal.builder().minute(87).whoScored(Who.HOME).team(home).build(),
                FootballGoal.builder().minute(90).whoScored(Who.HOME).team(home).build()
        ))));
        assertEquals(secondPeriod.getCards().size(), 5);
        assertTrue(secondPeriod.getCards().containsAll(new HashSet<>(Arrays.asList(
                FootballCard.builder().minute(76).who(Who.HOME).team(home).type(YELLOW).build(),
                FootballCard.builder().minute(82).who(Who.HOME).team(home).type(YELLOW).build(),
                FootballCard.builder().minute(87).who(Who.GUEST).team(guest).type(YELLOW).build(),
                FootballCard.builder().minute(88).who(Who.HOME).team(home).type(YELLOW).build(),
                FootballCard.builder().minute(90).who(Who.GUEST).team(guest).type(YELLOW).build()
        ))));
        assertEquals(secondPeriod.getHomeCorners().intValue(), 4);
        assertEquals(secondPeriod.getGuestCorners().intValue(), 4);
        assertEquals(secondPeriod.getHomeHits().intValue(), 8);
        assertEquals(secondPeriod.getGuestHits().intValue(), 10);
        assertEquals(secondPeriod.getHomeHitsOnTarget().intValue(), 5);
        assertEquals(secondPeriod.getGuestHitsOnTarget().intValue(), 3);
        assertNull(secondPeriod.getHomePossession());
        assertNull(secondPeriod.getGuestPossession());
        assertEquals(secondPeriod.getHomeOffsides().intValue(), 2);
        assertEquals(secondPeriod.getGuestOffsides().intValue(), 1);
        assertEquals(secondPeriod.getHomeFouls().intValue(), 16);
        assertEquals(secondPeriod.getGuestFouls().intValue(), 14);



         /*
          матч
        * */
        Period matchPeriod = footballMatchInfo.getMatch();

        assertEquals(matchPeriod.getHomeScore().intValue(), 2);
        assertEquals(matchPeriod.getGuestScore().intValue(), 1);
        assertEquals(matchPeriod.getTotalScore().intValue(), 3);
        assertEquals(matchPeriod.getWinner(), Winner.HOME);
        assertEquals(matchPeriod.getPeriodStatus(), Period.PeriodStatus.MATCH);
        assertNull(matchPeriod.getGoals());
        assertNull(matchPeriod.getCards());
        assertEquals(matchPeriod.getHomeCorners().intValue(), 4);
        assertEquals(matchPeriod.getGuestCorners().intValue(), 4);
        assertEquals(matchPeriod.getHomeHits().intValue(), 8);
        assertEquals(matchPeriod.getGuestHits().intValue(), 10);
        assertEquals(secondPeriod.getHomeHitsOnTarget().intValue(), 5);
        assertEquals(secondPeriod.getGuestHitsOnTarget().intValue(), 3);
        assertEquals(matchPeriod.getHomePossession().intValue(), 49);
        assertEquals(matchPeriod.getGuestPossession().intValue(), 51);
        assertEquals(matchPeriod.getHomeOffsides().intValue(), 2);
        assertEquals(matchPeriod.getGuestOffsides().intValue(), 1);
        assertEquals(matchPeriod.getHomeFouls().intValue(), 16);
        assertEquals(matchPeriod.getGuestFouls().intValue(), 14);

    }

    @Test
    public void testMatchWithoutTimesStats() {
        FootballMatch footballMatch = matchParser.parse("bcLlhGkn", FootballChampionship.LA, Season.S2016);
        footballMatch = footballMatchRepository.save(footballMatch);

        FootballTeam home = footballTeamRepository.findOneByNameAndChampionship("Вильярреал", FootballChampionship.LA);
        FootballTeam guest = footballTeamRepository.findOneByNameAndChampionship("Эйбар", FootballChampionship.LA);

        assertEquals(footballMatch.getSeason(), Season.S2016);
        assertEquals(footballMatch.getMyscoreCode(), "bcLlhGkn");
        assertEquals(footballMatch.getChampionship(), FootballChampionship.LA);
        assertEquals(footballMatch.getHomeTeam(), home);
        assertEquals(footballMatch.getGuestTeam(), guest);
        assertEquals(footballMatch.getBookieStats().getHomeRate(), Double.valueOf(1.91));
        assertEquals(footballMatch.getBookieStats().getDrawRate(), Double.valueOf(3.5));
        assertEquals(footballMatch.getBookieStats().getGuestRate(), Double.valueOf(4.2));
        assertEquals(footballMatch.getDate(), LocalDateTime.of(2017, 4, 1, 14, 0));

        FootballMatchInfo footballMatchInfo = footballMatch.getMatchInfo();

        /*
         1 тайм 1-0, 3 карт. и нет статистики
        * */
        Period firstPeriod = footballMatchInfo.getFirstPeriod();
        assertEquals(firstPeriod.getHomeScore().intValue(), 1);
        assertEquals(firstPeriod.getGuestScore().intValue(), 0);
        assertEquals(firstPeriod.getTotalScore().intValue(), 1);
        assertEquals(firstPeriod.getWinner(), Winner.HOME);
        assertEquals(firstPeriod.getPeriodStatus(), Period.PeriodStatus.FIRST);
        assertEquals(firstPeriod.getGoals().size(), 1);
        assertTrue(firstPeriod.getGoals().containsAll(new HashSet<>(Arrays.asList(
                FootballGoal.builder().minute(18).whoScored(Who.HOME).team(home).build()
        ))));
        assertEquals(firstPeriod.getCards().size(), 3);
        assertTrue(firstPeriod.getCards().containsAll(new HashSet<>(Arrays.asList(
                FootballCard.builder().minute(10).who(Who.HOME).team(home).type(YELLOW).build(),
                FootballCard.builder().minute(39).who(Who.HOME).team(home).type(YELLOW).build(),
                FootballCard.builder().minute(43).who(Who.GUEST).team(guest).type(YELLOW).build()
        ))));
        assertNull(firstPeriod.getHomeCorners());
        assertNull(firstPeriod.getGuestCorners());
        assertNull(firstPeriod.getHomeHits());
        assertNull(firstPeriod.getGuestHits());
        assertNull(firstPeriod.getHomeHitsOnTarget());
        assertNull(firstPeriod.getGuestHitsOnTarget());
        assertNull(firstPeriod.getHomePossession());
        assertNull(firstPeriod.getGuestPossession());
        assertNull(firstPeriod.getHomeOffsides());
        assertNull(firstPeriod.getGuestOffsides());
        assertNull(firstPeriod.getHomeFouls());
        assertNull(firstPeriod.getGuestFouls());


        /*
         2 тайм 1-3, 4 желтых карточек
        * */
        Period secondPeriod = footballMatchInfo.getSecondPeriod();

        assertEquals(secondPeriod.getHomeScore().intValue(), 1);
        assertEquals(secondPeriod.getGuestScore().intValue(), 3);
        assertEquals(secondPeriod.getTotalScore().intValue(), 4);
        assertEquals(secondPeriod.getWinner(), Winner.GUEST);
        assertEquals(secondPeriod.getPeriodStatus(), Period.PeriodStatus.SECOND);
        assertEquals(secondPeriod.getGoals().size(), 4);
        assertTrue(secondPeriod.getGoals().containsAll(new HashSet<>(Arrays.asList(
                FootballGoal.builder().minute(48).whoScored(Who.GUEST).team(guest).build(),
                FootballGoal.builder().minute(54).whoScored(Who.GUEST).team(guest).build(),
                FootballGoal.builder().minute(77).whoScored(Who.GUEST).team(guest).build(),
                FootballGoal.builder().minute(89).whoScored(Who.HOME).team(home).build()
        ))));
        assertEquals(secondPeriod.getCards().size(), 4);
        assertTrue(secondPeriod.getCards().containsAll(new HashSet<>(Arrays.asList(
                FootballCard.builder().minute(62).who(Who.GUEST).team(guest).type(YELLOW).build(),
                FootballCard.builder().minute(66).who(Who.HOME).team(home).type(YELLOW).build(),
                FootballCard.builder().minute(68).who(Who.GUEST).team(guest).type(YELLOW).build(),
                FootballCard.builder().minute(91).who(Who.HOME).team(home).type(YELLOW).build()
        ))));
        assertNull(firstPeriod.getHomeCorners());
        assertNull(firstPeriod.getGuestCorners());
        assertNull(firstPeriod.getHomeHits());
        assertNull(firstPeriod.getGuestHits());
        assertNull(firstPeriod.getHomeHitsOnTarget());
        assertNull(firstPeriod.getGuestHitsOnTarget());
        assertNull(firstPeriod.getHomePossession());
        assertNull(firstPeriod.getGuestPossession());
        assertNull(firstPeriod.getHomeOffsides());
        assertNull(firstPeriod.getGuestOffsides());
        assertNull(firstPeriod.getHomeFouls());
        assertNull(firstPeriod.getGuestFouls());

         /*
          матч
        * */
        Period matchPeriod = footballMatchInfo.getMatch();

        assertEquals(matchPeriod.getHomeScore().intValue(), 2);
        assertEquals(matchPeriod.getGuestScore().intValue(), 3);
        assertEquals(matchPeriod.getTotalScore().intValue(), 5);
        assertEquals(matchPeriod.getWinner(), Winner.GUEST);
        assertEquals(matchPeriod.getPeriodStatus(), Period.PeriodStatus.MATCH);
        assertNull(matchPeriod.getGoals());
        assertNull(matchPeriod.getCards());
        assertEquals(matchPeriod.getHomeCorners().intValue(), 11);
        assertEquals(matchPeriod.getGuestCorners().intValue(), 5);
        assertEquals(matchPeriod.getHomeHits().intValue(), 15);
        assertEquals(matchPeriod.getGuestHits().intValue(), 14);
        assertEquals(matchPeriod.getHomeHitsOnTarget().intValue(), 7);
        assertEquals(matchPeriod.getGuestHitsOnTarget().intValue(), 4);
        assertEquals(matchPeriod.getHomePossession().intValue(), 61);
        assertEquals(matchPeriod.getGuestPossession().intValue(), 39);
        assertEquals(matchPeriod.getHomeOffsides().intValue(), 3);
        assertEquals(matchPeriod.getGuestOffsides().intValue(), 0);
        assertEquals(matchPeriod.getHomeFouls().intValue(), 9);
        assertEquals(matchPeriod.getGuestFouls().intValue(), 10);
    }

    @Test
    public void testGeneralMatchWithStats() {
        FootballMatch footballMatch = matchParser.parse("8O2GJGpD", FootballChampionship.LA, Season.S2016);
        footballMatch = footballMatchRepository.save(footballMatch);

        FootballTeam home = footballTeamRepository.findOneByNameAndChampionship("Реал Мадрид", FootballChampionship.LA);
        FootballTeam guest = footballTeamRepository.findOneByNameAndChampionship("Барселона", FootballChampionship.LA);

        assertEquals(footballMatch.getSeason(), Season.S2016);
        assertEquals(footballMatch.getMyscoreCode(), "8O2GJGpD");
        assertEquals(footballMatch.getChampionship(), FootballChampionship.LA);
        assertEquals(footballMatch.getHomeTeam(), home);
        assertEquals(footballMatch.getGuestTeam(), guest);
        assertEquals(footballMatch.getBookieStats().getHomeRate(), Double.valueOf(1.91));
        assertEquals(footballMatch.getBookieStats().getDrawRate(), Double.valueOf(4.2));
        assertEquals(footballMatch.getBookieStats().getGuestRate(), Double.valueOf(3.5));
        assertEquals(footballMatch.getDate(), LocalDateTime.of(2017, 4, 23, 21, 45));

        FootballMatchInfo footballMatchInfo = footballMatch.getMatchInfo();

        /*
         1 тайм 1-1, 2 yellow карточек
        * */
        Period firstPeriod = footballMatchInfo.getFirstPeriod();
        assertEquals(firstPeriod.getHomeScore().intValue(), 1);
        assertEquals(firstPeriod.getGuestScore().intValue(), 1);
        assertEquals(firstPeriod.getTotalScore().intValue(), 2);
        assertEquals(firstPeriod.getWinner(), Winner.DRAW);
        assertEquals(firstPeriod.getPeriodStatus(), Period.PeriodStatus.FIRST);
        assertEquals(firstPeriod.getGoals().size(), 2);
        assertTrue(firstPeriod.getGoals().containsAll(new HashSet<>(Arrays.asList(
                FootballGoal.builder().minute(28).whoScored(Who.HOME).team(home).build(),
                FootballGoal.builder().minute(33).whoScored(Who.GUEST).team(guest).build()
        ))));
        assertEquals(firstPeriod.getCards().size(), 2);
        assertTrue(firstPeriod.getCards().containsAll(new HashSet<>(Arrays.asList(
                FootballCard.builder().minute(12).who(Who.HOME).team(home).type(YELLOW).build(),
                FootballCard.builder().minute(39).who(Who.GUEST).team(guest).type(YELLOW).build()
        ))));
        assertEquals(firstPeriod.getHomeCorners().intValue(), 1);
        assertEquals(firstPeriod.getGuestCorners().intValue(), 1);
        assertEquals(firstPeriod.getHomeHits().intValue(), 9);
        assertEquals(firstPeriod.getGuestHits().intValue(), 7);
        assertEquals(firstPeriod.getHomeHitsOnTarget().intValue(), 6);
        assertEquals(firstPeriod.getGuestHitsOnTarget().intValue(), 1);
        assertEquals(firstPeriod.getHomePossession().intValue(), 41);
        assertEquals(firstPeriod.getGuestPossession().intValue(), 59);
        assertEquals(firstPeriod.getHomeOffsides().intValue(), 4);
        assertEquals(firstPeriod.getGuestOffsides().intValue(), 1);
        assertEquals(firstPeriod.getHomeFouls().intValue(), 5);
        assertEquals(firstPeriod.getGuestFouls().intValue(), 3);


        /*
         2 тайм 1-2, 3 желтых карточек, 1 red
        * */
        Period secondPeriod = footballMatchInfo.getSecondPeriod();

        assertEquals(secondPeriod.getHomeScore().intValue(), 1);
        assertEquals(secondPeriod.getGuestScore().intValue(), 2);
        assertEquals(secondPeriod.getTotalScore().intValue(), 3);
        assertEquals(secondPeriod.getWinner(), Winner.GUEST);
        assertEquals(secondPeriod.getPeriodStatus(), Period.PeriodStatus.SECOND);
        assertEquals(secondPeriod.getGoals().size(), 3);
        assertTrue(secondPeriod.getGoals().containsAll(new HashSet<>(Arrays.asList(
                FootballGoal.builder().minute(73).whoScored(Who.GUEST).team(guest).build(),
                FootballGoal.builder().minute(85).whoScored(Who.HOME).team(home).build(),
                FootballGoal.builder().minute(92).whoScored(Who.GUEST).team(guest).build()
        ))));
        assertEquals(secondPeriod.getCards().size(), 4);
        assertTrue(secondPeriod.getCards().containsAll(new HashSet<>(Arrays.asList(
                FootballCard.builder().minute(77).who(Who.HOME).team(home).type(YELLOW).build(),
                FootballCard.builder().minute(77).who(Who.HOME).team(home).type(RED).build(),
                FootballCard.builder().minute(81).who(Who.HOME).team(home).type(YELLOW).build(),
                FootballCard.builder().minute(93).who(Who.GUEST).team(guest).type(YELLOW).build()
        ))));
        assertEquals(secondPeriod.getHomeCorners().intValue(), 6);
        assertEquals(secondPeriod.getGuestCorners().intValue(), 3);
        assertEquals(secondPeriod.getHomeHits().intValue(), 13);
        assertEquals(secondPeriod.getGuestHits().intValue(), 9);
        assertEquals(secondPeriod.getHomeHitsOnTarget().intValue(), 8);
        assertEquals(secondPeriod.getGuestHitsOnTarget().intValue(), 8);
        assertEquals(secondPeriod.getHomePossession().intValue(), 43);
        assertEquals(secondPeriod.getGuestPossession().intValue(), 57);
        assertEquals(secondPeriod.getHomeOffsides().intValue(), 2);
        assertEquals(secondPeriod.getGuestOffsides().intValue(), 1);
        assertEquals(secondPeriod.getHomeFouls().intValue(), 8);
        assertEquals(secondPeriod.getGuestFouls().intValue(), 5);

         /*
          матч
        * */
        Period matchPeriod = footballMatchInfo.getMatch();

        assertEquals(matchPeriod.getHomeScore().intValue(), 2);
        assertEquals(matchPeriod.getGuestScore().intValue(), 3);
        assertEquals(matchPeriod.getTotalScore().intValue(), 5);
        assertEquals(matchPeriod.getWinner(), Winner.GUEST);
        assertEquals(matchPeriod.getPeriodStatus(), Period.PeriodStatus.MATCH);
        assertNull(matchPeriod.getGoals());
        assertNull(matchPeriod.getCards());
        assertEquals(matchPeriod.getHomeCorners().intValue(), 7);
        assertEquals(matchPeriod.getGuestCorners().intValue(), 4);
        assertEquals(matchPeriod.getHomeHits().intValue(), 22);
        assertEquals(matchPeriod.getGuestHits().intValue(), 16);
        assertEquals(matchPeriod.getHomeHitsOnTarget().intValue(), 14);
        assertEquals(matchPeriod.getGuestHitsOnTarget().intValue(), 9);
        assertEquals(matchPeriod.getHomePossession().intValue(), 42);
        assertEquals(matchPeriod.getGuestPossession().intValue(), 58);
        assertEquals(matchPeriod.getHomeOffsides().intValue(), 6);
        assertEquals(matchPeriod.getGuestOffsides().intValue(), 2);
        assertEquals(matchPeriod.getHomeFouls().intValue(), 13);
        assertEquals(matchPeriod.getGuestFouls().intValue(), 8);
    }
}
