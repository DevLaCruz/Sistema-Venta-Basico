/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.util.Date;
import java.util.List;

/**
 *
 * @author COMPUTER
 */
public class Venta {
    private int idventa;
    private Date fecha;
    private double total;
    private Cliente cliente;
    private List<DetalleVenta> detalleventa;
    
    public Venta(int idventa, Date fecha, double total, Cliente cliente, List<DetalleVenta> detalleventa){
        this.idventa = idventa;
        this.fecha = fecha;
        this.total = total;
        this.cliente = cliente;
        this.detalleventa = detalleventa;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleVenta> getDetalleventa() {
        return detalleventa;
    }

    public void setDetalleventa(List<DetalleVenta> detalleventa) {
        this.detalleventa = detalleventa;
    }
    
    
    @Override
    public String toString(){
        return ""+this.getIdventa();
    }
}
