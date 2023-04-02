package ro.online.store.convertor;

import ro.online.store.dto.OrderDTO;
import ro.online.store.entity.OrderEntity;

import java.util.stream.Collectors;

public class OrderConvertor {

    public static OrderEntity map(OrderDTO orderDTO){
        return new OrderEntity(
                orderDTO.getUserName(),
                orderDTO.getTotalCost(),
                orderDTO.getDeliveryAddress(),
                orderDTO.getUserAddress(),
                orderDTO.getDateOfSubmission(),
                orderDTO.getOrderLineDTOList()
                        .stream()
                        .map(orderLineDTO -> OrderLineConvertor.map(orderLineDTO))
                        .toList(),
                orderDTO.getStatus());
    }

    public static OrderDTO map(OrderEntity orderEntity){
        return new OrderDTO(
                orderEntity.getUserName(),
                orderEntity.getDeliveryAddress(),
                orderEntity.getUserAddress(),
                orderEntity.getDateOfSubmission(),
                orderEntity.getOrderLineEntityList()
                        .stream()
                        .map(orderLineEntity -> OrderLineConvertor.map(orderLineEntity))
                        .toList(),
                orderEntity.getStatus()
        );
    }
}
