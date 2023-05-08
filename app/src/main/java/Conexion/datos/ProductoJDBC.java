package Conexion.datos;

import com.example.domain.Producto;
import static com.example.datos.Conexion.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoJDBC {

    private Connection conexionTranssaccional; //Para usar transacciones se necesita que sea una misma conexion a la bd
    private static final String SQL_SELECT = "SELECT idproducto, nombreProducto, descripcionProducto, precioProducto, imagenProducto, tamañoProducto from producto";
    private static final String SQL_INSERT = "INSERT INTO producto(idproducto, nombreProducto, descripcionProducto, precioProducto, imagenProducto, tamañoProducto) VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE producto SET nombreProducto = ?, descripcionProducto = ?, precioProducto = ?, imagenProducto = ?, tamañoProducto = ? WHERE idproducto = ?";
    private static final String SQL_DELETE = "DELETE FROM producto WHERE idproducto = ?";


    public ProductoJDBC(){

    }

    public ProductoJDBC(Connection conexionTranssaccional){
        this.conexionTranssaccional = conexionTranssaccional;
    }

    //CLASE PARA SELECIONAR TOOS LOS DATOS DE LOS PRODUCTOS E IMPRIMIR EN PANTALLA
    public List<Producto> seleccionar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto = null;
        List<Producto> productos = new ArrayList<>();


        try { //
            conn = this.conexionTranssaccional != null ? this.conexionTranssaccional : getConnection();//CONECTAMOS A LA BASE DE DATOS
            stmt = conn.prepareStatement(SQL_SELECT);//USAMOS EL OBJETO SMTM PARA EJECUTAR LA CADENA SQL
            rs = stmt.executeQuery();//EJECUTAMOS EL QUERY

            //OBTIENE TODOS LOS REGISTROS HASTA QUE NO HAYA
            while(rs.next()){
                //CREO VARIABLES LOCALES
                int idProducto = rs.getInt("idproducto");
                String nombreProducto = rs.getString("nombreProducto");
                String descripcionProducto = rs.getString("descripcionProducto");
                double precioProducto = rs.getDouble("precioProducto");
                String imagenProducto = rs.getNString("imagenProducto");
                String tamañoProducto = rs.getString("tamañoProducto");

                //EN LA CLASE IDENTIDAD SE CREARON VARIOS CONNSTRUCTORES
                //EN ESTE CASO SE HARA UN OBJETO DE TIPÓ PRUDUCTO, USANDO EL CONSTRUCTOR MAS CPOMPLETO
                producto = new Producto(idProducto,nombreProducto,descripcionProducto,precioProducto,imagenProducto,tamañoProducto);

                //EL OBJETO PRODUCTO DE TIPO PRODUCTO(VIENE DE LA CLASE DOMAIN-PRODUCTO) ES ALMACENAD0
                //EN EL ARRAYLIST
                productos.add(producto);
            }
        } catch (SQLException ex){
            ex.printStackTrace(System.out);
        }
        finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                if (this.conexionTranssaccional == null){
                    Conexion.close(conn);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return productos;
    }






    //CLASE PARA INSERTAR NUEVOS PRODUCTOS A LA BASE DE DATOS
    public int insertar(Producto producto){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTranssaccional != null ? this.conexionTranssaccional : getConnection();//CONECTAMOS A LA BASE DE DATOS
            stmt = conn.prepareStatement(SQL_INSERT);//iicializamos variable smtm y ejecutamos el query

            stmt.setInt(1,producto.getIdProducto());
            stmt.setString(2,producto.getNombreProducto());
            stmt.setString(3,producto.getDescripcionProducto());
            stmt.setDouble(4,producto.getPrecioProducto());
            stmt.setString(5,producto.getImagenProducto());
            stmt.setString(6, producto.getTamañoProducto());

            //EJECUTAMNOS LA SENTENCIA DEVOLVIENDO EL NUMERO DE REFISTROS AFECTADOS
            registros = stmt.executeUpdate();//actualizando el estado de la bd

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        finally {
            try {
                Conexion.close(stmt);
                if (this.conexionTranssaccional == null){
                    Conexion.close(conn);
                }
            }catch (SQLException e){
                e.printStackTrace(System.out);
            }
        }
        return registros;
    }





    //CLASE PARA ACTUALIZAR NUEVOS PRODUCTOS A LA BASE DE DATOS
    public int actualizar(Producto producto){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTranssaccional != null ? this.conexionTranssaccional : getConnection();//CONECTAMOS A LA BASE DE DATOS
            stmt = conn.prepareStatement(SQL_UPDATE);//iicializamos variable smtm y ejecutamos el query

            stmt.setString(1,producto.getNombreProducto());
            stmt.setString(2,producto.getDescripcionProducto());
            stmt.setDouble(3,producto.getPrecioProducto());
            stmt.setString(4,producto.getImagenProducto());
            stmt.setString(5, producto.getTamañoProducto());
            stmt.setInt(6,producto.getIdProducto());

            //EJECUTAMNOS LA SENTENCIA DEVOLVIENDO EL NUMERO DE REFISTROS AFECTADOS
            registros = stmt.executeUpdate();//actualizando el estado de la bd

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        finally {
            try {
                Conexion.close(stmt);
                if (this.conexionTranssaccional == null){
                    Conexion.close(conn);
                }
            }catch (SQLException e){
                e.printStackTrace(System.out);
            }
        }
        return registros;
    }




    //CLASE PARA ELIMINAR PRRODUCTOS A LA BASE DE DATOS
    public int eliminar(Producto producto){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTranssaccional != null ? this.conexionTranssaccional : getConnection();//CONECTAMOS A LA BASE DE DATOS
            stmt = conn.prepareStatement(SQL_DELETE);//iicializamos variable smtm y ejecutamos el query

            stmt.setInt(1,producto.getIdProducto());

            //EJECUTAMNOS LA SENTENCIA DEVOLVIENDO EL NUMERO DE REFISTROS AFECTADOS
            registros = stmt.executeUpdate();//actualizando el estado de la bd

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        finally {
            try {
                Conexion.close(stmt);
                if (this.conexionTranssaccional == null){
                    Conexion.close(conn);
                }
            }catch (SQLException e){
                e.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
