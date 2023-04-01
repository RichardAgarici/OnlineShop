package ro.online.store.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCreateDTO {

    @NotBlank(message = "Category Name Mandatory")
    private String name;
}
