import java.util.ArrayList;

class PedidoKiosko {
    private ArrayList<Articulo> menu;
    private ArrayList<Pedido> pedidos;

    public PedidoKiosko(){
        menu = new ArrayList<Articulo>();
        pedidos = new ArrayList<Pedido>();
    }

    public void addMenuItem(String nombre, double precio){
        Articulo newItem = new Articulo(nombre, precio); 
        menu.add(newItem);
        newItem.setIndex(menu.indexOf(newItem));

    }

    public void display(){
        for (Articulo a : menu){
            System.out.println(a.getIndex()+" "+a.getNombre() + " -- $" + a.getPrecio());
        }
    }

    public Pedido newOrder() {
    	// Mostrar al usuario un aviso de mensaje y luego establece su entrada en una variable, nombre
        System.out.println("Ingrese el nombre del cliente para el nuevo pedido:");
        String name = System.console().readLine().trim();

        while(name.length()==0){
            System.out.println("Ingrese el nombre del cliente para el nuevo pedido:");
            name = System.console().readLine().trim();
        }

    	// Tu código:
        // Crea un nuevo pedido con la cadena de entrada dada
        Pedido newPedido = new Pedido(name);
    
        // Muestra el menú al usuario, para que puedan elegir artículos para agregar
        this.display();
    
    	// Pedir al usuario que ingrese un número de artículo
        System.out.println("Ingrese un índice de artículo del menú o q para salir:");
        String itemNumber = System.console().readLine().trim();
        
        // Escribir un bucle while para recopilar todos los artículos del pedido del usuario
        while(!itemNumber.equals("q")) {
            // Obtén el objeto del artículo del menú y agrega el artículo al pedido
            for (Articulo a : menu){
                if (a.getIndex() == Integer.parseInt(itemNumber)){
                    newPedido.addArticulo(a);
                }
            }
            // Pídales que ingresen un nuevo índice de artículo o q nuevamente, y toma su entrada
            System.out.println("Ingrese un índice de artículo del menú o q para salir:");
            itemNumber = System.console().readLine().trim();
        }
        // Después de haber completado su pedido, imprime los detalles del pedido
        newPedido.display();
    	// como el ejemplo de abajo. Puedes utilizar el método de visualización del pedido
        // ??? 

        return newPedido;
    }
}