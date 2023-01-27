/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.ArrayList;
import java.util.List;
import modelo.beans.Cliente;

/**
 *
 * @author COMPUTER
 */
public class ClienteDAO {
    private List<Cliente> clientes;
    
    public ClienteDAO(){
        clientes = new ArrayList<>();
    }
    
    public int buscar(int codigo){
        int pos = -1;
        for (int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i).getCodigo()==codigo){
                pos = i;
                break;
            }
        }
        return pos;
    }
    
    public boolean insertar(Cliente cliente)throws Exception{
        try{
            if(buscar(cliente.getCodigo())==-1){
                clientes.add(cliente);
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public boolean modificar(Cliente cliente)throws Exception{
        try{
            int posicion = buscar(cliente.getCodigo());
            if(posicion != -1){
                clientes.set(posicion, cliente);
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public boolean eliminar(int codigo)throws Exception{
        try{
            int posicion = buscar(codigo);
            if(posicion != -1){
                clientes.remove(posicion);
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public Cliente obtener(int codigo)throws Exception{
        try{
            int pos = buscar(codigo);
            return clientes.get(pos);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public List<Cliente> listar(){
        return clientes;
    }
    
}
