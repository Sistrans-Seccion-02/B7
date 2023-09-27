package uniandes.edu.co.proyecto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;

import java.util.List;

@Controller
public class HabitacionController {

    @Autowired
    private HabitacionRepository habitacionRepository;

    @GetMapping
    public List<Habitacion> getAllHabitacions() {
        return habitacionRepository.findAll();
    }

    @GetMapping("/habitacionId")
    public Habitacion getHabitacionById(@PathVariable Long habitacionId) {
        return habitacionRepository.findById(habitacionId).orElse(null);
    }
    
    
}
