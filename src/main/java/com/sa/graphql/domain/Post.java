package com.sa.graphql.domain;

import lombok.Data;

import java.util.List;

@Data
public class Post {
    int userId;
    int id;
    String title;
    String body;
    List<String> commentsIds;
}
