package com.sa.graphql.datafetchers;

import com.google.gson.Gson;
import com.sa.graphql.datafetchers.BaseFetcher;
import com.sa.graphql.domain.User;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
class UsersFetcher extends BaseFetcher<List<User>> {

    public String URI = "https://jsonplaceholder.typicode.com/users";

    @Override
    public List<User> get(DataFetchingEnvironment env) {
        try {
            Gson gson = new Gson();
            List<User> users = gson.fromJson(client.get(URI), List.class);
            return users;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
