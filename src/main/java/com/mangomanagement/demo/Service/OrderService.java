package com.mangomanagement.demo.Service;

import com.mangomanagement.demo.Entity.OrderHistory;

import java.util.List;

public interface OrderService {
    public void save(OrderHistory order);

    public List<OrderHistory> findByUserId(int userId);

    public OrderHistory findByOrderId(int orderId);

    public Integer lastId();
}
