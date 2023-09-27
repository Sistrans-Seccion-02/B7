package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import uniandes.edu.co.proyecto.modelo.Estadia;
import uniandes.edu.co.proyecto.repositorio.EstadiaRepository;

import java.util.List;

@Controller
public class EstadiaController {

    @Autowired
    private EstadiaRepository estadiaRepository;

    @GetMapping
    public List<Estadia> getAllEstadias() {
        return estadiaRepository.findAll();
    }

    @GetMapping("/estadiaId")
    public Estadia getEstadiaById(@PathVariable Long estadiaId) {
        return estadiaRepository.findById(estadiaId).orElse(null);
    }
    
}
