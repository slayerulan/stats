package football;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * @author Savushkin Yauheni
 * @since 10.04.2017
 */
@Entity
public class MatchInfo {

    @NotNull
    Result result;

    @NotNull
    Period firstPeriod;

    @NotNull
    Period secondPeriod;

}
