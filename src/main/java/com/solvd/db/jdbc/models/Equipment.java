package com.solvd.db.jdbc.models;

import java.sql.Date;

public class Equipment {

    private int equipmentId;
    private String name;
    private String type;
    private Date purchaseDate;
    private Date warrantyEnd;
    private Supplier supplier;

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getWarrantyEnd() {
        return warrantyEnd;
    }

    public void setWarrantyEnd(Date warrantyEnd) {
        this.warrantyEnd = warrantyEnd;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
