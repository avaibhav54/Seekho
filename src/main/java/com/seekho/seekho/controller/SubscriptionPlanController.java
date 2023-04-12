package com.seekho.seekho.controller;

import com.seekho.seekho.dao.UserRepository;
import com.seekho.seekho.model.Coupon;
import com.seekho.seekho.model.SubscriptionPlan;
import com.seekho.seekho.model.User;
import com.seekho.seekho.service.CouponService;
import com.seekho.seekho.service.SubscriptionPlanService;
import com.seekho.seekho.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/subscription")
@CrossOrigin("*")
public class SubscriptionPlanController {
    @Autowired
    private SubscriptionPlanService subscriptionPlanService;

    @Autowired
    private UserService userService;

    @Autowired
    private CouponService couponService;

    @GetMapping("/user-plan/details/")
    public ResponseEntity<?> getUserPlanDetails(@RequestParam int userId, @RequestParam(required = false) String couponCode) {


        return ResponseEntity.ok(this.subscriptionPlanService.getUserPlanDetails(userId,couponCode));
    }


}
