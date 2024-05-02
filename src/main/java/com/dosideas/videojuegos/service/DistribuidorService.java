/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dosideas.videojuegos.service;

import com.dosideas.videojuegos.domain.Distribuidor;
import com.dosideas.videojuegos.repository.DistribuidorRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author alopezorozco
 */
@Service
public class DistribuidorService {
    private final DistribuidorRepository distribuidorRepository;

    public DistribuidorService(DistribuidorRepository distribuidorRepository) {
        this.distribuidorRepository = distribuidorRepository;
    }
    
    public List<Distribuidor> buscarTodos(){
        return distribuidorRepository.findAll();
    }
}