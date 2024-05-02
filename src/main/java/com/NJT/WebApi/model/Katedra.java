package com.NJT.WebApi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "katedra")
public class Katedra {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "naziv", nullable = false)
    private String naziv;

}