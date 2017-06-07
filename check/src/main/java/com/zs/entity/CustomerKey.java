package com.zs.entity;

import java.math.BigDecimal;

public class CustomerKey {
    private String cteBarCode;

    private BigDecimal historyCount;

    public String getCteBarCode() {
        return cteBarCode;
    }

    public void setCteBarCode(String cteBarCode) {
        this.cteBarCode = cteBarCode == null ? null : cteBarCode.trim();
    }

    public BigDecimal getHistoryCount() {
        return historyCount;
    }

    public void setHistoryCount(BigDecimal historyCount) {
        this.historyCount = historyCount;
    }
}