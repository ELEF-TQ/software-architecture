package org.ensa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
public class City {

    private int soldiers;
    private int citizens ;

    public String report(String countryInitial, int cityIndex) {
        return String.format("%s:%s-%s", countryInitial + "c" + (cityIndex + 1), soldiers, citizens);
    }


    @Override
    public String toString() {
        return "c:" + soldiers + "-" + citizens;
    }



}
