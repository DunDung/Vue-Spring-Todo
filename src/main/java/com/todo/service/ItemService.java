package com.todo.service;

import com.todo.dto.ItemDto;

import java.util.List;

public interface ItemService {
    void insert(ItemDto itemDto);
    List<ItemDto> findAll();
    void deleteOne(int id);
    void deleteAll();
    String findOne(int id);
    int size();
    void update(int id, String contents);
}
