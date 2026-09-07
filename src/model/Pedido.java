package model;

import model.interfaces.Despachable;
import model.interfaces.Reservable;

public abstract class Pedido implements Reservable, Despachable {

    private String idPedido;
    private String direccionEntrega;
    private String tipoPedido;
    private double distanciaKm;
    protected boolean reservado;
    protected boolean despachado;
    protected boolean cancelado;

    public Pedido(String tipoPedido, String direccionEntrega, String idPedido, double distanciaKm) {
        this.tipoPedido = tipoPedido;
        this.direccionEntrega = direccionEntrega;
        this.idPedido = idPedido;
        this.distanciaKm = distanciaKm;
        this.reservado = false;
        this.despachado = false;
        this.cancelado = false;
    }

    public String getTipoPedido() {return tipoPedido;}
    public String getDireccionEntrega() {return direccionEntrega;}
    public String getIdPedido() {return idPedido;}
    public double getDistanciaKm() {
        return distanciaKm;
    }
    public boolean isReservado() {return reservado;}
    public boolean isDespachado() {return despachado;}
    public boolean isCancelado() {return cancelado;}


    public void asignarRepartidor(){
       System.out.println("==Pedido " + tipoPedido + "==" +"N° " + idPedido + " -> Entregar en : " + direccionEntrega );
       System.out.println("Asigando Repartidor...");
    }

    public void asignarRepartidor(String nombreRepartidor){
        System.out.println("**Pedido asignado a " + nombreRepartidor + "**");
    }

    public void mostrarResumen(){
        System.out.println("===RESUMEN DE PEDIDO===");
        System.out.println("Numero de pedido :" + idPedido);
        System.out.println("Tipo de pedido :" + tipoPedido);
        System.out.println("Direccion entrega :" + direccionEntrega);
        System.out.println("Distancia Km " + distanciaKm);
    }


    public abstract double calcularTiempoEntrega();

    @Override
    public void reservar() {
        if (reservado) {
            System.out.println("El pedido " + idPedido + " ya estaba reservado.");
        } else {
            reservado = true;
            System.out.println("Pedido " + idPedido + " reservado correctamente.");
        }
    }

    @Override
    public void despachar() {

        if (cancelado) {
              System.out.println("El pedido " + idPedido + " Fue cancelado");
        }else if (!reservado) {
              System.out.println("El pedido " + idPedido + " no se puede despachar, no esta reservado.");
        }else{
            despachado = true;
            System.out.println("Pedido " + idPedido + " El pedido va en camino a: " + direccionEntrega);
        }
    }



}
