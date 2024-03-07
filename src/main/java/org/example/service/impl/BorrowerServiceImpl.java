package org.example.service.impl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.Entity.Borrower;
import org.example.dto.BorrowerDto;
import org.example.repository.BorrowerRepository;
import org.example.service.BorrowerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BorrowerServiceImpl implements BorrowerService {

    final BorrowerRepository borrowerRepository;
    ModelMapper modelMapper;
    @Autowired
    ObjectMapper objectMapper;

    @Bean
    public void setUp(){
        this.modelMapper = new ModelMapper();
    }


    @Override
    public List<BorrowerDto> getBarrowers() {
        List<Borrower> borrowerList = (List<Borrower>) borrowerRepository.findAll();
        ArrayList<BorrowerDto> borrowerDtos = new ArrayList<>();
        for(Borrower borrower : borrowerList){
            borrowerDtos.add(
                    modelMapper.map(borrower, BorrowerDto.class)
            );
        }
        return borrowerDtos;
    }

    @Override
    public boolean deleteBarrower(String bid) {
        borrowerRepository.deleteByBorrowerId(bid);
        return true;
    }

    @Override
    public Optional<BorrowerDto> findByID(String bid) {
            Optional<Borrower> barrower = Optional.ofNullable(borrowerRepository.findByBorrowerId(bid));
            Optional<BorrowerDto> barrowerDto = Optional.ofNullable(modelMapper.map(barrower, BorrowerDto.class));
            return barrowerDto;
    }


    @Override
    public void updateBarrower(BorrowerDto borrowerDto) {
        Borrower borrower = modelMapper.map(borrowerDto, Borrower.class);
        borrowerRepository.save(borrower);
    }

    public BorrowerDto addBorrower(BorrowerDto borrowerDto){
        Borrower borrower = modelMapper.map(borrowerDto, Borrower.class);
        if(borrower !=null){
            borrower.setBorrowerId(generateBorrowerId());
            Borrower borrower1 = borrowerRepository.save(borrower);
            BorrowerDto borrowerDto1 = modelMapper.map(borrower1, BorrowerDto.class);
            return borrowerDto1;
        }
        return null;
    }

    public String generateBorrowerId(){
        Long id = borrowerRepository.findMaxID();
        if(id!=null){
            ++id;
            return "BR"+id;
        }else{
            return "BR"+1;
        }
    }
}
