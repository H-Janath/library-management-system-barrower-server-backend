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
}
