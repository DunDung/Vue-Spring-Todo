package com.todo.controller;


import com.todo.dto.Item;
import com.todo.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    ItemMapper itemMapper;

    @GetMapping("/addTodo/{contents}")
    public void create(@PathVariable String contents) {
        Item a_Item = new Item();
        a_Item.setContents(contents);
        itemMapper.insert(a_Item);
    }

}