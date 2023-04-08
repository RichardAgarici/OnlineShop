package ro.online.store.service;

import ro.online.store.convertor.ProductConvertor;
import ro.online.store.dto.ProductDTO;
import ro.online.store.dto.ProductInfoDTO;
import ro.online.store.entity.ProductEntity;
import ro.online.store.exception.ProductCustomException;
import ro.online.store.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductInfoDTO createProduct(ProductDTO productDTO) {
        ProductEntity productsToSave = ProductConvertor.map(productDTO);
        ProductEntity savedProduct = productRepository.save(productsToSave);
        return ProductConvertor.mapInfoDTO(savedProduct);
    }

    public ProductInfoDTO getProductById(Integer id) {
        ProductEntity productEntity = productRepository
                .findById(id)
                .orElseThrow(() -> new ProductCustomException("Could not find the product with id "+id));
        return ProductConvertor.mapInfoDTO(productEntity);
    }

    public List<ProductInfoDTO> findAllProducts() {
        List<ProductEntity> productEntityList = new ArrayList<>();
        productRepository.findAll().forEach(productEntity -> productEntityList.add(productEntity));

        return productEntityList.stream().map(productEntity -> ProductConvertor.mapInfoDTO(productEntity)).toList();
    }

    public Boolean deleteById (Integer id) {
        try {
            productRepository.deleteById(id);
            return Boolean.TRUE;
        }
        catch (Exception e){
            System.out.println("Couldn't find this product to delete from the list. Please enter a valid product");
            return Boolean.FALSE;
        }
    }
}
