package com.NJT.WebApi.service;

import com.NJT.WebApi.model.Sala;
import com.NJT.WebApi.repository.SalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {

    SalaRepository salaRepo;

    public SalaService(SalaRepository salaRepo) {
        this.salaRepo = salaRepo;
    }

    public Optional<Sala> getSala(Long id) {
        return salaRepo.findById(id);
    }

    public List<Sala> getAllSala() {
        return (List<Sala>) salaRepo.findAll();
    }

    public Sala saveSala(Sala sala) {
        return salaRepo.save(sala);
    }

    public void deleteSala(Sala sala) {
        salaRepo.delete(sala);
    }

    public Sala updateSala(Sala sala) {
        return salaRepo.save(sala);
    }

}
