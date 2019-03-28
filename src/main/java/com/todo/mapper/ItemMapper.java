package com.todo.mapper;

import com.todo.dto.ItemDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ItemMapper {
    void insert(ItemDto item);
    List<ItemDto> findAll();
    void deleteOne(int id);
    void deleteAll();
    String findOne(int id);
    int size();
}

