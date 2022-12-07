package device;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class RegimeElectronicDevice extends ElectronicDevice {

  Regimes regime;

  public RegimeElectronicDevice() {
    super();
    this.regime = Regimes.REGULAR;
  }

  public RegimeElectronicDevice(String name, Integer power) {
    super(name, power);
    state = false;
    regime = Regimes.REGULAR;
  }

  public void setRegime(Integer regimeCode) {
    if (regimeCode == 1) {
      this.regime = Regimes.ECO;
    } else if (regimeCode == 2) {
      this.regime = Regimes.REGULAR;
    } else if (regimeCode == 3) {
      this.regime = Regimes.MAX;
    }
    calculateRegimePower(this);
  }

  public static void calculateRegimePower(RegimeElectronicDevice obj) {
    switch (obj.regime.getRegimeCode()) {
      case (1):
        obj.power = (int) (obj.power * 0.5);
        break;
      case (3):
        obj.power = (int) (obj.power * 1.3);
        break;
      default:
    }
  }

  @Override
  public String toString() {
    return
        "\nName='" + name + '\'' +
            ", power=" + power +
            ", state=" + state +
            ", regime=" + regime;
  }


  public Regimes getRegime() {
    return regime;
  }
}
