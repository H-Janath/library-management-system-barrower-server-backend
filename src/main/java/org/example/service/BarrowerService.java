package org.example.service;

import org.example.Entity.Barrower;
import org.example.dto.BarrowerDto;

import java.util.List;

public interface BarrowerService {

    List<BarrowerDto> getBarrowers();
}
