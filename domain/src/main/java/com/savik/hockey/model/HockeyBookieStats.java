package com.savik.hockey.model;

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
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "hockey_bookie_id_generator")
@EqualsAndHashCode
public class HockeyBookieStats extends BookieStats {

    @Builder(toBuilder = true)
    public HockeyBookieStats(Double homeRate, Double drawRate, Double guestRate) {
        super(homeRate, drawRate, guestRate);
    }
}
