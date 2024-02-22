package org.example.service;

import org.example.Entity.Barrower;
import org.example.dto.BarrowerDto;

import java.util.List;
import java.util.Optional;

public interface BarrowerService {

    List<BarrowerDto> getBarrowers();

    boolean deleteBarrower(Long bid);

    Optional<BarrowerDto> findByID(Long bid);
}
