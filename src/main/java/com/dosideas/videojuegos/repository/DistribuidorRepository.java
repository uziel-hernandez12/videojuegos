package com.dosideas.videojuegos.repository;

import com.dosideas.videojuegos.domain.Distribuidor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author alopezorozco
 */
public interface DistribuidorRepository extends JpaRepository<Distribuidor, Integer> {
    
}