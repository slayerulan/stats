package com.savik.blocks.football.match.corners.match;


import com.savik.ContainerType;
import com.savik.MatchData;
import com.savik.PossibleBetContainer;
import com.savik.blocks.football.match.corners.OpposingTeamCornersHandicapPossibleBetBlock;
import com.savik.blocks.football.match.corners.OpposingTeamCornersNotLoosePossibleBetBlock;
import com.savik.blocks.football.match.corners.TeamCornersHandicapPossibleBetBlock;
import com.savik.blocks.football.match.corners.TeamCornersNotLoosePossibleBetBlock;
import com.savik.football.model.FootballMatch;

import java.util.Arrays;

public class PossibleBetsMatchCornersBlock extends PossibleBetContainer<FootballMatch> {
    public PossibleBetsMatchCornersBlock(MatchData homeMatchData, MatchData guestMatchData) {
        super(Arrays.asList(
                new CornersTotalOverPossibleBetBlock(),
                new CornersTotalUnderPossibleBetBlock(),
                new TeamCornersTotalOverPossibleBetBlock(homeMatchData, guestMatchData),
                new OpposingTeamCornersTotalOverPossibleBetBlock(homeMatchData, guestMatchData),
                new TeamCornersNotLoosePossibleBetBlock(homeMatchData, guestMatchData),
                new OpposingTeamCornersNotLoosePossibleBetBlock(homeMatchData, guestMatchData),
                new TeamCornersHandicapPossibleBetBlock(homeMatchData, guestMatchData, FootballMatch.MATCH),
                new OpposingTeamCornersHandicapPossibleBetBlock(homeMatchData, guestMatchData, FootballMatch.MATCH)
        ), ContainerType.MATCH);
    }
}
