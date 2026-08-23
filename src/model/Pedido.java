package model;

public abstract class Pedido {

    private String idPedido;
    private String direccionEntrega;
    private String tipoPedido;
    private double distanciaKm;

    public Pedido(String tipoPedido, String direccionEntrega, String idPedido, double distanciaKm) {
        this.tipoPedido = tipoPedido;
        this.direccionEntrega = direccionEntrega;
        this.idPedido = idPedido;
        this.distanciaKm = distanciaKm;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }


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

}
