package com.mangomanagement.demo.dao;

import com.mangomanagement.demo.Entity.OrderDetail;
import com.mangomanagement.demo.Entity.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId>, JpaSpecificationExecutor<OrderDetail> {

    @Query(value = "SELECT od FROM OrderDetail od " +
            "WHERE od.orderId IN :orderIds AND od.itemId = :itemId " +
            "ORDER BY od.orderId ASC")
    List<OrderDetail> findByOrdersAndItem(@Param("orderIds") List<Integer> orderIds, @Param("itemId") int itemId);

    @Query(value = "SELECT od " +
            "FROM OrderDetail od JOIN OrderHistory oh ON " +
            "od.orderId = oh.orderId AND oh.userId = :userId " +
            "WHERE od.itemId = :itemId " +
            "ORDER BY od.orderId ASC")
    List<OrderDetail> findByItemAndUser(@Param("userId") int userId, @Param("itemId") int itemId);
}