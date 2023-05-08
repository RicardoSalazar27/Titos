package Conexion.datos;

import com.example.domain.Cliente;
import static com.example.datos.Conexion.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteJDBC {

    private static final String SQL_SELECT = "SELECT idcliente, nombreCliente, apellidosCliente, telefonoCliente, direccionCliente from cliente";
    private static final String SQL_INSERT = "INSERT INTO cliente(idcliente, nombreCliente, apellidosCliente, telefonoCliente, direccionCliente) VALUES(?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE cliente SET nombreCliente = ?, apellidosCliente = ?, telefonoCliente = ?, direccionCliente = ? WHERE idcliente = ?";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE idcliente = ?";



    //CLASE PARA SELECIONAR TOOS LOS DATOS DE LOS CLIENTES E IMPRIMIR EN PANTALLA
    public List<Cliente> seleccionar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            conn = getConnection();//CONECTAMOS A LA BASE DE DATOS
            stmt = conn.prepareStatement(SQL_SELECT);//USAMOS EL OBJETO SMTM PARA EJECUTAR LA CADENA SQL
            rs = stmt.executeQuery();//EJECUTAMOS EL QUERY

            //OBTIENE TODOS LOS REGISTROS HASTA QUE NO HAYA
            while(rs.next()){
                //CREO VARIABLES LOCALES
                int idCliente = rs.getInt("idcliente");
                String nombreCliente = rs.getString("nombreCliente");
                String apellidosCliente = rs.getString("apellidosCliente");
                String telefonoCliente = rs.getString("telefonoCliente");
                String direccionCliente = rs.getNString("direccionCliente");

                //EN LA CLASE IDENTIDAD SE CREARON VARIOS CONNSTRUCTORES
                //EN ESTE CASO SE HARA UN OBJETO DE TIPÓ PRUDUCTO, USANDO EL CONSTRUCTOR MAS CPOMPLETO
                cliente = new Cliente(idCliente,nombreCliente,apellidosCliente,telefonoCliente,direccionCliente);

                //EL OBJETO PRODUCTO DE TIPO PRODUCTO(VIENE DE LA CLASE DOMAIN-PRODUCTO) ES ALMACENAD0
                //EN EL ARRAYLIST
                clientes.add(cliente);
            }
        } catch (SQLException ex){
            ex.printStackTrace(System.out);
        }
        finally {
            try {
                close(rs); //Conexion.close():
                close(stmt);
                close(conn);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return clientes;
    }






    //CLASE PARA INSERTAR NUEVOS PRODUCTOS A LA BASE DE DATOS
    public int insertar(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);//iicializamos variable smtm y ejecutamos el query

            stmt.setInt(1,cliente.getIdcliente());
            stmt.setString(2,cliente.getNombreCliente());
            stmt.setString(3,cliente.getApellidosCliente());
            stmt.setString(4,cliente.getTelefonoCliente());
            stmt.setString(5,cliente.getDireccionCliente());


            //EJECUTAMNOS LA SENTENCIA DEVOLVIENDO EL NUMERO DE REFISTROS AFECTADOS
            registros = stmt.executeUpdate();//actualizando el estado de la bd

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        finally {
            try {
                close(stmt);
                close(conn);
            }catch (SQLException e){
                e.printStackTrace(System.out);
            }
        }
        return registros;
    }





    //CLASE PARA ACTUALIZAR NUEVOS PRODUCTOS A LA BASE DE DATOS
    public int actualizar(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);//iicializamos variable smtm y ejecutamos el query

            stmt.setString(1,cliente.getNombreCliente());
            stmt.setString(2,cliente.getApellidosCliente());
            stmt.setString(3,cliente.getTelefonoCliente());
            stmt.setString(4,cliente.getDireccionCliente());
            stmt.setInt(5,cliente.getIdcliente());

            //EJECUTAMNOS LA SENTENCIA DEVOLVIENDO EL NUMERO DE REFISTROS AFECTADOS
            registros = stmt.executeUpdate();//actualizando el estado de la bd

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        finally {
            try {
                close(stmt);
                close(conn);
            }catch (SQLException e){
                e.printStackTrace(System.out);
            }
        }
        return registros;
    }




    //CLASE PARA ELIMINAR PRRODUCTOS A LA BASE DE DATOS
    public int eliminar(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);//iicializamos variable smtm y ejecutamos el query

            stmt.setInt(1,cliente.getIdcliente());

            //EJECUTAMNOS LA SENTENCIA DEVOLVIENDO EL NUMERO DE REFISTROS AFECTADOS
            registros = stmt.executeUpdate();//actualizando el estado de la bd

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        finally {
            try {
                close(stmt);
                close(conn);
            }catch (SQLException e){
                e.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
