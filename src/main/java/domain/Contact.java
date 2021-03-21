package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String gender;

    private String phoneNumber;

    public Contact(String firstName, String lastName, String gender, String phoneNumber){
        this.firstName = firstName;
        this.lastName =lastName;
        this.gender= gender;
        this.phoneNumber =phoneNumber;
    }

}
