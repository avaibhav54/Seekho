package com.seekho.seekho.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    // we can add password also but it is asked not to consider authentication and authorization so dropping.
    @CreationTimestamp
    private Date creationTimeStamp;
    @UpdateTimestamp
    private Date updateTimeStamp;

    @ManyToOne(fetch = FetchType.EAGER)
    private SubscriptionPlan subscriptionPlan;

    public SubscriptionPlan getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public void setSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreationTimeStamp() {
        return creationTimeStamp;
    }

    public void setCreationTimeStamp(Date creationTimeStamp) {
        this.creationTimeStamp = creationTimeStamp;
    }

    public Date getUpdateTimeStamp() {
        return updateTimeStamp;
    }

    public void setUpdateTimeStamp(Date updateTimeStamp) {
        this.updateTimeStamp = updateTimeStamp;
    }

    public User(int id, String name, String email, Date creationTimeStamp, Date updateTimeStamp) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.creationTimeStamp = creationTimeStamp;
        this.updateTimeStamp = updateTimeStamp;
    }

    public User(String name, String email, Date creationTimeStamp, Date updateTimeStamp) {
        this.name = name;
        this.email = email;
        this.creationTimeStamp = creationTimeStamp;
        this.updateTimeStamp = updateTimeStamp;
    }
}
