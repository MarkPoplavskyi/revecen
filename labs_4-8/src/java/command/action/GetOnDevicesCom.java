package command.action;

import command.Command;
import device.AvailableDevices;
import device.ElectronicDevice;

import java.util.List;

public class GetOnDevicesCom implements Command {

    private List<ElectronicDevice> devicesList;

    public GetOnDevicesCom(List<ElectronicDevice> devices){
        devicesList = AvailableDevices.returnTurnedOnDevices(devices);
    }

    public void execute(){
        ElectronicDevice.printAll(devicesList);
    }
}
