package football;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * @author Savushkin Yauheni
 * @since 10.04.2017
 */
@Entity
public class Card {

    @NotNull
    Integer minute;

    @NotNull
    Team team;

    @NotNull
    Who who;

    @NotNull
    Type type;

    enum Type {
        YELLOW,
        RED
    }

}
