package Conexion.domain;

        //CLASE IDENTIDAD QUE REPRESENTA LA TABLA DE PRODUCTOS EN EL SISTEMA
        //ESTA CLASE REPRESENTA LOS REGISTROS DE LA TABLA PRODUCTOS
        //RECUPERA LA INFORMACION, REGISTRA Y ELIMINA

public class Cliente {

    private int idcliente;
    private String nombreCliente;
    private String apellidosCliente;
    private String telefonoCliente;
    private String direccionCliente;

    public Cliente(){}

    public Cliente(int idcliente){
        this.idcliente = idcliente;
    }
    //CONSTRUCTOR PARA VER LOS PRODUCTOS SIN IDE´S
    public Cliente(String nombreCliente, String apellidosCliente, String direccionCliente, String telefonoCliente){
        this.nombreCliente = nombreCliente;
        this.apellidosCliente = apellidosCliente;
        this.direccionCliente = direccionCliente;
        this.telefonoCliente= telefonoCliente;
    }

    //CONSTRUCTOR PARA VER LOS PRODUCTOS con IDE´S
    public Cliente(int idcliente, String nombreCliente, String apellidosCliente, String direccionCliente, String telefonoCliente){
        this.idcliente = idcliente;
        this.nombreCliente = nombreCliente;
        this.apellidosCliente = apellidosCliente;
        this.direccionCliente = direccionCliente;
        this.telefonoCliente= telefonoCliente;
    }

    //GETTERS Y SETTERS PARA ESTABLCER O OBTENER LOS DATOS DE LOS ATRIBUTOS A TRAVEZ DE LOS CONSTRUCTORES
    public int getIdcliente(){
        return idcliente;
    }
    public void setIdcliente(){this.idcliente = idcliente;}

    public String getNombreCliente(){
        return nombreCliente;
    }
    public void setNombreCliente(){this.nombreCliente = nombreCliente;}

    public String getApellidosCliente(){
        return apellidosCliente;
    }
    public void setApellidosCliente(){this.apellidosCliente = apellidosCliente;}

    public String getDireccionCliente(){
        return direccionCliente;
    }
    public void setDireccionCliente(){this.direccionCliente = direccionCliente;}

    public String getTelefonoCliente(){
        return telefonoCliente;
    }
    public void setTelefonoCliente(){this.telefonoCliente = telefonoCliente;}


    @Override
    public String toString(){
        return "Cliente(" + "idCliente= " + idcliente + "  Nombre= " + nombreCliente + "  Apellidos= " + apellidosCliente + "  Direccion= " + direccionCliente + "  telefono==" + telefonoCliente;
    }

}
