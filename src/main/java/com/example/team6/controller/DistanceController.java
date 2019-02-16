package com.example.team6.controller;

import com.example.team6.model.Cidade;
import com.example.team6.model.Distance;
import com.example.team6.repository.CidadeRepository;
import com.example.team6.util.DistanceCalculatorUtil;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

        List<Cidade> cidadeList = cidadeRepository.findAll().stream()
            .map(cidade ->
            {
                Double lat1 = Double.valueOf(cidade.getVlrLatitude());
                Double lng1 = Double.valueOf(cidade.getVlrLongitude());
                Double lat2 = Double.valueOf(distance.getLat());
                Double lng2 = Double.valueOf(distance.getLng());
                cidade.setDistanceFrom(DistanceCalculatorUtil.distance(lat1, lng1, lat2, lng2));
                return cidade;
            })
            .sorted(Comparator.comparing(Cidade::getDistanceFrom))
            .collect(Collectors.toList());

        model.addAttribute("ubs", cidadeList.subList(0, 3));
        return "distance/distance";
    }
}
