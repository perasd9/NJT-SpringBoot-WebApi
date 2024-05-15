/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.NJT.WebApi.service;

import com.NJT.WebApi.model.Rezervacija;
import com.NJT.WebApi.repository.RezervacijaRepository;
import com.NJT.WebApi.service.interfaces.IRezervacijaService;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pera
 */
@Service
public class RezervacijaService implements IRezervacijaService {

    private RezervacijaRepository repository;

    @Autowired
    public RezervacijaService(RezervacijaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Rezervacija> getAll() {
        return (List<Rezervacija>) repository.findAll();
    }

    @Override
    public List<Rezervacija> getAllByDate(LocalDateTime date) {
        return (List<Rezervacija>) repository.findByVremeDatum(date);
    }

    //NOT IMPLEMENTED YET
    @Override
    public Optional<Rezervacija> getById(Object id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean save(Rezervacija rezervacija) {

        Rezervacija r = repository.save(rezervacija);

        return r != null;

    }

    //NOT IMPLEMENTED YET
    @Override
    public boolean update(Rezervacija entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //NOT IMPLEMENTED YET
    @Override
    public boolean delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
