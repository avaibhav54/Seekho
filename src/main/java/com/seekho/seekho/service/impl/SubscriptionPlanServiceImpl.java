package com.seekho.seekho.service.impl;

import com.seekho.seekho.exception.SeekhoException;
import com.seekho.seekho.model.AmPlanDetails;
import com.seekho.seekho.model.Coupon;
import com.seekho.seekho.model.SubscriptionPlan;
import com.seekho.seekho.model.User;
import com.seekho.seekho.service.CouponService;
import com.seekho.seekho.service.SubscriptionPlanService;
import com.seekho.seekho.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SubscriptionPlanServiceImpl implements SubscriptionPlanService {
    @Autowired
    private UserService userService;

    @Autowired
    private CouponService couponService;

    @Override
    public AmPlanDetails getUserPlanDetails(int userId, String couponCode) {
        User user = userService.getUserByUserID(userId);
        Coupon coupon = couponService.getCoupon(couponCode);
        SubscriptionPlan subscriptionPlan = user.getSubscriptionPlan();

        // Check if the coupon is valid for the user
        if(coupon!= null)
        {
            if (!checkCouponValidityForUser(coupon,user)) {
                throw new SeekhoException("coupon","Invalid Coupon Code");
            }
        }

AmPlanDetails amPlanDetails = new AmPlanDetails();
        amPlanDetails.setSubscriptionPlan(subscriptionPlan);
        List<Coupon> couponList = couponService.getPublicCoupons();
        List<String> couponCodes = new ArrayList<>();
        for(Coupon cpn:couponList)
        {
            couponCodes.add(cpn.getCode());
        }
        amPlanDetails.setPublicCoupons(couponCodes);
        int payablePrice = subscriptionPlan.getPrice();
        if(coupon!=null)
        {
            payablePrice-=coupon.getDiscountValue();
        }
        amPlanDetails.setPayablePrice(payablePrice);
        return amPlanDetails;
    }
    public Boolean checkCouponValidityForUser(Coupon coupon, User user)
    {
        Date currentDate = new Date();
        Date couponStartDate = coupon.getStartDate();
        Date couponEndDate = coupon.getEndDate();
        int couponValidityInDays = coupon.getValidityInDays();
        Instant creationTime = Instant.ofEpochMilli(user.getCreationTimeStamp().getTime());
        Instant now = Instant.now();

        Duration duration = Duration.between(creationTime, now);
        long days = duration.toDays();
        if (couponStartDate.compareTo(currentDate) > 0 || couponEndDate.compareTo(currentDate) < 0
                || days > couponValidityInDays) {
            return false;
        }
        return true;
    }
}
