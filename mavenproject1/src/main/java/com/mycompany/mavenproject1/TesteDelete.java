package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TesteDelete {
    
    public static void Delete(String nick, String senha){
        try {
            Connection con = Conexao.conectarBanco();
            
            String query = "delete from usuario where nick='" + nick + "'" + "and senha='" + senha + "'";
            
            PreparedStatement stmt = con.prepareStatement(query);
            
            //stmt.setString(1, "luvas");
            //stmt.setString(2, "luvas");
            
            stmt.executeUpdate(query);
            
            
            stmt.close();
            con.close();
            
            System.out.println("Usuário deletado e conexão com o banco fechada com sucesso");
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}


