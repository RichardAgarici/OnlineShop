package ro.online.store.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ro.online.store.utils.Status;

import java.util.List;

@Entity(name = "order_entity")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "total_cost")
    private Double totalCost;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @Column(name = "user_address")
    private String userAddress;

    @Column(name = "date_of_submission")
    private String dateOfSubmission;

    @OneToMany(targetEntity = OrderLineEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_place_order", referencedColumnName = "id")
    private List<OrderLineEntity> orderLineEntityList;

    private Status status;

    public OrderEntity() {
    }

    public OrderEntity(
            String userName,
            Double totalCost,
            String deliveryAddress,
            String userAddress,
            String dateOfSubmission,
            List<OrderLineEntity> orderLineEntityList,
            Status status) {
        this.userName = userName;
        this.totalCost = totalCost;
        this.deliveryAddress = deliveryAddress;
        this.userAddress = userAddress;
        this.dateOfSubmission = dateOfSubmission;
        this.orderLineEntityList = orderLineEntityList;
        this.status = status;
    }
}
