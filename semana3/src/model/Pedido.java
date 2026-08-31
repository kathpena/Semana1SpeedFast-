package model;

public abstract class Pedido implements Despachable, Cancelable {

    private String idPedido;
    private String direccionEntrega;
    private String tipoPedido;
    private double distanciaKm;
    private boolean despachado;
    private boolean cancelado;

    public Pedido(String tipoPedido, String direccionEntrega, String idPedido, double distanciaKm) {
        this.tipoPedido = tipoPedido;
        this.direccionEntrega = direccionEntrega;
        this.idPedido = idPedido;
        this.distanciaKm = distanciaKm;
        this.despachado = false;
        this.cancelado = false;
    }

    public String getTipoPedido() {return tipoPedido;}
    public String getDireccionEntrega() {return direccionEntrega;}
    public String getIdPedido() {return idPedido;}
    public double getDistanciaKm() {
        return distanciaKm;
    }
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
    public void despachar() {

        if (cancelado) {
              System.out.println("El pedido " + idPedido + " Fue cancelado");
        }else{
            despachado = true;
            System.out.println("Pedido " + idPedido + " El pedido va en camino ");
        }
    }

    @Override
    public void cancelar() {

        if (despachado){
            System.out.println("El pedido " + idPedido + " no se puede cancelar ya fue despachado");

        }else{
            cancelado = true;
            System.out.println("El pedido " + idPedido + " fue cancelado ");

        }


    }

}
