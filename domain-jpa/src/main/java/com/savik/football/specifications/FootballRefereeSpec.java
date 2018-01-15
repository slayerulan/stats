package com.savik.football.specifications;

import com.savik.football.model.*;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import static com.savik.specification.CommonSpecifications.anyEquals;
import static com.savik.specification.CommonSpecifications.contain;
import static com.savik.specification.CommonSpecifications.equal;

@UtilityClass
public class FootballRefereeSpec {

    public static Specification<FootballReferee> hasName(String name) {
        return contain(FootballReferee_.name, name);
    }

}
