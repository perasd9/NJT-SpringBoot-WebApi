package com.NJT.WebApi.api;

import com.NJT.WebApi.model.Sala;
import com.NJT.WebApi.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sala")
public class SalaController {

    SalaService salaService;

    @Autowired
    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @GetMapping("/")
    public List<Sala> getAllSala() {
        return salaService.getAllSala();
    }

    @GetMapping("/{id}")
    public Optional<Sala> getSalaById(@PathVariable String id) {
        return salaService.getSala(Long.valueOf(id));
    }

    @PostMapping("/")
    public Sala createSala(@RequestBody Sala sala) {
        return salaService.saveSala(sala);
    }

    @DeleteMapping("/")
    public void deleteSala(@RequestBody Sala sala) {
        salaService.deleteSala(sala);
    }

    @PutMapping("/")
    public Sala updateSala(@RequestBody Sala sala) {
        return salaService.updateSala(sala);
    }


}
