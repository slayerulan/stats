package com.savik;


import com.savik.domain.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(allocationSize = 4, name = "sequence_id", sequenceName = "coeff_id_generator")
public class CoeffEntry extends Identifiable {


    @Embedded
    private Coeff coeff;

    private Boolean leaf;

    private String path;

    @Setter
    private String myscoreCode;

    public CoeffEntry(Coeff coeff, Boolean leaf, String path) {
        this.coeff = coeff;
        this.leaf = leaf;
        this.path = path;
    }
}
