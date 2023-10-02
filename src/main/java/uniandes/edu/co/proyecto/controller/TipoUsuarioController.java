package uniandes.edu.co.proyecto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.repositorio.TipoUsuarioRepository;



@RestController
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioRepository tipousuarioRepository;

    @GetMapping("/tiposUsuario")
    public String tiposUsuario(Model model) {
        model.addAttribute("tiposUsuario",tipousuarioRepository.darTiposUsuario());          
        return model.toString();
    }

  
    
}
