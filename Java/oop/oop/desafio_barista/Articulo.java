public class Articulo {
    private String nombre;
    private double precio;

    public Articulo(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre(){
        return nombre;
    }
    public double getPrecio(){
        return precio;
    }

    public void setNombre(String newNombre){
        nombre = newNombre;
    }
    public void setPrecio(double newPrecio){
        precio = newPrecio;
    }
}