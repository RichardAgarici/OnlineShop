package ro.online.store.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import ro.online.store.entity.OrderLineEntity;
import ro.online.store.utils.Status;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class OrderCreateDTO {

    @NotNull(message = "User Name must not be null")
    private String userName;
    private Double totalCost;
    private String deliveryAddress;
    private String userAddress;
    private String dateOfSubmission;
    private List<OrderLineEntity> orderLineEntityList;
    private Status status;

    private static Double calculateTotalCost(List<OrderLineEntity> orderLineEntityList){
        Double totalPrice = 0.0;
        if(!orderLineEntityList.isEmpty()){
            for(int i = 0; i< orderLineEntityList.size(); i++){
                totalPrice = totalPrice +
                        (orderLineEntityList.get(i).getPrice()* orderLineEntityList.get(i).getNumberOfProducts());
            }
            return totalPrice;
        }
        return totalPrice;
    }

    public OrderCreateDTO(
            String userName,
            String deliveryAddress,
            String userAddress,
            String dateOfSubmission,
            List<OrderLineEntity> orderLineEntityList,
            Status status) {
        this.userName = userName;
        this.totalCost = calculateTotalCost(orderLineEntityList);
        this.deliveryAddress = deliveryAddress;
        this.userAddress = userAddress;
        this.dateOfSubmission = dateOfSubmission;
        this.orderLineEntityList = orderLineEntityList;
        this.status = status;
    }
}
