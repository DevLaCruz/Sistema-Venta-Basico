 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logic;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import modelo.beans.Categoria;
import modelo.dao.CategoriaDAO;

/**
 *
 * @author COMPUTER
 */
public class CategoriaLogic {
    
    private static CategoriaDAO categoriadao = new CategoriaDAO();
    
    public static boolean insertarCategoria(Categoria categoria)throws Exception{
        try{
           return categoriadao.insertar(categoria);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static boolean modificarCategoria(Categoria categoria)throws Exception{
        try{
            return categoriadao.modificar(categoria);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static boolean eliminarCategoria(int codigo)throws Exception{
        try{
            return categoriadao.eliminar(codigo);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static DefaultComboBoxModel comboModelCategoria(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        List lista = categoriadao.listar();
        for (int i = 0; i < lista.size(); i++) {
            modelo.addElement(lista.get(i));
        }
        return modelo;
    }
    
    public static DefaultListModel listModelCategoria(){
        DefaultListModel modelo = new DefaultListModel();
        List lista = categoriadao.listar();
        
        for (int i = 0; i < lista.size(); i++) {
            modelo.addElement(lista.get(i));
        }
        return modelo;        
    }
    public static DefaultTableModel tableModelCate(){
        DefaultTableModel modelo = new DefaultTableModel();
        
        String[] columnNames = {"CODIGO","NOMBRE"};
        modelo.setColumnIdentifiers(columnNames);
        
        List<Categoria> lista = categoriadao.listar();
        Object[] fila = new Object[modelo.getColumnCount()];
        for (int i = 0; i < lista.size(); i++) {
            fila[0] = lista.get(i).getIdcategoria();
            fila[1] = lista.get(i).getNombre();
            modelo.addRow(fila);
        }
        return modelo;
    }
}
