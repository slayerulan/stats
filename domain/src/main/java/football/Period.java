package football;

import java.util.Set;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * @author Savushkin Yauheni
 * @since 10.4.17
 */
@Entity
public class Period {

    @NotNull
    PeriodNumber periodNumber;

    @NotNull
    Integer homeScore;

    @NotNull
    Integer guestScore;

    @NotNull
    Integer totalScore;

    @NotNull
    Winner winner;

    @NotNull
    Set<Goal> goals;

    @NotNull
    Set<Card> cards;

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

    enum PeriodNumber {
        FIRST,
        SECOND
    }
}
