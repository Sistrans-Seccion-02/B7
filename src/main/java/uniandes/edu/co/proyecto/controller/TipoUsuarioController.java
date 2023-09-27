package uniandes.edu.co.proyecto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.TipoUsuarioRepository;

import java.util.List;

@Controller
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioRepository tipousuarioRepository;

    @GetMapping
    public List<Usuario> getAllTipoUsuarios() {
        return tipousuarioRepository.findAll();
    }

    @GetMapping("/tipousuarioId")
    public Usuario getTipoUsuarioById(@PathVariable Long tipousuarioId) {
        return tipousuarioRepository.findById(tipousuarioId).orElse(null);
    }
    
}
