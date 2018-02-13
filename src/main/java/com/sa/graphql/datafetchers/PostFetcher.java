package com.sa.graphql.datafetchers;

import com.google.gson.Gson;
import com.sa.graphql.datafetchers.BaseFetcher;
import com.sa.graphql.domain.Post;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
class PostFetcher extends BaseFetcher<Post> {

    public String URI = "https://jsonplaceholder.typicode.com/posts";

    @Override
    public Post get(DataFetchingEnvironment env) {
        Map args = env.getArguments();
        try {
            Gson gson = new Gson();
            Post posts = gson.fromJson(client.get(URI + "/" + args.getOrDefault("id", "")), Post.class);
            return posts;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
