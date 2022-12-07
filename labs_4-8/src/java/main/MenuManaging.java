package main;

import command.CommandEnum;
import command.RegulateCommands;
import device.ElectronicDevice;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.in;
import static java.lang.System.out;

public class MenuManaging {
    private final static Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    static Scanner input = new Scanner(in);

    public static void mainMenuText(){
        LOG.info("Print main menu");
        out.println("\n\t1\t|\t\tManage java.device" +
                "\n\t2\t|\t\tPrint all devices" +
                "\n\t3\t|\t\tSort by power consumption" +
                "\n\t4\t|\t\tList of turned ON devices" +
                "\n\t5\t|\t\tSearch by parameters" +
                "\n\t6\t|\t\tExit\n");
    }

    public static void deviceMenuText(){
        LOG.info("Print device menu");
        out.println("\n\t1\t|\t\tTurn ON java.device" +
                "\n\t2\t|\t\tTurn OFF java.device" +
                "\n\t3\t|\t\tSet regime (only for selected)" +
                "\n\t4\t|\t\tSet timer\n");
    }

    public static CommandEnum deviceMenuManaging(){
        CommandEnum com = null;
        deviceMenuText();
        int choice = input.nextInt();
        switch(choice){
            case(1):
                com = CommandEnum.ON;
                break;
            case(2):
                com = CommandEnum.OFF;
                break;
            case(3):
                com = CommandEnum.SetRegime;
                break;
            case(4):
                com = CommandEnum.SetTimer;
                break;
        }
        return com;
    }

    public static void menuManaging(Integer choice, List<ElectronicDevice> allDevices ){
        CommandEnum com = null;
        switch (choice){
            case(1):
                com = deviceMenuManaging();
                break;
            case(2):
                com = CommandEnum.PrintAll;
                break;
            case(3):
                com = CommandEnum.SortAndPrint;
                break;
            case(4):
                com = CommandEnum.PrintOnDevices;
                break;
            case(5):
                com = CommandEnum.SearchByParameters;
                break;
            default:
                LOG.log(Level.WARNING, "Incorrect command");
                out.println("\n\n\t\tOops... Wrong java.command :(");
                return;
        }
        RegulateCommands.certainty(com, allDevices);
    }
}
