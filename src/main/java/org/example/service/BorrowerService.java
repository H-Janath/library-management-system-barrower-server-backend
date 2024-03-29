package org.example.service;

import org.example.dto.BorrowerDto;

import java.util.List;
import java.util.Optional;

public interface BorrowerService {

    List<BorrowerDto> getBarrowers();

    boolean deleteBarrower(String bid);

    Optional<BorrowerDto> findByID(String bid);

    void updateBarrower(BorrowerDto borrowerDto);
    BorrowerDto addBorrower(BorrowerDto barrower);
    public String generateBorrowerId();

    BorrowerDto getBorrowerById(String id);
}
