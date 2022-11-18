package com.example.Cyrsach;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DeviceTable{ // клас Списку всіх приладів
        private final SimpleIntegerProperty Id;
        private final SimpleStringProperty Name;
        private final SimpleIntegerProperty Power;
        private String status = "off";
        private  int counter = 0;

public  DeviceTable(int id, String name, int power) {
        this.Id = new SimpleIntegerProperty(id);
        this.Name = new SimpleStringProperty(name);
        this.Power = new SimpleIntegerProperty(power);
        }

public int getId() {
        return Id.get();
        }

public SimpleIntegerProperty idProperty() {
        return Id;
        }

public String getName() {
        return Name.get();
        }

public SimpleStringProperty nameProperty() {
        return Name;
        }

public int getPower() {
        return Power.get();
        }

public SimpleIntegerProperty powerProperty() {
        return Power;
        }

        public String getStatus() {
                return status;
        }

        public void setStatus(String status) {
                this.status = status;
        }

        public int getCounter() {
                return counter;
        }

        public void setCounter(int counter) {
                this.counter = counter;
        }
}
