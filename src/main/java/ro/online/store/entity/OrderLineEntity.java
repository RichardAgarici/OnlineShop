package ro.online.store.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Entity(name = "order_line")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class OrderLineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    @OneToMany(targetEntity = ProductEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_order_line_product", referencedColumnName = "id")
    private List<ProductEntity> products;

    @Column(name = "number_of_products")
    private Integer numberOfProducts;

    private Double price;

    public OrderLineEntity() {
    }

    public OrderLineEntity(List<ProductEntity> products, Integer numberOfProducts, Double price) {
        this.products = products;
        this.numberOfProducts = numberOfProducts;
        this.price = price;
    }
}
