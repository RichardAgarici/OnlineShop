package ro.online.store.convertor;

import ro.online.store.dto.ProductDTO;
import ro.online.store.entity.ProductEntity;

public class ProductConvertor {
    public static ProductEntity map(ProductDTO productDTO){
        return new ProductEntity(
                productDTO.getDescription(),
                productDTO.getThumbnail(),
                CategoryConvertor.map(productDTO.getCategoryDTO()),
                productDTO.getPrice(),
                productDTO.getProductType(),
                productDTO.getManufacturerDTOList()
                        .stream()
                        .map(manufacturerDTO -> ManufacturerConvertor.map(manufacturerDTO))
                        .toList());
    }
    public static ProductDTO map(ProductEntity productEntity){
        return new ProductDTO(
                productEntity.getDescription(),
                productEntity.getThumbnail(),
                CategoryConvertor.mapDTO(productEntity.getCategoryEntity()),
                productEntity.getPrice(),
                productEntity.getProductType(),
                productEntity.getManufacturerEntityList()
                        .stream()
                        .map(manufacturerEntity -> ManufacturerConvertor.map(manufacturerEntity))
                        .toList());
    }
}
