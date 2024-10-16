package org.ensa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class KingDom {

    private King king ;
    private List<Country> countries ;
    private int soldiersOnEdges;

    public String report() {
        StringBuilder report = new StringBuilder(king.getName().charAt(0) + ":|");

        for (Country country : countries) {
            report.append(country.getName().charAt(0)).append(":<");
            int cityCount = 1; // For city identifiers
            for (City city : country.getCities()) {
                report.append("Fc").append(cityCount++).append(":").append(city.getSoldiers()).append("-").append(city.getCitizens()).append(",");
            }
            report.setLength(report.length() - 1); // Remove last comma
            report.append(">");
        }

        report.append(", S:<"); // Start soldiers on edges
        report.append(soldiersOnEdges).append(">-").append(soldiersOnEdges); // Corrected output
        return report.toString();
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


}
