/*
 * Copyright (c) 2017, AT-Consulting. All Rights Reserved.
 * Use is subject to license terms.
 */

package football;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * @author Savushkin Yauheni
 * @since 11.04.2017
 */
@Entity
public class Result {

    @NotNull
    Integer homeScore;

    @NotNull
    Integer guestScore;

    @NotNull
    Integer totalScore;

    @NotNull
    Winner winner;

    @NotNull
    Integer homeCorners;

    @NotNull
    Integer guestCorners;

    @NotNull
    Integer homePossession;

    @NotNull
    Integer guestPossession;

    @NotNull
    Integer homeOffsides;

    @NotNull
    Integer guestOffsides;

    @NotNull
    Integer homeFouls;

    @NotNull
    Integer guestFouls;


}
