package com.todo.dao;

import com.todo.dto.ItemDto;
import com.todo.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDaoImpl implements ItemDao {
    @Autowired
    ItemMapper itemMapper;

    @Override
    public void insert(ItemDto itemDto) {
        itemMapper.insert(itemDto);
    }

    @Override
    public List<ItemDto> findAll(){
        return itemMapper.findAll();
    }

    @Override
    public void deleteOne(int id) {
        itemMapper.deleteOne(id);
    }
    @Override
    public void deleteAll() {
        itemMapper.deleteAll();
    }

    @Override
    public String findOne(int id) {
        return itemMapper.findOne(id);
    }

    @Override
    public int size() {
        return itemMapper.size();
    }
}
