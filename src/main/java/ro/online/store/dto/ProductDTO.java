package ro.online.store.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.online.store.entity.CategoryEntity;
import ro.online.store.utils.ProductType;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private String description;
    private String thumbnail;
    private CategoryDTO categoryDTO;
    @NotNull(message = "Price must not be null")
    private Double price;
    private ProductType productType;
    private List<ManufacturerDTO> manufacturerDTOList;
}
