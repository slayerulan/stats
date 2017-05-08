package com.savik.football.model;

import com.savik.domain.Identifiable;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.SequenceGenerator;

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
public class BookieStats extends Identifiable {

    @Enumerated(EnumType.STRING)
    Who favorite;

    Double homeRate;

    Double drawRate;

    Double guestRate;
}
