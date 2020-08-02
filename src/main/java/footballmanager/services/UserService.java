package footballmanager.services;

import footballmanager.models.UserEntity;
import footballmanager.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserEntity findById(Long id) {
        return userRepo.getOne(id);
    }

    public UserEntity create(UserEntity userEntity) {
        return userRepo.save(userEntity);
    }

    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }

    public UserEntity update(Long id, UserEntity userEntity) {
        userEntity.setId(id);
        return userRepo.save(userEntity);
    }

    public Iterable<UserEntity> getAll() {
        return userRepo.findAll();
    }
}
