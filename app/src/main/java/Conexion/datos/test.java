package Conexion.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
    public static void main(String[] args) {

        //Cadena de conexion para conectar a MySql
        String url = "jdbc:mysql://localhost:3306/test?user=root&password=admin&useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

        try {
            //para aplicaciones web
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "admin");

            // crear objeto statement para ejecutar sentencias DML de sql
            Statement instruccion = conexion.createStatement();
            String sql = "SELECT * FROM test.producto;";

            //procesar resuktado con resultset
            ResultSet resultado = instruccion.executeQuery(sql);

            while (resultado.next()) { //.next es hasta que no halla uno siguiente pare

                System.out.print("Id_pizza : " + resultado.getInt("idproducto") + " " +
                        "nombre: " + resultado.getString("nombreProducto"));
            }

            resultado.close();
            instruccion.close();
            conexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
