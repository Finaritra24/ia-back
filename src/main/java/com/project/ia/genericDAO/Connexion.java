package com.project.ia.genericDAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
    public static Connection getConnection() throws Exception
    {
        String url = "jdbc:postgresql://containers-us-west-184.railway.app:6809/railway";
        String user = "postgres";
        String password = "mBtsy9pNubiUmBXUEwSt";
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
}