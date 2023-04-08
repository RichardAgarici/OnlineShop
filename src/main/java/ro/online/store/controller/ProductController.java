package ro.online.store.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.online.store.dto.ProductDTO;
import ro.online.store.dto.ProductInfoDTO;
import ro.online.store.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/api/product")
@ControllerAdvice

public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public ResponseEntity<ProductInfoDTO> create(@RequestBody @Valid ProductDTO productDTO){
        return ResponseEntity.ok(productService.createProduct(productDTO));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductInfoDTO> findProductById (@PathVariable Integer id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/find_all")
    public ResponseEntity<List<ProductInfoDTO>> findAll (){
        return ResponseEntity.ok(productService.findAllProducts());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id){
        if(productService.deleteById(id)){
            return ResponseEntity.ok(Boolean.TRUE);
        }
        return ResponseEntity.notFound().build();
    }
}
