package com.example.baggagev1.components.resolvers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;

@DgsComponent
public class HelloFetcher {
    @DgsQuery
    public String hello() {
        return "Hello, world!";
    }
}
