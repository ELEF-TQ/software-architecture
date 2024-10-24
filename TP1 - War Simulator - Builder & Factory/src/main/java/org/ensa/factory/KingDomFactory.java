package org.ensa.factory;

import org.ensa.model.Country;
import org.ensa.model.King;
import org.ensa.model.KingDom;

import java.util.List;

public class KingDomFactory {
    public static KingDom createKingDom(King king, List<Country> countries, int soldiersOnEdges) {
        return new KingDom(king, countries, soldiersOnEdges);
    }
}
