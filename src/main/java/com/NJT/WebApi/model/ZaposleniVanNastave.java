package com.NJT.WebApi.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "zaposleni_van_nastave")
@DiscriminatorValue("vannastave")
public class ZaposleniVanNastave extends Zaposleni{
}