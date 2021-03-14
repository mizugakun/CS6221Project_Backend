package com.mangomanagement.demo.Service;

import com.mangomanagement.demo.Entity.User;

public interface UserService {
    public User findById(int Id);

    public User findByAccount(String account);

    public void save(User user);

    public void deleteById(int theId);

}
