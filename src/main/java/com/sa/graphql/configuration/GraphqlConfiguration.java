package com.sa.graphql.configuration;

import com.sa.graphql.datafetchers.FetcherFactory;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

import static graphql.GraphQL.newGraphQL;
import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;

@Component
public class GraphqlConfiguration {

    @Value("classpath:schemas.graphqls")
    private Resource schemaResource;

    private FetcherFactory fetcherFactory;

    @Autowired
    GraphqlConfiguration(FetcherFactory fetcherFactory) throws IOException {
        this.fetcherFactory = fetcherFactory;
    }

    @PostConstruct
    public GraphQL createGraphQlObject() throws IOException {
        File schemas = schemaResource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemas);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);


        /*GraphQLObjectType reviewType = newObject()
                .name("createType")
                .field(newFieldDefinition()
                        .name("name")
                        .type(Scalars.GraphQLString))
                .field(newFieldDefinition()
                        .name("age")
                        .type(Scalars.GraphQLInt))
                .field(newFieldDefinition()
                        .name("id")
                        .type(Scalars.GraphQLString))
                .field(newFieldDefinition()
                        .name("nationality")
                        .type(Scalars.GraphQLString))
                .build();*/

        /*
        GraphQLObjectType.Builder Crud = GraphQLObjectType.newObject()
                .name("Crud")
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("create")
                        .type(reviewType)
                        .argument(GraphQLArgument.newArgument()
                                .name("name")
                                .type(Scalars.GraphQLString))
                        .argument(GraphQLArgument.newArgument()
                                .name("age")
                                .type(Scalars.GraphQLInt))
                        .argument(GraphQLArgument.newArgument()
                                .name("nationality")
                                .type(Scalars.GraphQLString))
                        .dataFetcher(userCreateData)
                        .build());*/


        return newGraphQL(GraphQLSchema.newSchema().query(schema.getQueryType()).build()).build();
    }


    public RuntimeWiring buildRuntimeWiring() {
        return newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("posts", fetcherFactory.getPostsFetcher())
                        .dataFetcher("post", fetcherFactory.getPostFetcher())
                        .dataFetcher("user", fetcherFactory.getUserFetcher())
                        .dataFetcher("user", fetcherFactory.getUserFetcher())
                ).type("Post", typeWiring -> typeWiring
                        .dataFetcher("comments", fetcherFactory.getCommentsByUser()))

                .type("User", typeWiring -> typeWiring
                        .dataFetcher("albums", fetcherFactory.getAlbumsByUser())
                        .dataFetcher("photos", fetcherFactory.getPhotosByAlbum())
                        .dataFetcher("todos", fetcherFactory.getTodosFetcher())
                )
                .type("Album", typeWiring -> typeWiring
                        .dataFetcher("photos", fetcherFactory.getPhotosByAlbum()))
                .build();
    }
}
