package org.example.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BorrowerDto {
    private String borrowerId;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String address1;
    private String nic;
    private String country;
    private String phone_no;
    private String bid;
}
