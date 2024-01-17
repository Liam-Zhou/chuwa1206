package com.chuwa.bankstatement.payload;

import com.chuwa.bankstatement.validationgroup.Create;
import com.chuwa.bankstatement.validationgroup.Update;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    @NotNull(groups = Create.class)
    private String name;
    @NotNull(groups = Create.class)
    @Size(max = 255)
    private String address;
    @NotNull(groups = Create.class)
    @Size(min = 10, max = 10)
    private String phone;
    @NotNull(groups = Create.class)
    @Email(groups = {Create.class, Update.class}, message = "Please provide a valid email address")
    private String email;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;
    private Set<AccountDto> accounts;

}

