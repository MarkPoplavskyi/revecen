package com.example.Cyrsach;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Integer.parseInt;

public class Controller {

    @FXML
    private Button AddButton;

    @FXML
    private TableView<IncludeDevices> IncludedDevices;
    @FXML
    private TableColumn<IncludeDevices, Integer> AppIncId;

    @FXML
    private TableColumn<IncludeDevices, String> AppIncName;

    @FXML
    private TableColumn<IncludeDevices, Integer> AppIncVoltage;

    @FXML
    private Button DeleteButton;
    @FXML
    private TableView<DeviceTable> AllDeviceTable;
    @FXML
    private TableColumn<DeviceTable, Integer> DevExcId;

    @FXML
    private TableColumn<DeviceTable, String> DevExcName;

    @FXML
    private TableColumn<DeviceTable, Integer> DevExcVoltage;
    @FXML
    private TextField TextField;

    @FXML
    private VBox Voltage;



    ObservableList<DeviceTable> devices = FXCollections.observableArrayList(); // колекція для Всіх приладів
    ObservableList<IncludeDevices> includeddevice = FXCollections.observableArrayList(); // колекція для включених приладів


    @FXML
    void initialize() throws SQLException { //Основна функція інтерфейсу

        IncludeDevices[] arr = new IncludeDevices[21];
        RecordInDataBase(arr);
        InitiateAllDeviceCols();
        InitiateIncludedDeviceCols();
        AllDeviceTable.getItems().setAll(devices);
        UseButton(arr);
    }
    ResultSet ConnectToDataBase()throws SQLException // функція підключення до бази даних і одночаснозбираю інформацію з БД
    {
        ResultSet result;
        Statement stnt;
        stnt = DATABASE.setConnect().createStatement();
        result = stnt.executeQuery("SELECT * FROM device");
        return result;
    }
    void RecordInDataBase (IncludeDevices[]arr)throws SQLException // функція взяття даних з бази даних
    {
        int i = 1;
        ResultSet result = ConnectToDataBase();
        while (result.next()) {
            int id = result.getInt("id");
            String Name = result.getString("Name");
            int Power = result.getInt("Power");
            arr[i] = new IncludeDevices(id,Name,Power); // заповнюю масив класів для майбутьніх операцій над ними
            devices.addAll(new DeviceTable(id,Name,Power)); // заповнюю колекцію приладів
            i++;
        }
    }
    int LoadPower (int power,int pow) // функція виводу і обчислення потужності
    {
        pow += power;
        Voltage.getChildren().clear();
        Voltage.getChildren().add(new Label(Integer.toString(pow)));
        return pow;
    }
    void UseButton(IncludeDevices[]arr)
    {
        AtomicInteger pow = new AtomicInteger();
        AddButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {// Реалізація кнопки включення, яка реагує на натискання
            if (!TextField.getText().trim().equals("")) { // Перевіряю чи там не пусто
                int id = parseInt(TextField.getText().trim());
                if (id <= 20) {
                    arr[id].setStatus("On");
                    arr[id].plusCounter(1);
                    pow.set(LoadPower(arr[id].getPower(), pow.get()));
                    includeddevice.addAll(arr[id]); // Добавляю прилад до таблиці включених приладів
                    IncludedDevices.getItems().setAll(includeddevice);// оновлюю таблицю з вімкненими приладами
                    TextField.setText("");

                    }
                }
            });
        DeleteButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> { // Реалізація кнопки виключення яка реагує на натискання
            if (!TextField.getText().trim().equals("")) { // Перевіряю чи там не пусто
                int id = parseInt(TextField.getText().trim()); // зчитую те що написано в TextField
                if (id <= 20) {
                    if (arr[id].getCounter() == 0) {
                        arr[id].setStatus("off");

                    }
                    if (arr[id].getCounter() > 0) { // перевіряю кількість одного предмету що б випадково не вийти в мінус
                        arr[id].minusCounter(1);
                        pow.set(LoadPower(arr[id].getPower()*(-1), pow.get()));
                        includeddevice.remove(arr[id]); // видаляю з прилад з таблиці включених приладів
                        IncludedDevices.getItems().setAll(includeddevice); // оновлюю таблицю з вімкненими приладами
                        TextField.setText("");
                    }
                }
                }
            });
    }


   private void InitiateAllDeviceCols()
    {
        DevExcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        DevExcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        DevExcVoltage.setCellValueFactory(new PropertyValueFactory<>("power"));
    }
    private void InitiateIncludedDeviceCols()
    {
        AppIncId.setCellValueFactory(new PropertyValueFactory<>("id"));
        AppIncName.setCellValueFactory(new PropertyValueFactory<>("name"));
        AppIncVoltage.setCellValueFactory(new PropertyValueFactory<>("power"));


    }
}
