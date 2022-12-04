package de.nag2548.debitor.server.graphql;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import java.util.Set;

import org.junit.jupiter.api.Test;

import de.nag2548.debitor.server.TestUtils;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.oidc.server.OidcWiremockTestResource;

@QuarkusTest
@QuarkusTestResource(OidcWiremockTestResource.class)
public class TestResourceTests {
    @Test
    void test() {
        String query = """
                {
                    hello
                }
                """;

        given()
                .auth().oauth2(TestUtils.getAccessToken("Heinzi", Set.of("user")))
                .body(TestUtils.buildGraphQLBody(query))
                .when()
                .post("/graphql")
                .then()
                .statusCode(200)
                .body("data.hello", is("hello"));
    }
}
