/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logic;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import modelo.beans.Cliente;
import modelo.dao.ClienteDAO;

/**
 *
 * @author COMPUTER
 */
public class ClienteLogic {
    private static ClienteDAO clientedao = new ClienteDAO();
    
    public static boolean insertarCliente(Cliente cliente)throws Exception{
        try{
            return clientedao.insertar(cliente);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static boolean modificarCliente(Cliente cliente)throws Exception{
        try{
            return clientedao.modificar(cliente);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static boolean eliminarCliente(int codigo)throws Exception{
        try{
            return clientedao.eliminar(codigo);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public static Cliente obtenerCliente(int codigo)throws Exception{
        try{
            return clientedao.obtener(codigo);
        }catch(Exception ex){
            throw ex;
        }
    }
    public static DefaultComboBoxModel comboModelCategoria(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        List lista = clientedao.listar();
        for (int i = 0; i < lista.size(); i++) {
            modelo.addElement(lista.get(i));
        }
        return modelo;
    }
    
    public static DefaultTableModel tableModelCliente(){
        DefaultTableModel modelo = new DefaultTableModel();
        
        String[] columnNames = {"CODIGO","DNI","NOMBRES","APELLIDOS"};
        modelo.setColumnIdentifiers(columnNames);
        
        List<Cliente> lista = clientedao.listar();
        Object[] fila = new Object[modelo.getColumnCount()];
        for (int i = 0; i < lista.size(); i++) {
            fila[0] = lista.get(i).getCodigo();
            fila[1] = lista.get(i).getDni();
            fila[2] = lista.get(i).getNombre();
            fila[3] = lista.get(i).getApellidos();
            modelo.addRow(fila);
        }
        return modelo;
    }
}
