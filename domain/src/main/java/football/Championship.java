package football;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * @author Savushkin Yauheni
 * @since 10.04.2017
 */
@Entity
public class Championship {

    @NotNull
    Kind kind;

    @NotNull
    Season season;

    enum Kind {
    }

    enum Season {

    }

}
