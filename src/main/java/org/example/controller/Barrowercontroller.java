package org.example.controller;
import lombok.RequiredArgsConstructor;
import org.example.dto.BarrowerDto;
import org.example.service.BarrowerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @DeleteMapping("/delete/{bid}")
    public ResponseEntity<String> deleteBarrower(@PathVariable Long bid){
        Optional<BarrowerDto> optionalBarrowerDto = barrowerService.findByID(bid);
        if(optionalBarrowerDto.isPresent()){
            barrowerService.deleteBarrower(bid);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addBarrowers(@RequestBody BarrowerDto barrowerDto){
        Optional<BarrowerDto> optionalBarrowerDto = barrowerService.findByID(barrowerDto.getBid());
        if(optionalBarrowerDto.isPresent()){
            barrowerService.addBarrower(barrowerDto);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
