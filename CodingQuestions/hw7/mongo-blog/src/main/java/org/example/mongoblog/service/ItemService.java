package org.example.mongoblog.service;

import org.example.mongoblog.dao.ItemRepository;
import org.example.mongoblog.entity.GroceryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void addItem(GroceryItem item) {
        itemRepository.save(item);
    }
}
