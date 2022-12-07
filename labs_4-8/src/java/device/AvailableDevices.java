package device;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AvailableDevices {
    private final static Logger LOG = Logger.getLogger(ElectronicDevice.class.getName());


    public static List<ElectronicDevice> baseDevices(){
        ArrayList<ElectronicDevice> devices = new ArrayList<>();
        devices.add(new ElectronicDevice("pc", 500));
        devices.add(new ElectronicDevice("freezer", 250));
        devices.add(new ElectronicDevice("tv", 100));
        devices.add(new ElectronicDevice("ps5", 220));
        devices.add(new ElectronicDevice("speakers", 40));
        devices.add(new ElectronicDevice("toaster", 800));
        devices.add(new RegimeElectronicDevice("vacuum cleaner", 700));
        devices.add(new RegimeElectronicDevice("hairdryer", 1500));
        devices.add(new RegimeElectronicDevice("dishwasher", 850));
        devices.add(new RegimeElectronicDevice("iron", 2000));
        return devices;
    }

    public static List<ElectronicDevice> returnElectronicDevices(List<ElectronicDevice> devices){
        ArrayList<ElectronicDevice> electronicDevices = new ArrayList<>();
        for (ElectronicDevice device : devices) {
            if (device.getClass() == ElectronicDevice.class) {
                electronicDevices.add(device);
            }
        }
        LOG.info("returned all Electronic Devices");
        return electronicDevices;
    }

    public static List<RegimeElectronicDevice> returnRegimedDevices(List<ElectronicDevice> devices){
        List<RegimeElectronicDevice> regimedDevices = new ArrayList<>();
        for (ElectronicDevice device : devices) {
            if (device.getClass() == RegimeElectronicDevice.class) {
                regimedDevices.add((RegimeElectronicDevice) device);
            }
        }
        LOG.info("returned all Regimed Devices");
        return regimedDevices;
    }

    public static List<ElectronicDeviceOnTimer> returnDevicesOnTimer(List<ElectronicDevice> devices){
        List<ElectronicDeviceOnTimer> devicesOnTimer = new ArrayList<>();
        for (ElectronicDevice device : devices) {
            if (device.getClass() == ElectronicDeviceOnTimer.class) {
                devicesOnTimer.add((ElectronicDeviceOnTimer) device);
            }
        }
        LOG.info("returned all Electronic Devices on timer");
        return devicesOnTimer;
    }

    public static List<ElectronicDevice> returnTurnedOnDevices(List<ElectronicDevice> devices){
        List<ElectronicDevice> onDevices = new ArrayList<>();
        for (ElectronicDevice device : devices) {
            if (device.isState()) {
                onDevices.add(device);
            }
        }
        LOG.info("returned all devices turned on");
        return onDevices;
    }

    public static void addElectronicDevice(ElectronicDevice device, List<ElectronicDevice> allDevices){
        allDevices.add(device);
        LOG.info("added new device to the list");
    }
}
