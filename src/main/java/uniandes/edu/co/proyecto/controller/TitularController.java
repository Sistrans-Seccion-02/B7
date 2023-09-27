package uniandes.edu.co.proyecto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import uniandes.edu.co.proyecto.modelo.Titular;
import uniandes.edu.co.proyecto.repositorio.TitularRepository;

import java.util.List;

@Controller
public class TitularController {

    @Autowired
    private TitularRepository  usuarioRepository;

    @GetMapping
    public List<Titular> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuarioId")
    public Titular getUsuarioById(@PathVariable Long usuarioId) {
        return usuarioRepository.findById(usuarioId).orElse(null);
    }

}
