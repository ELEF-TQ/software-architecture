package org.ensa.factory;

import org.ensa.model.KingDom;
import org.ensa.model.War;

import java.util.List;

public class WarFactory {
    public static War createWar(List<KingDom> kingdoms, String map) {
        return new War(kingdoms, map);
    }}
