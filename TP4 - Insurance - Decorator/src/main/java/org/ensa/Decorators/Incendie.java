package org.ensa.Decorators;

import org.ensa.Models.Assurance;
import org.ensa.Models.GarantieOptionnelle;

public class Incendie extends GarantieOptionnelle {

    private final double coutIncendie = 150.0; // coût additionnel pour la garantie incendie

    public Incendie(Assurance assurance) {
        super(assurance);
    }

    @Override
    public double cout() {
        return super.cout() + coutIncendie;
    }

    @Override
    public String description() {
        return super.description() + ", Incendie";
    }
}
