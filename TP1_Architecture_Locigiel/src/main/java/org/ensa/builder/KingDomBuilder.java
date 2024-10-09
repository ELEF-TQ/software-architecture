package org.ensa.builder;

import org.ensa.factory.CountryFactory;
import org.ensa.factory.KingDomFactory;
import org.ensa.factory.KingFactory;
import org.ensa.model.Country;
import org.ensa.model.King;
import org.ensa.model.KingDom;

import java.util.ArrayList;
import java.util.List;

public class KingDomBuilder {
    private King king;
    private final List<Country> countries = new ArrayList<>();
    private int soldiersOnEdges = 0;

    public KingDomBuilder addKing(String kingName) {
        this.king = KingFactory.createKing(kingName); // Using Factory
        return this;
    }

    public KingDomBuilder addCountry(String name, String... cityData) {
        this.countries.add(CountryFactory.createCountry(name, cityData));
        return this;
    }

    public KingDomBuilder addSoldiersOnEdges(String soldiersOnEdges) {
        this.soldiersOnEdges = Integer.parseInt(soldiersOnEdges);
        return this;
    }

    public KingDom build() {
        return KingDomFactory.createKingDom(king, countries, soldiersOnEdges);
    }
}

