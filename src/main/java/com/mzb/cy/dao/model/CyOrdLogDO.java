package com.mzb.cy.dao.model;

public class CyOrdLogDO extends CyOrdLogDOKey {
    private String transType;

    private String muCard;

    private String points;

    private String ipAddress;

    private String partnerId;

    private String stat;

    private String ordId;

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType == null ? null : transType.trim();
    }

    public String getMuCard() {
        return muCard;
    }

    public void setMuCard(String muCard) {
        this.muCard = muCard == null ? null : muCard.trim();
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points == null ? null : points.trim();
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId == null ? null : partnerId.trim();
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat == null ? null : stat.trim();
    }

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId == null ? null : ordId.trim();
    }
}