package uniandes.edu.co.proyecto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import uniandes.edu.co.proyecto.modelo.Plan;
import uniandes.edu.co.proyecto.repositorio.PlanRepository;

import java.util.List;

@Controller
public class PlanController {

    @Autowired
    private PlanRepository planRepository;

    @GetMapping
    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }

    @GetMapping("/planId")
    public Plan getPlanById(@PathVariable Long planId) {
        return planRepository.findById(planId).orElse(null);
    }
    
    
}
