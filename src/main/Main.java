package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
public class Main {
    
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
        
        // Instrucción SQL para crear nueva tabla
        sql = "CREATE TABLE IF NOT EXISTS EMAIL (\n"
            + " Id integer PRIMARY KEY AUTOINCREMENT,\n"
            + " Mail text NOT NULL);";
        stmt = con.createStatement();
        // Se crea la nueva tabla
        stmt.execute(sql);
        System.out.println("Tabla creada");
    }
}
