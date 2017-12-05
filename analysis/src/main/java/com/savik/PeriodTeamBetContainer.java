package com.savik;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@Getter
public class PeriodTeamBetContainer<T extends Match> extends BetContainer<T> {

    @JsonIgnore
    private MatchData matchData;

    private PeriodBet forHome;

    private PeriodBet forGuest;

    @JsonIgnore
    private Function<T, Period> function;

    public PeriodTeamBetContainer(List<? extends PeriodTeamBetContainer> childrenBetBlocks, Function<T, Period> function,
                                  MatchData matchData, ContainerType containerType) {
        super(childrenBetBlocks, containerType);
        this.matchData = matchData;
        childrenBetBlocks.forEach((PeriodTeamBetContainer periodBetContainer) -> {
            periodBetContainer.function = function;
            periodBetContainer.matchData = matchData;
        });
    }

    public PeriodTeamBetContainer(PeriodTeamBetContainer childrenBetBlocks, Function<T, Period> function,
                                  MatchData matchData, ContainerType containerType) {
        this(Arrays.asList(childrenBetBlocks), function, matchData, containerType);
    }

    public PeriodTeamBetContainer(PeriodBet forHome, PeriodBet forGuest, ContainerType type) {
        super(type);
        this.forHome = forHome;
        this.forGuest = forGuest;
    }

    @Override
    protected boolean canAnalyze(T match) {
        Who teamStatus = match.getTeamStatus(matchData.getForTeam());
        if (teamStatus == Who.HOME) {
            return forHome.canAnalyze(function.apply(match));
        } else if (teamStatus == Who.GUEST) {
            return forGuest.canAnalyze(function.apply(match));
        }
        return false;
    }

    @Override
    protected boolean checkMatch(T match) {
        Who teamStatus = match.getTeamStatus(matchData.getForTeam());
        Period period = function.apply(match);
        if (teamStatus == Who.HOME) {
            return forHome.check(period);
        } else if (teamStatus == Who.GUEST) {
            return forGuest.check(period);
        }
        throw new IllegalArgumentException("team status isn't correct");
    }
}
