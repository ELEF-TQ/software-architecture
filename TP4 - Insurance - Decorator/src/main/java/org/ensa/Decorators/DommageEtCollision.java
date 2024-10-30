package org.ensa.Decorators;

import org.ensa.Models.Assurance;
import org.ensa.Models.GarantieOptionnelle;

public class DommageEtCollision extends GarantieOptionnelle {
    public DommageEtCollision(Assurance assurance) {
        super(assurance);
    }

    @Override
    public double cout() {
        return super.cout() + 200.0;  // coût additionnel pour dommage et collision
    }

    @Override
    public String description() {
        return super.description() + ", Dommage et collision";
    }
}
