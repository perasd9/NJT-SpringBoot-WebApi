/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.NJT.WebApi.api;

import com.NJT.WebApi.model.Rezervacija;
import com.NJT.WebApi.service.RezervacijaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Pera
 */
@RestController
@RequestMapping("api/v1/rezervacija")
public class RezervacijaController {
    
    RezervacijaService rezervacijaService;
    
    @Autowired
    public RezervacijaController(RezervacijaService rezervacijaService) {
        this.rezervacijaService = rezervacijaService;
    }
    
    @GetMapping
    public List<Rezervacija> getAllReservations(){
        return rezervacijaService.getAll();
    }

    @PostMapping
    public void addReservation(@RequestBody Rezervacija rezervacija) {
        rezervacijaService.save(rezervacija);
    }
}
