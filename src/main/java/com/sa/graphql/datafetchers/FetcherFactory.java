package com.sa.graphql.datafetchers;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class FetcherFactory {

    @Autowired
    private PostFetcher postFetcher;
    @Autowired
    private PostsFetcher postsFetcher;
    @Autowired
    private CommentsByUser commentsByUser;
    @Autowired
    private UserFetcher userFetcher;
    @Autowired
    private UsersFetcher usersFetcher;
    @Autowired
    private AlbumsByUser albumsByUser;

    @Autowired
    private TodosFetcher todosFetcher;
    @Autowired
    private PhotosByAlbum photosByAlbum;

}
