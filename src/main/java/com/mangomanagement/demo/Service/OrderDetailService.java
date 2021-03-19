package com.mangomanagement.demo.Service;

import com.mangomanagement.demo.Entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    public void save(OrderDetail detail);

    public List<OrderDetail> findById(int orderId);

}
