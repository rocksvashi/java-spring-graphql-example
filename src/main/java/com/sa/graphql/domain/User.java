package com.sa.graphql.domain;

import lombok.Data;

import java.util.List;

@Data
public class User {
    int id;
    String name;
    String username;
    String email;
    String phone;
    String website;
    Company company;
    List<String> albumsIds;
    List<String> todosIds;

}
