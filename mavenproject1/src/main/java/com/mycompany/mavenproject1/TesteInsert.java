package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;


public class TesteInsert {
    
    private JdbcTemplate jdbcTemplate;

    public static void Insert () {
        try{
            Connection con = Conexao.faz_conexao();
        
            String fargo = "fargo";
            
            String query = "insert into teste (nome) values(" + "'" + fargo + "');";
        
            PreparedStatement stmt = con.prepareStatement(query);
             
            stmt.executeUpdate(query);
            
            System.out.println(stmt.toString());
            

            stmt.close();
            con.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

   
}
