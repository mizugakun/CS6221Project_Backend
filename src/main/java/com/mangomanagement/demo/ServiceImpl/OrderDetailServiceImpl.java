package com.mangomanagement.demo.ServiceImpl;

import com.mangomanagement.demo.Entity.OrderDetail;
import com.mangomanagement.demo.Service.OrderDetailService;
import com.mangomanagement.demo.dao.OrderDetailRepository;
import com.mangomanagement.demo.util.query.SearchCriteria;
import com.mangomanagement.demo.util.query.SpecificationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    OrderDetailRepository orderDetailRepository;

    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public void save(OrderDetail detail) {
        orderDetailRepository.save(detail);
    }

    @Override
    public List<OrderDetail> findById(int orderId) {
        String id = "" + orderId;
        SpecificationImpl<OrderDetail> sp = new SpecificationImpl(new SearchCriteria("orderId", "=", id));
        List<OrderDetail> list = orderDetailRepository.findAll(sp);
        return list;
    }

    @Override
    public List<OrderDetail> findByOrderAndItem(List<Integer> orderIds, int itemId) {
        return orderDetailRepository.findByOrdersAndItem(orderIds, itemId);
    }

    @Override
    public List<OrderDetail> findByUserAndItem(int userId, int itemId) {
        return orderDetailRepository.findByItemAndUser(userId, itemId);
    }

}
