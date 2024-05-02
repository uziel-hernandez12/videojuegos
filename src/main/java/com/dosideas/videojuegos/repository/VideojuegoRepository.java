/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dosideas.videojuegos.repository;

import com.dosideas.videojuegos.domain.Videojuego;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author alopezorozco
 */
public interface VideojuegoRepository extends JpaRepository <Videojuego, Integer> {
    
    /**
     * Retorna la lista de videojuegos ordenados por nombre
     * @return 
     */
    @Query("Select v from Videojuego v order by v.nombre")
    List<Videojuego> buscarTodos();
    
    @Query("from Videojuego v where v.distribuidor.id = ?1 order by v.nombre")
    List<Videojuego> buscarPorDistribuidor(int distribuidorId);
    
    @Query("from Videojuego v where v.nombre like %?1%")
    List<Videojuego> buscar(String consulta);
    
    //List<Videojuego> findByNombreContaining(String consulta);
}