import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

public class main {
    public static void main(String[] args) {

        Pedido pedidoComida = new PedidoComida("P001", "Av. Siempre viva 123", "P001" , true);
        pedidoComida.asignarRepartidor();
        pedidoComida.asignarRepartidor("Juan Perez");

        System.out.println();

        Pedido pedidoEncomienda = new PedidoEncomienda("Calle Condell 456", "P002", 5.5, true);
        pedidoEncomienda.asignarRepartidor();
        pedidoEncomienda.asignarRepartidor("Camila Soto");

        System.out.println();

        Pedido pedidoExpress = new PedidoExpress("Express", "Pasaje Nublado 789", "P003", 1.2, true);
        pedidoExpress.asignarRepartidor();
        pedidoExpress.asignarRepartidor("Luis Díaz");



    }
}
