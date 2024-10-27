package com.solvd.patterns.abstractfactory.product;

public class RadiologyTechnician implements Technician {
    @Override
    public void performDuties() {
        System.out.println("Performing radiology procedures and imaging.");
    }
}
