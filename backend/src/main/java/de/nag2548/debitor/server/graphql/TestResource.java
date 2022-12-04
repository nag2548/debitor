package de.nag2548.debitor.server.graphql;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import io.quarkus.security.Authenticated;
import io.vertx.core.cli.annotations.Description;

@GraphQLApi
@Authenticated
public class TestResource {
    @Query
    @Description("Test endpoint")
    public String hello() {
        return "hello";
    }
}
