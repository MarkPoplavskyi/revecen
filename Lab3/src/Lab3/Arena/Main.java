package Lab3.Arena;

import Lab3.Droid.FillingTeams;

import java.io.*;

import static Lab3.Arena.Colors.*;

public class Main { // і обнови вивід ботів

    public static void main(String[] args) throws IOException {

        System.out.println(ANSI_YELLOW + "Choose your droids!\n");

        FillingTeams team1 = new FillingTeams();
        System.out.println("Nice job! Here is your team list:");
        team1.info();

        System.out.println(ANSI_RED + "\nChoose enemy droids!\n");
        FillingTeams team2 = new FillingTeams();
        team2.info();

        System.out.println(ANSI_RESET + "auto battle or want to play?");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();

        if (!name.equals("Auto")) {
            Battle battle = new Battle(team1, team2, name);
        }

        if (name.equals("Auto")) {

            try {

                final boolean append = true, autoflush = true;
                PrintStream printWriter = new PrintStream(new FileOutputStream("test.txt", append), autoflush);
                PrintStream printStream = new PrintStream(System.out, autoflush); // для запису в консоль
                System.setOut(printWriter);
                printStream.println("Тестувати на консоль");
                System.setErr(printWriter);

            } catch (IOException e) {
                System.out.println("Помилка під час читання/запису");
            }

            Battle battle = new Battle(team1, team2, name);
        }
    }
}
