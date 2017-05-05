package com.savik.football.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import com.savik.domain.Identifiable;
import lombok.*;

/**
 * @author Savushkin Yauheni
 * @since 10.04.2017
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "match_info_id_generator")
@Getter
public class MatchInfo extends Identifiable {

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    Period match;

    @OneToOne(cascade = CascadeType.ALL)
    Period firstPeriod;

    @OneToOne(cascade = CascadeType.ALL)
    Period secondPeriod;

}
