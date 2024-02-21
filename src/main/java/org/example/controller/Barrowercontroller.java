package org.example.controller;

import org.example.dto.BarrowerDto;
import org.example.service.BarrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Barrowercontroller {

    @Autowired
    BarrowerService barrowerService;


    @GetMapping("/barrowers")
    public List<BarrowerDto> getBarrower(){
        return barrowerService.getBarrowers();
    }


}
