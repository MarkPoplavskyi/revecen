package command.action;

import command.Command;
import device.ElectronicDevice;

import java.util.List;

public class TurnOnCom implements Command {
    private List<ElectronicDevice> deviceList;
    private int deviceNum;

    public TurnOnCom(List<ElectronicDevice> deviceList, int deviceNum){
        this.deviceList=deviceList;
        this.deviceNum = deviceNum;
    }

    public void execute(){
        deviceList.get(deviceNum).turnOn();
    }
}
