/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.NJT.WebApi.service;

import com.NJT.WebApi.model.Sala;
import com.NJT.WebApi.repository.interfaces.ISalaRepository;
import com.NJT.WebApi.service.interfaces.ISalaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pera
 */
@Service
public class SalaService implements ISalaService{
    ISalaRepository salaRepository;

    @Autowired
    public SalaService(ISalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }
    
    
    @Override
    public List<Sala> getAll() {
        return (List<Sala>) salaRepository.findAll();
    }

    @Override
    public Optional<Sala> getById(Object id) {
        return salaRepository.findById(Long.valueOf(id.toString()));
    }

    @Override
    public boolean save(Sala entity) {
        Sala s = salaRepository.save(entity);
        
        return s != null;
    }

    @Override
    public boolean update(Sala entity) {
        Sala s = salaRepository.save(entity);
        
        return s != null;
    }

    @Override
    public boolean delete(Object id) {
        salaRepository.deleteById(Long.valueOf(id.toString()));
        
        return true;
    }
    
}
