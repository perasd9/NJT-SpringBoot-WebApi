/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.NJT.WebApi.service.interfaces;

import com.NJT.WebApi.model.Rezervacija;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Pera
 */
public interface IRezervacijaService extends IService<Rezervacija>{
    public List<Rezervacija> getAllByDate(LocalDateTime date);
    
}
