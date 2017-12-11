package com.savik;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coeff {
    private ContainerType type;
    private Double value;
    private Double positiveValue;
    private Double negativeValue;

    public void set(Double value) {
        this.value = value;
    }

    public void set(Double positiveValue, Double negativeValue) {
        this.positiveValue = positiveValue;
        this.negativeValue = negativeValue;
    }
}
