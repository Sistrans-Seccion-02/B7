package uniandes.edu.co.proyecto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import uniandes.edu.co.proyecto.modelo.Factura;
import uniandes.edu.co.proyecto.repositorio.FacturaRepository;

import java.util.List;

@Controller
public class FacturaController {

    @Autowired
    private FacturaRepository facturaRepository;

    @GetMapping
    public List<Factura> getAllConsumos() {
        return facturaRepository.findAll();
    }

    @GetMapping("/facturaId")
    public Factura getFacturaById(@PathVariable Long consumoId) {
        return facturaRepository.findById(consumoId).orElse(null);
    }
    
}
