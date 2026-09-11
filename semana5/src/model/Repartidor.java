package model;


public class Repartidor implements Runnable {

    private String nombre;
    private ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    @Override
    public void run() {

        Pedido pedido;
        while ((pedido = zonaDeCarga.retirarPedido()) != null) {
            System.out.println("El repartidor " + nombre + " retiro el pedido: " + pedido.getId() +
            "ESTADO=> " + pedido.getEstado());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            pedido.setEstado(EstadoPedido.ENTREGADO);
            System.out.println("El repartidor " + nombre + " entrego el pedido: " + pedido.getId() +
                    " ESTADO=> " + pedido.getEstado());
        }

          System.out.println("El repartidor " + nombre + " termino, ya no quedan pedidos en la zona de carga: ");
    }

}
