package command.action;

import command.Command;
import device.ElectronicDevice;

public class TurnOffCom implements Command {
    private ElectronicDevice device;

    public TurnOffCom(ElectronicDevice device){
        this.device=device;
    }

    public void execute(){
        device.turnOff();
    }
}
