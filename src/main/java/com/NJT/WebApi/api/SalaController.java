/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.NJT.WebApi.api;

import com.NJT.WebApi.model.Sala;
import com.NJT.WebApi.service.interfaces.ISalaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pera
 */
@RestController
@RequestMapping("api/v1/sala")
public class SalaController {

    ISalaService salaService;

    @Autowired
    public SalaController(ISalaService salaService) {
        this.salaService = salaService;
    }

    @GetMapping
    public ResponseEntity<List<Sala>> getAll() {
        List<Sala> lista = salaService.getAll();

        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Sala sala) {
        return salaService.save(sala) ? (ResponseEntity) ResponseEntity.ok().build()
                : (ResponseEntity) ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Sala sala) {
        return salaService.update(sala) ? (ResponseEntity) ResponseEntity.ok().build()
                : (ResponseEntity) ResponseEntity.badRequest().build();
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody Long id) {
        salaService.delete(id);

        return (ResponseEntity) ResponseEntity.ok().build();
    }
}
