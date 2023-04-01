package ro.online.store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ro.online.store.utils.Role;

@Entity(name = "user")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    private String email;
    private String password;
    private String city;
    private String address;
    private Role role;

    public UserEntity() {
    }

    public UserEntity(
            String email,
            String password,
            String city,
            String address,
            Role role) {
        this.email = email;
        this.password = password;
        this.city = city;
        this.address = address;
        this.role = role;
    }
}
