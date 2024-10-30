package org.ensa.Decorators;

import org.ensa.Models.Assurance;
import org.ensa.Models.GarantieOptionnelle;

public class BrisDeGlace extends GarantieOptionnelle {
    public BrisDeGlace(Assurance assurance) {
        super(assurance);
    }

    @Override
    public double cout() {
        return super.cout() + 100.0;  // coût additionnel pour bris de glace
    }

    @Override
    public String description() {
        return super.description() + ", Bris de glace";
    }
}
