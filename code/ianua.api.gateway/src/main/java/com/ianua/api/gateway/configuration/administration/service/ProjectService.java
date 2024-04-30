package com.ianua.api.gateway.configuration.administration.service;

import com.ianua.api.gateway.configuration.administration.manager.ProjectManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private final ProjectManager projectManager;

    @Autowired
    public ProjectService(ProjectManager projectManager) {
        this.projectManager = projectManager;
    }
}