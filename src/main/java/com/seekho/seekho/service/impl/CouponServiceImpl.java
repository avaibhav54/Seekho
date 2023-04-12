package com.seekho.seekho.service.impl;

import com.seekho.seekho.exception.SeekhoException;
import com.seekho.seekho.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.seekho.seekho.dao.CouponRepository;
import com.seekho.seekho.model.Coupon;

import java.util.List;


@Service
public class CouponServiceImpl implements CouponService {
    @Autowired
    public CouponRepository couponRepository;

    public boolean validateCoupon(Coupon coupon) {
        if (!validateCouponCode(coupon.getCode())) {
            throw new SeekhoException("code","Invalid Coupon Code. Must be 6 digits alpha numeric");
        }

        if (coupon.getStartDate().compareTo(coupon.getEndDate())>0) {
            throw new SeekhoException("startDate and endDate","Start date cannot be after end date");
        }
        // If all checks pass, the coupon is valid
        return true;
    }

    public boolean validateCouponCode(String couponCode) {
        if (couponCode.length() != 6) {
            return false;
        }
        // Check if the coupon code contains only alphanumeric characters
        for (int i = 0; i < couponCode.length(); i++) {
            char c = couponCode.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }
        //Check if coupon code exists in db.
        List<Coupon> existingCoupons = getCoupons();
        for(Coupon coupon:existingCoupons)
        {
            if(coupon.getCode().equals(couponCode))
            {
                throw new SeekhoException("code","Coupon Already Exists");
            }
        }
        return true;
    }

    @Override
    public Coupon addCoupon(Coupon coupon) {
        if(validateCoupon(coupon))
        {return this.couponRepository.save(coupon);}
        else return null;
    }

    @Override
    public Coupon updateCoupon(Coupon coupon) {
        return this.couponRepository.save(coupon);
    }

    @Override
    public Coupon getCoupon(String code) {
        return this.couponRepository.findByCode(code);
    }

    @Override
    public List<Coupon> getCoupons() {
        return this.couponRepository.findAll();
    }

    @Override
    public List<Coupon> getPublicCoupons() {
        return this.couponRepository.findByIsPrivateFalse();
    }

    @Override
    public void deleteCouponByCode(String code) {
        try {
            this.couponRepository.deleteCouponByCode(code);
        }catch (Exception e)
        {
            throw new SeekhoException("code","This Coupon Does not exist");
        }
    }
}
