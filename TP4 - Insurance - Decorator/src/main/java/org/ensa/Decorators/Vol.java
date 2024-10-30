package org.ensa.Decorators;

import org.ensa.Models.Assurance;
import org.ensa.Models.GarantieOptionnelle;

public class Vol extends GarantieOptionnelle {
    public Vol(Assurance assurance) {
        super(assurance);
    }

    @Override
    public double cout() {
        return super.cout() + 150.0;  // coût additionnel pour vol
    }

    @Override
    public String description() {
        return super.description() + ", Vol";
    }
}
