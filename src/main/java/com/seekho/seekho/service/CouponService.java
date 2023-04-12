package com.seekho.seekho.service;


import com.seekho.seekho.model.Coupon;

import java.util.List;

public interface CouponService {
    public Coupon addCoupon(Coupon coupon);
    public Coupon updateCoupon(Coupon coupon);
    public Coupon getCoupon(String code);
    public List<Coupon> getCoupons();
    public List<Coupon> getPublicCoupons();
    public void deleteCouponByCode(String code);
}
