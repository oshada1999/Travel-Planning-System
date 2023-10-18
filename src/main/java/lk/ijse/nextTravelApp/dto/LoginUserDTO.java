package lk.ijse.nextTravelApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class LoginUserDTO {
    private String loginEmail;
    private String loginPassword;
}
