package com.seekho.seekho.controller;

import com.seekho.seekho.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.seekho.seekho.service.CouponService;

@RestController
@RequestMapping("/coupon")
@CrossOrigin("*")
public class CouponController {
    @Autowired
    public CouponService couponService;
    @PostMapping("/")
    public ResponseEntity<?> addCoupon(@RequestBody Coupon coupon)
    {
        return ResponseEntity.ok(this.couponService.addCoupon(coupon));
    }
    @PutMapping("/")
    public ResponseEntity<?> updateCoupon(@RequestBody Coupon coupon)
    {
        return ResponseEntity.ok(this.couponService.updateCoupon(coupon));
    }

    @GetMapping("/")
    public ResponseEntity<?> getCoupons()
    {
        return ResponseEntity.ok(this.couponService.getCoupons());
    }
    @DeleteMapping("/{code}")
    public void deleteCoupon(@PathVariable("code") String code)
    {
        this.couponService.deleteCouponByCode(code);
    }
}
