/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.dosideas.videojuegos.service;

import com.dosideas.videojuegos.domain.Videojuego;
import com.dosideas.videojuegos.repository.VideojuegoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author alopezorozco
 */
@Service
public class VideojuegoService {
    
    private final VideojuegoRepository videojuegoRepository;

    public VideojuegoService(VideojuegoRepository videojuegoRepository) {
        this.videojuegoRepository = videojuegoRepository;
    }
    
    public List<Videojuego> buscarDestacados(){
        return videojuegoRepository.buscarTodos();
    }
    
    /**
     * Retorna una lista de videojuegos por id. del distribuidor
     * @param distribuidorId
     * @return 
     */
    public List<Videojuego> buscarPorDistribuidor(int distribuidorId){
        return videojuegoRepository.buscarPorDistribuidor(distribuidorId);
    }
    
    /**
     * Realiza una consulta a la bd para buscar
     * videojuegos por nombre
     * @param consulta
     * @return 
     */
    public List<Videojuego> buscar(String consulta){
        return videojuegoRepository.buscar(consulta);
    }
    
    /**
     * Guardar un videojuego en la bd
     * @param videojuego
     * @return 
     */
    public Videojuego guardar(Videojuego videojuego){
        return videojuegoRepository.save(videojuego);
    }
    
    /**
     * Permite buscar un videojuego por su identificador
     * @param id
     * @return 
     */
    public Optional<Videojuego> buscarPorId(int id){
        return videojuegoRepository.findById(id);        
    }
    
    /**
     * Elimina un videojuego por su id
     * @param id 
     */
    public void eliminarPorId(int id){
        videojuegoRepository.deleteById(id);
    }
    
    
    /**
     *
     * @param consulta
     * @return
     */
    /*public List<Videojuego> buscarPorNombre(String consulta)
    {
        return videojuegoRepository.findByNombreContaining(consulta);
    }*/
    public void guardarCambios(Videojuego videojuego){
        videojuegoRepository.save(videojuego);
    }
}