package org.example.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomResponse<T> {
    private String userId;
    private String status;

    CustomResponse(String status){
        this.status =status;
    }
}