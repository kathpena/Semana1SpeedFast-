package model;

public class PedidoComida extends Pedido {

    private boolean requiereMochilaT;

    public PedidoComida(String tipoPedido, String direccionEntrega, String idPedido, double distanciaKm, boolean requiereMochilaT) {
        super(tipoPedido, direccionEntrega, idPedido, distanciaKm);
        this.requiereMochilaT = requiereMochilaT;
    }

    public boolean isRequeireMochilaT() {
        return requiereMochilaT;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("===Pedido Comida===" + " N° " + getIdPedido() + "-> Entrega en: " + getDireccionEntrega());
        System.out.println("Asignando Repartidor...");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        if (requiereMochilaT) {
            System.out.println("**Verificando mochila térmica...OK**" );
            System.out.println("Pedido asignado a = " + nombreRepartidor);
        }else{
            System.out.println("**Verifiicando mochila térmica... FALTA**");
            System.out.println("Pedido no pudo ser asignado a = " + nombreRepartidor + "**");
        }
    }

    @Override
    public double calcularTiempoEntrega(){
        return 15 + (2 * getDistanciaKm());
    }
}
