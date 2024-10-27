package com.solvd.patterns.abstractfactory.product;

public class LabTechnician implements Technician {
    @Override
    public void performDuties() {
        System.out.println("Handling lab tests and sample analysis.");
    }
}