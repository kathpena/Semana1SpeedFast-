import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;
import model.Repartidor;
import model.ControladorDeEnvios;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {


        PedidoComida pedido1 = new PedidoComida("Comida", "Av. Siempre Viva 123", "P001", 3.0, true);
        PedidoEncomienda pedido2 = new PedidoEncomienda("Calle Condell 456", "P002", 5.5, 10.0,true);
        PedidoExpress pedido3 = new PedidoExpress("Express", "Pasaje Nublado 789", "P003", 1.2, true);
        PedidoComida pedido4 = new PedidoComida("Comida", "Calle la mostaza 123", "P004", 4.0, true);
        PedidoEncomienda pedido5 = new PedidoEncomienda("Calle Arturo Prat 456", "P005", 2.0, 5.0,true);
        PedidoExpress pedido6 = new PedidoExpress("Express", "Pasaje Del Sol 789", "P006", 6.0, true);


        Pedido [] pedidos = {pedido1, pedido2, pedido3, pedido4, pedido5, pedido6};


        System.out.println("=RESERVA DE PEDIDOS=");
        for (Pedido pedido : pedidos) {
            pedido.reservar();
        }

        Repartidor repartidor1 = new Repartidor("Juan Perez");
        repartidor1.agregarPedido(pedido1);
        repartidor1.agregarPedido(pedido2);

        Repartidor repartidor2 = new Repartidor("Camila Soto");
        repartidor2.agregarPedido(pedido3);
        repartidor2.agregarPedido(pedido4);

        Repartidor repartidor3 = new Repartidor("Luis Diaz");
        repartidor3.agregarPedido(pedido5);
        repartidor3.agregarPedido(pedido6);

        Repartidor[] repartidores = {repartidor1, repartidor2, repartidor3};

        System.out.println("=COMIENZO DE ENTREGAS EN PARALELO=");
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (Repartidor repartidor : repartidores) {
            executor.submit(repartidor);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("=REGISTRO EN HISTORIAL=");
        ControladorDeEnvios controlador = new ControladorDeEnvios();
        for (Repartidor repartidor : repartidores) {
            for (Pedido pedido : repartidor.getPedidosAsignados()) {
                controlador.registrarEntrega(pedido);
            }
        }

        System.out.println();
        controlador.verHistorial();
    }
    }
