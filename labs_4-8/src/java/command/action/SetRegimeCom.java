package command.action;

import command.Command;

import device.ElectronicDevice;
import device.RegimeElectronicDevice;
import lombok.Getter;

@Getter
public class SetRegimeCom implements Command {

    RegimeElectronicDevice device;
    int regimeCode;

    public SetRegimeCom(RegimeElectronicDevice device, int regimeCode) {
        this.device = device;
        this.regimeCode = regimeCode;
    }

    public void execute() {
        device.setRegime(regimeCode);
    }

    public ElectronicDevice getDevice() {
        return device;
    }
}