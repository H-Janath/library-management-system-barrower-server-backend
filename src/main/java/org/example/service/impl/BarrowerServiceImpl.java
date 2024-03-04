package org.example.service.impl;
import lombok.RequiredArgsConstructor;
import org.example.Entity.Barrower;
import org.example.dto.BarrowerDto;
import org.example.repository.BarrowerRepository;
import org.example.service.BarrowerService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BarrowerServiceImpl implements BarrowerService {

    final BarrowerRepository barrowerRepository;
    ModelMapper modelMapper;

    @Bean
    public void setUp(){
        this.modelMapper = new ModelMapper();
    }


    @Override
    public List<BarrowerDto> getBarrowers() {
        List<Barrower> barrowerList = (List<Barrower>) barrowerRepository.findAll();
        ArrayList<BarrowerDto> barrowerDtos = new ArrayList<>();
        for(Barrower barrower:barrowerList){
            barrowerDtos.add(
                    modelMapper.map(barrower,BarrowerDto.class)
            );
        }
        return barrowerDtos;
    }

    @Override
    public boolean deleteBarrower(String bid) {
        barrowerRepository.deleteBybid(bid);
        return true;
    }

    @Override
    public Optional<BarrowerDto> findByID(String bid) {
            Optional<Barrower> barrower = Optional.ofNullable(barrowerRepository.findBybid(bid));
            Optional<BarrowerDto> barrowerDto = Optional.ofNullable(modelMapper.map(barrower, BarrowerDto.class));
            return barrowerDto;
    }


    @Override
    public void updateBarrower(BarrowerDto barrowerDto) {
        Barrower barrower = modelMapper.map(barrowerDto,Barrower.class);
        barrowerRepository.save(barrower);
    }

    public BarrowerDto addBorrower(BarrowerDto barrowerDto){
        Barrower barrower = modelMapper.map(barrowerDto,Barrower.class);
        if(barrower!=null){
            Barrower barrower1 = barrowerRepository.save(barrower);
            String userid = barrower1.generateUserId();
            barrower1.setBid(userid);
            barrowerRepository.save(barrower1);
            BarrowerDto barrowerDto1 = modelMapper.map(barrower1,BarrowerDto.class);
            return barrowerDto1;
        }
        return null;
    }
}
