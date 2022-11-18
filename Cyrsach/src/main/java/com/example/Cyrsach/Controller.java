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



    ObservableList<DeviceTable> devices = FXCollections.observableArrayList();
    ObservableList<IncludeDevices> includeddevice = FXCollections.observableArrayList();


    @FXML
    void initialize() throws SQLException {

        IncludeDevices[] arr = new IncludeDevices[21];
        RecordInDataBase(arr);
        InitiateAllDeviceCols();
        InitiateIncludedDeviceCols();
        AllDeviceTable.getItems().setAll(devices);
        UseButton(arr);
    }
    ResultSet ConnectToDataBase()throws SQLException
    {
        ResultSet result;
        Statement stnt;
        stnt = DATABASE.setConnect().createStatement();
        result = stnt.executeQuery("SELECT * FROM device");
        return result;
    }
    void RecordInDataBase (IncludeDevices[]arr)throws SQLException
    {
        int i = 1;
        ResultSet result = ConnectToDataBase();
        while (result.next()) {
            int id = result.getInt("id");
            String Name = result.getString("Name");
            int Power = result.getInt("Power");
            arr[i] = new IncludeDevices(id,Name,Power);
            devices.addAll(new DeviceTable(id,Name,Power));
            i++;
        }
    }
    int LoadPower (int power,int pow)
    {
        pow += power;
        Voltage.getChildren().clear();
        Voltage.getChildren().add(new Label(Integer.toString(pow)));
        return pow;
    }
    void UseButton(IncludeDevices[]arr)
    {
        AtomicInteger pow = new AtomicInteger();
        AddButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (!TextField.getText().trim().equals("")) {
                int id = parseInt(TextField.getText().trim());
                if (id <= 20) {
                    arr[id].setStatus("On");
                    arr[id].plusCounter(1);
                    pow.set(LoadPower(arr[id].getPower(), pow.get()));
                    includeddevice.addAll(arr[id]);
                    IncludedDevices.getItems().setAll(includeddevice);
                    TextField.setText("");

                    }
                }
            });
        DeleteButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (!TextField.getText().trim().equals("")) {
                int id = parseInt(TextField.getText().trim());
                if (id <= 20) {
                    if (arr[id].getCounter() == 0) {
                        arr[id].setStatus("off");

                    }
                    if (arr[id].getCounter() > 0) {
                        arr[id].minusCounter(1);
                        pow.set(LoadPower(arr[id].getPower()*(-1), pow.get()));
                        includeddevice.remove(arr[id]);
                        IncludedDevices.getItems().setAll(includeddevice);
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
