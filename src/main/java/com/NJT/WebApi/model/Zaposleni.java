package com.NJT.WebApi.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "zaposleni")
@DiscriminatorValue("zaposleni")
public abstract class Zaposleni extends User{
    @Column(name = "titula", nullable = false)
    private String titula;

}