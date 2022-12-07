package Lab3.Droid;

import java.util.Random;

public class DroidSniper extends Droid implements Shoot {

    public   DroidSniper() {

        setName("DroidSniper");
        setDamage(1200);
        setArmor(1850);
        setEnergy(2800);
        setHealth(3950);
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

    @Override

    public String toString() {
       return  "User"+getName()+ "(HP: " + getHealth() + "AR: " +getArmor() +
               " ES: " + getEnergy() + " Dmg: " + getDamage()+")";
    }
}


