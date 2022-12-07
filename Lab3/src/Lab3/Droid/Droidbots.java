package Lab3.Droid;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.*;

public class Droidbots extends Droid implements Shoot {



    public Droidbots(String name, int damage,int health,int armor,int energy) {

    this.name=name;
    this.damage=damage;
    this.health=health;
    this.armor=armor;
    this.energy=energy;

    }

    public static Droidbots[] fillingBots(String filename) {

        Pattern namePattern = Pattern.compile("(?<=NAME:).*?(?=[;\\n])");
        Pattern damagePattern = Pattern.compile("(?<=DAMAGE:).*?(?=[;\\n])");
        Pattern healthPattern = Pattern.compile("(?<=HEALTH:).*?(?=[;\\n])");
        Pattern armorPattern = Pattern.compile("(?<=ARMOR:).*?(?=[;\\n])");
        Pattern energyPattern = Pattern.compile("(?<=ENERGY:).*?(?=[;\\n])");

        ArrayList<Droidbots> droidbots = new ArrayList<>();
        Droidbots d;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {

                Matcher matcherName = namePattern.matcher(line);
                Matcher matcherDamage = damagePattern.matcher(line);
                Matcher matcherHealth = healthPattern.matcher(line);
                Matcher matcherarmor = armorPattern.matcher(line);
                Matcher matcherenergy = energyPattern.matcher(line);

                String name = "";
                while (matcherName.find()) {
                    name = matcherName.group();
                }
                if (Objects.equals(name, ""))
                    throw new Exception("An empty field with a name");

                String damage = "";
                while (matcherDamage.find()) {
                    damage = matcherDamage.group();
                }
                if (Objects.equals(damage, ""))
                    throw new Exception("An empty field with a damage");

                String health = "";
                while (matcherHealth.find()) {
                    health = matcherHealth.group();
                }
                if (Objects.equals(health, ""))
                    throw new Exception("An empty field with a health");

                String armor = "";
                while (matcherarmor.find()) {
                    armor = matcherarmor.group();
                }
                if (Objects.equals(armor, ""))
                    throw new Exception("An empty field with an armor");

                String energy = "";
                while (matcherenergy.find()) {
                    energy = matcherenergy.group();
                }
                if (Objects.equals(matcherenergy, ""))
                    throw new Exception("An empty field with an energy");

                d = new Droidbots(name, Integer.parseInt(damage), Integer.parseInt(health),
                        Integer.parseInt(armor), Integer.parseInt(energy));

                droidbots.add(d);
                 line = reader.readLine();

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return droidbots.toArray(new Droidbots[0]);
    }

    @Override

    public void shoot(Droid droid, Droid droidEndured) {

        int healthBeforeHitted = droidEndured.getHealth();
        int energy = droid.getEnergy();

        Random rand = new Random();
        int random = 100;
        int int_random = rand.nextInt(random);

        if (int_random < 50) {

            droidEndured.setHealth(droidEndured.getHealth() - (droid.getDamage() - droid.getEnergy() / 10 - droidEndured.getArmor() / 15));
            System.out.println("Damage done" + (healthBeforeHitted - droidEndured.getHealth()) + "\n");
            droid.setEnergy(droid.getEnergy() - getDamage());

            if (droid.getEnergy() == 0 || droid.getEnergy() < 0) {

                int bonus = droid.getDamage() / 3;
                droid.setEnergy(bonus);

                return;
            }
        }

        if (int_random >= 50) {

            droidEndured.setHealth(droidEndured.getHealth() - (droid.getDamage() * 2 - droid.getEnergy() / 8 - droidEndured.getArmor() / 30));
            System.out.println("Damage done" + (healthBeforeHitted - droid.getHealth()) + "\n");
            droid.setEnergy(droid.getEnergy() - droid.getDamage());

            if (droid.getEnergy() == 0 || droid.getEnergy() < 0) {

                int bonus = droid.getDamage() / 3;
                droid.setEnergy(bonus);

                return;
            }
        }
    }


    @Override

    public String toString() {
        return "User" + getName() + "(HP: " + getHealth() +  "AR: " + getArmor() +
                " ES: " + getEnergy() + " Dmg: " + getDamage() + ")";
    }
}