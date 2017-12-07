package com.savik.blocks.general.result;

import com.savik.*;
import com.savik.bets.general.other.PeriodGuestNotLooseAndTotalOver;
import com.savik.bets.general.other.PeriodHomeNotLooseAndTotalOver;
import com.savik.bets.general.result.PeriodGuestNotLoose;
import com.savik.bets.general.result.PeriodHomeNotLoose;
import com.savik.bets.general.total.over.PeriodOver;
import com.savik.hockey.model.HockeyPeriod;

import java.util.function.Function;


public class PeriodTeamNotLooseAndTotalOverBlock<T extends Match> extends PeriodTeamBetContainer<T> {

    public PeriodTeamNotLooseAndTotalOverBlock(double total, ContainerType type) {
        super(
                new PeriodHomeNotLooseAndTotalOver(total),
                new PeriodGuestNotLooseAndTotalOver(total),
                type
        );
    }


}
