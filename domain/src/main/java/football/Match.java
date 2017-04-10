package football;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Match {

    @NotNull
    Team homeTeam;

    @NotNull
    Team guestTeam;
}
