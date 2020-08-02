package footballmanager.services;

import footballmanager.models.PlayerEntity;
import footballmanager.repositories.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepo playerRepo;

    public PlayerEntity findById(Long id) {
        return playerRepo.getOne(id);
    }

    public PlayerEntity create(PlayerEntity playerEntity) {
        return playerRepo.save(playerEntity);
    }

    public void deleteById(Long id) {
        playerRepo.deleteById(id);
    }

    public PlayerEntity update(Long id, PlayerEntity playerEntity) {
        playerEntity.setId(id);
        return playerRepo.save(playerEntity);
    }

    public Iterable<PlayerEntity> getAll() {
        return playerRepo.findAll();
    }
}
