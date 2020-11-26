
package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
     private static String driver = "com.mysql.cj.jdbc.Driver";
     private static String caminho = "jdbc:mysql://localhost/Continuada3?useTimezone=true&serverTimezone=UTC";
     private static String usuario = "root";
     private static String senha = "53677821";
     
     public static Connection conectarBanco() throws SQLException{
        try{
            Class.forName(driver);
        
            return DriverManager.getConnection(caminho, usuario, senha);
        }
        catch (ClassNotFoundException e){
            throw new SQLException(e.getException());
        }
    }
  
}
