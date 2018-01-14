package com.savik.football.specifications;

import com.savik.football.model.FootballMatch;
import com.savik.football.model.FootballMatch_;
import com.savik.football.model.FootballTeam;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import static com.savik.specification.CommonSpecifications.anyEquals;
import static com.savik.specification.CommonSpecifications.equal;

@UtilityClass
public class FootballMatchSpec {

    public static Specification<FootballMatch> hasHomeTeam(FootballTeam team) {
        return equal(FootballMatch_.homeTeam, team);
    }

    public static Specification<FootballMatch> hasHomeTeam(Long id) {
        return equal(FootballMatch_.homeTeam, id);
    }

    public static Specification<FootballMatch> hasGuestTeam(Long id) {
        return equal(FootballMatch_.guestTeam, id);
    }

    public static Specification<FootballMatch> hasTeam(FootballTeam team) {
        return anyEquals(team, FootballMatch_.homeTeam, FootballMatch_.guestTeam);
    }

    public static Specification<FootballMatch> hasTeam(Long id) {
        return anyEquals(id, FootballMatch_.homeTeam, FootballMatch_.guestTeam);
    }

    public static Specification<FootballMatch> hasReferee(Long id) {
        return equal(FootballMatch_.referee, id);
    }


}
