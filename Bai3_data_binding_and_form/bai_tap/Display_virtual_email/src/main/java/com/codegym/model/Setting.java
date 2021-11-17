package com.codegym.model;

public class Setting {
    private String langueges;
    private int pageSize;
    private String spamsFillter;
    private String signature;

    public Setting(String langueges, int pageSize, String spamsFillter, String signature) {
        this.langueges = langueges;
        this.pageSize = pageSize;
        this.spamsFillter = spamsFillter;
        this.signature = signature;
    }

    public Setting() {
    }

    public String getLangueges() {
        return langueges;
    }

    public void setLangueges(String langueges) {
        this.langueges = langueges;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    public String getSpamsFillter() {
        return spamsFillter;
    }

    public void setSpamsFillter(String spamsFillter) {
        this.spamsFillter = spamsFillter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
