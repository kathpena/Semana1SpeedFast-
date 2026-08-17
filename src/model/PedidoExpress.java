package model;

public class PedidoExpress extends Pedido{
    private double distanciaKm;
    private boolean disponibilidadInmediata;

    public PedidoExpress(String tipoPedido, String direccionEntrega, String idPedido, double distanciaKm, boolean disponibilidadInmediata) {
        super(tipoPedido, direccionEntrega, idPedido);
        this.distanciaKm = distanciaKm;
        this.disponibilidadInmediata = disponibilidadInmediata;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public boolean isDisponibilidadInmediata() {
        return disponibilidadInmediata;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("===Pedido Express===" + " N° " + getIdPedido() + "-> Entrega en: " + getDireccionEntrega());
        System.out.println("Asignando Repartidor...");
    }
    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        if (disponibilidadInmediata) {
            System.out.println("**Repartidor más cercano con disponibilidad inmediata encontrado**");
            System.out.println("Pedido asignado a = " + nombreRepartidor);
        }else{
            System.out.println("**Sin repartidor disponible de forma inmediata**");
            System.out.println("Pedido no se pudo asignar a = " + nombreRepartidor);
        }
    }
}

