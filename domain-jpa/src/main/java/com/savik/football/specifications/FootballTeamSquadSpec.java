package com.savik.football.specifications;

import com.savik.football.model.FootballTeam;
import com.savik.football.model.FootballTeamSquad;
import com.savik.football.model.FootballTeamSquad_;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import static com.savik.specification.CommonSpecifications.equal;

@UtilityClass
public class FootballTeamSquadSpec {

    public static Specification<FootballTeamSquad> hasTeam(FootballTeam team) {
        return equal(FootballTeamSquad_.team, team);
    }

    public static Specification<FootballTeamSquad> hasTeam(Long id) {
        return equal(FootballTeamSquad_.team, id);
    }


}
