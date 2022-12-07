package command.action;

import command.Command;
import device.ElectronicDevice;

import java.util.List;

public class PrintAllCom implements Command {

    private final List<ElectronicDevice> devices;

    public PrintAllCom(List<ElectronicDevice> devices){
        this.devices = devices;
    }

    public void execute(){
        ElectronicDevice.printAll(devices);
    }
}
