package com.sa.graphql.domain;

import lombok.Data;

@Data
public class Comment {
    int postId;
    int id;
    String name;
    String email;
    String body;
}
