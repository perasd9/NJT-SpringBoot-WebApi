/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.NJT.WebApi.repository;

import com.NJT.WebApi.model.StatusRezervacije;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pera
 */
@Repository
public interface StatusRezervacijeRepository extends CrudRepository<StatusRezervacije, Long>{
    
}

