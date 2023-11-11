
package Modelo;

public class Producto {
    int codigo;
    String nombre;
    String precio;
    int cantidad;
    String fehca;
    
    public Producto(){
        
    }

    public Producto(int codigo, String nombre, String precio, int cantidad, String fehca) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.fehca = fehca;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFehca() {
        return fehca;
    }

    public void setFehca(String fehca) {
        this.fehca = fehca;
    }
    

    
}
