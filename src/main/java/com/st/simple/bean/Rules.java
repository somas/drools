package com.st.simple.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Rules {
    @Id
    private String id;
    private String merchantName;
    private String merchantJurisdiction;
    private String insurer;
    private Date startDate;
    private Date endDate;

    public Rules() {
    }

    public Rules(String id, String merchantName, String merchantJurisdiction, String insurer, Date startDate, Date endDate) {
        this.id = id;
        this.merchantName = merchantName;
        this.merchantJurisdiction = merchantJurisdiction;
        this.insurer = insurer;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static RulesBuilder builder() {
        return new RulesBuilder();
    }

    public String getId() {
        return this.id;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public String getMerchantJurisdiction() {
        return this.merchantJurisdiction;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public void setMerchantJurisdiction(String merchantJurisdiction) {
        this.merchantJurisdiction = merchantJurisdiction;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getInsurer() {
        return insurer;
    }

    public void setInsurer(String insurer) {
        this.insurer = insurer;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Rules)) return false;
        final Rules other = (Rules) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.id;
        final Object other$id = other.id;
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$merchantName = this.merchantName;
        final Object other$merchantName = other.merchantName;
        if (this$merchantName == null ? other$merchantName != null : !this$merchantName.equals(other$merchantName))
            return false;
        final Object this$merchantJurisdiction = this.merchantJurisdiction;
        final Object other$merchantJurisdiction = other.merchantJurisdiction;
        if (this$merchantJurisdiction == null ? other$merchantJurisdiction != null : !this$merchantJurisdiction.equals(other$merchantJurisdiction))
            return false;
        final Object this$startDate = this.startDate;
        final Object other$startDate = other.startDate;
        if (this$startDate == null ? other$startDate != null : !this$startDate.equals(other$startDate)) return false;
        final Object this$endDate = this.endDate;
        final Object other$endDate = other.endDate;
        if (this$endDate == null ? other$endDate != null : !this$endDate.equals(other$endDate)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.id;
        result = result * PRIME + ($id == null ? 0 : $id.hashCode());
        final Object $merchantName = this.merchantName;
        result = result * PRIME + ($merchantName == null ? 0 : $merchantName.hashCode());
        final Object $merchantJurisdiction = this.merchantJurisdiction;
        result = result * PRIME + ($merchantJurisdiction == null ? 0 : $merchantJurisdiction.hashCode());
        final Object $startDate = this.startDate;
        result = result * PRIME + ($startDate == null ? 0 : $startDate.hashCode());
        final Object $endDate = this.endDate;
        result = result * PRIME + ($endDate == null ? 0 : $endDate.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Rules;
    }

    public String toString() {
        return "com.st.simple.bean.Rules(id=" + this.id + ", merchantName=" + this.merchantName + ", merchantJurisdiction=" + this.merchantJurisdiction + ", startDate=" + this.startDate + ", endDate=" + this.endDate + ")";
    }

    public static class RulesBuilder {
        private String id;
        private String merchantName;
        private String merchantJurisdiction;
        private String insurer;
        private Date startDate;
        private Date endDate;

        RulesBuilder() {
        }

        public Rules.RulesBuilder id(String id) {
            this.id = id;
            return this;
        }

        public Rules.RulesBuilder merchantName(String merchantName) {
            this.merchantName = merchantName;
            return this;
        }

        public Rules.RulesBuilder merchantJurisdiction(String merchantJurisdiction) {
            this.merchantJurisdiction = merchantJurisdiction;
            return this;
        }

        public Rules.RulesBuilder insurer(String insurer) {
            this.insurer = insurer;
            return this;
        }

        public Rules.RulesBuilder startDate(Date startDate) {
            this.startDate = startDate;
            return this;
        }

        public Rules.RulesBuilder endDate(Date endDate) {
            this.endDate = endDate;
            return this;
        }

        public Rules build() {
            return new Rules(id, merchantName, merchantJurisdiction, insurer, startDate, endDate);
        }

        public String toString() {
            return "com.st.simple.bean.Rules.RulesBuilder(id=" + this.id + ", merchantName=" + this.merchantName + ", merchantJurisdiction=" + this.merchantJurisdiction + ", insurer=" + this.insurer + ", startDate=" + this.startDate + ", endDate=" + this.endDate + ")";
        }
    }
}
