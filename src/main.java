import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

public class main {
    public static void main(String[] args) {

        Pedido pedidoComida = new PedidoComida("Comida", "Av. Siempre viva 123", "P001" , 3.0,  true);
        pedidoComida.mostrarResumen();
        pedidoComida.asignarRepartidor();
        pedidoComida.asignarRepartidor("Juan Perez");
        System.out.println("Tiempo estimado de entrega: " + pedidoComida.calcularTiempoEntrega() + " min");

        System.out.println();

        Pedido pedidoEncomienda = new PedidoEncomienda("Calle Condell 456", "P002", 5.5, 10.0,true);
        pedidoEncomienda.mostrarResumen();
        pedidoEncomienda.asignarRepartidor();
        pedidoEncomienda.asignarRepartidor("Camila Soto");
        System.out.println("Tiempo estimado de entrega: " + pedidoEncomienda.calcularTiempoEntrega() + " min");

        System.out.println();

        Pedido pedidoExpress = new PedidoExpress("Express", "Pasaje Nublado 789", "P003", 1.2, true);
        pedidoExpress.mostrarResumen();
        pedidoExpress.asignarRepartidor();
        pedidoExpress.asignarRepartidor("Luis Díaz");
        System.out.println("Tiempo estimado de entrega: " + pedidoExpress.calcularTiempoEntrega() + " min");

        System.out.println();

        System.out.println("===Comparacion de tiempos de entrega===");
        System.out.println("Comida :" + pedidoComida.calcularTiempoEntrega() + " min");
        System.out.println("Encomienda :" + pedidoEncomienda.calcularTiempoEntrega() + " min");
        System.out.println("Express :" + pedidoExpress.calcularTiempoEntrega() + " min");

    }
}
