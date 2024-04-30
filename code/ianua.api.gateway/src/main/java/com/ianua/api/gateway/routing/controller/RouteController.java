package com.ianua.api.gateway.routing.controller;

import com.ianua.api.gateway.configuration.administration.controller.ProjectController;
import com.ianua.api.gateway.configuration.administration.exception.ObjectNotFoundException;
import com.ianua.api.gateway.configuration.administration.manager.EndpointManager;
import com.ianua.api.gateway.configuration.administration.manager.ProjectManager;
import com.ianua.api.gateway.configuration.administration.manager.VersionManager;
import com.ianua.api.gateway.configuration.administration.model.Endpoint;
import com.ianua.api.gateway.configuration.administration.model.Project;
import com.ianua.api.gateway.routing.factory.RequestInfoFactory;
import com.ianua.api.gateway.routing.model.RequestInfo;
import com.ianua.api.gateway.routing.service.RoutingService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Optional;

@SpringBootApplication
@RestController
public class RouteController {
    private RoutingService routingService;

    public RouteController(RoutingService routingService) {
        this.routingService = routingService;
    }

    @GetMapping("/gateway/**")
    public String handleGatewayRequest(HttpServletRequest request) throws Exception {
        RequestInfo requestInfo = RequestInfoFactory.build(request);
        Endpoint endpoint = this.routingService.getEndpointFromRequestInfo(requestInfo);
        String completeUrl;
        String protocol;

        protocol = endpoint.isSecure() ? "https" : "http";
        completeUrl = protocol + "://" + endpoint.getDomain() + endpoint.getPath() + "?" + request.getQueryString();

        return RoutingService.route(
                completeUrl,
                requestInfo.getHeaders(),
                requestInfo.getMethod()
        );
    }
}
