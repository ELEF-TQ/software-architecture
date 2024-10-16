package org.ensa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class Country {

    private String name ;
    private List<City> cities ;


    public String report() {
        String countryInitial = name != null && !name.isEmpty() ? String.valueOf(name.charAt(0)) : "";
        String cityReports = cities.stream()
                .map(city -> city.report(countryInitial, cities.indexOf(city)))
                .collect(Collectors.joining(","));

        // Return just the city reports without adding any additional formatting
        return String.format("<%s>", cityReports); // This returns the formatted cities report
    }





}
