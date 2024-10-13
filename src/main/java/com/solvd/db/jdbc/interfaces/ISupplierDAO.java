package com.solvd.db.jdbc.interfaces;

import com.solvd.db.jdbc.models.Supplier;

public interface ISupplierDAO extends IBaseDao<Supplier> {

    Supplier getSupplierByName(String supplierName);
}
