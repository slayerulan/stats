package com.savik.snooker.model;

import com.savik.BookieStats;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@NoArgsConstructor
@Getter
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "snooker_bookie_id_generator")
@EqualsAndHashCode
public class SnookerBookieStats extends BookieStats {

    @Builder(toBuilder = true)
    public SnookerBookieStats(Double homeRate, Double drawRate, Double guestRate) {
        super(homeRate, drawRate, guestRate);
    }
}
