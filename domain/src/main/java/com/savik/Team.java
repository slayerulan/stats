package com.savik;


import com.savik.domain.Identifiable;
import lombok.*;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@MappedSuperclass
public abstract class Team extends Identifiable {

    @NotNull
    @Setter
    protected String name;

}
