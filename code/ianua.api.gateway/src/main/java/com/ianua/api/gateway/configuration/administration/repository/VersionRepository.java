package com.ianua.api.gateway.configuration.administration.repository;

import com.ianua.api.gateway.configuration.administration.model.Version;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VersionRepository extends JpaRepository<Version, Long> {

    List<Version> findByProjectId(Long projectId);
}
