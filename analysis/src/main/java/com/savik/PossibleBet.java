package com.savik;

import lombok.Getter;

import java.util.List;

@Getter
public class PossibleBet<T extends Match> {

    private BetContainer<T> firstTeamContainer;

    private BetContainer<T> secondTeamContainer;

    private ContainerType type;

    public PossibleBet(BetContainer<T> firstTeamContainer, BetContainer<T> secondTeamContainer) {
        this.firstTeamContainer = firstTeamContainer;
        this.secondTeamContainer = secondTeamContainer;
    }

    public void check(List<T> firstTeamMatches, List<T> secondTeamMatches) {
        firstTeamMatches.forEach(firstTeamContainer::check);
        secondTeamMatches.forEach(secondTeamContainer::check);
    }

    public int getFirstTeamPercentage() {
        return firstTeamContainer.getPercentage();
    }

    public int getSecondTeamPercentage() {
        return secondTeamContainer.getPercentage();
    }

    public PossibleBetStatus getPossibleBetStatus() {
        Integer firstTeamContainerPercentage = firstTeamContainer.getPercentage();
        Integer secondTeamContainerPercentage = secondTeamContainer.getPercentage();
        int averagePercentage = (firstTeamContainerPercentage + secondTeamContainerPercentage) / 2;
        if (averagePercentage < 25 || averagePercentage > 70) {
            return PossibleBetStatus.GOOD;
        }
        return PossibleBetStatus.SO_SO;
    }
}
