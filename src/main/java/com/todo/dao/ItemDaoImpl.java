package com.todo.dao;

import com.todo.dto.ItemDto;
import com.todo.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDaoImpl implements ItemDao {
    @Autowired
    ItemMapper itemMapper;

    @Override
    public void insert(ItemDto itemDto) {
        itemMapper.insert(itemDto);
    }
}
