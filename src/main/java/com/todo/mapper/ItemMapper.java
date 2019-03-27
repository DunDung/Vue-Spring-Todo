package com.todo.mapper;

import com.todo.dto.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    void insert(Item item);
    List<Item> findAll();
}

