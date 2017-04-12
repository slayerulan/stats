package football.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import domain.Identifiable;

@Entity
public class Match extends Identifiable {

    @NotNull
    @OneToOne
    MatchInfo matchInfo;

    @NotNull
    @OneToOne
    Team homeTeam;

    @NotNull
    @OneToOne
    Team guestTeam;

    @NotNull
    Championship championship;

    @NotNull
    Season season;

    @NotNull
    LocalDate date;

    @NotNull
    String myscoreCode;
}
