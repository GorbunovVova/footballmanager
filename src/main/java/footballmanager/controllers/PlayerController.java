package footballmanager.controllers;

import footballmanager.dto.Player;
import footballmanager.models.PlayerEntity;
import footballmanager.generators.PlayerGenerator;
import footballmanager.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Iterator;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private PlayerGenerator playerGenerator;


    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable("id") Long id) {
        return new Player(playerService.findById(id));
    }

    @PostMapping("/create")
    public PlayerEntity createPlayer(@RequestBody PlayerEntity player) {
        return playerService.create(player);
    }

    @PostMapping("/generate")
    public PlayerEntity generatePlayer() {
        PlayerEntity playerEntity = playerGenerator.generateNewPlayer();
        return playerService.create(playerEntity);
    }

    @PutMapping("/{id}")
    public PlayerEntity update(@RequestBody PlayerEntity playerEntity, @PathVariable("id") Long id) {
        return playerService.update(id, playerEntity);
    }

    @GetMapping
    public Iterable<Player> getPlayers() {
        Iterable<PlayerEntity> playerEntities = playerService.getAll();
        Iterator<PlayerEntity> iterator = playerEntities.iterator();
        HashSet<Player> players = new HashSet<>();
        while (iterator.hasNext()) {
            players.add(new Player(iterator.next()));
        }
        return players;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        playerService.deleteById(id);
    }
}
