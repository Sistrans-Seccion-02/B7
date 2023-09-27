package uniandes.edu.co.proyecto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import uniandes.edu.co.proyecto.modelo.ReservaServicios;
import uniandes.edu.co.proyecto.repositorio.ReservaServicioRepository;

import java.util.List;

@Controller
public class ReservaServicioController {

    @Autowired
    private ReservaServicioRepository reservaservicioRepository;

    @GetMapping
    public List<ReservaServicios> getAllReservaServicios() {
        return reservaservicioRepository.findAll();
    }

    @GetMapping("/reservaservicioId")
    public ReservaServicios getReservaServicioById(@PathVariable Long reservaservicioId) {
        return reservaservicioRepository.findById(reservaservicioId).orElse(null);
    }
    
}
