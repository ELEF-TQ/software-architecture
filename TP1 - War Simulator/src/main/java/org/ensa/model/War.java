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
            int totalSoldiers = kingdom.currentPower();
            int soldiersToMove = totalSoldiers / 2; // Move 50% of the total power

            // Keep track of how many soldiers have been moved
            int soldiersMoved = 0;

            // Update soldiers in each city and calculate soldiers on edges
            for (Country country : kingdom.getCountries()) {
                for (City city : country.getCities()) {
                    int citySoldiers = city.getSoldiers();
                    if (citySoldiers > 0 && soldiersMoved < soldiersToMove) {
                        int soldiersMoving = Math.min(soldiersToMove - soldiersMoved, citySoldiers);
                        city.setSoldiers(citySoldiers - soldiersMoving); // Reduce soldiers in the city
                        soldiersMoved += soldiersMoving; // Keep track of total soldiers moved
                    }
                }
            }

            kingdom.updateSoldiersOnEdges(soldiersMoved);
        }
    }




    public void start() {
        // Logic for starting the war
    }
}
