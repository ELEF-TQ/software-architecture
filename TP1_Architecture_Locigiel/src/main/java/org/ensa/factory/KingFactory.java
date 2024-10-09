package org.ensa.factory;

import org.ensa.model.King;

public class KingFactory {
    public static King createKing(String name) {
        return new King(name);
    }
}
