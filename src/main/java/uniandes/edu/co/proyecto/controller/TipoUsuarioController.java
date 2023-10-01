package uniandes.edu.co.proyecto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



import uniandes.edu.co.proyecto.repositorio.TipoUsuarioRepository;



@Controller
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioRepository tipousuarioRepository;

    @GetMapping("/tiposUsuario")
    public String tiposUsuario(Model model) {
        model.addAttribute("tiposUsuario",tipousuarioRepository.darTiposUsuario());          
        return "tiposUsuario";
    }

  
    
}
