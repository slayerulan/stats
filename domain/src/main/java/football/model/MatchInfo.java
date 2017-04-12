package football.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import domain.Identifiable;

/**
 * @author Savushkin Yauheni
 * @since 10.04.2017
 */
@Entity
public class MatchInfo extends Identifiable {

    @NotNull
    @OneToOne
    Period match;

    @NotNull
    @OneToOne
    Period firstPeriod;

    @NotNull
    @OneToOne
    Period secondPeriod;

}
