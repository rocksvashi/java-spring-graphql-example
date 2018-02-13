package com.sa.graphql.controllers;

import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Api {

    private GraphQL graphQL;

    @Autowired
    Api(GraphQL graphQL) throws IOException {
        this.graphQL = graphQL;
    }

    @PostMapping(value = "/query")
    public ResponseEntity query(@RequestBody String query) {
        ExecutionResult result = graphQL.execute(query);
        System.out.println("errors: " + result.getErrors());
        return ResponseEntity.ok(result.getData());
    }

    @PostMapping(value = "/mutation")
    public ResponseEntity mutation(@RequestBody String query) {
        ExecutionResult result = graphQL.execute(query);
        System.out.println("errors: " + result.getErrors());
        return ResponseEntity.ok(result.getData());
    }
}
