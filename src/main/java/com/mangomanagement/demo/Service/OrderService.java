package com.mangomanagement.demo.Service;

import com.mangomanagement.demo.Entity.OrderHistory;

import java.util.List;

public interface OrderService {
    public void save(OrderHistory order);

    public List<OrderHistory> findById(int userId);
}
