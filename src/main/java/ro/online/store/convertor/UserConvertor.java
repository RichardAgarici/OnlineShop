package ro.online.store.convertor;

import ro.online.store.dto.UserCreateDTO;
import ro.online.store.dto.UserInfoDTO;
import ro.online.store.entity.UserEntity;

public class UserConvertor {

    public static UserEntity map(UserCreateDTO userCreateDTO){
        return new UserEntity(
                userCreateDTO.getEmail(),
                userCreateDTO.getPassword(),
                userCreateDTO.getCity(),
                userCreateDTO.getAddress(),
                userCreateDTO.getRole());
    }
    public static UserInfoDTO map(UserEntity userEntity){
        return new UserInfoDTO(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getCity(),
                userEntity.getAddress());
    }
}
