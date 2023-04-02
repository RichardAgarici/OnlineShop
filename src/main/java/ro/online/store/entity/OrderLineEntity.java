package ro.online.store.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "order_line")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class OrderLineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_line_product_id", referencedColumnName = "id")
    private ProductEntity product;

    @Column(name = "number_of_products")
    private Integer numberOfProducts;

    private Double price;

    public OrderLineEntity() {
    }

    public OrderLineEntity(ProductEntity product, Integer numberOfProducts, Double price) {
        this.product = product;
        this.numberOfProducts = numberOfProducts;
        this.price = price;
    }
}
