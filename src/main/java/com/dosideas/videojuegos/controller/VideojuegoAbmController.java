package com.dosideas.videojuegos.controller;

import com.dosideas.videojuegos.domain.Videojuego;
import com.dosideas.videojuegos.service.DistribuidorService;
import com.dosideas.videojuegos.service.VideojuegoService;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author alopezorozco
 */
@Controller
public class VideojuegoAbmController {
    private final DistribuidorService distribuidorService;
    private final VideojuegoService videojuegoService;

    public VideojuegoAbmController(DistribuidorService distribuidorService,
            VideojuegoService videojuegoService) {
        this.distribuidorService = distribuidorService;
        this.videojuegoService = videojuegoService;
    }
    
    @RequestMapping("/videojuegos/crear")
    public String mostrarFormAlta(Model model){
        model.addAttribute("distribuidores", distribuidorService.buscarTodos());
        model.addAttribute("videojuego", new Videojuego());
        return "formvideojuego.html";
    }
    
    /**
     * Inserta un nuevo videojuego
     * @param videojuego
     * @return 
     */
    @PostMapping("/videojuegos/guardar")
    public String guardar(Videojuego videojuego){
        videojuegoService.guardar(videojuego);
        return "redirect:/";
    }
    
    /**
     * Elimina un videojuego según su Id.
     * @param idVideojuego
     * @return 
     */
    @RequestMapping("/videojuegos/eliminar")
    public String eliminarVideojuegoPorId(@RequestParam("id") String idVideojuego){
        int idv = Integer.parseInt(idVideojuego);      
        videojuegoService.eliminarPorId(idv);       
        return "redirect:/";
    }
    
    /**
     * Mostrar la pagina de edicion de videojuegos
     * @param idVideojuego
     * @param model
     * @return 
     */
    @RequestMapping("/videojuegos/editar")
    public String mostrarEditarVideojuego(@RequestParam("id") String idVideojuego, Model model) {
        String mensajeError = "";
        
        try{
            // Intenta convertir el ID del videojuego a un entero
            int id = Integer.parseInt(idVideojuego);
            
            // Busca el videojuego por su ID
            Optional<Videojuego> opcionalVideojuego = videojuegoService.buscarPorId(id);

            if (opcionalVideojuego.isPresent()){
                // Si el videojuego se encuentra, lo agrega al modelo y muestra la vista del videojuego
                Videojuego videojuego = opcionalVideojuego.get();
                model.addAttribute("videojuego", videojuego);
                // Aquí puedes hacer cualquier procesamiento adicional necesario antes de mostrar la página
                model.addAttribute("distribuidores", distribuidorService.buscarTodos());
                return "formEditarVideojuego.html";
            }else{
                // Si el videojuego no se encuentra, muestra una página de error con el mensaje correspondiente
                mensajeError = "Videojuego no encontrado";
                model.addAttribute("mensajeError", mensajeError);
                return "error";
            } 
        }catch(NumberFormatException e){
            // Si ocurre una excepción al convertir el ID a entero, muestra una página de error con el mensaje correspondiente
            mensajeError = "Id. del videojuego inválido";
            model.addAttribute("mensajeError", mensajeError);
            return "error";
        }      
        
    }
    
    /**
     * Guarda cambios al editar un videojuego
     * @param videojuego
     * @return 
     */
    @PostMapping("/videojuegos/guardarCambios")
    public String guardarCambios(Videojuego videojuego){
        videojuegoService.guardarCambios(videojuego);
        return "redirect:/";
    }
}