package model;

public class PedidoEncomienda extends Pedido{

    private double pesoKg;
    private boolean embalajeValido;

    public PedidoEncomienda(String direccionEntrega, String idPedido,double distanciaKm, double pesoKg, boolean embalajeValido) {
        super("Encomienda", direccionEntrega, idPedido, distanciaKm);
        this.pesoKg = pesoKg;
        this.embalajeValido = embalajeValido;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public boolean isEmbalajeValido() {
       return embalajeValido;
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("===Pedido Encomienda===" + " N° " + getIdPedido() + "-> Entrega en: " + getDireccionEntrega());
        System.out.println("Asignando Repartidor...");
    }

    @Override
    public void asignarRepartidor(String nombreRepartidor){
        if (embalajeValido && pesoKg <=20.0) {
            System.out.println("**Validando peso y embalaje...OK**");
            System.out.println("Pedido asignado a = " + nombreRepartidor );
        }else{
            System.out.println("**Validando peso y embalaje...RECHAZADO**");
            System.out.println("Pedido no se pudo asignar a = " + nombreRepartidor) ;
        }
    }

    @Override
    public double calcularTiempoEntrega(){
        return Math.round (20 + (1.5 * getDistanciaKm()));
    }
}
