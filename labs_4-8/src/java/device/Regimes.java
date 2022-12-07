package device;

import lombok.Getter;

@Getter
public enum Regimes {
    ECO(1),
    REGULAR(2),
    MAX(3);

    private int regimeCode;

    Regimes(int regimeCode) {
        this.regimeCode = regimeCode;
    }

    public int getRegimeCode() {
        return regimeCode;
    }
}
