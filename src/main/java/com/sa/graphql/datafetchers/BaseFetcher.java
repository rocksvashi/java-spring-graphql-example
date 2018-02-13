package com.sa.graphql.datafetchers;

import com.sa.graphql.datasource.DataClient;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseFetcher<T> implements DataFetcher<T> {

    @Autowired
    protected DataClient client;

}
