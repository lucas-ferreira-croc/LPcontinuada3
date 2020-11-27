package com.mycompany.mavenproject1.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    //private static String driver = "com.mysql.cj.jdbc.Driver";
    //private static String caminho = "jdbc:mysql://localhost/Continuada3?useTimezone=true&serverTimezone=UTC";
    //private static String usuario = "root";
    //    private static String senha = "53677821";

    public static Connection conectarBanco() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection("jdbc:mysql://localhost:3306/Continuada3?useTimezone=true&serverTimezone=UTC", "root", "53677821");
        } catch (ClassNotFoundException e) {
            throw new SQLException(e.getException());
        }
    }

}
