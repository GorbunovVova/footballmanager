package footballmanager.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="player")
public class  PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int age;
    private String nationality;
    private int salary;
    private int contract;
    private int talent;
    private int greed;
    private int universality;
    private int shape;
    private int moral;
    private int shot;
    private int longShot;
    private int dribbling;
    private int pass;
    private int highCross;
    private int headPlay;
    private int speed;
    private int selection;
    private int positionChoice;
    private int stamina;
    private int lead;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY,optional=true)
    @JoinColumn(name = "team_id")
    private TeamEntity team;

    public PlayerEntity(String name, int age, String nationality, int salary, int contract, int talent, int greed
            , int universality, int shape, int moral, int shot, int longShot, int dribbling, int pass, int highCross
            , int headPlay, int speed, int selection, int positionChoice, int stamina, int lead) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.salary = salary;
        this.contract = contract;
        this.talent = talent;
        this.greed = greed;
        this.universality = universality;
        this.shape = shape;
        this.moral = moral;
        this.shot = shot;
        this.longShot = longShot;
        this.dribbling = dribbling;
        this.pass = pass;
        this.highCross = highCross;
        this.headPlay = headPlay;
        this.speed = speed;
        this.selection = selection;
        this.positionChoice = positionChoice;
        this.stamina = stamina;
        this.lead = lead;
    }

    public PlayerEntity() {
    }
}
