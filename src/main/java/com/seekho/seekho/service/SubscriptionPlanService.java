package com.seekho.seekho.service;

import com.seekho.seekho.model.AmPlanDetails;

public interface SubscriptionPlanService {
    public AmPlanDetails getUserPlanDetails(int userId, String couponCode);
}
