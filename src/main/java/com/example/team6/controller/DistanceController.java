package com.example.team6.controller;

import com.example.team6.model.Distance;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log
@RequestMapping
@Controller
public class DistanceController
{
    @GetMapping
    public String welcome(Model model)
    {
        model.addAttribute("message", "Oi");
        model.addAttribute("distance", new Distance());

        return "distance/distance";
    }

    @PostMapping
    public String calcDistance(@ModelAttribute Distance distance,  Model model)
    {
        model.addAttribute("message", "Oi");
        log.info(distance.toString());
        return "distance/distance";
    }
}
