package football.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import domain.Identifiable;

/**
 * @author Savushkin Yauheni
 * @since 10.04.2017
 */
@Entity
public class Card extends Identifiable {

    @NotNull
    Integer minute;

    @NotNull
    @OneToOne
    Team team;

    @NotNull
    @Enumerated(EnumType.STRING)
    Who who;

    @NotNull
    @Enumerated(EnumType.STRING)
    Type type;

    enum Type {
        YELLOW,
        RED,
        YELLOW_RED
    }

}
