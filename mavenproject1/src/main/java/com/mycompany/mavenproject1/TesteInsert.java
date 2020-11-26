package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TesteInsert {
    

    public static void Insert () {
        try{
            Connection con = Conexao.conectarBanco();
        
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

    public static void InsertCadastro(String nick, String senha){
        try {
            Connection conexaoBanco = Conexao.conectarBanco();
                  
            String query = "insert into usuario values(" + "null" + " , '" + nick + "' , " + "'" + senha + "');";
            PreparedStatement stmt = conexaoBanco.prepareStatement(query);
            stmt.executeUpdate(query);
                        
            stmt.close();
            conexaoBanco.close();
            
            System.out.println("Cadastro realizado e conexão com banco finalizada");           
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    public static void main(String[] args) {
        TesteInsert.InsertCadastro("luvas", "luvas");
    }
}
