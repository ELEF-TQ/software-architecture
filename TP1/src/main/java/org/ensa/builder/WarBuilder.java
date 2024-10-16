package org.ensa.builder;

import org.ensa.factory.WarFactory;
import org.ensa.model.KingDom;
import org.ensa.model.War;

import java.util.ArrayList;
import java.util.List;

public class WarBuilder {

    private final List<KingDom> kingdoms = new ArrayList<>();
    private String map;

    public WarBuilder addKingDom(KingDom kingdom) {
        this.kingdoms.add(kingdom);
        return this;
    }

    public WarBuilder addMap(String map) {
        this.map = map;
        return this;
    }

    public War build() {
        return WarFactory.createWar(kingdoms, map);
    }
}
