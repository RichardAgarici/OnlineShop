package ro.online.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManufacturerInfoDTO {

    private Integer id;
    private String firstName;
    private String lastName;

}
