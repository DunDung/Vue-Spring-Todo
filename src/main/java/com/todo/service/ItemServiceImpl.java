package com.todo.service;

import com.todo.dao.ItemDao;
import com.todo.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemDao itemDao;

    @Override
    public void insert(ItemDto itemDto){
        itemDao.insert(itemDto);
    }

}
