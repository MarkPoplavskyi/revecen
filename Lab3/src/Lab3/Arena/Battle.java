package Lab3.Arena;

import Lab3.Droid.FillingTeams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import static Lab3.Arena.Colors.ANSI_RED;
import static Lab3.Arena.Colors.ANSI_YELLOW;


public class Battle {

    int myDroidTurn;
    int enemyDroidTurn;
    int myDroidIndex;
    int enemyDroidIndex;
    int turnNumber = 1;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Battle(FillingTeams myTeam, FillingTeams enemyTeam, String name) {

        if(!name.equals("Auto")){

            while (!myTeam.getDroidList().isEmpty() && !enemyTeam.getDroidList().isEmpty()) {

                if(myTeam.getDroidList().isEmpty()){

                    System.out.println(ANSI_RED+"winner");
                    enemyTeam.info();
                    return;

                }

                System.out.println("Turn number " + turnNumber++);
                myTurn(myTeam, enemyTeam);

                enemyTeam.info();

                if(enemyTeam.getDroidList().isEmpty()){

                    System.out.println(ANSI_YELLOW + "winner");
                    myTeam.info();
                    return;

                }

                enemyTurn(myTeam, enemyTeam);

                myTeam.info();
            }
        }

        while (!myTeam.getDroidList().isEmpty() && !enemyTeam.getDroidList().isEmpty()) {

            System.out.println("Turn number " + turnNumber++);
            myTurnAuto(myTeam, enemyTeam);

            enemyTeam.info();

            if (enemyTeam.getDroidList().isEmpty()) {

                System.out.println(ANSI_YELLOW + "winner");
                myTeam.info();
                return;

            }

            enemyTurn(myTeam, enemyTeam);
            myTeam.info();

            if (name.equals("Auto")) {

                if (myTeam.getDroidList().isEmpty()) {

                    System.out.println(ANSI_RED + "winner");
                    enemyTeam.info();
                    return;

                }

            }
        }
    }

    private void enemyTurn(FillingTeams myTeam, FillingTeams enemyTeam) {

        Random random = new Random();

        if (myDroidIndex == 0)
            myDroidIndex = random.nextInt(myTeam.getDroidList().size());

        shootEnemyDroid(enemyTeam, myTeam, enemyDroidTurn, myDroidIndex);
        turn(enemyDroidTurn, enemyTeam);
        System.out.println(turnNumber++);
    }

    private void myTurnAuto(FillingTeams myTeam, FillingTeams enemyTeam) {

        Random random = new Random();

        if (enemyDroidIndex == 0)
            enemyDroidIndex = random.nextInt(enemyTeam.getDroidList().size());

        shootEnemyDroid(myTeam, enemyTeam, myDroidTurn, enemyDroidIndex);
        turn(myDroidTurn, myTeam);
        System.out.println(turnNumber++);

    }

    private void myTurn(FillingTeams myTeam, FillingTeams enemyTeam) {

        String enemyIndex;
        int enemyDroidIndex;

        if (turnNumber <= 2) {
            enemyTeam.info();
        }

        try {

           // System.out.println(myTeam.getDroidList().get(myDroidTurn) + "Turn");
            System.out.print("Choose your enemy!\n");
            enemyTeam.info();
            enemyIndex = reader.readLine();

            while (enemyIndex.isEmpty() || Integer.parseInt(enemyIndex) > enemyTeam.getDroidList().size()
                    || Integer.parseInt(enemyIndex) <= 0) {

                if (enemyIndex.isEmpty()){

                    System.out.println("You haven't enter anything!");
                    System.out.println("Please, choose enemy");
                    enemyTeam.info();
                    enemyIndex= reader.readLine();
                }


                if (Integer.parseInt(enemyIndex) <= 0){

                    System.out.println("You  enter <=0 ");
                    System.out.println("Please, choose enemy");
                    enemyTeam.info();
                    enemyIndex= reader.readLine();
                }
            }

            enemyDroidIndex = Integer.parseInt(enemyIndex)-1;
            shootEnemyDroid(myTeam, enemyTeam, myDroidTurn, enemyDroidIndex);

        } catch (IOException e) {
            e.printStackTrace();
        }

        turn(myDroidTurn, myTeam);
        System.out.println(turnNumber++);

    }


    private void turn(int turn, FillingTeams Team) {

        if (turn < Team.getDroidList().size() - 1)
            myDroidTurn++;

        if (turn >= Team.getDroidList().size() - 1)
            myDroidTurn = 0;

    }

    private static void shootEnemyDroid(FillingTeams myTeam, FillingTeams enemyTeam,
                                        int myDroidIndex, int enemyDroidIndex) {

      //if (myTeam.getDroidList().size()>=enemyTeam.getDroidList().size())
        myTeam.getDroidList().get(myDroidIndex).shoot(myTeam.getDroidList().get(myDroidIndex),enemyTeam.getDroidList().get(enemyDroidIndex));

      //if(myTeam.getDroidList().size()<enemyTeam.getDroidList().size())
         // myTeam.getDroidList().get(0).shoot(enemyTeam.getDroidList().get(enemyDroidIndex),enemyTeam.getDroidList().get(enemyDroidIndex));
        // remove droid if it has 0 HP
        if (enemyTeam.getDroidList().get(enemyDroidIndex).getHealth() <= 0)
            enemyTeam.getDroidList().remove(enemyDroidIndex);

    }
}
