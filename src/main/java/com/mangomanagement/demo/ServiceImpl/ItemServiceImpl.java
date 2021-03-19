package com.mangomanagement.demo.ServiceImpl;

import com.mangomanagement.demo.Entity.Item;
import com.mangomanagement.demo.Service.ItemService;
import com.mangomanagement.demo.dao.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Override
    public Item findById(int id) {
        Optional<Item> optional = itemRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }

        throw new RuntimeException("No item id:" + id);
    }
}
