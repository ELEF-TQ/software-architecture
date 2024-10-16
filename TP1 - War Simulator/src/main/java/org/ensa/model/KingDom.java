package org.ensa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
@AllArgsConstructor
public class KingDom {

    private King king ;
    private List<Country> countries ;
    private int soldiersOnEdges;


    public void updateSoldiersOnEdges(int soldiers) {
        this.soldiersOnEdges += soldiers;
    }

    public String report() {
        String countryReports = countries.stream()
                .map(Country::report)
                .collect(Collectors.joining(", "));

        return String.format("%s:|%s|", king, countryReports);
    }





    public int currentPower() {
        int totalPower = soldiersOnEdges;
        for (Country country : countries) {
            for (City city : country.getCities()) {
                totalPower += city.getSoldiers();
            }
        }
        return totalPower;
    }


    public String peopleMood() {
        return null;
    }
}
