package com.sa.graphql.datafetchers;

import com.google.gson.Gson;
import com.sa.graphql.datafetchers.BaseFetcher;
import com.sa.graphql.domain.Post;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
class PostsFetcher extends BaseFetcher<List<Post>> {

    public String URI = "https://jsonplaceholder.typicode.com/posts";

    @Override
    public List<Post> get(DataFetchingEnvironment env) {
        Map args = env.getArguments();
        try {
            Gson gson = new Gson();
            List<Post> posts = gson.fromJson(client.get(URI), List.class);
            return posts;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
