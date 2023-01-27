/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logic;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import modelo.beans.Producto;
import modelo.dao.ProductoDAO;

/**
 *
 * @author COMPUTER
 */
public class ProductoLogic {
    private static ProductoDAO productodao = new ProductoDAO();
    
    public static boolean insertarProducto(Producto producto)throws Exception{
        try{
            return productodao.insertar(producto);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static boolean modificarProducto(Producto producto)throws Exception{
        try{
            return productodao.modificar(producto);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static boolean eliminarProducto(int codigo)throws Exception{
        try{
            return productodao.eliminar(codigo);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static Producto obtenerProducto(int codigo)throws Exception{
        try{
            return productodao.obtener(codigo);
        }catch(Exception ex){
            throw ex;
        }
    }
     public static DefaultComboBoxModel comboModelCategoria(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        List lista = productodao.listar();
        for (int i = 0; i < lista.size(); i++) {
            modelo.addElement(lista.get(i));
        }
        return modelo;
    }
    
    public static DefaultTableModel tableModelProducto(){
        DefaultTableModel modelo = new DefaultTableModel();
        String[] columnNames = {"CODIGO","NOMBRE","PRECIO","STOCK","CATEGORIA","IMAGEN"};
        modelo.setColumnIdentifiers(columnNames);
        
        List<Producto> lista = productodao.listar();
        Object[] fila = new Object[modelo.getColumnCount()];
        for (int i = 0; i < lista.size(); i++) {
            fila[0] = lista.get(i).getIdproducto();
            fila[1] = lista.get(i).getNombre();
            fila[2] = lista.get(i).getPrecio();
            fila[3] = lista.get(i).getStock();
            fila[4] = lista.get(i).getCategoria();
            fila[5] = lista.get(i).getImagen();
            modelo.addRow(fila);
        }
        return modelo;
    }
    
    public static DefaultTableModel tableMain(){
        DefaultTableModel modelo = new DefaultTableModel();
        String[] column = {"NOMBRE","PRECIO","STOCK","IMAGEN"};
        modelo.setColumnIdentifiers(column);
        
        List<Producto> lista = productodao.listar();
        Object[] fila = new Object[modelo.getColumnCount()];
        for (int i = 0; i < lista.size(); i++) {
            fila[1] = lista.get(i).getNombre();
            fila[2] = lista.get(i).getPrecio();
            fila[3] = lista.get(i).getStock();
            fila[5] = lista.get(i).getImagen();
            modelo.addRow(fila);
        }
        return modelo;
    }
}
