package com.savik.hockey.filters;

import com.savik.filter.Filter;
import com.savik.hockey.model.HockeyMatch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import static com.savik.hockey.specifications.HockeyMatchSpec.hasHomeTeam;
import static org.springframework.data.jpa.domain.Specifications.where;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class HockeyMatchFilter implements Filter<HockeyMatch> {

    private Long homeId;

    private Long guestId;

    private String myscoreCode;

    private boolean includeAllMatches;

    public Specification<HockeyMatch> toSpecification() {
        return where(hasHomeTeam(homeId));
    }

}
