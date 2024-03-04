package org.example.controller;
import lombok.RequiredArgsConstructor;
import org.example.Entity.CustomResponse;
import org.example.dto.BarrowerDto;
import org.example.service.BarrowerService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> deleteBarrower(@PathVariable String bid){
        Optional<BarrowerDto> optionalBarrowerDto = barrowerService.findByID(bid);
        if(optionalBarrowerDto.isPresent()){
            barrowerService.deleteBarrower(bid);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateBarrowers(@RequestBody BarrowerDto barrowerDto){
        Optional<BarrowerDto> optionalBarrowerDto = barrowerService.findByID(barrowerDto.getBid());
        if(optionalBarrowerDto.isPresent()){
            barrowerService.updateBarrower(barrowerDto);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/add")
    public ResponseEntity<CustomResponse<String>> addBorrower(@RequestBody BarrowerDto barrowerDto) {
        BarrowerDto addedBorrower = barrowerService.addBorrower(barrowerDto);

        if (addedBorrower != null && addedBorrower.getBid() !=null) {
            CustomResponse<String> customResponse = new CustomResponse<>(addedBorrower.getBid(), "Success");
            return new ResponseEntity<>(customResponse, HttpStatus.OK);
        } else {
            CustomResponse<String> customResponse = new CustomResponse<>(addedBorrower.getBid(),"Unsuccessful");
            return new ResponseEntity<>(customResponse, HttpStatus.BAD_REQUEST);
        }
    }


}
