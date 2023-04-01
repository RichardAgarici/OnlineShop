package ro.online.store.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.online.store.utils.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDTO {

    @NotNull(message = "Email must not be null")
    private String email;
    @NotNull(message = "Password is mandatory")
    private String password;
    private String city;
    private String address;
    private Role role;
}
