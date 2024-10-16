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
                .map(country -> {
                    // Call country.report() which returns the formatted city reports
                    String report = country.report();
                    // Use the first character of the country name
                    String formattedReport = String.format("%s:%s", country.getName().charAt(0), report);

                    // Append soldiers on edges if applicable
                    if (soldiersOnEdges > 0) {
                        formattedReport += String.format("-%d", soldiersOnEdges);
                    }

                    return formattedReport;
                })
                .collect(Collectors.joining(", "));

        return String.format("%s:|%s|", king, countryReports);
    }






    public int currentPower() {
        int totalPower = 0; // Start with zero

        // Add soldiers from each country and its cities
        for (Country country : countries) {
            for (City city : country.getCities()) {
                totalPower += city.getSoldiers(); // Only add city soldiers
            }
        }

        return totalPower; // Return the correctly calculated total power (now just city soldiers)
    }





    public String peopleMood() {
        return null;
    }
}
