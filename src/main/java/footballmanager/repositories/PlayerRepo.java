package footballmanager.repositories;

import footballmanager.models.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepo extends JpaRepository<PlayerEntity, Long> {
}