package model;

import java.util.ArrayList;

public class ControladorDeEnvios implements Rastreable {

    private ArrayList<Pedido> historial;


    public ControladorDeEnvios() {
        historial = new ArrayList<>();
    }

    public void registrarEntrega(Pedido pedido) {
        if (pedido.isDespachado()){
        historial.add(pedido);
    }else{
        System.out.println("El pedido no se puede registrar en el historial "+ pedido.getIdPedido() + " no fue despachado");
        }
    }

    @Override
    public void verHistorial() {
        System.out.println("===Historial de Entregas===");
        if(historial.isEmpty()){
            System.out.println("No hay historial de Entregas");
            return;
        }
        for (Pedido pedido : historial) {
            System.out.println("Pedido " + pedido.getIdPedido() + "(" + pedido.getTipoPedido()
                    + " ) => " + pedido.getDireccionEntrega() + "=Tiempo: " + pedido.calcularTiempoEntrega()
                    + " min");

        }
    }

}
