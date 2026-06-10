package com.example.demo.user.dto;

//Data which should be send to response will be managed here
public class UserDTO {

    private Integer id;
    private String name;

    public UserDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
