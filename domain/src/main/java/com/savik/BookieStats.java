package com.savik;


import com.savik.domain.Identifiable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EqualsAndHashCode
public class BookieStats extends Identifiable {

    protected Double homeRate;

    protected Double drawRate;

    protected Double guestRate;

    public Who getFavorite() {
        if (homeRate == null || guestRate == null) {
            return Who.UNKNOWN;
        }
        if ((homeRate * 1.5) < guestRate) {
            return Who.HOME;
        }
        if ((guestRate * 1.5) < homeRate) {
            return Who.GUEST;
        }
        return Who.UNKNOWN;
    }

    public boolean hasFavorite() {
        Who favorite = getFavorite();
        return favorite == Who.HOME || favorite == Who.GUEST;
    }
}
