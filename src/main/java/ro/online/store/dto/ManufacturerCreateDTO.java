package ro.online.store.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManufacturerCreateDTO {

    @NotNull(message = "First Name can not be null")
    private String firstName;
    @NotNull(message = "Last name can not be null")
    private String lastName;
}
