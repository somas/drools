package com.st.simple.bean;

public class Merchant {
    private String name;
    private String jurisdiction;

    public Merchant(String name, String jurisdiction) {
        this.name = name;
        this.jurisdiction = jurisdiction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }
}
