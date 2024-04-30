package com.ianua.api.gateway.configuration.administration.manager;

import com.ianua.api.gateway.configuration.administration.exception.ObjectNotFoundException;
import com.ianua.api.gateway.configuration.administration.model.Endpoint;
import com.ianua.api.gateway.configuration.administration.model.Project;
import com.ianua.api.gateway.configuration.administration.repository.EndpointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EndpointManager {
    private final EndpointRepository endpointRepository;

    @Autowired
    public EndpointManager(EndpointRepository endpointRepository) {
        this.endpointRepository = endpointRepository;
    }

    public Optional<Endpoint> findOneById(Long id) {
        return endpointRepository.findById(id);
    }

    public List<Endpoint> findAllByVersionId(Long endpointId) {
        return endpointRepository.findByVersionId(endpointId);
    }

    public Endpoint update(Long id, Endpoint updatedEndpoint) throws ObjectNotFoundException {
        Endpoint endpoint = endpointRepository.findById(id).orElse(null);

        if (endpoint == null) {
            throw new ObjectNotFoundException();
        }

        endpoint.setDomain(updatedEndpoint.getDomain());
        endpoint.setPath(updatedEndpoint.getPath());

        return endpointRepository.save(endpoint);
    }

    public Endpoint save(Endpoint endpoint) {
        return endpointRepository.save(endpoint);
    }

    public void delete(Long id) {
        endpointRepository.deleteById(id);
    }

    public List<Endpoint> findByProjectIdAndVersion(int projectId, int version) {
        return endpointRepository.findByProjectIdAndVersion(projectId, version);
    }

    public Optional<Endpoint> findByProjectIdAndVersionAndPath(int projectId, int version, String path) {
        return endpointRepository.findByProjectIdAndVersionAndPath(projectId, version, path);
    }
}
