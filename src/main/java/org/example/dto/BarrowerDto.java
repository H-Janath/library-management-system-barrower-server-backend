package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BarrowerDto {
    private Long bid;
    private String barrower_name;
    private String contact_no;
    private String address;
    private String nic;
}
