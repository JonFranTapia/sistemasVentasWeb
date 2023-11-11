
package Modelo;

public class Cliente {
    int id;
    String dpi;
    String nombre;
    String direc;
    String estado;
    
    public Cliente(){
        
    }

    public Cliente(int id, String dpi, String nombre, String direc, String estado) {
        this.id = id;
        this.dpi = dpi;
        this.nombre = nombre;
        this.direc = direc;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirec() {
        return direc;
    }

    public void setDirec(String direc) {
        this.direc = direc;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
