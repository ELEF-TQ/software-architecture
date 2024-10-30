package org.ensa.mdoel;

import lombok.*;

@Getter
@AllArgsConstructor
public class Trajet extends MissionComponent {

    private String pointDepart;
    private String pointArrivee;
    private double coutBonCommande;

    @Override
    public double cout() {
        return coutBonCommande;
    }

    @Override
    public String view() {
        return "Trajet de " + pointDepart + " à " + pointArrivee + " (Coût: " + coutBonCommande + ")";
    }
}
