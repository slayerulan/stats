package com.savik.parser.hockey;

import com.savik.Application;
import com.savik.Season;
import com.savik.Who;
import com.savik.Winner;
import com.savik.hockey.model.*;
import com.savik.hockey.repository.HockeyMatchRepository;
import com.savik.hockey.repository.HockeyTeamRepository;
import com.savik.parser.hockey.matches.HockeySingleMatchParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Savushkin Yauheni
 * @since 05.05.2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@ActiveProfiles("test")
public class HockeyMatchParserTest {

    @Autowired
    HockeySingleMatchParser matchParser;

    @Autowired
    HockeyTeamRepository hockeyTeamRepository;

    @Autowired
    HockeyMatchRepository hockeyMatchRepository;

    @Test
    public void testMatchWithOvertimeAndBulletsAndStats() {
        HockeyMatch match = matchParser.parse("KvlMqOL3", HockeyChampionship.NHL, Season.S2017);
        hockeyMatchRepository.save(match);
        match = hockeyMatchRepository.findByMyscoreCode("KvlMqOL3");

        HockeyTeam home = hockeyTeamRepository.findOneByNameAndChampionship("Рейнджерс", HockeyChampionship.NHL);
        HockeyTeam guest = hockeyTeamRepository.findOneByNameAndChampionship("Ванкувер", HockeyChampionship.NHL);

        assertEquals(Season.S2017, match.getSeason());
        assertEquals("KvlMqOL3", match.getMyscoreCode());
        assertEquals(HockeyChampionship.NHL, match.getChampionship());
        assertEquals(match.getHomeTeam(), home);
        assertEquals(match.getGuestTeam(), guest);
        assertEquals(Double.valueOf(2.05), match.getBookieStats().getHomeRate());
        assertEquals(Double.valueOf(4.00), match.getBookieStats().getDrawRate());
        assertEquals(Double.valueOf(3.1), match.getBookieStats().getGuestRate());
        assertEquals(LocalDateTime.of(2017, 11, 26, 22, 0), match.getDate());


        HockeyMatchInfo hockeyMatchInfo = match.getMatchInfo();

        /*
         1 период 0-1
        * */
        HockeyPeriod firstPeriod = hockeyMatchInfo.getFirstPeriod();
        assertEquals(0, firstPeriod.getHomeScore().intValue());
        assertEquals(1, firstPeriod.getGuestScore().intValue());
        assertEquals(1, firstPeriod.getTotalScore().intValue());
        assertEquals(Winner.GUEST, firstPeriod.getWinner());
        assertEquals(HockeyPeriod.PeriodStatus.FIRST, firstPeriod.getPeriodStatus());
        assertEquals(1, firstPeriod.getGoals().size());
        assertTrue(firstPeriod.getGoals().containsAll(new HashSet<>(Collections.singletonList(
                HockeyGoal.builder().minute(7).whoScored(Who.GUEST).seconds(54).team(guest).build()
        ))));
        assertEquals(1, firstPeriod.getHomeMinorPenaltiesAmount().intValue());
        assertEquals(1, firstPeriod.getGuestMinorPenaltiesAmount().intValue());
        assertEquals(4, firstPeriod.getHomeShotsOnTarget().intValue());
        assertEquals(11, firstPeriod.getGuestShotsOnTarget().intValue());
        assertEquals(2, firstPeriod.getHomePenaltiesTime().intValue());
        assertEquals(2, firstPeriod.getGuestPenaltiesTime().intValue());
        assertEquals(0, firstPeriod.getHomeShotHandedGoals().intValue());
        assertEquals(0, firstPeriod.getGuestShotHandedGoals().intValue());
        assertEquals(0, firstPeriod.getHomePowerplayGoals().intValue());
        assertEquals(0, firstPeriod.getGuestPowerplayGoals().intValue());



        /*
         2 период 1-1
        * */
        HockeyPeriod secondPeriod = hockeyMatchInfo.getSecondPeriod();

        assertEquals(1, secondPeriod.getHomeScore().intValue());
        assertEquals(1, secondPeriod.getGuestScore().intValue());
        assertEquals(2, secondPeriod.getTotalScore().intValue());
        assertEquals(Winner.DRAW, secondPeriod.getWinner());
        assertEquals(HockeyPeriod.PeriodStatus.SECOND, secondPeriod.getPeriodStatus());
        assertEquals(2, secondPeriod.getGoals().size());
        assertTrue(secondPeriod.getGoals().containsAll(new HashSet<>(Arrays.asList(
                HockeyGoal.builder().minute(27).whoScored(Who.GUEST).seconds(21).team(guest).build(),
                HockeyGoal.builder().minute(37).whoScored(Who.HOME).seconds(40).team(home).build()
        ))));
        assertEquals(0, secondPeriod.getHomeMinorPenaltiesAmount().intValue());
        assertEquals(1, secondPeriod.getGuestMinorPenaltiesAmount().intValue());
        assertEquals(7, secondPeriod.getHomeShotsOnTarget().intValue());
        assertEquals(7, secondPeriod.getGuestShotsOnTarget().intValue());
        assertEquals(0, secondPeriod.getHomePenaltiesTime().intValue());
        assertEquals(2, secondPeriod.getGuestPenaltiesTime().intValue());
        assertEquals(0, secondPeriod.getHomeShotHandedGoals().intValue());
        assertEquals(0, secondPeriod.getGuestShotHandedGoals().intValue());
        assertEquals(0, secondPeriod.getHomePowerplayGoals().intValue());
        assertEquals(0, secondPeriod.getGuestPowerplayGoals().intValue());


        /*
         3 период 2-1
        * */
        HockeyPeriod thirdPeriod = hockeyMatchInfo.getThirdPeriod();

        assertEquals(2, thirdPeriod.getHomeScore().intValue());
        assertEquals(1, thirdPeriod.getGuestScore().intValue());
        assertEquals(3, thirdPeriod.getTotalScore().intValue());
        assertEquals(Winner.HOME, thirdPeriod.getWinner());
        assertEquals(HockeyPeriod.PeriodStatus.THIRD, thirdPeriod.getPeriodStatus());
        assertEquals(3, thirdPeriod.getGoals().size());
        assertTrue(thirdPeriod.getGoals().containsAll(new HashSet<>(Arrays.asList(
                HockeyGoal.builder().minute(40).whoScored(Who.HOME).seconds(19).team(home).build(),
                HockeyGoal.builder().minute(41).whoScored(Who.GUEST).seconds(0).team(guest).build(),
                HockeyGoal.builder().minute(45).whoScored(Who.HOME).seconds(5).team(home).build()
        ))));
        assertEquals(0, thirdPeriod.getHomeMinorPenaltiesAmount().intValue());
        assertEquals(0, thirdPeriod.getGuestMinorPenaltiesAmount().intValue());
        assertEquals(9, thirdPeriod.getHomeShotsOnTarget().intValue());
        assertEquals(11, thirdPeriod.getGuestShotsOnTarget().intValue());
        assertEquals(0, thirdPeriod.getHomePenaltiesTime().intValue());
        assertEquals(0, thirdPeriod.getGuestPenaltiesTime().intValue());
        assertEquals(0, thirdPeriod.getHomeShotHandedGoals().intValue());
        assertEquals(0, thirdPeriod.getGuestShotHandedGoals().intValue());
        assertEquals(0, thirdPeriod.getHomePowerplayGoals().intValue());
        assertEquals(0, thirdPeriod.getGuestPowerplayGoals().intValue());

                /*
         Овертайм 0-0
        * */
        HockeyPeriod overtime = hockeyMatchInfo.getOvertime();

        assertEquals(0, overtime.getHomeScore().intValue());
        assertEquals(0, overtime.getGuestScore().intValue());
        assertEquals(0, overtime.getTotalScore().intValue());
        assertEquals(Winner.DRAW, overtime.getWinner());
        assertEquals(HockeyPeriod.PeriodStatus.OVERTIME, overtime.getPeriodStatus());
        assertEquals(0, overtime.getGoals().size());
        assertEquals(0, overtime.getHomeMinorPenaltiesAmount().intValue());
        assertEquals(0, overtime.getGuestMinorPenaltiesAmount().intValue());
        assertEquals(0, overtime.getHomeShotsOnTarget().intValue());
        assertEquals(3, overtime.getGuestShotsOnTarget().intValue());
        assertEquals(0, overtime.getHomePenaltiesTime().intValue());
        assertEquals(0, overtime.getGuestPenaltiesTime().intValue());
        assertEquals(0, overtime.getHomeShotHandedGoals().intValue());
        assertEquals(0, overtime.getGuestShotHandedGoals().intValue());
        assertEquals(0, overtime.getHomePowerplayGoals().intValue());
        assertEquals(0, overtime.getGuestPowerplayGoals().intValue());


         /*
          матч
        * */
        HockeyPeriod matchPeriod = hockeyMatchInfo.getMatch();

        assertEquals(3, matchPeriod.getHomeScore().intValue());
        assertEquals(3, matchPeriod.getGuestScore().intValue());
        assertEquals(6, matchPeriod.getTotalScore().intValue());
        assertEquals(Winner.DRAW, matchPeriod.getWinner());
        assertEquals(HockeyPeriod.PeriodStatus.MATCH, matchPeriod.getPeriodStatus());
        assertTrue(matchPeriod.getGoals().containsAll(new HashSet<>(Arrays.asList(
                HockeyGoal.builder().minute(7).whoScored(Who.GUEST).seconds(54).team(guest).build(),
                HockeyGoal.builder().minute(27).whoScored(Who.GUEST).seconds(21).team(guest).build(),
                HockeyGoal.builder().minute(37).whoScored(Who.HOME).seconds(40).team(home).build(),
                HockeyGoal.builder().minute(40).whoScored(Who.HOME).seconds(19).team(home).build(),
                HockeyGoal.builder().minute(41).whoScored(Who.GUEST).seconds(0).team(guest).build(),
                HockeyGoal.builder().minute(45).whoScored(Who.HOME).seconds(5).team(home).build()
        ))));
        assertEquals(1, matchPeriod.getHomeMinorPenaltiesAmount().intValue());
        assertEquals(2, matchPeriod.getGuestMinorPenaltiesAmount().intValue());
        assertEquals(20, matchPeriod.getHomeShotsOnTarget().intValue());
        assertEquals(32, matchPeriod.getGuestShotsOnTarget().intValue());
        assertEquals(2, matchPeriod.getHomePenaltiesTime().intValue());
        assertEquals(4, matchPeriod.getGuestPenaltiesTime().intValue());
        assertEquals(0, matchPeriod.getHomeShotHandedGoals().intValue());
        assertEquals(0, matchPeriod.getGuestShotHandedGoals().intValue());
        assertEquals(0, matchPeriod.getHomePowerplayGoals().intValue());
        assertEquals(0, matchPeriod.getGuestPowerplayGoals().intValue());

    }


