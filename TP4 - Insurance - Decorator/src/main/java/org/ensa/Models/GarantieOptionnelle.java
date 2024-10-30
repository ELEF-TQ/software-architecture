package org.ensa.Models;

import org.ensa.Models.Assurance;

public abstract class GarantieOptionnelle implements Assurance {
    protected Assurance assurance;

    public GarantieOptionnelle(Assurance assurance) {
        this.assurance = assurance;
    }

    @Override
    public double cout() {
        return assurance.cout();
    }

    @Override
    public String description() {
        return assurance.description();
    }
}
