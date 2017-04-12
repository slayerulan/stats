package football;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Match {

    @NotNull
    MatchInfo matchInfo;

    @NotNull
    Team homeTeam;

    @NotNull
    Team guestTeam;

    @NotNull
    Championship championship;

    @NotNull
    Season season;

    @NotNull
    LocalDate date;
}
