package org.ensa.Models;

public class AssuranceBase implements Assurance {
    @Override
    public double cout(){
        return  100.0 ; // cout de base
    }

    @Override
    public String description() {
        return "Garantie de responsabilité civile";
    }
}
