/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.NJT.WebApi.api;

import com.NJT.WebApi.model.Rezervacija;
import com.NJT.WebApi.service.RezervacijaService;
import com.NJT.WebApi.service.interfaces.IRezervacijaService;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Pera
 */
@RestController
@RequestMapping("api/v1/rezervacija")
public class RezervacijaController {

    IRezervacijaService rezervacijaService;

    @Autowired
    public RezervacijaController(IRezervacijaService rezervacijaService) {
        this.rezervacijaService = rezervacijaService;
    }

    @GetMapping
    public ResponseEntity<List<Rezervacija>> getAllReservations(@RequestParam String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime datum = LocalDateTime.parse(date, formatter);

        List<Rezervacija> lista = rezervacijaService.getAllByDate(datum);

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/naCekanju")
    public ResponseEntity<List<Rezervacija>> getAllReservationRequests() {
        List<Rezervacija> lista = rezervacijaService.getAllByStatusRezervacije("Na cekanju");

        return ResponseEntity.ok(lista);
    }

    @PostMapping("/kreiraj")
    public ResponseEntity addReservationRequest(@RequestBody Rezervacija rezervacija) {
        return rezervacijaService.saveRequest(rezervacija) ? ResponseEntity.ok().build()
                : ResponseEntity.badRequest().build();
    }

    @PostMapping("/prihvati")
    public ResponseEntity acceptReservationRequest(@RequestBody Rezervacija rezervacija) {
        return rezervacijaService.acceptRequest(rezervacija) ? ResponseEntity.ok().build()
                : ResponseEntity.badRequest().build();
    }

    @PostMapping("/odbij")
    public ResponseEntity denyReservationRequest(@RequestBody Rezervacija rezervacija) {
        return rezervacijaService.denyRequest(rezervacija) ? ResponseEntity.ok().build()
                : ResponseEntity.badRequest().build();
    }

    @PostMapping("/odjavi")
    public ResponseEntity closeReservation(@RequestBody Rezervacija rezervacija) {
        return rezervacijaService.closeReservation(rezervacija) ? ResponseEntity.ok().build()
                : ResponseEntity.badRequest().build();
    }

    @PutMapping()
    public ResponseEntity updateReservation(@RequestBody Rezervacija rezervacija) {
        return rezervacijaService.update(rezervacija) ? ResponseEntity.ok().build()
                : ResponseEntity.badRequest().build();
    }
}
