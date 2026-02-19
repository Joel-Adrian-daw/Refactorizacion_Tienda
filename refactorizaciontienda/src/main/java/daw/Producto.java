package daw;

public class Producto {
    
    private String nombre;
    private double precio;
    private int stock;

    /*nombre del producto, precio y el stock */
    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    /*creamos getters y setters */
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }


    //reducir stock
    public void reducirStock (int cantidad){
        if (cantidad <= stock){
            stock -= cantidad;
        }
    }
    /*to strings */
    @Override
    public String toString() {
        return nombre + " - " + precio + "€ - Stock: " + stock;
    }
}
