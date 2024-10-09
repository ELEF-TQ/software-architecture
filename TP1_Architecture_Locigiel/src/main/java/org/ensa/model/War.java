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
        // Logic for preparing the attack
        for (KingDom kingdom : kingdoms) {
            int soldiersToMove = (int) (kingdom.currentPower() * 0.5);
            for (Country country : kingdom.getCountries()) {
                for (City city : country.getCities()) {
                    if (soldiersToMove > 0) {
                        int soldiersInCity = city.getSoldiers();
                        if (soldiersInCity >= soldiersToMove) {
                            // Move soldiers to the edge
                            city = new City(soldiersInCity - soldiersToMove, city.getCitizens());
                            soldiersToMove = 0; // All soldiers moved
                        }
                    }
                }
            }
        }
    }

    public void start() {
        // Logic for starting the war
    }
}
