package com.savik;


import com.savik.domain.Identifiable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@MappedSuperclass
public abstract class Match extends Identifiable {

}
