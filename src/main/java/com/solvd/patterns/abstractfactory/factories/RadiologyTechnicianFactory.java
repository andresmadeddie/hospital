package com.solvd.patterns.abstractfactory.factories;

import com.solvd.patterns.abstractfactory.AbstractTechnicianFactory;
import com.solvd.patterns.abstractfactory.product.RadiologyTechnician;
import com.solvd.patterns.abstractfactory.product.Technician;

public class RadiologyTechnicianFactory implements AbstractTechnicianFactory {
    @Override
    public Technician createTechnician() {
        return new RadiologyTechnician();
    }
}
