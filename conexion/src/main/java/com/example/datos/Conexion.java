package com.example.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    //DECLARACION FORMAL DE LAS VARIABLES PARA CONECTAR SE A LA BASE DE DATOS
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?user=root&password=admin&useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final  String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";

    //METODO PARA OBTENER LA CONEXION A LA BASE DE DATOS
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
    }


    //METODOS PARA CERRAR LOS OBJETOS REULSET, CONEXION
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    public static void close(Statement smtm) throws SQLException{
        smtm.close();
    }
    public static void close(PreparedStatement smtm) throws SQLException{
        smtm.close();
    }
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
}
