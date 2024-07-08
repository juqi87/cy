package com.mzb.cy.dao.model;

public class TestDO {
    private String dbStat;

    public String getDbStat() {
        return dbStat;
    }

    public void setDbStat(String dbStat) {
        this.dbStat = dbStat == null ? null : dbStat.trim();
    }
}