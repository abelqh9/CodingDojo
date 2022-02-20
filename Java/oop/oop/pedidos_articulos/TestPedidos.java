import java.util.ArrayList;

public class TestPedidos {
    
    public static void main(String[] args) {
    
        // Elementos del menú
        Articulo articulo1 = new Articulo();
        articulo1.nombre = "moka";
        articulo1.precio = 3.5;

        Articulo articulo2 = new Articulo();
        articulo2.nombre = "latte";
        articulo2.precio = 3.5;

        Articulo articulo3 = new Articulo();
        articulo3.nombre = "cafe de goteo";
        articulo3.precio = 2;

        Articulo articulo4 = new Articulo();
        articulo4.nombre = "capuchino";
        articulo4.precio = 3;
    
        //Ordenar variables -- orden1, orden2, etc.
        Pedido pedido1 = new Pedido();
        pedido1.nombre = "Cindhuri";
        pedido1.total = 0;
        pedido1.listo = false;
        pedido1.items = new ArrayList<Articulo>();

        Pedido pedido2 = new Pedido();
        pedido2.nombre = "Jimmy";
        pedido2.total = 0;
        pedido2.listo = false;
        pedido2.items = new ArrayList<Articulo>();

        Pedido pedido3 = new Pedido();
        pedido3.nombre = "Noah";
        pedido3.total = 0;
        pedido3.listo = false;
        pedido3.items = new ArrayList<Articulo>();

        Pedido pedido4 = new Pedido();
        pedido4.nombre = "Sam";
        pedido4.total = 0;
        pedido4.listo = false;
        pedido4.items = new ArrayList<Articulo>();
    
        // Simulaciones de aplicaciones
        // --- Imprime la variable pedido1 en la consola para ver qué sucede.
        System.out.println(pedido1);

        // --- Agrega el artículo1 a la lista de artículos del pedido2 e incrementa el total del pedido.
        pedido2.items.add(articulo1);
        pedido2.total += articulo1.precio;

        // --- pedido3 pidió un capuchino. Agrega el capuchino a su lista de pedido y a su cuenta.
        pedido3.items.add(articulo4);
        pedido3.total += articulo4.precio;

        // pedido4 agregó un latte. Actualiza en consecuencia.
        pedido4.items.add(articulo2);
        pedido4.total += articulo2.precio;

        // El pedido de Cindhuri ya está listo. Actualiza su estado.
        pedido1.listo = true;

        // Sam pidió más bebidas: 2 latte. Actualiza su pedido también.
        pedido4.items.add(articulo2);
        pedido4.items.add(articulo2);
        pedido4.total += articulo2.precio;
        pedido4.total += articulo2.precio;

        // El pedido de Jimmy ya está listo. Actualiza su estado.
        pedido2.listo = true;

        // Utiliza este código de ejemplo para probar las actualizaciones de varios pedidos
        System.out.printf("Nombre: %s\n", pedido4.nombre);
        System.out.printf("Total: %s\n", pedido4.total);
        System.out.printf("Listo: %s\n", pedido4.listo);
        System.out.printf("Items: %s\n", pedido4.items);
    }
}