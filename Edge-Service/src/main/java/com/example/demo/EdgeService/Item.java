package com.example.demo.EdgeService;

import lombok.Data;

@Data
public class Item {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
