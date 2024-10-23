package org.ensa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class War {
    private List<KingDom> kingdoms;
    private final String map;

    public void prepareAttack() {
        for (KingDom kingdom : kingdoms) {
            int soldiersOnEdges = kingdom.getSoldiersOnEdges();
            int totalSoldiersInCities = kingdom.currentPower() - soldiersOnEdges; // Total soldiers in cities
            int soldiersToMove = totalSoldiersInCities / 2; // Move 50% of the soldiers in cities

            System.out.println("Total soldiers in cities: " + totalSoldiersInCities);
            System.out.println("Soldiers to move: " + soldiersToMove);

            // Keep track of how many soldiers have been moved
            int soldiersMoved = 0;

            // Update soldiers in each city
            for (Country country : kingdom.getCountries()) {
                for (City city : country.getCities()) {
                    int citySoldiers = city.getSoldiers();
                    System.out.println("Current city soldiers: " + citySoldiers);

                    // Only move soldiers if we still need to move more
                    if (soldiersMoved < soldiersToMove) {
                        // Calculate soldiers to move from the current city
                        int soldiersMoving = Math.min(soldiersToMove - soldiersMoved, citySoldiers);

                        // Reduce soldiers in the city by the moving amount
                        city.setSoldiers(citySoldiers - soldiersMoving);
                        soldiersMoved += soldiersMoving; // Update total soldiers moved

                        System.out.println("Moving " + soldiersMoving + " soldiers from city. New count: " + city.getSoldiers());
                    }
                }
            }

            // Update soldiers on edges after moving
            kingdom.updateSoldiersOnEdges(soldiersMoved);
            System.out.println("Soldiers moved to edges: " + soldiersMoved);
            System.out.println("Total soldiers on edges after move: " + kingdom.getSoldiersOnEdges());
        }
    }







    public void start() {
        // Logic for starting the war
    }
}
