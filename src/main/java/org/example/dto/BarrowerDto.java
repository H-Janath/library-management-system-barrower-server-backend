package org.example.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BarrowerDto {
    private Long id;
    private String bid;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String address1;
    private String address2;
    private String country;
    private String phone_no;
}
