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
    @GeneratedValue(strategy = GenerationType.AUTO)
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


    public String generateUserId() {
        // Example logic: Combine auto-generated ID with custom prefix
        if (id != null) {
            this.bid = "USR" + id; // Example prefix + auto-generated ID
            return bid;
        } else {
            // Handle the case where the ID is not set yet
            // This might happen if the object is not persisted yet
            this.bid = "USR0001";
        }
        return null;
    }
}