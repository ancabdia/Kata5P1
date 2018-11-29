/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

/**
 *
 * @author Usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlite:kata5.db";
                
        Connection con = null;
        con = DriverManager.getConnection(url);
        
        System.out.println("Connexión a SQLite establecida");
        
        // Se seleccionan todos los registros de la tabla PEOPLE
        String sql = "SELECT * FROM PEOPLE";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        // Bucle sobre el conjunto de registros.
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t" + rs.getString("Name") + "\t" + rs.getString("Apellidos") + "\t" + rs.getString("Departamento") + "\t");
        }
    }
}
