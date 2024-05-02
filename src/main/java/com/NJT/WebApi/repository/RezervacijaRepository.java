package com.NJT.WebApi.repository;

import com.NJT.WebApi.model.Rezervacija;
import org.springframework.data.repository.CrudRepository;

public interface RezervacijaRepository extends CrudRepository<Rezervacija, Long> {
}