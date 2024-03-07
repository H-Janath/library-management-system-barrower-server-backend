package org.example.service;

import org.example.Entity.Barrower;
import org.example.dto.BarrowerDto;

import java.util.List;
import java.util.Optional;

public interface BarrowerService {

    List<BarrowerDto> getBarrowers();

    boolean deleteBarrower(String bid);

    Optional<BarrowerDto> findByID(String bid);

    void updateBarrower(BarrowerDto barrowerDto);
    BarrowerDto addBorrower(BarrowerDto barrower);
    public String generateBorrowerId();
}
