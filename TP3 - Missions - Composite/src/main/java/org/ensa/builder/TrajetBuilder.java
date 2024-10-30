package org.ensa.builder;

import org.ensa.mdoel.Trajet;

public class TrajetBuilder {
    private String pointDepart;
    private String pointArrivee;

    private double coutBonCommande;

    public TrajetBuilder setPointDepart(String pointDepart) {
        this.pointDepart = pointDepart;
        return this;
    }

    public TrajetBuilder setPointArrivee(String pointArrivee) {
        this.pointArrivee = pointArrivee;
        return this;
    }


    public TrajetBuilder setCoutBonCommande(double coutBonCommande) {
        this.coutBonCommande = coutBonCommande;
        return this;
    }

    public Trajet build() {
        return new Trajet(pointDepart, pointArrivee, coutBonCommande);
    }
}
