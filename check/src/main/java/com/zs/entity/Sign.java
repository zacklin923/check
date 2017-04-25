package com.zs.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Sign {
    private BigDecimal courierNumber;

    private String deliveryState;

    private String signatory;

    private Date signTime;

    private String abnormalCause;

    private BigDecimal goodsCost;

    private String goods;

    private String note;

    public BigDecimal getCourierNumber() {
        return courierNumber;
    }

    public void setCourierNumber(BigDecimal courierNumber) {
        this.courierNumber = courierNumber;
    }

    public String getDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState(String deliveryState) {
        this.deliveryState = deliveryState == null ? null : deliveryState.trim();
    }

    public String getSignatory() {
        return signatory;
    }

    public void setSignatory(String signatory) {
        this.signatory = signatory == null ? null : signatory.trim();
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public String getAbnormalCause() {
        return abnormalCause;
    }

    public void setAbnormalCause(String abnormalCause) {
        this.abnormalCause = abnormalCause == null ? null : abnormalCause.trim();
    }

    public BigDecimal getGoodsCost() {
        return goodsCost;
    }

    public void setGoodsCost(BigDecimal goodsCost) {
        this.goodsCost = goodsCost;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods == null ? null : goods.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}