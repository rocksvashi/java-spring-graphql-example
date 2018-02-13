package com.sa.graphql.datafetchers;

import com.google.gson.Gson;
import com.sa.graphql.datafetchers.BaseFetcher;
import com.sa.graphql.domain.Comment;
import com.sa.graphql.domain.Post;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
class CommentsByUser extends BaseFetcher<List<Comment>> {

    public String URI = "https://jsonplaceholder.typicode.com/posts/%s/comments";

    @Override
    public List<Comment> get(DataFetchingEnvironment env) {
        Post post = env.getSource();
        try {
            Gson gson = new Gson();
            List<Comment> comments = gson.fromJson(client.get(String.format(URI, post.getId())), List.class);
            return comments;
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
