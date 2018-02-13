package com.sa.graphql.domain;

import lombok.Data;

@Data
public class Photo {
    int albumId;
    int id;
    String title;
    String url;
    String thumbnail;
}
