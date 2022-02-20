class Articulo {
    private String nombre;
    private double precio;
    private int index;

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
    public int getIndex(){
        return index;
    }

    public void setNombre(String newNombre){
        nombre = newNombre;
    }
    public void setPrecio(double newPrecio){
        precio = newPrecio;
    }
    public void setIndex(int newIndex){
        index = newIndex;
    }
}