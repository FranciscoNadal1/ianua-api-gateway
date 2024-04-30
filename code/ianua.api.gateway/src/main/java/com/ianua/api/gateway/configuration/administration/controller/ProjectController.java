package com.ianua.api.gateway.configuration.administration.controller;

import com.ianua.api.gateway.configuration.administration.exception.ObjectNotFoundException;
import com.ianua.api.gateway.configuration.administration.exception.SerializationException;
import com.ianua.api.gateway.configuration.administration.manager.ProjectManager;
import com.ianua.api.gateway.configuration.administration.model.Project;
import com.ianua.api.gateway.helper.JsonHelper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/projects")
public class ProjectController {

    private ProjectManager projectManager;

    public ProjectController(ProjectManager projectManager) {
        this.projectManager = projectManager;
    }

    @GetMapping
    public String list() {
        List<Project> projects = projectManager.findAll();

        try {
            return JsonHelper.serialize(projects);
        } catch (Exception exception) {
            throw new SerializationException();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Project project) {
        projectManager.save(project);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Project project) throws ObjectNotFoundException {
        projectManager.update(id, project);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        projectManager.delete(id);

        return ResponseEntity.noContent().build();
    }
}
