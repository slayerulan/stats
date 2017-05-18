package com.savik.football.model;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.codiform.moo.annotation.CollectionProperty;
import com.codiform.moo.annotation.Optionality;
import com.codiform.moo.annotation.Property;
import com.savik.domain.Identifiable;
import lombok.*;
import org.springframework.util.CollectionUtils;

/**
 * @author Savushkin Yauheni
 * @since 10.4.17
 */
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "period_id_generator")
public class Period extends Identifiable {

    @NotNull
    @Enumerated(EnumType.STRING)
    @Property(optionality = Optionality.OPTIONAL)
    PeriodStatus periodStatus;

    @Property(optionality = Optionality.OPTIONAL)
    Integer homeScore;

    @Property(optionality = Optionality.OPTIONAL)
    Integer guestScore;

    @Property(optionality = Optionality.OPTIONAL)
    Integer totalScore;

    @Enumerated(EnumType.STRING)
    @Property(optionality = Optionality.OPTIONAL)
    Winner winner;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @CollectionProperty(optionality = Optionality.OPTIONAL)
    Set<Goal> goals;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @CollectionProperty(optionality = Optionality.OPTIONAL)
    Set<Card> cards;

    Integer homeCorners;

    Integer guestCorners;

    Integer homeHits;

    Integer guestHits;

    Integer homeHitsOnTarget;

    Integer guestHitsOnTarget;

    Integer homePossession;

    Integer guestPossession;

    Integer homeOffsides;

    Integer guestOffsides;

    Integer homeFouls;

    Integer guestFouls;

    public enum PeriodStatus {
        FIRST,
        SECOND,
        MATCH
    }

    public Integer getFavoriteScore(Who favorite) {
        if (favorite == Who.HOME) {
            return homeScore;
        } else if (favorite == Who.GUEST) {
            return guestScore;
        }
        throw new IllegalArgumentException("Favorite is incorrect = " + favorite);
    }

    public Integer getLoserScore(Who favorite) {
        if (favorite == Who.HOME) {
            return guestScore;
        } else if (favorite == Who.GUEST) {
            return homeScore;
        }
        throw new IllegalArgumentException("Favorite is incorrect = " + favorite);
    }

    public Integer getFirstGoalTime() {
        Optional<Goal> firstGoal = getGoal(GoalOrder.FIRST);
        return firstGoal.map(Goal::getMinute).orElse(null);
    }

    public Integer getLastGoalTime() {
        Optional<Goal> firstGoal = getGoal(GoalOrder.LAST);
        return firstGoal.map(Goal::getMinute).orElse(null);
    }

    public boolean hasGoalBetween(int from, int before) {
        if (goals == null) {
            return false;
        }
        return goals.stream().anyMatch(g -> g.getMinute() > from && g.getMinute() < before);
    }

    private Optional<Goal> getGoal(GoalOrder goalOrder) {
        if (CollectionUtils.isEmpty(goals)) {
            return null;
        }
        List<Goal> goals = this.goals
                .stream()
                .sorted(Comparator.comparingInt(Goal::getMinute))
                .collect(Collectors.toList());

        if (goalOrder == GoalOrder.LAST) {
            return Optional.of(goals.get(goals.size() - 1));
        }
        if(goalOrder.getOrder() > goals.size()) {
            return Optional.ofNullable(null);
        }
        return Optional.of(goals.get(goalOrder.getOrder() - 1));

    }

    @Getter
    private enum GoalOrder {
        FIRST(1),
        LAST(Integer.MAX_VALUE);

        int order;

        GoalOrder(int order) {
            this.order = order;
        }
    }
}
