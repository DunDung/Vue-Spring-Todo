package com.todo.controller;


import com.todo.dto.ItemDto;
import com.todo.mapper.ItemMapper;
import com.todo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    ItemService itemService;

    @GetMapping("/addTodo/{contents}")
    public void addTodo(@PathVariable String contents) {
        itemService.insert(new ItemDto(contents));
    }

    @GetMapping("/list")
    public List<ItemDto> findAll() {
        return itemService.findAll();
    }
    @GetMapping("/size")
    public int size() {
        return itemService.size();
    }
    @GetMapping("/findOne/{id}")
    public String findOne(@PathVariable int id){
        return itemService.findOne(id);
    }

    @GetMapping("/delete/{id}")
    public void deleteOne(@PathVariable int id) {
        itemService.deleteOne(id);
    }

    @GetMapping("/deleteAll")
    public void deleteAll() {
        itemService.deleteAll();
    }


}