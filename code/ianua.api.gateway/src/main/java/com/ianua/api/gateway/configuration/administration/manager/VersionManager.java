package com.ianua.api.gateway.configuration.administration.manager;

import com.ianua.api.gateway.configuration.administration.exception.ObjectNotFoundException;
import com.ianua.api.gateway.configuration.administration.model.Project;
import com.ianua.api.gateway.configuration.administration.model.Version;
import com.ianua.api.gateway.configuration.administration.repository.VersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VersionManager {
    private final VersionRepository versionRepository;

    @Autowired
    public VersionManager(VersionRepository versionRepository) {
        this.versionRepository = versionRepository;
    }

    public Optional<Version> findOneById(Long id) {
        return versionRepository.findById(id);
    }

    public List<Version> findAllByProjectId(Long projectId) {
        return versionRepository.findByProjectId(projectId);
    }

    public Version update(Long id, Version updatedVersion) throws ObjectNotFoundException {
        Version version = versionRepository.findById(id).orElse(null);

        if (version == null) {
            throw new ObjectNotFoundException();
        }

        return versionRepository.save(version);
    }

    public Version save(Version version) {
        return versionRepository.save(version);
    }

    public void delete(Long id) {
        versionRepository.deleteById(id);
    }
}
