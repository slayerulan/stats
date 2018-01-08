package com.savik.coeffs.football.corners;


import com.savik.Coeff;
import com.savik.CoeffContainer;
import com.savik.ContainerType;

import java.util.Arrays;

public class CoeffOpposingTeamCornersHandicapBlock extends CoeffContainer {
    public CoeffOpposingTeamCornersHandicapBlock() {
        super(Arrays.asList(
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.MINUS_4_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.MINUS_3_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.MINUS_2_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.MINUS_1_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.PLUS_1_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.PLUS_2_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.PLUS_3_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.PLUS_4_5
                ),
                new CoeffContainer(
                        new Coeff(),
                        ContainerType.PLUS_5_5
                )
        ), ContainerType.OPPOSING_TEAM_HANDICAP);
    }
}
