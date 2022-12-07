package command.action;

import command.Command;
import device.AvailableDevices;
import device.ElectronicDevice;
import device.ElectronicDeviceOnTimer;

import java.util.List;

public class SetTimerCom implements Command {

    List<ElectronicDevice> devices ;
    ElectronicDevice device;
    double time;

    public SetTimerCom(List<ElectronicDevice> devices, ElectronicDevice device, double time){
        this.devices = devices;
        this.device = device;
        this.time = time;
    }

    public void execute() {
        ElectronicDeviceOnTimer deviceOnTimer = new ElectronicDeviceOnTimer(device, time);
        AvailableDevices.addElectronicDevice(deviceOnTimer, devices);
    }
}
