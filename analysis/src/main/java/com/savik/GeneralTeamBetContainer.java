package com.savik;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class GeneralTeamBetContainer<T extends Match> extends BetContainer<T> {

    @JsonIgnore
    private MatchData matchData;

    private GeneralBet forHome;

    private GeneralBet forGuest;

    public GeneralTeamBetContainer(List<? extends GeneralTeamBetContainer> childrenBetBlocks,
                                   MatchData matchData, ContainerType containerType) {
        super(childrenBetBlocks, containerType);
        this.matchData = matchData;
        childrenBetBlocks.forEach((GeneralTeamBetContainer periodBetContainer) -> {
            periodBetContainer.matchData = matchData;
        });
    }

    public GeneralTeamBetContainer(GeneralTeamBetContainer childrenBetBlocks,
                                   MatchData matchData, ContainerType containerType) {
        this(Arrays.asList(childrenBetBlocks), matchData, containerType);
    }

    public GeneralTeamBetContainer(GeneralBet forHome, GeneralBet forGuest, ContainerType type, MatchData matchData) {
        super(type);
        this.forHome = forHome;
        this.forGuest = forGuest;
        this.matchData = matchData;
    }

    public GeneralTeamBetContainer(GeneralBet forHome, GeneralBet forGuest, MatchData matchData) {
        this(forHome, forGuest, null, matchData);
    }

    public GeneralTeamBetContainer(GeneralBet forHome, GeneralBet forGuest, ContainerType type) {
        this(forHome, forGuest, type, null);
    }

    @Override
    protected boolean canAnalyze(T match) {
        Who teamStatus = match.getTeamStatus(matchData.getForTeam());
        if (teamStatus == Who.HOME) {
            return forHome.canAnalyze(match);
        } else if (teamStatus == Who.GUEST) {
            return forGuest.canAnalyze(match);
        }
        return false;
    }

    @Override
    protected boolean checkMatch(T match) {
        Who teamStatus = match.getTeamStatus(matchData.getForTeam());
        if (teamStatus == Who.HOME) {
            return forHome.check(match);
        } else if (teamStatus == Who.GUEST) {
            return forGuest.check(match);
        }
        throw new IllegalArgumentException("team status isn't correct");
    }
}
