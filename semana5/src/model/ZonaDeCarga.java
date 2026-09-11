package model;

import java.util.LinkedList;
import java.util.Queue;

public class ZonaDeCarga {

    private final Queue<Pedido> pedidosPendientes = new LinkedList<>();

    public synchronized void agregarPedido(Pedido pedido) {
        pedidosPendientes.add(pedido);
        System.out.println("Agregando pedido: " + pedido.getId() + " agregado a la zona de carga");

    }

    public synchronized Pedido retirarPedido() {

        if (pedidosPendientes.isEmpty()) {
            return null;
        }
        Pedido pedido = pedidosPendientes.poll();
        pedido.setEstado(EstadoPedido.EN_REPARTO);
        return pedido;

    }


}
