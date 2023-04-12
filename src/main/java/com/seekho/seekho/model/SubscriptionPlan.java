package com.seekho.seekho.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SubscriptionPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int price;
    private  int validityInDays;

    @OneToMany(mappedBy = "subscriptionPlan",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<User> users = new ArrayList<>();

//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "subscriptionPlan")

    public int getId() {
        return id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
//    @JsonIgnore
//    private List<CouponSubscriptionPlan> couponSubscriptionPlans = new ArrayList<>();
//    public int getId() {
//        return id;
//    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getValidityInDays() {
        return validityInDays;
    }

    public void setValidityInDays(int validityInDays) {
        this.validityInDays = validityInDays;
    }

//    public List<CouponSubscriptionPlan> getCouponsubscriptionPlans() {
//        return couponSubscriptionPlans;
//    }
//
//    public void setCouponsubscriptionPlans(List<CouponSubscriptionPlan> couponsubscriptionPlans) {
//        this.couponSubscriptionPlans = couponsubscriptionPlans;
//    }

}
