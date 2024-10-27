package com.solvd.patterns.abstractfactory;

import com.solvd.patterns.abstractfactory.factories.LabTechnicianFactory;
import com.solvd.patterns.abstractfactory.factories.RadiologyTechnicianFactory;

public class TechnicianFactoryProvider {
    public static AbstractTechnicianFactory getFactory(String technicianType) {
        switch (technicianType) {
            case "Radiology":
                return new RadiologyTechnicianFactory();
            case "Lab":
                return new LabTechnicianFactory();
            default:
                throw new IllegalArgumentException("Unknown technician type: " + technicianType);
        }
    }
}
