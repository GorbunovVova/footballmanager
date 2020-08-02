package footballmanager.dto;

import footballmanager.enums.Role;
import footballmanager.models.TeamEntity;
import footballmanager.models.UserEntity;
import lombok.Data;

@Data
public class User {
    private long id;
    private String nick;
    private String teamName;
    private long teamId;
    private Role role;
    private String gender;
    private int cash;
    private String PhotoPath;

    public User(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.nick = userEntity.getNick();
        TeamEntity teamEntity = userEntity.getTeam();
        if (teamEntity != null) {
            this.teamName = teamEntity.getName();
            this.teamId = teamEntity.getId();
        }
        this.role = userEntity.getRole();
        this.gender = userEntity.getGender();
        this.cash = userEntity.getCash();
        PhotoPath = userEntity.getPhotoPath();
    }
}
