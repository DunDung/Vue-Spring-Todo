package com.todo.dto;


public class ItemDto {
    int id;
    String contents;

    public ItemDto(String contents){
        this.contents = contents;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
