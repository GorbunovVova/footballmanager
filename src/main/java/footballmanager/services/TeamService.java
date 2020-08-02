package footballmanager.services;

import footballmanager.models.TeamEntity;
import footballmanager.repositories.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    @Autowired
    private TeamRepo teamRepo;

    public TeamEntity findById(Long id) {
        return teamRepo.getOne(id);
    }

    public TeamEntity create(TeamEntity teamEntity) {
        return teamRepo.save(teamEntity);
    }

    public void deleteById(Long id) {
        teamRepo.deleteById(id);
    }

    public TeamEntity update(Long id, TeamEntity teamEntity) {
        teamEntity.setId(id);
        return teamRepo.save(teamEntity);
    }

    public Iterable<TeamEntity> getAll() {
        return teamRepo.findAll();
    }
}