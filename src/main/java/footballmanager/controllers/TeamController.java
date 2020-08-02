package footballmanager.controllers;

import footballmanager.dto.Team;
import footballmanager.generators.TeamGenerator;
import footballmanager.models.TeamEntity;
import footballmanager.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Iterator;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamService teamService;
    @Autowired
    private TeamGenerator teamGenerator;

    @GetMapping("/{id}")
    public Team getTeam(@PathVariable("id") Long id) {
        return new Team(teamService.findById(id));
    }

    @PostMapping("/create")
    public TeamEntity createTeam(@RequestBody TeamEntity team) {
        return teamService.create(team);
    }

    @PostMapping("/generate")
    public TeamEntity generateTeam() {
        TeamEntity teamEntity = teamGenerator.generateNewTeam();
        return teamService.create(teamEntity);
    }

    @PutMapping("/{id}")
    public TeamEntity update(@RequestBody TeamEntity teamEntity, @PathVariable("id") Long id) {
        return teamService.update(id, teamEntity);
    }

    @GetMapping
    public Iterable<Team> getTeams () {
        Iterable<TeamEntity> teamEntities = teamService.getAll();
        Iterator<TeamEntity> iterator = teamEntities.iterator();
        HashSet<Team> teams = new HashSet<>();
        while (iterator.hasNext()) {
            teams.add(new Team(iterator.next()));
        }
        return teams;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        teamService.deleteById(id);
    }
}
