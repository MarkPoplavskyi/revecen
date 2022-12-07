package command;

import command.action.*;
import device.AvailableDevices;
import device.ElectronicDevice;
import device.RegimeElectronicDevice;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegulateCommands {
  private final static Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

  static Scanner input = new Scanner(System.in);

  public static void certainty(CommandEnum com, List<ElectronicDevice> allDevices) {

    Invoker doer;
    int deviceChoice;
    int continuing = 3;
    int regime;

    switch (com.getCommandCode()) {
      case (0):
        do {
          LOG.info("User choose 0 code");
          System.out.println(allDevices + "\n\nInput sequence number of java.device");
          LOG.info("Printed all devices");
          deviceChoice = input.nextInt();
          LOG.info("user choose " + deviceChoice + " command");
          Command turnOff = new TurnOffCom(allDevices.get(deviceChoice - 1));
          doer = new Invoker(turnOff);
          doer.doSmth();
          LOG.info("turn OFF device " + allDevices.get(deviceChoice - 1));
          System.out.println("\nPress 1 to continue");
          continuing = input.nextInt();
          LOG.info("user choose " + continuing + " command");

        } while (continuing == 1);

        break;

      case (1):
        do {
          System.out.println(allDevices + "\n\nInput sequence number of java.device");
          deviceChoice = input.nextInt();
          LOG.info("user choose " + deviceChoice + " command");
          Command turnOn = new TurnOnCom(allDevices, deviceChoice - 1);
          doer = new Invoker(turnOn);
          doer.doSmth();
          LOG.info(allDevices.get(deviceChoice - 1) +" is turn ON");
          System.out.println("\nPress 1 to continue");
          continuing = input.nextInt();
          LOG.info("user choose " + continuing + " command");
        } while (continuing == 1);
        break;
      case (2):
        List<RegimeElectronicDevice> regimedDevices = AvailableDevices.returnRegimedDevices(allDevices);
        System.out.println(regimedDevices + "\n\nChoose java.device");
        deviceChoice = input.nextInt();
        LOG.info("user choose " + allDevices.get(deviceChoice - 1) + " device");
        deviceChoice = allDevices.indexOf(regimedDevices.get(deviceChoice -1));
        System.out.println("\nChoose regime (0 - eco, 1 - regular, 2 - max)");
        regime = input.nextInt();
        LOG.info("user choose " + regime + " regime");
        Command setRegime = new SetRegimeCom((RegimeElectronicDevice) allDevices.get(deviceChoice), regime + 1);
        doer = new Invoker(setRegime);
        doer.doSmth();
        LOG.info( allDevices.get(deviceChoice - 1) + " now is working in " + regime + " regime");

        break;
      case (3):
        System.out.println(allDevices + "\n\nChoose java.device");
        deviceChoice = input.nextInt();
        LOG.info("user choose " + deviceChoice + " command");
        System.out.println("\n\nSet time ");
        double time = input.nextDouble();
        Command setTimer = new SetTimerCom(allDevices, allDevices.get(deviceChoice - 1), time);
        doer = new Invoker(setTimer);
        doer.doSmth();
        LOG.info( allDevices.get(deviceChoice - 1) + " set timer for " + time + " hours");
        break;
      case (4):
        Command printAll = new PrintAllCom(allDevices);
        doer = new Invoker(printAll);
        doer.doSmth();
        LOG.info("user choose print all device");
        break;
      case (5):
        Command printSorted = new SortAndPrintCom(allDevices);
        doer = new Invoker(printSorted);
        doer.doSmth();
        LOG.info("user choose sort and print all device");
        break;
      case (6):
        Command printOnDevices = new GetOnDevicesCom(allDevices);
        doer = new Invoker(printOnDevices);
        doer.doSmth();
        LOG.info("user choose print turned on devices");
        break;
      case (7):
        Command printNeeded = new SearchByParametersCom(allDevices);
        doer = new Invoker(printNeeded);
        doer.doSmth();
        LOG.info("user choose search by parameters");
        break;
      default:
        System.out.println("\n\n\t\tOops.. Something went wrong");
        LOG.log(Level.WARNING, "user choose another command");
        break;

    }
  }
}
