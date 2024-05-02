/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.NJT.WebApi.repository.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @author Pera
 * @param <TEntity>
 * @param <TKey>
 */

@NoRepositoryBean
public interface IRepository <TEntity, TKey> extends CrudRepository<TEntity, TKey>{
    
}
