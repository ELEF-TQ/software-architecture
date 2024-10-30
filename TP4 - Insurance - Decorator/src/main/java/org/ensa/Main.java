package org.ensa;

import org.ensa.Decorators.*;
import org.ensa.Models.Assurance;
import org.ensa.Models.AssuranceBase;


public class Main {

    public static void main(String[] args) {
        Assurance assurance = new AssuranceBase();

        // Ajouter des garanties optionnelles
        assurance = new DommageEtCollision(assurance);
        assurance = new Vol(assurance);
        assurance = new BrisDeGlace(assurance);
        assurance  = new Incendie(assurance);
        assurance  = new Inondation(assurance);


        // Affichage du coût total et de la description de l'assurance
        System.out.println("Description de l'assurance : " + assurance.description());
        System.out.println("Coût total de l'assurance : " + assurance.cout());
    }
}
