package ro.online.store.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ro.online.store.utils.ProductType;

import java.util.List;

@Entity(name = "product")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;
    private String thumbnail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private CategoryEntity categoryEntity;


    private Double price;

    @Column(name = "product_type")
    private ProductType productType;


    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "fk_product_manufacturer", referencedColumnName = "id")
    private List<ManufacturerEntity> manufacturerEntityList;

    public ProductEntity() {
    }

    public ProductEntity(
            String description,
            String thumbnail,
            CategoryEntity categoryEntity,
            Double price,
            ProductType productType,
            List<ManufacturerEntity> manufacturerEntityList) {
        this.description = description;
        this.thumbnail = thumbnail;
        this.categoryEntity = categoryEntity;
        this.price = price;
        this.productType = productType;
        this.manufacturerEntityList = manufacturerEntityList;
    }

}
