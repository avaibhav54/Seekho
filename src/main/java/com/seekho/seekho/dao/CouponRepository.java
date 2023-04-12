package com.seekho.seekho.dao;

import com.seekho.seekho.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;
@Repository
public interface CouponRepository extends JpaRepository<Coupon,Integer > {
    Coupon findByCode(String couponCode);

    @Transactional
    void deleteCouponByCode(String couponCode);
    @Transactional
    List<Coupon> findByIsPrivateFalse();
}
