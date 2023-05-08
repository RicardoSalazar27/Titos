package Conexion.domain;

//CLASE IDENTIDAD QUE REPRESENTA LA TABLA DE PRODUCTOS EN EL SISTEMA
//ESTA CLASE REPRESENTA LOS REGISTROS DE LA TABLA PRODUCTOS
//RECUPERA LA INFORMACION, REGISTRA Y ELIMINA
public class Producto {

    private int idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private double precioProducto;
    private String imagenProducto;
    private String tamañoProducto;

    public Producto(){}

    public Producto(int idProducto){
        this.idProducto = idProducto;
    }

    //CONSTRUCTOR PARA VER LOS PRODUCTOS SIN IDE´S
    public Producto(String nombreProducto, String descripcionProducto, double precioProducto, String imagenProducto, String tamañoProducto){
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.precioProducto = precioProducto;
        this.imagenProducto = imagenProducto;
        this.tamañoProducto = tamañoProducto;
    }

    //CONSTRUCTOR MPARA CAMBIAR TODOS LOS ATRIBUTOS DE GOLPE
    public Producto(int idProducto, String nombreProducto, String descripcionProducto, double precioProducto, String imagenProducto, String tamañoProducto){
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.precioProducto = precioProducto;
        this.imagenProducto = imagenProducto;
        this.tamañoProducto = tamañoProducto;
    }


    //GETTERS Y SETTERS PARA ESTABLCER O OBTENER LOS DATOS DE LOS ATRIBUTOS A TRAVEZ DE LOS CONSTRUCTORES
    public int getIdProducto(){
        return idProducto;
    }
    public void setIdProducto(){
        this.idProducto = idProducto;
    }


    public String getNombreProducto(){
        return nombreProducto;
    }
    public void setNombreProducto(){
        this.nombreProducto = nombreProducto;
    }


    public String getDescripcionProducto(){
        return descripcionProducto;
    }
    public void setDescripcionProducto(){
        this.descripcionProducto = descripcionProducto;
    }


    public double getPrecioProducto(){
        return precioProducto;
    }
    public void setPrecioProducto(){
        this.precioProducto = precioProducto;
    }


    public String getImagenProducto(){
        return imagenProducto;
    }
    public void setImagenProducto(){
        this.imagenProducto = imagenProducto;
    }

    public String getTamañoProducto(){
        return tamañoProducto;
    }
    public void setTamañoProducto(){
        this.tamañoProducto = tamañoProducto;
    }

    @Override
    public String toString(){
        return "Producto(" + "idProducto= " + idProducto + "  Nombre= " + nombreProducto + "  Descripcion= " + descripcionProducto + "  Precio= " + precioProducto + "  imagen=" + imagenProducto +  "  tamano=" + tamañoProducto;
    }
}


