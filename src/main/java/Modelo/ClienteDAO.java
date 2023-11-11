
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    Conexion cn= new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Cliente Buscar(String dpi){
        Cliente cl = new Cliente(); 
        String sql="select * from cliente where dpi="+dpi;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                cl.setId(rs.getInt(1));
                cl.setDpi(rs.getString(2));
                cl.setNombre(rs.getString(3));
                cl.setDirec(rs.getString(4));
                cl.setEstado(rs.getString(5));
             
            }
        } catch (Exception e) {
        }
        return cl;
    }
    
    public  List listar(){
        String sql="select * from cliente;";
        List<Cliente>lista=new ArrayList<>();
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Cliente cl= new Cliente();
                cl.setId(rs.getInt(1));
                cl.setDpi(rs.getString(2));
                cl.setNombre(rs.getString(3));
                cl.setDirec(rs.getString(4));
                cl.setEstado(rs.getString(5));
                lista.add(cl);
                
            }
        } catch (Exception e) {
        }
        return lista;
    }
    public int agregar(Cliente cl){
        String sql ="insert into cliente(id,dpi,nombre,direccion,estado)values(?,?,?,?,?);";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, cl.getId());
            ps.setString(2, cl.getDpi());
            ps.setString(3, cl.getNombre());
            ps.setString(4, cl.getDirec());
            ps.setString(5, cl.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public Cliente listarId(int id){
        Cliente cli = new Cliente();
        String sql="select * from cliente where id="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                cli.setId(rs.getInt(1));
                cli.setDpi(rs.getString(2));
                cli.setNombre(rs.getString(3));
                cli.setDirec(rs.getString(4));
                cli.setEstado(rs.getString(5));
                
            }
        } catch (Exception e) {
        }
        return cli;
    }
    public int  actualizar(Cliente cl){
        String sql ="update cliente set dpi=?,nombre=?,direccion=?,estado=? where id=?;";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, cl.getDpi());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getDirec());
            ps.setString(4, cl.getEstado());
            ps.setInt(5,cl.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
        
    }
    public void eliminar(int id){
        String sql="delete from cliente where id="+id;
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();  
        } catch (Exception e) {
        }
    }
    
}
