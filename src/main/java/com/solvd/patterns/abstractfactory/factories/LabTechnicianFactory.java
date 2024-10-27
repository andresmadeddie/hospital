package com.solvd.patterns.abstractfactory.factories;

import com.solvd.patterns.abstractfactory.AbstractTechnicianFactory;
import com.solvd.patterns.abstractfactory.product.LabTechnician;
import com.solvd.patterns.abstractfactory.product.Technician;

public class LabTechnicianFactory implements AbstractTechnicianFactory {
    @Override
    public Technician createTechnician() {
        return new LabTechnician();
    }
}
