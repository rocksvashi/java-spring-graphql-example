package com.sa.graphql.datafetchers;

import com.google.gson.Gson;
import com.sa.graphql.domain.Todos;
import com.sa.graphql.domain.User;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
class TodosFetcher extends BaseFetcher<List<Todos>> {

    public String URI = "https://jsonplaceholder.typicode.com/todos?userId=%s";

    @Override
    public List<Todos> get(DataFetchingEnvironment env) {
        User user = env.getSource();
        try {
            Gson gson = new Gson();
            List<Todos> todos = gson.fromJson(client.get(String.format(URI, user.getId())), List.class);
            return todos;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