    @Test
    public void testMatchWithGoalsOnSameMinute() {
        HockeyMatch match = matchParser.parse("6gw94qut", HockeyChampionship.NHL, Season.S2017);
        hockeyMatchRepository.save(match);
        match = hockeyMatchRepository.findByMyscoreCode("6gw94qut");

        HockeyTeam home = hockeyTeamRepository.findOneByNameAndChampionship("Вегас", HockeyChampionship.NHL);
        HockeyTeam guest = hockeyTeamRepository.findOneByNameAndChampionship("Даллас", HockeyChampionship.NHL);

        assertEquals(Season.S2017, match.getSeason());
        assertEquals("6gw94qut", match.getMyscoreCode());
        assertEquals(HockeyChampionship.NHL, match.getChampionship());
        assertEquals(match.getHomeTeam(), home);
        assertEquals(match.getGuestTeam(), guest);
        assertEquals(Double.valueOf(2.40), match.getBookieStats().getHomeRate());
        assertEquals(Double.valueOf(4.00), match.getBookieStats().getDrawRate());
        assertEquals(Double.valueOf(2.55), match.getBookieStats().getGuestRate());
        assertEquals(LocalDateTime.of(2017, 11, 29, 6, 0), match.getDate());


        HockeyMatchInfo hockeyMatchInfo = match.getMatchInfo();

        /*
         1 период 0-1
        * */
        HockeyPeriod firstPeriod = hockeyMatchInfo.getFirstPeriod();
        assertEquals(0, firstPeriod.getHomeScore().intValue());
        assertEquals(0, firstPeriod.getGuestScore().intValue());
        assertEquals(0, firstPeriod.getTotalScore().intValue());
        assertEquals(Winner.DRAW, firstPeriod.getWinner());
        assertEquals(HockeyPeriod.PeriodStatus.FIRST, firstPeriod.getPeriodStatus());
        assertEquals(0, firstPeriod.getGoals().size());
        assertEquals(1, firstPeriod.getHomeMinorPenaltiesAmount().intValue());
        assertEquals(1, firstPeriod.getGuestMinorPenaltiesAmount().intValue());
        assertEquals(15, firstPeriod.getHomeShotsOnTarget().intValue());
        assertEquals(10, firstPeriod.getGuestShotsOnTarget().intValue());
        assertEquals(2, firstPeriod.getHomePenaltiesTime().intValue());
        assertEquals(2, firstPeriod.getGuestPenaltiesTime().intValue());
        assertEquals(0, firstPeriod.getHomeShotHandedGoals().intValue());
        assertEquals(0, firstPeriod.getGuestShotHandedGoals().intValue());
        assertEquals(0, firstPeriod.getHomePowerplayGoals().intValue());
        assertEquals(0, firstPeriod.getGuestPowerplayGoals().intValue());



        /*
         2 период 1-1
        * */
        HockeyPeriod secondPeriod = hockeyMatchInfo.getSecondPeriod();

        assertEquals(0, secondPeriod.getHomeScore().intValue());
        assertEquals(3, secondPeriod.getGuestScore().intValue());
        assertEquals(3, secondPeriod.getTotalScore().intValue());
        assertEquals(Winner.GUEST, secondPeriod.getWinner());
        assertEquals(HockeyPeriod.PeriodStatus.SECOND, secondPeriod.getPeriodStatus());
        assertEquals(3, secondPeriod.getGoals().size());
        assertTrue(secondPeriod.getGoals().containsAll(new HashSet<>(Arrays.asList(
                HockeyGoal.builder().minute(32).whoScored(Who.GUEST).seconds(55).team(guest).build(),
                HockeyGoal.builder().minute(39).whoScored(Who.GUEST).seconds(33).team(guest).build(),
                HockeyGoal.builder().minute(39).whoScored(Who.GUEST).seconds(41).team(guest).build()
        ))));
        assertEquals(2, secondPeriod.getHomeMinorPenaltiesAmount().intValue());
        assertEquals(1, secondPeriod.getGuestMinorPenaltiesAmount().intValue());
        assertEquals(8, secondPeriod.getHomeShotsOnTarget().intValue());
        assertEquals(11, secondPeriod.getGuestShotsOnTarget().intValue());
        assertEquals(4, secondPeriod.getHomePenaltiesTime().intValue());
        assertEquals(2, secondPeriod.getGuestPenaltiesTime().intValue());
        assertEquals(0, secondPeriod.getHomeShotHandedGoals().intValue());
        assertEquals(0, secondPeriod.getGuestShotHandedGoals().intValue());
        assertEquals(0, secondPeriod.getHomePowerplayGoals().intValue());
        assertEquals(0, secondPeriod.getGuestPowerplayGoals().intValue());


        /*
         3 период 0-0
        * */
        HockeyPeriod thirdPeriod = hockeyMatchInfo.getThirdPeriod();

        assertEquals(0, thirdPeriod.getHomeScore().intValue());
        assertEquals(0, thirdPeriod.getGuestScore().intValue());
        assertEquals(0, thirdPeriod.getTotalScore().intValue());
        assertEquals(Winner.DRAW, thirdPeriod.getWinner());
        assertEquals(HockeyPeriod.PeriodStatus.THIRD, thirdPeriod.getPeriodStatus());
        assertEquals(0, thirdPeriod.getGoals().size());
        assertEquals(1, thirdPeriod.getHomeMinorPenaltiesAmount().intValue());
        assertEquals(1, thirdPeriod.getGuestMinorPenaltiesAmount().intValue());
        assertEquals(11, thirdPeriod.getHomeShotsOnTarget().intValue());
        assertEquals(9, thirdPeriod.getGuestShotsOnTarget().intValue());
        assertEquals(2, thirdPeriod.getHomePenaltiesTime().intValue());
        assertEquals(2, thirdPeriod.getGuestPenaltiesTime().intValue());
        assertEquals(0, thirdPeriod.getHomeShotHandedGoals().intValue());
        assertEquals(0, thirdPeriod.getGuestShotHandedGoals().intValue());
        assertEquals(0, thirdPeriod.getHomePowerplayGoals().intValue());
        assertEquals(0, thirdPeriod.getGuestPowerplayGoals().intValue());


         /*
          матч
        * */
        HockeyPeriod matchPeriod = hockeyMatchInfo.getMatch();

        assertEquals(0, matchPeriod.getHomeScore().intValue());
        assertEquals(3, matchPeriod.getGuestScore().intValue());
        assertEquals(3, matchPeriod.getTotalScore().intValue());
        assertEquals(Winner.GUEST, matchPeriod.getWinner());
        assertEquals(HockeyPeriod.PeriodStatus.MATCH, matchPeriod.getPeriodStatus());
        assertEquals(4, matchPeriod.getHomeMinorPenaltiesAmount().intValue());
        assertEquals(3, matchPeriod.getGuestMinorPenaltiesAmount().intValue());
        assertTrue(matchPeriod.getGoals().containsAll(new HashSet<>(Arrays.asList(
                HockeyGoal.builder().minute(32).whoScored(Who.GUEST).seconds(55).team(guest).build(),
                HockeyGoal.builder().minute(39).whoScored(Who.GUEST).seconds(33).team(guest).build(),
                HockeyGoal.builder().minute(39).whoScored(Who.GUEST).seconds(41).team(guest).build()
        ))));
        assertEquals(34, matchPeriod.getHomeShotsOnTarget().intValue());
        assertEquals(30, matchPeriod.getGuestShotsOnTarget().intValue());
        assertEquals(8, matchPeriod.getHomePenaltiesTime().intValue());
        assertEquals(6, matchPeriod.getGuestPenaltiesTime().intValue());
        assertEquals(0, matchPeriod.getHomeShotHandedGoals().intValue());
        assertEquals(0, matchPeriod.getGuestShotHandedGoals().intValue());
        assertEquals(0, matchPeriod.getHomePowerplayGoals().intValue());
        assertEquals(0, matchPeriod.getGuestPowerplayGoals().intValue());

    }




