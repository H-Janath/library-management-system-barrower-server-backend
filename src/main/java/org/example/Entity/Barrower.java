package org.example.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Barrower {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long BID;
    private String barrower_name;
    private String contact_no;
    private String address;
    private String NIC;

}
