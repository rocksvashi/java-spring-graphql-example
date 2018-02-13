package com.sa.graphql.domain;

import lombok.Data;

import java.util.List;

@Data
public class Album {
    int userId;
    int id;
    String title;
    List<String> photosIds;
}
