package model;

public class Pedido {

    private String idPedido;
    private String direccionEntrega;
    private String tipoPedido;

    public Pedido(String tipoPedido, String direccionEntrega, String idPedido) {
        this.tipoPedido = tipoPedido;
        this.direccionEntrega = direccionEntrega;
        this.idPedido = idPedido;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public void asignarRepartidor(){
       System.out.println("==Pedido " + tipoPedido + "==" +"N° " + idPedido + " -> Entregar en : " + direccionEntrega );
       System.out.println("Asigando Repartidor...");
    }

    public void asignarRepartidor(String nombreRepartidor){
        System.out.println("**Pedido asignado a " + nombreRepartidor + "**");
    }

}
