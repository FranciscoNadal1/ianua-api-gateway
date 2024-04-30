package com.ianua.api.gateway.routing.service;

import com.ianua.api.gateway.configuration.administration.exception.ObjectNotFoundException;
import com.ianua.api.gateway.configuration.administration.manager.EndpointManager;
import com.ianua.api.gateway.configuration.administration.manager.ProjectManager;
import com.ianua.api.gateway.configuration.administration.model.Endpoint;
import com.ianua.api.gateway.configuration.administration.model.Project;
import com.ianua.api.gateway.routing.model.RequestInfo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

public class RoutingService {
    private EndpointManager endpointManager;
    private ProjectManager projectManager;

    public RoutingService(EndpointManager endpointManager, ProjectManager projectManager) {
        this.endpointManager = endpointManager;
        this.projectManager = projectManager;
    }

    public Endpoint getEndpointFromRequestInfo(RequestInfo requestInfo) {
        Project project = this.projectManager.findByName(requestInfo.getProject()).orElse(null);

        String version = requestInfo.getVersion();

        if (project == null) {
            throw new ObjectNotFoundException();
        }

        Endpoint endpoint = this.endpointManager.findByProjectIdAndVersionAndPath(
                project.getId(),
                Integer.parseInt(version.substring(1)),
                '/' + requestInfo.getPath()
        ).orElse(null);

        if (endpoint == null) {
            throw new ObjectNotFoundException();
        }
        return endpoint;
    }

    public static String route(String apiUrl, Map<String, String> headers, HttpMethod method) {
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> requestEntity = new HttpEntity<>(null, getHttpHeaders(headers));
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, method, requestEntity, String.class);

        return responseEntity.getBody();
    }

    private static HttpHeaders getHttpHeaders(Map<String, String> headers) {
        HttpHeaders httpHeaders = new HttpHeaders();

        for (Map.Entry<String, String> header : headers.entrySet()) {
            String key = header.getKey();
            String value = header.getValue();
            httpHeaders.set(key, value);
        }

        return httpHeaders;
    }
}
