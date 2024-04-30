package com.ianua.api.gateway.configuration.administration.manager;

import com.ianua.api.gateway.configuration.administration.exception.ObjectNotFoundException;
import com.ianua.api.gateway.configuration.administration.model.Endpoint;
import com.ianua.api.gateway.configuration.administration.model.Project;
import com.ianua.api.gateway.configuration.administration.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectManager {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectManager(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Optional<Project> findOneById(Long id) {
        return projectRepository.findById(id);
    }

    public Project update(Long id, Project updatedProject) throws ObjectNotFoundException {
        Project project = projectRepository.findById(id).orElse(null);

        if (project == null) {
            throw new ObjectNotFoundException();
        }

        project.setName(updatedProject.getName());

        return projectRepository.save(project);
    }

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    public Optional<Project> findByName(String project) {
        return projectRepository.findByName(project);
    }
}
