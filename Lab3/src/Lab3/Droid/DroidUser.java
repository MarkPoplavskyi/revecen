package Lab3.Droid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class DroidUser extends Droid implements Shoot {

    public String setNameU() {

        System.out.println("Enter a droid name");

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String name = reader.readLine();
            return name;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int setDamageU() {

        System.out.println("Enter a droid damage");

        try {

            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
            String str = b.readLine();
            int damage = Integer.parseInt(str);
            return damage;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int setHealthU() {

        System.out.println("Enter a droid Health");

        try {

            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
            String str = b.readLine();
            int health = Integer.parseInt(str);
            return health;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int setArmorU() {

        System.out.println("Enter a droid Armor");

        try {

            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
            String str = b.readLine();
            int armor = Integer.parseInt(str);
            return armor;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int setEnergyU() {

        System.out.println("Enter a droid Energy Damage ");

        try {

            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
            String str = b.readLine();
            int energy = Integer.parseInt(str);
            return energy;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public DroidUser() {

        String name = setNameU();
        int damage = setDamageU();
        int health = setHealthU();
        int armor = setArmorU();
        int energy = setEnergyU();

        setName(name);
        setDamage(damage);
        setHealth(health);
        setArmor(armor);
        setEnergy(energy);
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
            System.out.println("Damage done: " + (healthBeforeHitted - droidEndured.getHealth()) + "\n");
            droid.setEnergy(droid.getEnergy() - getDamage());

            if (droid.getEnergy() == 0 || droid.getEnergy() < 0) {

                int bonus = droid.getDamage() / 3;
                droid.setEnergy(bonus);

                return;
            }
        }

        if (int_random >= 50) {

            droidEndured.setHealth(droidEndured.getHealth() - (droid.getDamage() * 2 - droid.getEnergy() / 8 - droidEndured.getArmor() / 30));
            System.out.println("Damage done: " + (healthBeforeHitted - droidEndured.getHealth()) + "\n");
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
        return "User: " + getName()  + "(HP: " + getHealth() +  "AR: " +getArmor() + " ES: " + getEnergy() + " Dmg: " + getDamage() + ")";
    }
}




