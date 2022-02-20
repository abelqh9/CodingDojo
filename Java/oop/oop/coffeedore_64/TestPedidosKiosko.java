import java.util.ArrayList;

public class TestPedidosKiosko {
    
    public static void main(String[] args) {

        PedidoKiosko kiosko = new PedidoKiosko();
    
        // Elementos del menú
        kiosko.addMenuItem("moka", 3.5);
        kiosko.addMenuItem("latte", 3.5);
        kiosko.addMenuItem("cafe de goteo", 2);
        kiosko.addMenuItem("capuchino", 3);
    
        kiosko.newOrder();
    }
}