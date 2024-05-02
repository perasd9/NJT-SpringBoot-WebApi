package com.NJT.WebApi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sala")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "napomena", length = 1024)
    private String napomena;

    @Column(name = "broj_racunara", nullable = false)
    private Integer brojRacunara;

    @Column(name = "broj_mesta", nullable = false)
    private Integer brojMesta;

    @Column(name = "naziv", nullable = false)
    private String naziv;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tip_sale_id", nullable = false)
    private TipSale tipSale;

    @ManyToOne(optional = false)
    @JoinColumn(name = "status_sale_id", nullable = false)
    private StatusSale statusSale;

}