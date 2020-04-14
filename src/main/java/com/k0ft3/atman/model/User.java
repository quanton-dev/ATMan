package com.k0ft3.atman.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document(collection = "Users")
@Data
@AllArgsConstructor
public class User {

    private String id;
    private String userName;
    private String name;
    private String surname;
    private String email;
    // Projects id's that we are in and currently in system
    private List<String> processIdList = new ArrayList<>();

    public User(String userName, String name, String surname, String email, List<String> processIdList) {
        this.userName = userName;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.processIdList = processIdList;
    }

}