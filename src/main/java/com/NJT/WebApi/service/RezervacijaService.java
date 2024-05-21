/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.NJT.WebApi.service;

import com.NJT.WebApi.model.Rezervacija;
import com.NJT.WebApi.repository.RezervacijaRepository;
import com.NJT.WebApi.repository.StatusRezervacijeRepository;
import com.NJT.WebApi.service.interfaces.IRezervacijaService;
import jakarta.transaction.Transactional;
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
    private StatusRezervacijeRepository statusRezervacijeRepository;

    @Autowired
    public RezervacijaService(RezervacijaRepository repository, StatusRezervacijeRepository statusRezervacijeRepository) {
        this.repository = repository;
        this.statusRezervacijeRepository = statusRezervacijeRepository;
    }

    @Override
    public List<Rezervacija> getAll() {
        return (List<Rezervacija>) repository.findAll();
    }

    @Override
    public List<Rezervacija> getAllByDate(LocalDateTime date) {
        return (List<Rezervacija>) repository.findByVremeDatum(date);
    }

    @Override
    public List<Rezervacija> getAllByStatusRezervacije(String status) {
        return (List<Rezervacija>) repository.findByStatusRezervacije(status);
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

    @Override
    @Transactional
    public boolean saveRequest(Rezervacija entity) {
        entity.setStatusRezervacije(statusRezervacijeRepository.findBystatus("Na cekanju"));

        Rezervacija rez = repository.save(entity);

        return rez != null;
    }

    @Override
    public boolean acceptRequest(Rezervacija entity) {
        Optional<Rezervacija> rezOpt = repository.findById(entity.getId());

        if (rezOpt.isPresent()) {
            Rezervacija rez = rezOpt.get();
            rez.setStatusRezervacije(statusRezervacijeRepository.findBystatus("Odobrena"));

            repository.save(rez);
            return true;
        }

        return false;
    }

    @Override
    public boolean denyRequest(Rezervacija entity) {
        Optional<Rezervacija> rezOpt = repository.findById(entity.getId());

        if (rezOpt.isPresent()) {
            Rezervacija rez = rezOpt.get();
            rez.setStatusRezervacije(statusRezervacijeRepository.findBystatus("Odbijena"));

            repository.save(rez);
            return true;
        }

        return false;
    }

    @Override
    public boolean closeReservation(Rezervacija entity) {
        Optional<Rezervacija> rezOpt = repository.findById(entity.getId());

        if (rezOpt.isPresent()) {
            Rezervacija rez = rezOpt.get();
            if (!rez.getStatusRezervacije().getStatus().equals("Na cekanju")) {
                rez.setStatusRezervacije(statusRezervacijeRepository.findBystatus("Odbijena"));
            } else {
                return false;
            }
            repository.save(rez);
            return true;
        }

        return false;
    }

    @Override
    public boolean update(Rezervacija entity) {
        Optional<Rezervacija> rezOpt = repository.findById(entity.getId());

        if (rezOpt.isPresent()) {
            Rezervacija rez = rezOpt.get();
            rez.setStatusRezervacije(statusRezervacijeRepository.findBystatus("Na cekanju"));
            rez.setSale(entity.getSale());
            rez.setSvrha(entity.getSvrha());
            rez.setVremeDatum(entity.getVremeDatum());

            repository.save(rez);
            return true;
        }

        return false;
    }

    //NOT IMPLEMENTED YET
    @Override
    public boolean delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
