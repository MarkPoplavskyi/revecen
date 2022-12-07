package device;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class ElectronicDeviceOnTimer extends RegimeElectronicDevice {

    private double workingTime;

    public ElectronicDeviceOnTimer(ElectronicDevice obj) {
        this.name = obj.name;
        this.power = obj.power;
        this.state = obj.state;
        this.workingTime = 0;
    }

    public ElectronicDeviceOnTimer(ElectronicDevice obj, double time){
        this.name = obj.name;
        this.power = obj.power;
        this.state = obj.state;
        this.workingTime = time;
    }

    public ElectronicDeviceOnTimer(RegimeElectronicDevice obj, double workingTime) {
        super(obj.name, obj.power);
        state = false;
        regime = Regimes.REGULAR;
        this.workingTime = workingTime;
    }

    public static int calculatePowerAfterCertainTime(ElectronicDeviceOnTimer obj){
        return (int) (obj.power * obj.workingTime);
    }

    @Override
    public String toString() {
        return
            "\nName='" + name + '\'' +
            ", power=" + power +
            ", state=" + state +
            ", workingTime=" + workingTime +
            ", regime=" + regime;
    }
}
