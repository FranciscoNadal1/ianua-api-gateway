package com.ianua.api.gateway.configuration.administration.repository;

import com.ianua.api.gateway.configuration.administration.model.Endpoint;
import com.ianua.api.gateway.configuration.administration.model.Project;
import com.ianua.api.gateway.configuration.administration.model.Version;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface EndpointRepository extends JpaRepository<Endpoint, Long> {

    List<Endpoint> findByVersionId(Long versionId);

    @Query("SELECT e FROM Endpoint e WHERE e.version.project.id = :projectId AND e.version.version = :version")
    List<Endpoint> findByProjectIdAndVersion(@Param("projectId") int projectId, @Param("version") int version);

    @Query("SELECT e FROM Endpoint e WHERE e.version.project.id = :projectId AND e.version.version = :version AND e.path = :path")
    Optional<Endpoint> findByProjectIdAndVersionAndPath(int projectId, int version, String path);
}
