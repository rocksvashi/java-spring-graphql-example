package com.sa.graphql.domain;

import lombok.Data;

@Data
public class Todos {
    int id;
    String title;
    Boolean completed;
}
