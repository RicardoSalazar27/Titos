package Conexion.test;
import com.example.datos.ProductoJDBC;
import com.example.domain.Producto;
import com.example.datos.Conexion;
import java.sql.*;

import java.util.List;

public class testManejoProductos {

    public static void main(String[] args) {

        ProductoJDBC productoJDBC = new ProductoJDBC();

        List<Producto> productos = productoJDBC.seleccionar();
        //HACEMOS USO DE LA CLASE domain.Prodcuto paara crear objeto llamdo productos
        //ESTO ES PA IMPRIMIR
        for(Producto producto : productos){
            System.out.println("Producto = " + producto);
       }

        //PÁ INSERTAR
        //CREANDO OBJETO DE IIPO Producto PARA LA INSERCION A LA BD
        //Producto productoNuevo = new Producto(7, "PIZZA CASERA", "Peperoni, jamon, tocino, longaniza y salchicha", 230.0, "HHGFDFHJ", "I");
        //productoJDBC.insertar(productoNuevo);


        //PÁ ACTUALIZAR
        //Producto productoModificar = new Producto(7, "PIZZA CASERA", "Peperoni, jamon, tocino, longaniza y salchicha", 100.0, "HHGFDFHJ", "I");
        //productoJDBC.actualizar(productoModificar);



        //PÁ ELIMINAR
        Producto productoEliminar = new Producto(7);
        productoJDBC.eliminar(productoEliminar);



        //HACIENOO USO DE TRANSACCIONES
       /* Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            ProductoJDBC personaJdbc = new ProductoJDBC(conexion);

            Producto cambioProducto = new Producto();
            cambioProducto.setIdProducto();
            cambioProducto.setNombreProducto();
            cambioProducto.setDescripcionProducto();
            cambioProducto.setPrecioProducto();
            cambioProducto.setImagenProducto();
            cambioProducto.setTamañoProducto();
            personaJdbc.actualizar(cambioProducto);

            Persona nuevaPersona = new Persona();
            nuevaPersona.setNombre("Carlos");
            //nuevaPersona.setApellido("Ramirez11111111111111111111111111111111111111111111");
            nuevaPersona.setApellido("Ramirez");
            personaJdbc.insert(nuevaPersona);

            conexion.commit();
            System.out.println("Se ha hecho commit de la transaccion");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }*/
    }
}
