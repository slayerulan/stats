package com.savik.football.model;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
public class Period extends Identifiable {

    @NotNull
    @Enumerated(EnumType.STRING)
    @Property(optionality = Optionality.OPTIONAL)
    PeriodStatus periodStatus;

    @NotNull
    @Property(optionality = Optionality.OPTIONAL)
    Integer homeScore;

    @NotNull
    @Property(optionality = Optionality.OPTIONAL)
    Integer guestScore;

    @NotNull
    @Property(optionality = Optionality.OPTIONAL)
    Integer totalScore;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Property(optionality = Optionality.OPTIONAL)
    Winner winner;

    @NotNull
    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    @CollectionProperty(optionality = Optionality.OPTIONAL)
    Set<Goal> goals;

    @NotNull
    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    @CollectionProperty(optionality = Optionality.OPTIONAL)
    Set<Card> cards;

    @NotNull
    Integer homeCorners;

    @NotNull
    Integer guestCorners;

    @NotNull
    Integer homeHits;

    @NotNull
    Integer guestHits;

    @NotNull
    Integer homePossession;

    @NotNull
    Integer guestPossession;

    @NotNull
    Integer homeOffsides;

    @NotNull
    Integer guestOffsides;

    @NotNull
    Integer homeFouls;

    @NotNull
    Integer guestFouls;

    public enum PeriodStatus {
        FIRST,
        SECOND,
        MATCH
    }
}
