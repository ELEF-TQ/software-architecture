package org.ensa;

import org.ensa.builder.TrajetBuilder;
import org.ensa.mdoel.Mission;
import org.ensa.mdoel.Trajet;

public class Main {

    public static void main(String[] args) {
        // Création d'un trajet avec le builder
        TrajetBuilder trajetBuilder = new TrajetBuilder();
        Trajet trajet1 = trajetBuilder
                .setPointDepart("Paris")
                .setPointArrivee("Lyon")
                .setCoutBonCommande(500)
                .build();

        Trajet trajet2 = trajetBuilder
                .setPointDepart("Lyon")
                .setPointArrivee("Marseille")
                .setCoutBonCommande(300)
                .build();

        // Création d'une sous-mission et ajout de trajets
        Mission sousMission = new Mission();
        sousMission.add(trajet1);
        sousMission.add(trajet2);

        // Création d'une mission principale
        Mission missionPrincipale = new Mission();
        missionPrincipale.add(sousMission);

        // Affichage des détails et du coût
        System.out.println(missionPrincipale.view());
        System.out.println("Coût total de la mission : " + missionPrincipale.cout());
    }
}
