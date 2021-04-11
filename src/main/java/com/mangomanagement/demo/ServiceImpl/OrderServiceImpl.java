package com.mangomanagement.demo.ServiceImpl;

import com.mangomanagement.demo.Entity.OrderHistory;
import com.mangomanagement.demo.Service.OrderService;
import com.mangomanagement.demo.dao.OrderHistoryRepository;
import com.mangomanagement.demo.util.query.SearchCriteria;
import com.mangomanagement.demo.util.query.SpecificationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderHistoryRepository orderRepository;

    public OrderServiceImpl(OrderHistoryRepository repository) {
        this.orderRepository = repository;
    }

    @Override
    public void save(OrderHistory order) {
        orderRepository.save(order);
    }

    @Override
    public List<OrderHistory> findByUserId(int userId) {
        String id = "" + userId;
        SpecificationImpl<OrderHistory> sp = new SpecificationImpl(new SearchCriteria("userId", "=", id));
        List<OrderHistory> res = orderRepository.findAll(sp);

        return res;
    }

    @Override
    public OrderHistory findByOrderId(int orderId) {
        Optional<OrderHistory> op =  orderRepository.findById(orderId);
        if (op.isPresent()) {
            return op.get();
        }

        throw new RuntimeException("no such order id: " + orderId);
    }

    @Override
    public Integer lastId() {
        return Integer.valueOf("" + orderRepository.count());
    }
}
