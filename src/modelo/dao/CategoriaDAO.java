/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.ArrayList;
import java.util.List;
import modelo.beans.Categoria;

/**
 *
 * @author COMPUTER
 */
public class CategoriaDAO {
    private List<Categoria> categorias;
    
    public CategoriaDAO(){
        categorias = new ArrayList<>();
    }
    
    public int buscar(int codigo){
        int posicion = -1;
        for (int i = 0; i < categorias.size(); i++) {
            if(categorias.get(i).getIdcategoria() == codigo){
                posicion = i;
                break;
            }
        }
        return posicion;
    }
    
    public boolean insertar(Categoria categoria)throws Exception{
        try{
            if(buscar(categoria.getIdcategoria())==-1){
                categorias.add(categoria);
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public boolean modificar(Categoria categoria)throws Exception{
        try{
            int posicion = buscar(categoria.getIdcategoria());
            if(posicion != -1){
                categorias.set(posicion, categoria);
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
                categorias.remove(posicion);
                return true;
            }else{
                return false;
            }
        }catch(Exception ex){
            throw ex;
        }
    }
    public List<Categoria> listar(){
        return categorias;
    }
}
