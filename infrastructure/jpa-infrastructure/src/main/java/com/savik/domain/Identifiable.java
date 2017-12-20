package com.savik.domain;

import com.codiform.moo.annotation.Optionality;
import com.codiform.moo.annotation.Property;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@MappedSuperclass
public abstract class Identifiable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_id")
    @Property(optionality = Optionality.OPTIONAL)
    private Long id;
}
