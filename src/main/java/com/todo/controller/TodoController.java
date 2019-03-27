package com.todo.controller;


import com.todo.dto.ItemDto;
import com.todo.mapper.ItemMapper;
import com.todo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    ItemService itemService;

    @GetMapping("/addTodo/{contents}")
    public void create(@PathVariable String contents) {
        itemService.insert(new ItemDto(contents));
    }

}