package footballmanager.models;

import footballmanager.enums.Role;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nick;
    @OneToOne
    private TeamEntity team;
    private Role role;
    private String gender;
    private int cash;
    private String PhotoPath;
}
