package com.example.menuprueba.pedidos;

public class Detalle {
    private int articulo;
    private int cantidad;
    private int precio;

    public Detalle(){

    }

    public Detalle(int a, int c, int p){
        articulo = a;
        cantidad = c;
        precio = p;
    }

    public int getArticulo() {
        return articulo;
    }
    public int getCantidad() {
        return cantidad;
    }
    public int getPrecio() {
        return precio;
    }

    public void setArticulo(int articulo) {
        this.articulo = articulo;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Detalle [articulo=" + articulo + ", cantidad=" + cantidad + ", precio=" + precio + "]";
    }
}
