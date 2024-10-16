package org.ensa.factory;

import org.ensa.model.City;

public class CityFactory {
    public static City createCity(int soldiers, int citizens) {
        return new City(soldiers, citizens);
    }
}
