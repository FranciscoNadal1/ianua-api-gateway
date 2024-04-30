package com.ianua.api.gateway.configuration.administration.repository;

import com.ianua.api.gateway.configuration.administration.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    Optional<Project> findByName(String project);
}
