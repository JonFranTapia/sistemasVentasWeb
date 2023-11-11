/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Config.GenerarSerie;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JTC
 */
public class Controlador extends HttpServlet {
    
    Empleado em = new Empleado();
    EmpleadoDAO edao =  new EmpleadoDAO();
    Producto prod = new Producto();
    ProductoDAO prodao = new ProductoDAO();
    Cliente cl = new Cliente();
    ClienteDAO cldao = new ClienteDAO();
    Venta v = new Venta();
    List<Venta>listas=new ArrayList<>();
    int item;
    int codi;
    String descripcion;
    double precio;
    int canti;
    double subtotal;
    double totalPagar;
    
    String numeroserie;
    VentaDAO vdao= new VentaDAO();
    
    int ide;
    


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        String menu=request.getParameter("menu");
        String accion=request.getParameter("accion");
        if(menu.equals("Principal")){
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if(menu.equals("Empleado")){
            switch (accion) {
                case "Listar":
                    List lista=edao.listar();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    String dpi=request.getParameter("txtdpi");
                    String nom=request.getParameter("txtnom");
                    String tel=request.getParameter("txttel");
                    String est=request.getParameter("txtest");
                    String user=request.getParameter("txtusr");
                    em.setDpi(dpi);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(est);
                    em.setUser(user);
                    edao.agregar(em);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    
                    break;
                case "Editar":
                    ide=Integer.parseInt(request.getParameter("id"));
                    Empleado e=edao.listarId(ide);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    
                    break;
                case "Actualizar":
                    String dpi1=request.getParameter("txtdpi");
                    String nom1=request.getParameter("txtnom");
                    String tel1=request.getParameter("txttel");
                    String est1=request.getParameter("txtest");
                    String user1=request.getParameter("txtusr");
                    em.setDpi(dpi1);
                    em.setNom(nom1);
                    em.setTel(tel1);
                    em.setEstado(est1);
                    em.setUser(user1);
                    em.setId(ide);
                    edao.actualizar(em);
                    
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    ide=Integer.parseInt(request.getParameter("id"));
                    edao.eliminar(ide);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
            
        } 
        
        //Productos crud
        if(menu.equals("Producto")){
            switch (accion) {
                case "Listar":
                    List lista=prodao.listar();
                    request.setAttribute("productos", lista);
                    break;
                case "Agregar":
                    int cod;
                    int cant;
                    cod= Integer.parseInt( request.getParameter("txtcod"));
                    String nom=request.getParameter("txtnom");
                    String prec=request.getParameter("txtpre");
                    cant=Integer.parseInt(request.getParameter("txtcan"));
                    prod.setCodigo(cod);
                    prod.setNombre(nom);
                    prod.setPrecio(prec);
                    prod.setCantidad(cant);
                    prodao.agregar(prod);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    
                    break;
                case "Editar":
                    ide=Integer.parseInt(request.getParameter("id"));
                    Producto e=prodao.listarId(ide);
                    request.setAttribute("producto", e);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    
                    break;
                case "Actualizar":
                    int cod1;
                    int cant1;
                    cod1= Integer.parseInt( request.getParameter("txtcod"));
                    String nom1=request.getParameter("txtnom");
                    String prec1=request.getParameter("txtpre");
                    cant1= Integer.parseInt(request.getParameter("txtcan"));
                    prod.setCodigo(cod1);
                    prod.setNombre(nom1);
                    prod.setPrecio(prec1);
                    prod.setCantidad(cant1);
                    prodao.actualizar(prod);
                    
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    ide=Integer.parseInt(request.getParameter("id"));
                    prodao.eliminar(ide);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        //clientes crud
        
        if(menu.equals("Clientes")){
            switch (accion) {
                case "Listar":
                    List lista=cldao.listar();
                    request.setAttribute("clientes", lista);
                    break;
                case "Agregar":
                    int cod;
                    cod= Integer.parseInt( request.getParameter("txtid"));
                    String dpi=request.getParameter("txtdpi");
                    String nom=request.getParameter("txtnom");
                    String dir=request.getParameter("txtdir");
                    String est=request.getParameter("txtest");
                    cl.setId(cod);
                    cl.setDpi(dpi);
                    cl.setNombre(nom);
                    cl.setDirec(dir);
                    cl.setEstado(est);
                    cldao.agregar(cl);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    
                    break;
                case "Editar":
                    ide=Integer.parseInt(request.getParameter("id"));
                    Cliente e=cldao.listarId(ide);
                    request.setAttribute("cliente", e);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    
                    break;
                case "Actualizar":
                    int cod1;
                    cod1= Integer.parseInt( request.getParameter("txtid"));
                    String dpi1=request.getParameter("txtdpi");
                    String nom1=request.getParameter("txtnom");
                    String dir1=request.getParameter("txtdir");
                    String est1=request.getParameter("txtest");
                    cl.setId(cod1);
                    cl.setDpi(dpi1);
                    cl.setNombre(nom1);
                    cl.setDirec(dir1);
                    cl.setEstado(est1);
                    cldao.actualizar(cl);
                    
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    ide=Integer.parseInt(request.getParameter("id"));
                    cldao.eliminar(ide);
                    request.getRequestDispatcher("Controlador?menu=Clientes&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }
        if(menu.equals("NuevaVenta")){
            switch (accion) {
                case "BuscarCliente":
                    String dpi=request.getParameter("codigocliente");
                    cl.setDpi(dpi);
                    cl=cldao.Buscar(dpi);
                    request.setAttribute("cl", cl);
                    request.setAttribute("nserie", numeroserie);
                    break;
                case "BuscarProducto":
                    request.setAttribute("nserie", numeroserie);
                    int id=Integer.parseInt(request.getParameter("codigoproducto"));
                    prod=prodao.listarId(id);
                    request.setAttribute("cl", cl);
                    request.setAttribute("prod", prod);
                    request.setAttribute("lista", listas);
                    request.setAttribute("totalpagar", totalPagar);
                    break;
                    
                    
                case "Agregar":
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("cl", cl);
                    totalPagar=0.0;
                    item=item+1;
                    codi=prod.getCodigo();
                    descripcion=request.getParameter("nomproducto");
                    precio=Double.parseDouble(request.getParameter("precio"));
                    canti=Integer.parseInt(request.getParameter("cant"));
                    subtotal=precio*canti;
                    v=new Venta();
                    v.setItem(item);
                    v.setIdproducto(codi);
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(canti);
                    v.setSubtotal(subtotal);
                    listas.add(v);
                    for (int i = 0; i < listas.size(); i++) {
                        totalPagar=totalPagar+listas.get(i).getSubtotal();
                    }
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", listas);
                 
                    break;
                case "Delete":
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("cl", cl);
                    int idproductos;
                    idproductos=Integer.parseInt(request.getParameter("eliminar"));
                    for (int i = 0; i < listas.size(); i++) {
                        if(listas.get(i).getIdproducto()==idproductos){
                            listas.remove(i);
                        }
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", listas);
                    }
                    break;
                    
                    
                case "GenerarVenta":
                    //Actualizacion de stock
                    for (int i = 0; i < listas.size(); i++) {
                        Producto pr= new Producto();
                        int cantidad=listas.get(i).getCantidad();
                        int idproducto=listas.get(i).getIdproducto();
                        ProductoDAO aO = new ProductoDAO();
                        pr=aO.buscar(idproducto);
                        int sac = pr.getCantidad()- cantidad;
                        aO.actualizarStock(idproducto, sac);
                          
                    }
                     //Guardar venta
                    v.setIdcliente(cl.getId());
                    v.setIdempleado(2);
                    v.setNumserie(numeroserie);
                    v.setFecha("2023-11-06");
                    v.setMonto(totalPagar);
                    v.setEstado("1");
                    vdao.guardarVenta(v);
                    //Gaardar detalle venta
                    int idv=Integer.parseInt(vdao.IdVentas());
                    for (int i = 0; i <listas.size(); i++) {
                        v= new Venta();
                        v.setId(idv);
                        v.setIdproducto(listas.get(i).getIdproducto());
                        v.setCantidad(listas.get(i).getCantidad());
                        v.setPrecio(listas.get(i).getPrecio());
                        vdao.guardarDetalleventas(v);
                    }
                    
                    break;  
                
                    
                default:
                    v = new Venta();
                    listas = new ArrayList<>();
                    item=0;
                    totalPagar=0.0;
                    numeroserie= vdao.GenerarSerie();
                    if(numeroserie==null){
                        numeroserie="00000001";
                        request.setAttribute("nserie", numeroserie);
                    }
                    else{
                        int incrementar=Integer.parseInt(numeroserie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroserie=gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                    }
                    request.getRequestDispatcher("NuevaVenta.jsp").forward(request, response);
            }
            
            request.getRequestDispatcher("NuevaVenta.jsp").forward(request, response);
            
        }
      
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
