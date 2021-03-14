package com.mangomanagement.demo.dao;

import com.mangomanagement.demo.Entity.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Integer>, JpaSpecificationExecutor<OrderHistory> {

}