package com.zs.entity;

public class NoUpdate extends NoUpdateKey {
    private String noUpdateValue;

    public String getNoUpdateValue() {
        return noUpdateValue;
    }

    public void setNoUpdateValue(String noUpdateValue) {
        this.noUpdateValue = noUpdateValue == null ? null : noUpdateValue.trim();
    }
}