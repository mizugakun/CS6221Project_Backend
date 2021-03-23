package com.mangomanagement.demo.ServiceImpl;

import com.mangomanagement.demo.Entity.User;
import com.mangomanagement.demo.Service.UserService;
import com.mangomanagement.demo.dao.UserRepository;
import com.mangomanagement.demo.util.query.SearchCriteria;
import com.mangomanagement.demo.util.query.SpecificationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByAccount(String account) {
        SpecificationImpl<User> sp = new SpecificationImpl(new SearchCriteria("userAccount", "=", account));
        Optional<User> res = userRepository.findOne(sp);
        if (res.isPresent()) {
            return res.get();
        }

        throw new RuntimeException("No such User Account: " + account);
    }

    @Override
    public User findById(int userId) {
        Optional<User> res = userRepository.findById(userId);
        if (res.isPresent()) {
            return res.get();
        }

        throw new RuntimeException("No such User Id: " + userId);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(int userId) {
        Optional<User> res = userRepository.findById(userId);
        if (res.isPresent()) {
            userRepository.deleteById(userId);
        }
        throw new RuntimeException("No such User Id: " + userId);
    }
}


