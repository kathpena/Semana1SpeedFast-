package model;

import java.util.ArrayList;

public class Repartidor  implements Runnable {

    private String nombre;
    private ArrayList<Pedido> pedidosAsignados;

    public Repartidor(String nombre) {
        this.nombre = nombre;
        this.pedidosAsignados = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidosAsignados.add(pedido);
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Pedido> getPedidosAsignados() {
        return pedidosAsignados;
    }

    @Override
    public void run() {
        System.out.println("Repartidor " + nombre + " comienza su ruta  con " + pedidosAsignados.size() + " pedidos (s). ");

        for (Pedido pedido : pedidosAsignados) {
            System.out.println(" va en camino su pedido" + pedido.getIdPedido() + " a cargo de :" + nombre);
            try {
                int tiempoSimulado = (int) (Math.random() * 5000) + 1000;
                Thread.sleep(tiempoSimulado);
            } catch (InterruptedException e) {
                System.out.println("La entrega de " + nombre + " fue interrumpida.");
                Thread.currentThread().interrupt();
            }

            pedido.despachar();
            System.out.println(nombre + " completó la entrega del pedido " + pedido.getIdPedido());
        }
        System.out.println(nombre + " terminó todas sus entregas.");
    }


}

