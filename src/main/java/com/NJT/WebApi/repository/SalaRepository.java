package com.NJT.WebApi.repository;

import com.NJT.WebApi.model.Sala;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface SalaRepository extends CrudRepository<Sala, Long> {
}