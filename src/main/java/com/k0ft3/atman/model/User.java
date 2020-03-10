package com.k0ft3.atman.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "Users")
@Data
public class User {

    private String id;
    private String userName;
    private String name;
    private String surname;
    private String email;
    // Projects id's that we are in
    private List<String> groupList = new ArrayList<>();
}