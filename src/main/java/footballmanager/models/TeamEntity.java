package footballmanager.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="team")
public class TeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @OneToOne
    private UserEntity user;
    private String country;
    @JsonManagedReference
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<PlayerEntity> players;
    private long cash;
    private int stadiumCapacity;
    private String stadiumName;
    private boolean scout;
    private long sponsorContract;

    public TeamEntity(String name, String country, List<PlayerEntity> players, long cash, int stadiumCapacity, String stadiumName, boolean scout, long sponsorContract) {
        this.name = name;
        this.country = country;
        this.players = players;
        this.cash = cash;
        this.stadiumCapacity = stadiumCapacity;
        this.stadiumName = stadiumName;
        this.scout = scout;
        this.sponsorContract = sponsorContract;
    }

    public TeamEntity() {
    }
}
