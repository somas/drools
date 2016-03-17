package com.st.simple.bean;

import java.util.Date;


public class Merchant {
    private String name;
    private String jurisdiction;
    private Date startDate;

    public Merchant(String name, String jurisdiction) {
        this.name = name;
        this.jurisdiction = jurisdiction;
    }

    public Merchant(String name, String jurisdiction, Date startDate) {
        this(name, jurisdiction);
        this.startDate = startDate;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

}
