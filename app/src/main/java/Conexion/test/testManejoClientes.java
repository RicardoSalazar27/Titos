package Conexion.test;

import com.example.datos.ClienteJDBC;
import com.example.domain.Cliente;

import java.util.List;

public class testManejoClientes {

    public static void main(String[] args) {

        ClienteJDBC clienteJDBC = new ClienteJDBC();

        List<Cliente> clientes = clienteJDBC.seleccionar();
        //HACEMOS USO DE LA CLASE domain.Prodcuto paara crear objeto llamdo productos
        //ESTO ES PA IMPRIMIR
        for(Cliente cliente : clientes){
            System.out.println("Cliente = " + cliente);
        }

        //PÁ INSERTAR
        //CREANDO OBJETO DE IIPO Producto PARA LA INSERCION A LA BD
        //Producto productoNuevo = new Producto(7, "PIZZA CASERA", "Peperoni, jamon, tocino, longaniza y salchicha", 230.0, "HHGFDFHJ", "I");
        //productoJDBC.insertar(productoNuevo);


        //PÁ ACTUALIZAR
        //Producto productoModificar = new Producto(7, "PIZZA CASERA", "Peperoni, jamon, tocino, longaniza y salchicha", 100.0, "HHGFDFHJ", "I");
        //productoJDBC.actualizar(productoModificar);



        //PÁ ELIMINAR
        //Producto productoEliminar = new Producto(7);
        //productoJDBC.eliminar(productoEliminar);
    }
}
