package com.example.Cyrsach;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//Клас у якому зберігається підключення до БД
public class DATABASE {
    private static final String URL = "jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=Cyrsach;encrypt=true;trustServerCertificate=true";
    private static final String USERNAME = "revecen";
    private static final String PASSWORD = "01032004";


    public static Connection setConnect() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}


