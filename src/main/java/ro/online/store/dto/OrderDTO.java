package ro.online.store.dto;

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
public class OrderDTO {

    @NotNull(message = "User Name must not be null")
    private String userName;
    private Double totalCost;
    private String deliveryAddress;
    private String userAddress;
    private String dateOfSubmission;
    private List<OrderLineDTO> orderLineDTOList;
    private Status status;

    private static Double calculateTotalCost(List<OrderLineDTO> orderLineDTOList){
        Double totalPrice = 0.0;
        if(!orderLineDTOList.isEmpty()){
            for(int i = 0; i< orderLineDTOList.size(); i++){
                totalPrice = totalPrice +
                        (orderLineDTOList.get(i).getPrice()* orderLineDTOList.get(i).getNumberOfProducts());
            }
            return totalPrice;
        }
        return totalPrice;
    }

    public OrderDTO(
            String userName,
            String deliveryAddress,
            String userAddress,
            String dateOfSubmission,
            List<OrderLineDTO> orderLineDTOList,
            Status status) {
        this.userName = userName;
        this.totalCost = calculateTotalCost(orderLineDTOList);
        this.deliveryAddress = deliveryAddress;
        this.userAddress = userAddress;
        this.dateOfSubmission = dateOfSubmission;
        this.orderLineDTOList = orderLineDTOList;
        this.status = status;
    }
}
