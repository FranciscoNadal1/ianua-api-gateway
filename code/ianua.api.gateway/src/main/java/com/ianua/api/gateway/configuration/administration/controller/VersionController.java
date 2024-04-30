package com.ianua.api.gateway.configuration.administration.controller;

import com.ianua.api.gateway.configuration.administration.exception.ObjectNotFoundException;
import com.ianua.api.gateway.configuration.administration.exception.SerializationException;
import com.ianua.api.gateway.configuration.administration.manager.ProjectManager;
import com.ianua.api.gateway.configuration.administration.manager.VersionManager;
import com.ianua.api.gateway.configuration.administration.model.Project;
import com.ianua.api.gateway.configuration.administration.model.Version;
import com.ianua.api.gateway.helper.JsonHelper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/projects/{projectId}/versions")
public class VersionController {
    private VersionManager versionManager;

    public VersionController(VersionManager versionManager) {
        this.versionManager = versionManager;
    }

    @GetMapping
    public String list(@PathVariable Long projectId)  {
        List<Version> versions = versionManager.findAllByProjectId(projectId);

        try {
            return JsonHelper.serialize(versions);
        } catch (Exception exception) {
            throw new SerializationException();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Version version)  {
        versionManager.save(version);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        versionManager.delete(id);

        return ResponseEntity.noContent().build();
    }
}
