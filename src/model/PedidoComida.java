package model;

public class PedidoComida extends Pedido {

    private boolean requeireMochilaT;

    public PedidoComida(String tipoPedido, String direccionEntrega, String idPedido, double distanciaKm, boolean requeireMochilaT) {
        super(tipoPedido, direccionEntrega, idPedido, distanciaKm);
        this.requeireMochilaT = requeireMochilaT;
    }

    public boolean isRequeireMochilaT() {
        return requeireMochilaT;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("===Pedido Comida===" + " N° " + getIdPedido() + "-> Entrega en: " + getDireccionEntrega());
        System.out.println("Asignando Repartidor...");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor) {
        if (requeireMochilaT) {
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
