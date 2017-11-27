package com.savik;


import com.savik.domain.Identifiable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@MappedSuperclass
public class Goal extends Identifiable {

    @NotNull
    protected Integer minute;

    @NotNull
    @Enumerated(EnumType.STRING)
    protected Who whoScored;

}
