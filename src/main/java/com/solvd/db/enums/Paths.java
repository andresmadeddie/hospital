package com.solvd.db.enums;

public enum Paths {

    XMLFOLDER("src/main/resources/xml/"),
    MODELFOLDER("com.solvd.db.jdbc.models"),
    XSDFOLDER("src/main/resources/xmlXsd/");

    private final String path;

    Paths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
