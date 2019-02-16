package com.example.team6.controller;

import com.example.team6.model.Distance;
import com.example.team6.repository.CidadeRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.team6.model.Cidade;
import com.example.team6.util.DistanceCalculatorUtil;

@Log
@RequestMapping("/")
@Controller
public class DistanceController
{
    @Autowired
    private CidadeRepository cidadeRepository;

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
        double dist = 0;
        Cidade maisProxima = null;
        for (Cidade c : cidadeRepository.findAll()) {
            if (dist==0){
                maisProxima = c;
                dist = DistanceCalculatorUtil.distance(Double.parseDouble(distance.getLat()),Double.parseDouble(distance.getLng()), Double.parseDouble(c.getVlrLatitude()), Double.parseDouble(c.getVlrLongitude()));
            }else{
                if (dist > DistanceCalculatorUtil.distance(Double.parseDouble(distance.getLat()),Double.parseDouble(distance.getLng()), Double.parseDouble(c.getVlrLatitude()), Double.parseDouble(c.getVlrLongitude()))){
                    dist = DistanceCalculatorUtil.distance(Double.parseDouble(distance.getLat()),Double.parseDouble(distance.getLng()), Double.parseDouble(c.getVlrLatitude()), Double.parseDouble(c.getVlrLongitude()));
                    maisProxima = c;
                }
            }
        }


        model.addAttribute("maisProxima", maisProxima);
        return "distance/distance";
    }
}
