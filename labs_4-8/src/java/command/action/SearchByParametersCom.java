package command.action;

import command.Command;
import device.ElectronicDevice;
import device.ElectronicDeviceOnTimer;
import device.RegimeElectronicDevice;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Logger;

public class SearchByParametersCom implements Command {
    private final static Logger LOG = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    List<ElectronicDevice> allDevices;
    Scanner input = new Scanner(System.in);

    public SearchByParametersCom(List<ElectronicDevice> allDevices){
        this.allDevices = allDevices;
    }

    public List<ElectronicDevice> SearchByParameters() {
        System.out.println("\nStart of search...");
        System.out.println("\nType of device ( 1 - With Power; 2 - With Regimes; 3 - On timer)");
        int deviceClassCode = input.nextInt();
        Class deviceClass = ElectronicDevice.class;
        switch (deviceClassCode) {
            case (1):
                deviceClass = ElectronicDevice.class;
                LOG.info("User choose Power device");
                break;
            case (2):
                deviceClass = RegimeElectronicDevice.class;
                LOG.info("User choose Regimed device");
                break;
            case (3):
                deviceClass = ElectronicDeviceOnTimer.class;
                LOG.info("User choose Electronic device on timer");
                break;
        }

        System.out.println("\nPower is larger than...");
        int[] powerRange = new int[2];
        powerRange[0] = input.nextInt();


        System.out.println("\n... but lower than...");
        powerRange[1] = input.nextInt();
        LOG.info("User is searching for device with power more than: " + powerRange[0] + " but less than: " + powerRange[1]);

        System.out.println("\nState (0 - OFF; 1 - ON)");
        int stateCode = input.nextInt();
        boolean state = stateCode == 1;
        LOG.info("User is searching for" + state +" device");


        int regime;
        if (deviceClass == RegimeElectronicDevice.class || deviceClass == ElectronicDeviceOnTimer.class) {
            System.out.println("\nRegime ( 1 - ECO; 2 - Regular; 3 - MAX)");
            regime = input.nextInt();
        }
        int[] timerRange = new int[2];
        if (deviceClass == ElectronicDeviceOnTimer.class) {
            System.out.println("\nTimer is set on time between...(in minutes)");
            timerRange[0] = input.nextInt();
            System.out.println("... and...");
            timerRange[1] = input.nextInt();
            LOG.info("User is searching for device working between " + timerRange[0]+ " and" + timerRange[1] + " timer" );
        }
        List<ElectronicDevice> neededDevices = new ArrayList<>(allDevices.size());
        for (ElectronicDevice allDevice : allDevices) {
            if (Objects.equals(allDevice.getClass(), deviceClass))
                if (allDevice.getPower() > powerRange[0] && allDevice.getPower() < powerRange[1])
                    if (allDevice.isState() == state) {
                        neededDevices.add(allDevice);
                        continue;
                    }
        }
        return neededDevices;
    }

    public void execute() {
        System.out.println("\nRequired devices are :\n");
        System.out.println(SearchByParameters());
    }
}
