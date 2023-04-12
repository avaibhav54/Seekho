package com.seekho.seekho.model;

import java.util.*;
public class AmPlanDetails {
    private SubscriptionPlan subscriptionPlan;
    private List<String> publicCoupons;

    private  int payablePrice;

    public int getPayablePrice() {
        return payablePrice;
    }

    public void setPayablePrice(int payablePrice) {
        this.payablePrice = payablePrice;
    }

    public SubscriptionPlan getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public void setSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }

    public List<String> getPublicCoupons() {
        return publicCoupons;
    }

    public void setPublicCoupons(List<String> publicCoupons) {
        this.publicCoupons = publicCoupons;
    }
}
