import model.EstadoPedido;
import model.Pedido;
import model.Repartidor;
import model.ZonaDeCarga;

public class Main {

    public static void main(String[] args) {

        ZonaDeCarga zonaC = new ZonaDeCarga();

        zonaC.agregarPedido(new Pedido(1," Calle Los Alamos 456"));
        zonaC.agregarPedido(new Pedido(2," Pasaje Las Rosas 789"));
        zonaC.agregarPedido(new Pedido(3," Av. Siempre Viva 123"));
        zonaC.agregarPedido(new Pedido(4," Av. Providencia 1010"));
        zonaC.agregarPedido(new Pedido(5," Camino Del Loro 56"));

        Thread repartidor1 = new Thread (new Repartidor("Pedro", zonaC));
        Thread repartidor2 = new Thread (new Repartidor("Juan", zonaC));
        Thread repartidor3 = new Thread (new Repartidor("Diego", zonaC));

        repartidor1.start();
        repartidor2.start();
        repartidor3.start();

        try{
            repartidor1.join();
            repartidor2.join();
            repartidor3.join();
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }

        System.out.println("Los pedidos han sido entregados en su totalidad correctamente");
    }
}
