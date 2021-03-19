package com.mangomanagement.demo.Service;

import com.mangomanagement.demo.Entity.Item;

public interface ItemService {
    public void save(Item item);

    public Item findById(int id);
}
