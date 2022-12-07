package Lab3.Droid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static Lab3.Droid.Droidbots.fillingBots;

public class FillingTeams {

    private List<Droid> droidList = new ArrayList<>(); // dynamic memory
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public FillingTeams() {
        fillTeam();
    }

    private Droid chooseDroid() throws IOException { // дороби

        try {

            Droid droid = null;
            System.out.println("\tChoose a droid:");
            System.out.println(" (1) = DroidSword\n (2) = DroidSniper\n (3) = DroidUser(enter the values yourself)\n");
            String enter = reader.readLine();

            if (enter.equals("1")) droid = new DroidSword();

            if (enter.equals("2")) droid = new DroidSniper();

            if (enter.equals("3")) droid = new DroidUser();

            if (!enter.equals("1") && !enter.equals("2") && !enter.equals("3")) throw new Exception("n!=1 !=2 !=3");

            return droid;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void fillTeam() {

        System.out.println("How many droids should be on the team?");

        try {

            int i = 0;
            BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
            String str = b.readLine();
            int n = Integer.parseInt(str);

            if (n < 0) throw new Exception("n<0");

            if (n >= 3) {

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("if you want the default number of bots (3 drones), enter Yes");
                String s = br.readLine();

                if (Objects.equals(s, "Yes")) {

                    System.out.println("do you want bots as 1 drone or as different drones");
                    String strin = br.readLine();

                    if (Objects.equals(strin, "Yes")) {

                        Droid[] droidBots = fillingBots("C:\\Users\\mpopl\\OneDrive\\Робочий стіл\\1-Курс\\Lab3");
                        for (Droid droid : droidBots) {
                            droidList.add(droid);

                            i++;

                        }
                    }

                    if (!Objects.equals(strin, "Yes")) {

                        Droid[] droidBots = fillingBots("C:\\Users\\mpopl\\OneDrive\\Робочий стіл\\1-Курс\\Lab3");
                        for (Droid droid : droidBots) {
                            droidList.add(droid);

                        }

                        i++;
                    }
                }
            }

            for (; i < n; i++) {
                System.out.println("Choose droid №" + (i + 1));

                try {
                    droidList.add(chooseDroid());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Droid> getDroidList() {
        return droidList;
    }

    public void info() {

        for (int i = 1; i <= getDroidList().size(); i++)
            System.out.println(i + ". " + getDroidList().get(i - 1));

    }
}
