package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.Entity.Barrower;
import org.example.repository.BarrowerRepository;
import org.example.service.BarrowerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BarrowerServiceImpl implements BarrowerService {

    final BarrowerRepository barrowerRepository;


    @Override
    public List<Barrower> getBarrowers() {
        return (List<Barrower>) barrowerRepository.findAll();
    }
}
