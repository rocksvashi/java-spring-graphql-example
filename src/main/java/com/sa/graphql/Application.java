package com.sa.graphql;

import com.sa.graphql.configuration.GraphqlConfiguration;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public GraphQL graphQL(@Autowired GraphqlConfiguration graphqlConfiguration) throws IOException {
        return graphqlConfiguration.createGraphQlObject();
    }
}
