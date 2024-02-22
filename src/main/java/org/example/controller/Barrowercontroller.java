package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.BarrowerDto;
import org.example.service.BarrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/barrowers")
@RequiredArgsConstructor
@CrossOrigin
public class Barrowercontroller {


    final BarrowerService barrowerService;


    @GetMapping("/get")
    public List<BarrowerDto> getBarrower(){
        return barrowerService.getBarrowers();
    }


}
