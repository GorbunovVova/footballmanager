package footballmanager.generators;

import footballmanager.enums.Nationality;
import footballmanager.models.PlayerEntity;
import footballmanager.models.TeamEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeamGenerator {
    Nationality[] nationalities = Nationality.values();
    @Autowired
    PlayerGenerator playerGenerator;

    public TeamGenerator() {
    }

    public TeamEntity generateNewTeam() {
        String name = "Команда";
        int i = (int) (Math.random() * nationalities.length);
        String country = String.valueOf(nationalities[i]);
        List<PlayerEntity> players = generateNewPlayers(country);
        long cash = 1000000;
        int stadiumCapacity = 500;
        String stadiumName = "Стадион";
        boolean scout = false;
        long sponsorContract = 10000;
        TeamEntity team = new TeamEntity(name, country, players, cash, stadiumCapacity, stadiumName, scout, sponsorContract);
        setTeamToPlayers(team);
        return team;
    }

    private void setTeamToPlayers(TeamEntity team) {
        List<PlayerEntity> players = team.getPlayers();
        for (PlayerEntity player : players) {
            player.setTeam(team);
        }
    }

    private List<PlayerEntity> generateNewPlayers(String country) {
        List<PlayerEntity> players = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            PlayerEntity player = playerGenerator.generateNewPlayer();
            players.add(player);
        }
        return players;
    }
}
