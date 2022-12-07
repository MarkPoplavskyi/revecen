package command;

public enum CommandEnum {

    OFF(0),
    ON(1),
    SetRegime(2),
    SetTimer(3),
    PrintAll(4),
    SortAndPrint(5),
    PrintOnDevices(6),
    SearchByParameters(7);

    private final int commandCode;

    CommandEnum(int commandCode) {
        this.commandCode = commandCode;
    }


    public int getCommandCode() {
        return commandCode;
    }
}
