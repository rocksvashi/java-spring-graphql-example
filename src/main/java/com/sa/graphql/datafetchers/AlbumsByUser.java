package com.sa.graphql.datafetchers;

import com.google.gson.Gson;
import com.sa.graphql.datafetchers.BaseFetcher;
import com.sa.graphql.domain.Album;
import com.sa.graphql.domain.User;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
class AlbumsByUser extends BaseFetcher<List<Album>> {

    public String URI = "https://jsonplaceholder.typicode.com/albums?userId=%s";

    @Override
    public List<Album> get(DataFetchingEnvironment env) {
        User user = env.getSource();
        try {
            Gson gson = new Gson();
            List<Album> albums = gson.fromJson(client.get(String.format(URI, user.getId())), List.class);
            return albums;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
