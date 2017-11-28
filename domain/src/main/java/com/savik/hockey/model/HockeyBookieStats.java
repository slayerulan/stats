package com.savik.hockey.model;

import com.savik.Who;
import com.savik.domain.Identifiable;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder(toBuilder = true)
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "hockey_bookie_id_generator")
@EqualsAndHashCode
public class HockeyBookieStats extends Identifiable {

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
