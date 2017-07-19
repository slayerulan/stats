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
public class SecondPeriodBetContainer extends PeriodBetContainer {

    public SecondPeriodBetContainer(List<PeriodBetContainer> childrenBetBlocks) {
        super(childrenBetBlocks);
    }

    public SecondPeriodBetContainer(PeriodBet bet) {
        super(bet);
    }

    @Override
    public Period getPeriod(FootballMatch footballMatch) {
        return footballMatch.getMatchInfo().getSecondPeriod();
    }
}
