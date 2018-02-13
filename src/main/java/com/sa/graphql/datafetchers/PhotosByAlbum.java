package com.sa.graphql.datafetchers;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.sa.graphql.domain.Photo;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
class PhotosByAlbum extends BaseFetcher<List<Photo>> {

    public String URI = "https://jsonplaceholder.typicode.com/photos?albumId=%s";

    @Override
    public List<Photo> get(DataFetchingEnvironment env) {
        LinkedTreeMap map = (LinkedTreeMap) env.getSource(); //Hack, Not sure why I cant gey parent object, its failing on com.google.gson.internal.LinkedHashTreeMap cannot be cast to Album
        try {
            Gson gson = new Gson();
            List<Photo> photos = gson.fromJson(client.get(String.format(URI, ((Double) map.get("id")).intValue())), List.class);
            return (photos == null ? new ArrayList<>() : photos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Arrays.asList();
    }
}
