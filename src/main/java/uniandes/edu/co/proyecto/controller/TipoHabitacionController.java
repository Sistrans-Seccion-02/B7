package uniandes.edu.co.proyecto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import uniandes.edu.co.proyecto.modelo.TipoHabitacion;
import uniandes.edu.co.proyecto.repositorio.TipoHabitacionRepository;

import java.util.List;

@Controller
public class TipoHabitacionController {

    @Autowired
    private TipoHabitacionRepository tipohabitacionRepository;

    @GetMapping
    public List<TipoHabitacion> getAllTipoHabitacions() {
        return tipohabitacionRepository.findAll();
    }

 
}
