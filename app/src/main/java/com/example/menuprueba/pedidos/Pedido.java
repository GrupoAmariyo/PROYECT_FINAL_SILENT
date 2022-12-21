package com.example.menuprueba.pedidos;

import java.util.ArrayList;

public class Pedido {
    private int id;
    private int partner;
    private int factura;
    private int transportista;
    private int comercial;
    private ArrayList<Detalle> detalles;

    public Pedido(){

    }

    public Pedido(int id, int p, int f, int t, int c){
        this.id = id;
        partner = p;
        factura = f;
        transportista = t;
        comercial = c;
        detalles = new ArrayList<Detalle>();
    }

    public Pedido(int id, int p, int f, int t, int c, ArrayList<Detalle> d){
        this.id = id;
        partner = p;
        factura = f;
        transportista = t;
        comercial = c;
        detalles = d;
    }



    public int getId() {return id;}
    public int getPartner() {
        return partner;
    }
    public int getFactura() {
        return factura;
    }
    public int getTransportista() {
        return transportista;
    }
    public int getComercial() {
        return comercial;
    }

    public void setId(int id) {this.id = id;}
    public void setPartner(int partner) {
        this.partner = partner;
    }
    public void setFactura(int factura) {
        this.factura = factura;
    }
    public void setTransportista(int transportista) {
        this.transportista = transportista;
    }
    public void setComercial(int comercial) {
        this.comercial = comercial;
    }

    public ArrayList<Detalle> getDetalles() {
        return detalles;
    }
    public Detalle getDetalles(int i){
        return detalles.get(i);
    }
    public void setDetalles(ArrayList<Detalle> detalles) {
        this.detalles = detalles;
    }
    public void addDetalle(Detalle d){
        detalles.add(d);
    }
    public void removeDetalle(int i){
        detalles.remove(i);
    }

    @Override
    public String toString() {
        return "Pedido "+id+" [partner=" + partner + ", factura=" + factura + ", transportista=" + transportista
                + ", comercial=" + comercial + ", detalles=" + detalles + "]";
    }
}
