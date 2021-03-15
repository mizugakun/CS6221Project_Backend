package com.mangomanagement.demo.dao;

import com.mangomanagement.demo.Entity.OrderDetailId;
import com.mangomanagement.demo.Entity.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, OrderDetailId>, JpaSpecificationExecutor<OrderHistory> {

}