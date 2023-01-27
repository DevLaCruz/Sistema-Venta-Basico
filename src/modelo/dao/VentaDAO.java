/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.ArrayList;
import java.util.List;
import modelo.beans.Venta;

/**
 *
 * @author COMPUTER
 */
public class VentaDAO {
    private List<Venta> ventas;
    
    public VentaDAO(){
        ventas = new ArrayList<>();
    }
    
    public int buscar(int codigo){
        int pos = -1;
        for (int i = 0; i < ventas.size(); i++) {
            if(ventas.get(i).getIdventa()==codigo){
                pos = i;
                break;
            }
            
        }
        return pos;
    }
    
    public boolean insertar(Venta venta)throws Exception{
        try{
            if(buscar(venta.getIdventa())==-1){
                ventas.add(venta);
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public Venta obtener(int codigo)throws Exception{
        try{
            int pos = buscar(codigo);
            return ventas.get(pos);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public List<Venta> listar(){
        return ventas;
    }
}
