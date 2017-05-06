package com.savik.football.model;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

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
public class BookieStats {
    Who favorite;
}
