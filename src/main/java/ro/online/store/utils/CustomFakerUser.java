package ro.online.store.utils;

import com.github.javafaker.Faker;
import ro.online.store.entity.CategoryEntity;
import ro.online.store.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class CustomFakerUser {

    public List<UserEntity> generateDummyCategories(){
        List<UserEntity> users = new ArrayList<>();
        Faker faker = new Faker();
        for(int i = 0; i <= 100; i++){
            UserEntity userEntity = new UserEntity(
                    faker.bothify("?????##@company.com"),
                    faker.aviation().aircraft(),
                    faker.address().city(),
                    faker.address().streetAddress(),
                    Role.USER);
            users.add(userEntity);
        }
        return users;
    }
}
