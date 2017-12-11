package com.savik;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coeff {
    private Double value;
    private Double positiveValue;
    private Double negativeValue;
    private boolean averageCoeff;

    public Coeff() {
        // TODO: remove
        this.value = 2.0;
        this.averageCoeff = true;
    }

    public Coeff(Double value) {
        this.value = value;
        this.averageCoeff = true;
    }

    public Coeff(Double positiveValue, Double negativeValue) {
        this.positiveValue = positiveValue;
        this.negativeValue = negativeValue;
        this.averageCoeff = true;
    }

    public void set(Double value) {
        this.positiveValue = null;
        this.negativeValue = null;
        this.value = value;
        this.averageCoeff = false;
    }

    public void set(Double positiveValue, Double negativeValue) {
        this.value = null;
        this.positiveValue = positiveValue;
        this.negativeValue = negativeValue;
        this.averageCoeff = false;
    }

    public CoeffType getStatus() {
        if(value != null) {
            return CoeffType.SINGLE;
        } else if (positiveValue != null && negativeValue != null) {
            return CoeffType.POSITIVE_NEGATIVE;
        }
        throw new IllegalStateException();
    }
}
