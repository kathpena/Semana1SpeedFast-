import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;
import model.ControladorDeEnvios;

public class Main {
    public static void main(String[] args) {

        ControladorDeEnvios controlador = new ControladorDeEnvios();
        PedidoComida pedidoComida = new PedidoComida("Comida", "Av. Siempre Viva 123", "P001", 3.0, true);
        PedidoEncomienda pedidoEncomienda = new PedidoEncomienda("Calle Condell 456", "P002", 5.5, 10.0,true);
        PedidoExpress pedidoExpress = new PedidoExpress("Express", "Pasaje Nublado 789", "P003", 1.2, true);

        Pedido [] pedidos = {pedidoComida, pedidoEncomienda, pedidoExpress};
        String [] repartidores = {"Juan Perez", "Camila Soto", "Luis Diaz"};

        System.out.println("=ASIGNACION AUTOMATICA=");
        for (Pedido pedido : pedidos) {
            pedido.asignarRepartidor();
        }

        System.out.println("=ASIGNACION MANUAL=");
        for (int i = 0; i < pedidos.length; i++) {
            pedidos[i].asignarRepartidor(repartidores[i]);
        }

        System.out.println("=RESERVA DE PEDIDOS=");
        for (Pedido pedido : pedidos) {
            pedido.reservar();
        }

        System.out.println("=TIEMPO ESTIMADO DE ENTREGA=");
        for (Pedido pedido : pedidos) {
            System.out.println(pedido.getIdPedido() + ": " + pedido.calcularTiempoEntrega() + "min" );
        }

        System.out.println("=DESPACHO DE PEDIDOS=");
        pedidoComida.despachar();
        pedidoExpress.despachar();

        System.out.println("=CANCELACION DE UN PEDIDO=");
        pedidoEncomienda.cancelar();
        pedidoEncomienda.despachar();

        System.out.println("=REGISTRO EN HISTORIAL=");
        for (Pedido pedido : pedidos) {
            controlador.registrarEntrega(pedido);
        }

        System.out.println();
        controlador.verHistorial();



    }
}