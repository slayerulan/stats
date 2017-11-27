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
import com.savik.Who;
import com.savik.Winner;
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
public class FootballPeriod extends Identifiable {

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
    Set<FootballGoal> goals;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @CollectionProperty(optionality = Optionality.OPTIONAL)
    Set<FootballCard> cards;

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
        Optional<FootballGoal> firstGoal = getGoal(GoalOrder.FIRST);
        return firstGoal.map(FootballGoal::getMinute).orElse(null);
    }

    public Integer getLastGoalTime() {
        Optional<FootballGoal> firstGoal = getGoal(GoalOrder.LAST);
        return firstGoal.map(FootballGoal::getMinute).orElse(null);
    }

    public boolean hasGoalBetween(int from, int before) {
        if (goals == null) {
            return false;
        }
        return goals.stream().anyMatch(g -> g.getMinute() > from && g.getMinute() < before);
    }

    public boolean hasScores() {
        return guestScore != null && homeScore != null;
    }

    private Optional<FootballGoal> getGoal(GoalOrder goalOrder) {
        if (CollectionUtils.isEmpty(this.goals)) {
            return Optional.empty();
        }
        List<FootballGoal> footballGoals = this.goals
                .stream()
                .sorted(Comparator.comparingInt(FootballGoal::getMinute))
                .collect(Collectors.toList());

        if (goalOrder == GoalOrder.LAST) {
            return Optional.of(footballGoals.get(footballGoals.size() - 1));
        }
        if(goalOrder.getOrder() > footballGoals.size()) {
            return Optional.empty();
        }
        return Optional.of(footballGoals.get(goalOrder.getOrder() - 1));

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
