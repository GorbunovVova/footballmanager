package footballmanager.dto;

import footballmanager.models.PlayerEntity;
import footballmanager.models.TeamEntity;
import lombok.Data;

@Data
public class Player {
    private long id;
    private String name;
    private int age;
    private String nationality;
    private int salary;
    private int contract;
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
    private String teamName;
    private long teamId;

    public Player(PlayerEntity playerEntity) {
        this.id = playerEntity.getId();
        this.name = playerEntity.getName();
        this.age = playerEntity.getAge();
        this.nationality = playerEntity.getNationality();
        this.salary = playerEntity.getSalary();
        this.contract = playerEntity.getContract();
        this.shape = playerEntity.getShape();
        this.moral = playerEntity.getMoral();
        this.shot = playerEntity.getShot();
        this.longShot = playerEntity.getLongShot();
        this.dribbling = playerEntity.getDribbling();
        this.pass = playerEntity.getPass();
        this.highCross = playerEntity.getHighCross();
        this.headPlay = playerEntity.getHeadPlay();
        this.speed = playerEntity.getSpeed();
        this.selection = playerEntity.getSelection();
        this.positionChoice = playerEntity.getPositionChoice();
        this.stamina = playerEntity.getStamina();
        this.lead = playerEntity.getLead();
        TeamEntity teamEntity = playerEntity.getTeam();
        if (teamEntity != null) {
            this.teamName = teamEntity.getName();
            this.teamId = teamEntity.getId();
        }
    }
}
