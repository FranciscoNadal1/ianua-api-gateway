package com.ianua.api.gateway.configuration.administration.controller;

import com.ianua.api.gateway.configuration.administration.exception.ObjectNotFoundException;
import com.ianua.api.gateway.configuration.administration.exception.SerializationException;
import com.ianua.api.gateway.configuration.administration.manager.EndpointManager;
import com.ianua.api.gateway.configuration.administration.model.Endpoint;
import com.ianua.api.gateway.helper.JsonHelper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/projects/{projectId}/versions/{version}/endpoints")
public class EndpointController {

    private EndpointManager endpointManager;

    public EndpointController(EndpointManager endpointManager) {
        this.endpointManager = endpointManager;
    }

    @GetMapping
    public String list(@PathVariable int projectId, @PathVariable int version) {
        List<Endpoint> endpoints = endpointManager.findByProjectIdAndVersion(projectId, version);

        try {
            return JsonHelper.serialize(endpoints);
        } catch (Exception exception) {
            throw new SerializationException();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Endpoint endpoint) {
        endpointManager.save(endpoint);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Endpoint endpoint) throws ObjectNotFoundException {
        endpointManager.update(id, endpoint);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        endpointManager.delete(id);

        return ResponseEntity.noContent().build();
    }
}
