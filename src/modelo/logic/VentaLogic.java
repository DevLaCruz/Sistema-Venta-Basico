/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logic;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.beans.DetalleVenta;
import modelo.beans.Producto;
import modelo.beans.Venta;
import modelo.dao.VentaDAO;

/**
 *
 * @author COMPUTER
 */
public class VentaLogic {

    private static VentaDAO ventadao = new VentaDAO();

    public static boolean insertarVenta(Venta venta) throws Exception {
        DetalleVenta item;
        Producto producto;
        int stock;
        try {
            for (int i = 0; i < venta.getDetalleventa().size(); i++){
                    item = venta.getDetalleventa().get(i);
                    producto = ProductoLogic.obtenerProducto(item.getProducto().getIdproducto());
                    stock = producto.getStock();
                    if(stock <= item.getCantidad()){;
                        throw new Exception("No tienes esa cantidad en el stock");
                    }else{
                        stock = stock - item.getCantidad();
                        producto.setStock(stock);
                    }
            }
            return ventadao.insertar(venta);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public static Venta obtenerVenta(int codigo) throws Exception {
        try {
            return ventadao.obtener(codigo);
        } catch (Exception ex) {
            throw ex;
        }
    }
    public static DefaultComboBoxModel comboModelVenta(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        List lista = ventadao.listar();
        for (int i = 0; i < lista.size(); i++) {
            modelo.addElement(lista.get(i));
        }
        return modelo;
    }
}
