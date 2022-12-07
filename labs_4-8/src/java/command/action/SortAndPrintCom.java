package command.action;

import command.Command;
import device.ElectronicDevice;

import java.util.List;

public class SortAndPrintCom implements Command {

    private List<ElectronicDevice> devices;

    public SortAndPrintCom(List<ElectronicDevice> devices){
        this.devices = devices;
    }

    public void execute(){
        ElectronicDevice.sortByPower(devices);
        ElectronicDevice.printAll(devices);
    }
}
