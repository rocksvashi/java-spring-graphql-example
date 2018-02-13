package com.sa.graphql.datafetchers;

import com.google.gson.Gson;
import com.sa.graphql.datafetchers.BaseFetcher;
import com.sa.graphql.domain.User;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
class UserFetcher extends BaseFetcher<User> {

    public String URI = "https://jsonplaceholder.typicode.com/users/%s";

    @Override
    public User get(DataFetchingEnvironment env) {
        Map args = env.getArguments();
        try {
            Gson gson = new Gson();
            User users = gson.fromJson(client.get(String.format(URI, args.get("id"))), User.class);
            return users;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
