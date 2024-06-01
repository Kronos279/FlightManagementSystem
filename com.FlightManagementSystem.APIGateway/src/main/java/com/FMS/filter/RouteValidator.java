package com.FMS.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.*;
import java.util.function.Predicate;

@Component
@CrossOrigin
public class RouteValidator {

    public static final List<String> openApiEndpoints = List.of(
            "/auth",
            "auth/api/swagger-ui/index.html",
            "/eureka",
            "/search/api/v3/api-docs",
            "/flightdetails/api/v3/api-docs",
            "/booking/api/v3/api-docs",
            "/checkin/api/v3/api-docs",
            "/auth/api/v3/api-docs",
            "/search"
    );

    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));

}