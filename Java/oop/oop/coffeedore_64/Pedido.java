import java.util.ArrayList;

class Pedido {
    private String nombre;
    private boolean listo;
    private ArrayList<Articulo> items;

    public Pedido(){
        this.nombre = "Invitado";
        this.items = new ArrayList<Articulo>();
    }

    public Pedido(String nombre){
        this.nombre = nombre;
        this.items = new ArrayList<Articulo>();
    }

    public String getNombre(){
        return nombre;
    }
    public ArrayList<Articulo> getItems(){
        return items;
    }
    public boolean isListo(){
        return listo;
    }

    public void setNombre(String newNombre){
        nombre = newNombre;
    }
    public void setListo(boolean newState){
        listo = newState;
    }

    public void addArticulo(Articulo newArticulo){
        items.add(newArticulo);
    }
    public String getStatusMessage(){
        if ( listo ){
            return "- Tu pedido está listo";
        }else{
            return "- Gracias por esperar. Tu pedido estará listo pronto";
        }
    }
    public double getOrderTotal(){
        double total = 0;
        for (Articulo a : items){
            total += a.getPrecio();
        }
        return total;
    }
    public void display(){
        System.out.println("\nNombre Cliente: " + nombre);
        for (Articulo a : items){
            System.out.println(a.getNombre() + ": " + a.getPrecio());
        }
        System.out.println("Total: " + getOrderTotal() +"\n");
    }
}