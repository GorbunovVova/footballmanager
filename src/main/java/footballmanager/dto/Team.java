package footballmanager.dto;

import footballmanager.models.PlayerEntity;
import footballmanager.models.TeamEntity;
import footballmanager.models.UserEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
public class Team {
    private long id;
    private String name;
    private String userName;
    private long userId;
    private String country;
    private List<Player> players;
    private long cash;
    private int stadiumCapacity;
    private String stadiumName;
    private boolean scout;
    private long sponsorContract;

    public Team(TeamEntity teamEntity) {
        this.id = teamEntity.getId();
        this.name = teamEntity.getName();
        UserEntity userEntity = teamEntity.getUser();
        if (userEntity != null) {
            this.userName = userEntity.getNick();
            this.userId = userEntity.getId();
        }
        this.country = teamEntity.getCountry();
        this.cash = teamEntity.getCash();
        this.stadiumCapacity = teamEntity.getStadiumCapacity();
        this.stadiumName = teamEntity.getStadiumName();
        this.scout = teamEntity.isScout();
        this.sponsorContract = teamEntity.getSponsorContract();
        // перекладываем из playerEntities в players (DTO)
        Iterable<PlayerEntity> playerEntities = teamEntity.getPlayers();
        Iterator<PlayerEntity> iterator = playerEntities.iterator();
        this.players = new ArrayList<>();
        while (iterator.hasNext()) {
            this.players.add(new Player(iterator.next()));
        }
    }
}
