package balachonov.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity (name = "User")
@Table(name = "USERS")
@Where(clause = "DELETED = 0")
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID_USER", unique = true)
    private String idUser;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "SALT")
    private String salt;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_ROLE")
    private UserRole userRole;

    @OneToMany(mappedBy = "user")
    List<UserFood> orders;

    @Column(name = "DELETED")
    private Integer deleted = 0;

    public void setDeleted() {
        this.deleted = 1;
    }
}
