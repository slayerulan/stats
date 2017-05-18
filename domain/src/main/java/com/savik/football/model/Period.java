package com.savik.football.model;

import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.codiform.moo.annotation.CollectionProperty;
import com.codiform.moo.annotation.Optionality;
import com.codiform.moo.annotation.Property;
import com.savik.domain.Identifiable;
import lombok.*;

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
}
