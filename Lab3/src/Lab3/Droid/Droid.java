package Lab3.Droid;

import java.util.Random;

public abstract class Droid implements Shoot {
    String name;
    protected int damage;
    int health;
    int armor;
    int energy;

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getArmor() {
        return armor;
    }

    public int getEnergy() {
        return energy;
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
            System.out.println("Damage done" + (healthBeforeHitted - droidEndured.getHealth()) + "\n");
            droid.setEnergy(droid.getEnergy() - droid.getDamage());

            if (droid.getEnergy() == 0 || droid.getEnergy() < 0) {

                int bonus = droid.getDamage() / 3;
                droid.setEnergy(bonus);

                return;
            }
        }
    }
}
