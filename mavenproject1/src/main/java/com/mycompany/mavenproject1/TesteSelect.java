package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteSelect {
    

    public static void Select() {
        try{
            Connection con = Conexao.faz_conexao();
        
            String query = "select * from teste where nome =?";
        
            PreparedStatement stmt = con.prepareStatement(query);
            
            stmt.setString(1, "garfo");
         
            ResultSet rs = stmt.executeQuery();
            
            System.out.println(stmt.toString());
            
            if(rs.next()){
                System.out.println("uiui");
            }
            else{
                System.out.println("garfo");
            }
            
            stmt.close();
            con.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

   
}
