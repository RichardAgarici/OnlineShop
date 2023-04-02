package ro.online.store.convertor;

import ro.online.store.dto.OrderLineDTO;
import ro.online.store.entity.OrderEntity;
import ro.online.store.entity.OrderLineEntity;

public class OrderLineConvertor {

    public static OrderLineEntity map(OrderLineDTO orderLineDTO){
        return new OrderLineEntity(
                orderLineDTO.getProduct(),
                orderLineDTO.getNumberOfProducts(),
                orderLineDTO.getPrice());
    }

    public static OrderLineDTO map(OrderLineEntity orderLineEntity){
        return new ro.online.store.dto.OrderLineDTO(
                orderLineEntity.getProduct(),
                orderLineEntity.getNumberOfProducts(),
                orderLineEntity.getPrice());
    }
}
