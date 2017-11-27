package com.savik.football.model;

import javax.persistence.*;

import com.savik.Who;
import com.savik.domain.Identifiable;
import lombok.*;

/**
 * @author Savushkin Yauheni
 * @since 06.05.2017
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder(toBuilder = true)
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "bookie_id_generator")
@EqualsAndHashCode
public class FootballBookieStats extends Identifiable {

    @Enumerated(EnumType.STRING)
    @Transient
    Who favorite;

    Double homeRate;

    Double drawRate;

    Double guestRate;

    public Who getFavorite() {
        if (homeRate == null || guestRate == null) {
            return Who.UNKNOWN;
        }
        if ((homeRate * 2) < guestRate) {
            return Who.HOME;
        }
        if ((guestRate * 2) < homeRate) {
            return Who.GUEST;
        }
        return Who.UNKNOWN;
    }

    public boolean hasFavorite() {
        Who favorite = getFavorite();
        return favorite == Who.HOME || favorite == Who.GUEST;
    }
}
