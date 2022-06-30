package com.inventorycontrol.service;

import com.inventorycontrol.exception.ExitNotFoundException;
import com.inventorycontrol.model.ExitModel;
import com.inventorycontrol.repository.ExitRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ExitService {

    private final ExitRepository exitRepository;

    public List<ExitModel> findAll() {
        return exitRepository.findAll();
    }

    public ExitModel findById(UUID uuid) {
        return exitRepository.findById(uuid).orElseThrow(() -> new ExitNotFoundException("Resultado não encontrado!"));
    }

    public ExitModel save(ExitModel exitModel) {
        return exitRepository.save(exitModel);
    }

    public ExitModel update(ExitModel exitModel, UUID uuid) {
        exitRepository.findById(uuid).orElseThrow(() -> new ExitNotFoundException("Resultado não encontrado!"));
        exitModel.setCodExit(uuid);
        exitRepository.save(exitModel);
        return exitModel;
    }

    public UUID delete(UUID uuid) {
        var exitModel = exitRepository.findById(uuid).orElseThrow(() -> new ExitNotFoundException("Resultado não encontrado!"));
        exitRepository.delete(exitModel);
        return uuid;
    }
}
