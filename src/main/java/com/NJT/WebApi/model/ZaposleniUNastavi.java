package com.NJT.WebApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "zaposleni_u_nastavi")
@DiscriminatorValue("unastavi")
public class ZaposleniUNastavi extends Zaposleni{
    @Column(name = "zvanje", nullable = false)
    private String zvanje;

    @ManyToOne(optional = false)
    @JoinColumn(name = "katedra_id", nullable = false)
    private Katedra katedra;

}