    @Test
    public void testMinorPenaltiesParsing() {
        HockeyMatch match = matchParser.parse("lfdn7IJR", HockeyChampionship.NHL, Season.S2017);
        hockeyMatchRepository.save(match);
        match = hockeyMatchRepository.findByMyscoreCode("lfdn7IJR");

        HockeyTeam home = hockeyTeamRepository.findOneByNameAndChampionship("Вегас", HockeyChampionship.NHL);
        HockeyTeam guest = hockeyTeamRepository.findOneByNameAndChampionship("Анахайм", HockeyChampionship.NHL);



        HockeyMatchInfo hockeyMatchInfo = match.getMatchInfo();

        /*
         1 период 2-0
        * */
        HockeyPeriod firstPeriod = hockeyMatchInfo.getFirstPeriod();
        assertEquals(2, firstPeriod.getHomeScore().intValue());
        assertEquals(0, firstPeriod.getGuestScore().intValue());
        assertEquals(2, firstPeriod.getTotalScore().intValue());
        assertEquals(Winner.HOME, firstPeriod.getWinner());
        assertEquals(HockeyPeriod.PeriodStatus.FIRST, firstPeriod.getPeriodStatus());
        assertEquals(2, firstPeriod.getGoals().size());
        assertTrue(firstPeriod.getGoals().containsAll(new HashSet<>(Arrays.asList(
                HockeyGoal.builder().minute(18).whoScored(Who.HOME).seconds(34).team(home).build(),
                HockeyGoal.builder().minute(18).whoScored(Who.HOME).seconds(50).team(home).build()
        ))));
        assertEquals(0, firstPeriod.getHomeMinorPenaltiesAmount().intValue());
        assertEquals(0, firstPeriod.getGuestMinorPenaltiesAmount().intValue());
        assertEquals(19, firstPeriod.getHomeShotsOnTarget().intValue());
        assertEquals(7, firstPeriod.getGuestShotsOnTarget().intValue());
        assertEquals(0, firstPeriod.getHomePenaltiesTime().intValue());
        assertEquals(4, firstPeriod.getGuestPenaltiesTime().intValue());
        assertEquals(0, firstPeriod.getHomeShotHandedGoals().intValue());
        assertEquals(0, firstPeriod.getGuestShotHandedGoals().intValue());
        assertEquals(0, firstPeriod.getHomePowerplayGoals().intValue());
        assertEquals(0, firstPeriod.getGuestPowerplayGoals().intValue());



        /*
         2 период 0-3
        * */
        HockeyPeriod secondPeriod = hockeyMatchInfo.getSecondPeriod();

        assertEquals(0, secondPeriod.getHomeScore().intValue());
        assertEquals(3, secondPeriod.getGuestScore().intValue());
        assertEquals(3, secondPeriod.getTotalScore().intValue());
        assertEquals(Winner.GUEST, secondPeriod.getWinner());
        assertEquals(HockeyPeriod.PeriodStatus.SECOND, secondPeriod.getPeriodStatus());
        assertEquals(3, secondPeriod.getGoals().size());
        assertTrue(secondPeriod.getGoals().containsAll(new HashSet<>(Arrays.asList(
                HockeyGoal.builder().minute(21).whoScored(Who.GUEST).seconds(3).team(guest).build(),
                HockeyGoal.builder().minute(25).whoScored(Who.GUEST).seconds(2).team(guest).build(),
                HockeyGoal.builder().minute(36).whoScored(Who.GUEST).seconds(14).team(guest).build()
        ))));
        assertEquals(0, secondPeriod.getHomeMinorPenaltiesAmount().intValue());
        assertEquals(0, secondPeriod.getGuestMinorPenaltiesAmount().intValue());
        assertEquals(5, secondPeriod.getHomeShotsOnTarget().intValue());
        assertEquals(8, secondPeriod.getGuestShotsOnTarget().intValue());
        assertEquals(4, secondPeriod.getHomePenaltiesTime().intValue());
        assertEquals(0, secondPeriod.getGuestPenaltiesTime().intValue());
        assertEquals(0, secondPeriod.getHomeShotHandedGoals().intValue());
        assertEquals(0, secondPeriod.getGuestShotHandedGoals().intValue());
        assertEquals(0, secondPeriod.getHomePowerplayGoals().intValue());
        assertEquals(1, secondPeriod.getGuestPowerplayGoals().intValue());


        /*
         3 период 1-0
        * */
        HockeyPeriod thirdPeriod = hockeyMatchInfo.getThirdPeriod();

        assertEquals(1, thirdPeriod.getHomeScore().intValue());
        assertEquals(0, thirdPeriod.getGuestScore().intValue());
        assertEquals(1, thirdPeriod.getTotalScore().intValue());
        assertEquals(Winner.HOME, thirdPeriod.getWinner());
        assertEquals(HockeyPeriod.PeriodStatus.THIRD, thirdPeriod.getPeriodStatus());
        assertEquals(1, thirdPeriod.getGoals().size());
        assertTrue(thirdPeriod.getGoals().containsAll(new HashSet<>(Collections.singletonList(
                HockeyGoal.builder().minute(55).whoScored(Who.HOME).seconds(38).team(home).build()
        ))));
        assertEquals(0, thirdPeriod.getHomeMinorPenaltiesAmount().intValue());
        assertEquals(1, thirdPeriod.getGuestMinorPenaltiesAmount().intValue());
        assertEquals(12, thirdPeriod.getHomeShotsOnTarget().intValue());
        assertEquals(10, thirdPeriod.getGuestShotsOnTarget().intValue());
        assertEquals(0, thirdPeriod.getHomePenaltiesTime().intValue());
        assertEquals(2, thirdPeriod.getGuestPenaltiesTime().intValue());
        assertEquals(0, thirdPeriod.getHomeShotHandedGoals().intValue());
        assertEquals(0, thirdPeriod.getGuestShotHandedGoals().intValue());
        assertEquals(0, thirdPeriod.getHomePowerplayGoals().intValue());
        assertEquals(0, thirdPeriod.getGuestPowerplayGoals().intValue());


        /*
         Овертайм 0-0
        * */
        HockeyPeriod overtime = hockeyMatchInfo.getOvertime();

        assertEquals(0, overtime.getHomeScore().intValue());
        assertEquals(0, overtime.getGuestScore().intValue());
        assertEquals(0, overtime.getTotalScore().intValue());
        assertEquals(Winner.DRAW, overtime.getWinner());
        assertEquals(HockeyPeriod.PeriodStatus.OVERTIME, overtime.getPeriodStatus());
        assertEquals(0, overtime.getGoals().size());
        assertEquals(1, overtime.getHomeMinorPenaltiesAmount().intValue());
        assertEquals(2, overtime.getGuestMinorPenaltiesAmount().intValue());
        assertEquals(7, overtime.getHomeShotsOnTarget().intValue());
        assertEquals(4, overtime.getGuestShotsOnTarget().intValue());
        assertEquals(2, overtime.getHomePenaltiesTime().intValue());
        assertEquals(4, overtime.getGuestPenaltiesTime().intValue());
        assertEquals(0, overtime.getHomeShotHandedGoals().intValue());
        assertEquals(0, overtime.getGuestShotHandedGoals().intValue());
        assertEquals(0, overtime.getHomePowerplayGoals().intValue());
        assertEquals(0, overtime.getGuestPowerplayGoals().intValue());

         /*
          матч
        * */
        HockeyPeriod matchPeriod = hockeyMatchInfo.getMatch();

        assertEquals(3, matchPeriod.getHomeScore().intValue());
        assertEquals(3, matchPeriod.getGuestScore().intValue());
        assertEquals(6, matchPeriod.getTotalScore().intValue());
        assertEquals(Winner.DRAW, matchPeriod.getWinner());
        assertEquals(HockeyPeriod.PeriodStatus.MATCH, matchPeriod.getPeriodStatus());
        assertEquals(1, matchPeriod.getHomeMinorPenaltiesAmount().intValue());
        assertEquals(3, matchPeriod.getGuestMinorPenaltiesAmount().intValue());
        assertTrue(matchPeriod.getGoals().containsAll(new HashSet<>(Arrays.asList(
                HockeyGoal.builder().minute(18).whoScored(Who.HOME).seconds(34).team(home).build(),
                HockeyGoal.builder().minute(18).whoScored(Who.HOME).seconds(50).team(home).build(),
                HockeyGoal.builder().minute(21).whoScored(Who.GUEST).seconds(3).team(guest).build(),
                HockeyGoal.builder().minute(25).whoScored(Who.GUEST).seconds(2).team(guest).build(),
                HockeyGoal.builder().minute(36).whoScored(Who.GUEST).seconds(14).team(guest).build(),
                HockeyGoal.builder().minute(55).whoScored(Who.HOME).seconds(38).team(home).build()
        ))));
        assertEquals(43, matchPeriod.getHomeShotsOnTarget().intValue());
        assertEquals(29, matchPeriod.getGuestShotsOnTarget().intValue());
        assertEquals(6, matchPeriod.getHomePenaltiesTime().intValue());
        assertEquals(10, matchPeriod.getGuestPenaltiesTime().intValue());
        assertEquals(0, matchPeriod.getHomeShotHandedGoals().intValue());
        assertEquals(0, matchPeriod.getGuestShotHandedGoals().intValue());
        assertEquals(0, matchPeriod.getHomePowerplayGoals().intValue());
        assertEquals(1, matchPeriod.getGuestPowerplayGoals().intValue());




    }


}
