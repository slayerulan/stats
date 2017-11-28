package com.savik.football.model;

import com.savik.BookieStats;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

/**
 * @author Savushkin Yauheni
 * @since 06.05.2017
 */
@Entity
@NoArgsConstructor
@Getter
@Builder(toBuilder = true)
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "football_bookie_id_generator")
@EqualsAndHashCode
public class FootballBookieStats extends BookieStats {

}
