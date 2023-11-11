
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JTC
 */
public class ProductoDAO {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    
    public Producto buscar(int id){
        Producto p = new Producto();
        String sql="select * from producto where codigoProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                p.setCodigo(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getString(3));
                p.setCantidad(rs.getInt(4));
                
            }
        } catch (Exception e) {
           
        }
         return p;
    }
    
    public int actualizarStock(int id, int stock){
        String sql="update producto set cantidadProducto=? where codigoProducto=?";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1,stock);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    //operaciones crud
    
    public  List listar(){
        String sql="select * from producto;";
        List<Producto>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Producto prod= new Producto();
                prod.setCodigo(rs.getInt(1));
                prod.setNombre(rs.getString(2));
                prod.setPrecio(rs.getString(3));
                prod.setCantidad(rs.getInt(4));
                prod.setFehca(rs.getString(5));
                lista.add(prod);
                
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int agregar(Producto prod){
        String sql ="insert into producto(codigoProducto,nombreProducto,precoUnitario,cantidadProducto)values(?,?,?,?);";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, prod.getCodigo());
            ps.setString(2, prod.getNombre());
            ps.setString(3, prod.getPrecio());
            ps.setInt(4, prod.getCantidad());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public Producto listarId(int id){
        Producto pro = new Producto();
        String sql="select * from producto where codigoProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                pro.setCodigo(rs.getInt(1));
                pro.setNombre(rs.getString(2));
                pro.setPrecio(rs.getString(3));
                pro.setCantidad(rs.getInt(4));
                
            }
        } catch (Exception e) {
        }
        return pro;
    }
    public int  actualizar(Producto prod){
        String sql ="update producto set nombreProducto=?,precoUnitario=?,cantidadProducto=? where codigoProducto=?;";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, prod.getNombre());
            ps.setString(2, prod.getPrecio());
            ps.setInt(3, prod.getCantidad());
            ps.setInt(4,prod.getCodigo());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
        
    }
    public void eliminar(int id){
        String sql="delete from producto where codigoProducto="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();  
        } catch (Exception e) {
        }
    }
}
