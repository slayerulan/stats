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

    enum PeriodNumber {
        FIRST,
        SECOND
    }
}
