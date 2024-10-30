package org.ensa.Decorators;

import org.ensa.Models.Assurance;
import org.ensa.Models.GarantieOptionnelle;

public class Inondation extends GarantieOptionnelle {

    private final double coutInondation = 200.0; // coût additionnel pour la garantie inondation

    public Inondation(Assurance assurance) {
        super(assurance);
    }

    @Override
    public double cout() {
        return super.cout() + coutInondation;
    }

    @Override
    public String description() {
        return super.description() + ", Inondation";
    }
}
