package com.mycompany.mavenproject1.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TesteInsert {

    public static void InsertUsuario(String nick, String senha) {
        try {
            Connection conexaoBanco = Conexao.conectarBanco();

            String query = "insert into usuario values(" + "null" + " , '" + nick + "' , " + "'" + senha + "');";
            PreparedStatement stmt = conexaoBanco.prepareStatement(query);
            stmt.executeUpdate(query);

            stmt.close();
            conexaoBanco.close();

            System.out.println("Cadastro realizado e conexão com banco finalizada");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
