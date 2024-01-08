package com.example.mongoblog.service.impl;

import com.example.mongoblog.DAO.ItemRepository;
import com.example.mongoblog.entity.GroceryItem;
import com.example.mongoblog.payload.GroceryItemDto;
import com.example.mongoblog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private ItemRepository itemRepository;

    @Autowired
    public PostServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    @Override
    public GroceryItemDto createPost(GroceryItemDto postDto) {
        GroceryItem tobeSaved = new GroceryItem();
        tobeSaved.setId(postDto.getId());
        tobeSaved.setName(postDto.getName());
        tobeSaved.setCategory(postDto.getCategory());
        tobeSaved.setQuantity(postDto.getQuantity());

        GroceryItem saved = itemRepository.save(tobeSaved);

        GroceryItemDto response = new GroceryItemDto();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setCategory(saved.getCategory());
        response.setQuantity(saved.getQuantity());
        return response;
    }
}
