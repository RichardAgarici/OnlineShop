package ro.online.store.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.online.store.utils.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDTO {

    private String id;
    private String email;
    private String city;
    private String address;
}
