package com.seekho.seekho.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import java.util.Date;

@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String code;
    private Date startDate;
    private Date endDate;
    private int validityInDays;// validity from the signup
    @JsonProperty("isPrivate")
    private Boolean isPrivate;

    @Enumerated(EnumType.STRING)
    private DISCOUNT_TYPE discountType;

    private  int discountValue;

//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "coupon")
//    @JsonIgnore
//    private List<CouponSubscriptionPlan> couponSubscriptionPlans = new ArrayList<>();

    public Boolean getPrivate() {
        return isPrivate;
    }

//    public List<CouponSubscriptionPlan> getCouponSubscriptionPlans() {
//        return couponSubscriptionPlans;
//    }
//
//    public void setCouponSubscriptionPlans(List<CouponSubscriptionPlan> couponSubscriptionPlans) {
//        this.couponSubscriptionPlans = couponSubscriptionPlans;
//    }

    public Coupon(String code, Date startDate, Date endDate, int validityInDays, Boolean isPrivate, String discountType, int discountValues) {
        this.code = code;
        this.startDate = startDate;
        this.endDate = endDate;
        this.validityInDays = validityInDays;
        this.isPrivate = isPrivate;
        this.discountType = DISCOUNT_TYPE.valueOf(discountType);
        this.discountValue = discountValues;
    }

    public DISCOUNT_TYPE getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DISCOUNT_TYPE discountType) {
        this.discountType = discountType;
    }

    public int getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(int discountValues) {
        this.discountValue = discountValues;
    }

    public int getValidityInDays() {
        return validityInDays;
    }
    public void setValidityInDays(int validityInDays) {
        this.validityInDays = validityInDays;
    }
    public boolean isPrivate() {
        return isPrivate;
    }
    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String couponCode) {
        this.code = couponCode;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public Coupon() {

    }
    public Coupon(String couponCode, Date startDate, Date endDate, int validityInDays, boolean isPrivate) {
        this.code = couponCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.validityInDays = validityInDays;
        this.isPrivate = isPrivate;
    }
}
