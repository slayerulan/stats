package com.savik.hockey.specifications;

import com.savik.hockey.model.HockeyMatch;
import com.savik.hockey.model.HockeyMatch_;
import com.savik.hockey.model.HockeyTeam;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import static com.savik.specification.CommonSpecifications.anyEquals;
import static com.savik.specification.CommonSpecifications.equal;

@UtilityClass
public class HockeyMatchSpec {

    public static Specification<HockeyMatch> hasHomeTeam(HockeyTeam team) {
        return equal(HockeyMatch_.homeTeam, team);
    }

    public static Specification<HockeyMatch> hasHomeTeam(Long id) {
        return equal(HockeyMatch_.homeTeam, id);
    }

    public static Specification<HockeyMatch> hasGuestTeam(Long id) {
        return equal(HockeyMatch_.guestTeam, id);
    }

    public static Specification<HockeyMatch> hasTeam(HockeyTeam team) {
        return anyEquals(team, HockeyMatch_.homeTeam, HockeyMatch_.guestTeam);
    }

    public static Specification<HockeyMatch> hasTeam(Long id) {
        return anyEquals(id, HockeyMatch_.homeTeam, HockeyMatch_.guestTeam);
    }


}
