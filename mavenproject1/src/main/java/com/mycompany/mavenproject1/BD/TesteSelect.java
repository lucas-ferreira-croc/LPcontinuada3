package com.mycompany.mavenproject1.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteSelect {

    public static void SelectUsuario(String nick, String senha) {
        try {
            
            Connection con = Conexao.conectarBanco();

            String query = "select * from usuario where nome =? and senha=?";

            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setString(1, "garfo");

            stmt.close();
            con.close();

            System.out.println("Select realizado e conexão com o banco fechada com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
