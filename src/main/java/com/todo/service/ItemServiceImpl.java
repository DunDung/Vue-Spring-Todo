package com.todo.service;

import com.todo.dao.ItemDao;
import com.todo.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemDao itemDao;

    @Override
    public void insert(ItemDto itemDto){
        itemDao.insert(itemDto);
    }

    @Override
    public List<ItemDto> findAll(){
        return itemDao.findAll();
    }
    @Override
    public void deleteOne(int id) {
        itemDao.deleteOne(id);
    }
}
