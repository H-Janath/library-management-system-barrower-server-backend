package org.example.controller;
import lombok.RequiredArgsConstructor;
import org.example.Entity.CustomResponse;
import org.example.dto.BorrowerDto;
import org.example.service.BorrowerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/borrowers")
@RequiredArgsConstructor
@CrossOrigin
public class BorrowerController {
    final BorrowerService borrowerService;

    @GetMapping("/get")
    public List<BorrowerDto> getBorrower(){
        return borrowerService.getBarrowers();
    }

    @DeleteMapping("/delete/{bid}")
    public ResponseEntity<String> deleteBorrower(@PathVariable String bid){
        Optional<BorrowerDto> optionalBorrowerDto = borrowerService.findByID(bid);
        if(optionalBorrowerDto.isPresent()){
            borrowerService.deleteBarrower(bid);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateBorrowers(@RequestBody BorrowerDto borrowerDto){
        Optional<BorrowerDto> optionalBorrowerDto = borrowerService.findByID(borrowerDto.getBid());
        if(optionalBorrowerDto.isPresent()){
            borrowerService.updateBarrower(borrowerDto);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/add")
    public ResponseEntity<CustomResponse<String>> addBorrower(@RequestBody BorrowerDto borrowerDto) {
        BorrowerDto addedBorrower = borrowerService.addBorrower(borrowerDto);

        if (addedBorrower != null && addedBorrower.getBorrowerId() !=null) {
            CustomResponse<String> customResponse = new CustomResponse<>(addedBorrower.getBorrowerId(), "Success");
            return new ResponseEntity<>(customResponse, HttpStatus.OK);
        } else {
            CustomResponse<String> customResponse = new CustomResponse<>(addedBorrower.getBorrowerId(),"Unsuccessful");
            return new ResponseEntity<>(customResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/id")
    public ResponseEntity<CustomResponse<String>> getId(){
        String id = borrowerService.generateBorrowerId();
        if(id!=null){
            CustomResponse<String> customResponse = new CustomResponse<>(id,"Success");
            return new ResponseEntity<>(customResponse,HttpStatus.OK);
        }else{
            CustomResponse<String> customResponse = new CustomResponse<>(id,"Unsuccessful");
            return new ResponseEntity<>(customResponse, HttpStatus.BAD_REQUEST);
        }

    }


}
