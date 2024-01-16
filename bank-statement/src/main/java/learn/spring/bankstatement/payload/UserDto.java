package learn.spring.bankstatement.payload;

import jakarta.validation.constraints.Email;
import learn.spring.bankstatement.entity.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private Long userId;
    private String name;
    private String address;

    private String phone;

    @Email(message = "Please provide a valid email address")
    private String email;


    public UserDto(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
}
