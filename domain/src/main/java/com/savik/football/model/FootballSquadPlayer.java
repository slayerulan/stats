package com.savik.football.model;

import com.savik.domain.Identifiable;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "football_squad_player_id_generator")
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = "myscoreCode"),
        indexes = @Index(columnList = "myscoreCode")
)
@EqualsAndHashCode
@Builder
@Getter
public class FootballSquadPlayer extends Identifiable {

    @NotNull
    private String name;

    @NotNull
    private String myscoreUrlName;

    @NotNull
    private String myscoreCode;

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FootballSquadPlayer that = (FootballSquadPlayer) o;
        return Objects.equals(myscoreCode, that.myscoreCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), myscoreCode);
    }
}
