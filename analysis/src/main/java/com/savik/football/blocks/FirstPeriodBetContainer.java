/*
 * Copyright (c) 2017, AT-Consulting. All Rights Reserved.
 * Use is subject to license terms.
 */

package com.savik.football.blocks;

import java.util.List;

import com.savik.football.bets.PeriodBet;
import com.savik.football.model.FootballMatch;
import com.savik.football.model.Period;

/**
 * @author Savushkin Yauheni
 * @since 19.07.2017
 */
public class FirstPeriodBetContainer extends PeriodBetContainer {

    public FirstPeriodBetContainer(List<PeriodBetContainer> childrenBetBlocks) {
        super(childrenBetBlocks);
    }

    public FirstPeriodBetContainer(PeriodBet bet) {
        super(bet);
    }

    @Override
    public Period getPeriod(FootballMatch footballMatch) {
        return footballMatch.getMatchInfo().getFirstPeriod();
    }
}
