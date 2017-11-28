package com.savik;


import com.codiform.moo.annotation.Optionality;
import com.codiform.moo.annotation.Property;
import com.savik.domain.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class  Period<T extends Goal> extends Identifiable {

    @Property(optionality = Optionality.OPTIONAL)
    protected Integer homeScore;

    @Property(optionality = Optionality.OPTIONAL)
    protected Integer guestScore;

    @Property(optionality = Optionality.OPTIONAL)
    protected Integer totalScore;

    @Enumerated(EnumType.STRING)
    @Property(optionality = Optionality.OPTIONAL)
    protected Winner winner;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Property(optionality = Optionality.OPTIONAL)
    protected PeriodStatus periodStatus;

    public enum PeriodStatus {
        FIRST,
        SECOND,
        THIRD,
        MATCH
    }

    @Getter
    public enum GoalOrder {
        FIRST(1),
        LAST(Integer.MAX_VALUE);

        int order;

        GoalOrder(int order) {
            this.order = order;
        }
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

    public boolean hasScores() {
        return guestScore != null && homeScore != null;
    }

    protected Optional<Goal> getGoal(GoalOrder goalOrder) {
        Set<T> goals = getGoals();
        if (CollectionUtils.isEmpty(goals)) {
            return Optional.empty();
        }
        List<Goal> sortedGoals = goals
                .stream()
                .sorted(Comparator.comparingInt(Goal::getMinute))
                .collect(Collectors.toList());

        if (goalOrder == GoalOrder.LAST) {
            return Optional.of(sortedGoals.get(sortedGoals.size() - 1));
        }
        if (goalOrder.getOrder() > sortedGoals.size()) {
            return Optional.empty();
        }
        return Optional.of(sortedGoals.get(goalOrder.getOrder() - 1));

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
        Set<T> goals = getGoals();
        if (goals == null) {
            return false;
        }
        return goals.stream().anyMatch(g -> g.getMinute() > from && g.getMinute() < before);
    }

    protected abstract Set<T> getGoals();

}
