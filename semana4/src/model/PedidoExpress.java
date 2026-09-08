package model;

public class PedidoExpress extends Pedido{

    private boolean disponibilidadInmediata;

    public PedidoExpress(String tipoPedido, String direccionEntrega, String idPedido, double distanciaKm, boolean disponibilidadInmediata) {
        super(tipoPedido, direccionEntrega, idPedido, distanciaKm);
        this.disponibilidadInmediata = disponibilidadInmediata;
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

    @Override
    public double calcularTiempoEntrega(){
        double tiempo = 10;
        if (getDistanciaKm() > 5) {
            tiempo += 5;
        }
        return tiempo;
    }
}

