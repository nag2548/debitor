package de.nag2548.debitor.server;

import java.util.Set;

import io.smallrye.jwt.build.Jwt;

public class TestUtils {
    public static String getAccessToken(String userName, Set<String> groups) {
        return Jwt.preferredUserName(userName)
                .groups(groups)
                .issuer("https://server.example.com")
                .audience("https://service.example.com")
                .sign();
    }

    public static String buildGraphQLBody(String query) {
        return String.format("""
                {
                    "query": "%s"
                }
                """, query);
    }

    private TestUtils() {
        //
    }
}
