package com.example.usuario.tarea.bean;

/**
 * Created by Usuario on 02/05/2017.
 */

public class Carrito {

    private Long codProducto;
    private String desProducto;
    private Double cantidad;
    private Double precio;
    private Double total;

    public Carrito(){

    }

    public Long getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Long codProducto) {
        this.codProducto = codProducto;
    }

    public String getDesProducto() {
        return desProducto;
    }

    public void setDesProducto(String desProducto) {
        this.desProducto = desProducto;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Carrito(Long codProducto, String desProducto, Double cantidad, Double precio, Double total) {
        this.codProducto = codProducto;
        this.desProducto = desProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "desProducto='" + desProducto + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", total=" + total +
                '}';
    }
}
