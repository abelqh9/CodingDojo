import java.util.ArrayList;

public class TestPedidos {
    
    public static void main(String[] args) {
    
        // Elementos del menú
        Articulo articulo1 = new Articulo("moka", 3.5);
        Articulo articulo2 = new Articulo("latte", 3.5);
        Articulo articulo3 = new Articulo("cafe de goteo", 2);
        Articulo articulo4 = new Articulo("capuchino", 3);
    
        // Ordenar variables -- orden1, orden2, etc.
        Pedido pedidoInvitado1 = new Pedido();
        Pedido pedidoInvitado2 = new Pedido();
        Pedido pedido1 = new Pedido("Bryan");
        Pedido pedido2 = new Pedido("Leo");
        Pedido pedido3 = new Pedido("Abel");
    
        // Agrega al menos 2 artículos a cada uno de los pedidos usando el método addItem que escribiste.
        pedidoInvitado1.addArticulo(articulo1);
        pedidoInvitado1.addArticulo(articulo2);

        pedidoInvitado2.addArticulo(articulo3);
        pedidoInvitado2.addArticulo(articulo4);

        pedido1.addArticulo(articulo1);
        pedido1.addArticulo(articulo4);
        
        pedido2.addArticulo(articulo2);
        pedido2.addArticulo(articulo4);

        pedido3.addArticulo(articulo1);
        pedido3.addArticulo(articulo3);

        // Prueba los resultados y el método display llamando al método display en todos tus pedidos, así: pedido3.display();

        // pedidoInvitado1.display();
        // pedidoInvitado2.display();
        // pedido1.display();
        // pedido2.display();
        // pedido3.display();

        // rueba la funcionalidad de getStatusMessage configurando algunos pedidos para que estén listos e imprimiendo los mensajes para cada pedido.

        System.out.println(pedidoInvitado1.getStatusMessage());
        pedidoInvitado1.setListo(true);
        System.out.println(pedidoInvitado1.getStatusMessage());
    }
}