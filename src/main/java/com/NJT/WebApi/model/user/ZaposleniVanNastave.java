package com.NJT.WebApi.model.user;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue("zaposleni_van_nastave")
public class ZaposleniVanNastave extends User{
    @Column(name = "titula", nullable = false)
    private String titula;
}