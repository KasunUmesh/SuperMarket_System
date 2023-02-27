package entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer {
    @Id
    private String id;
    private String title;
    private String name;
    private String address;
    private String city;
    private String province;
    private String postalCode;

}
