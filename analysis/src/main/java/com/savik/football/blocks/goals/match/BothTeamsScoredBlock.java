package com.savik.football.blocks.goals.match;

import com.savik.football.bets.goals.PeriodBothTeamsScored;
import com.savik.football.blocks.MatchPeriodBetContainer;

/**
 * @author Savushkin Yauheni
 * @since 16.05.2017
 */
public class BothTeamsScoredBlock extends MatchPeriodBetContainer {

    public BothTeamsScoredBlock() {
        super(new PeriodBothTeamsScored());
    }

}
