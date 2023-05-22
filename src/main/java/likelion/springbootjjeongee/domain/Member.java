package likelion.springbootjjeongee.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Member {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String city;
    private String state;
    private String street;
    private String zipcode;
}
