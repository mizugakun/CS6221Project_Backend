package com.mangomanagement.demo.Service;

import com.mangomanagement.demo.Entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    public void save(OrderDetail detail);

    public List<OrderDetail> findById(int orderId);

    public List<OrderDetail> findByOrderAndItem(List<Integer> orderIds, int itemId);

    public List<OrderDetail> findByUserAndItem(int userId, int itemId);
}
