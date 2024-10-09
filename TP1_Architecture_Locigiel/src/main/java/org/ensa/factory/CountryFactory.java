package org.ensa.factory;

import org.ensa.model.City;
import org.ensa.model.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryFactory {
    public static Country createCountry(String name, String... cityData) {

        List<City> cities = new ArrayList<>();
        for (int i = 0; i < cityData.length; i += 2) {
            int soldiers = Integer.parseInt(cityData[i]);
            int citizens = Integer.parseInt(cityData[i + 1]);
            cities.add(CityFactory.createCity(soldiers, citizens));
        }
        return new Country(name, cities);
    }
}
