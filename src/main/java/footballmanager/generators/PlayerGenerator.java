package footballmanager.generators;

import footballmanager.enums.Nationality;
import footballmanager.enums.firstNames.RUSFirstName;
import footballmanager.enums.lastNames.RUSLastName;
import footballmanager.models.PlayerEntity;
import org.springframework.stereotype.Component;

@Component
public class PlayerGenerator {
    Nationality[] nationalities = Nationality.values();
    RUSFirstName[] rusFirstNames = RUSFirstName.values();
    RUSLastName[] rusLastNames = RUSLastName.values();

    public PlayerGenerator() {
    }

    public PlayerEntity generateNewPlayer() {
        int i = (int) (Math.random() * nationalities.length);
        String nationality = String.valueOf(nationalities[i]);
        String name = generateName(nationality);
        int age = generateAge();
        int shape = 100;
        int moral = 100;
        int contract = generateOneToFive();
        int talent = generateOneToTen();
        int greed = generateOneToTen();
        int universality = generateOneToTen();
        int shot = generateOneToTen();
        int longShot = generateOneToTen();
        int dribbling = generateOneToTen();
        int pass = generateOneToTen();
        int highCross = generateOneToTen();
        int headPlay = generateOneToTen();
        int speed = generateOneToTen();
        int selection = generateOneToTen();
        int positionChoice = generateOneToTen();
        int stamina = generateOneToTen();
        int lead = generateOneToTen();
        int ss = getSS(shot, longShot, dribbling, pass, highCross, headPlay, speed, selection, positionChoice, stamina, lead);
        int salary = generateSalary(age, ss, greed);
        return new PlayerEntity(name, age, nationality, salary, contract, talent, greed
                , universality, shape, moral, shot, longShot, dribbling, pass, highCross
                , headPlay, speed, selection, positionChoice, stamina, lead);
    }

    private int getSS(int shot, int longShot, int dribbling, int pass, int highCross, int headPlay, int speed, int selection, int positionChoice, int stamina, int lead) {
        return shot + longShot + dribbling + pass + highCross + headPlay + speed + selection + positionChoice + stamina + lead;
    }

    private int generateSalary(int age, int ss, int greed) {
        return (int) (ss * (1 + (double) greed / 10) / age) * 100;
    }

    private int generateOneToTen() {
        return (int) (Math.random() * 10) + 1;
    }

    private int generateOneToFive() {
        return (int) (Math.random() * 5) + 1;
    }

    private int generateAge() {
        return (int) (Math.random() * 20) + 18;
    }

    private String generateName(String nationality) {
        int i = (int) (Math.random() * rusFirstNames.length);
        String firstName = String.valueOf(rusFirstNames[i]);
        i = (int) (Math.random() * rusLastNames.length);
        String lastName = String.valueOf(rusLastNames[i]);
        return firstName + " " + lastName;
    }
}
