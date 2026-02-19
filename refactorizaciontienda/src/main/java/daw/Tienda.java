package daw;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * CÓDIGO CON CODESMELLING
 * 
 * TODO: Este código necesita un refactorización urgente.
 * - Eliminar la "Clase Dios" que es todo el main
 * - Usar programación orientada a objetos
 * - Eliminar números fijos introducidos en el código (no están dentro de variables).
 * - Mejorar la gestión de logs (Patrón Singleton).
 */
public class Tienda {

     //Lista de productos disponibles con arraylist
    public static ArrayList<Producto>productos=new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Datos de prueba iniciales
        // Productos iniciales
        productos.add(new Producto("Camiseta",15.0,10));
        productos.add(new Producto("pantalon", 0, 0));
        productos.add(new Producto("zapato", 0, 0));
        
        while(true) {
            System.out.println("\n--- TIENDA ---");
            System.out.println("1. Añadir producto");
            System.out.println("2. Mostrar inventario");
            System.out.println("3. Realizar venta");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            int op = sc.nextInt();
            
            if(op == 1) { 
                System.out.print("Nombre del producto: ");
                String nombre = sc.next();
                System.out.print("Precio: ");
                double precio = sc.nextDouble();
                System.out.print("Stock inicial: ");
                int stock = sc.nextInt();
                
               
                productos.add(new Producto(nombre, precio, stock));
                System.out.println("el producto se añadio correctamente ");
                
            } else if(op == 2) {
                System.out.println("\n--- INVENTARIO ACTUAL ---");
                
                if(productos.isEmpty()) {
                    System.out.println("No hay productos.");
                } else {
                    for(int i=0; i<productos.size(); i++) {
                        System.out.println(i + ". " + productos.get(i));
                    }
                }
                
            } else if(op == 3) {
                System.out.println("\n--- VENTA ---");
                System.out.print("Introduzca nombre del producto a vender: ");
                String prod = sc.next();
                
                
                Producto encontrado=null;
                for(Producto p:productos){
                    if(p.getNombre().equalsIgnoreCase(prod))
                        encontrado = p;
                    break;
                }
                
                if(encontrado !=null) {
                    System.out.println("Producto encontrado: " + encontrado.getNombre());
                    System.out.println("Precio: " + encontrado.getPrecio() + "€ | Stock: " + encontrado.getStock());
                    System.out.print("Cantidad a comprar: ");
                    int cant = sc.nextInt();
                    
                   //cambios
                    if(encontrado.getStock() >= cant) {
                        double total = cant * encontrado.getPrecio();
                        
                        // Hay números fijos que se utilizan en el código
                        //cambios oferta simple
                        if(total > 50) {
                            System.out.println("¡Oferta! Descuento aplicado por compra superior a 50€");
                            total = total * 0.90;
                        }
                        
                        //cambios
                        encontrado.reducirStock(cant); // Actualizar stock
                        System.out.println("Venta realizada. Total a pagar: " + total + "€");
                        
                        // Debería ser Singleton cambios
                        System.out.println("[LOG SYSTEM]: Venta de " + cant + "x " + encontrado.getNombre() + " registrada.");
                        if(encontrado.getStock() < 3) {
                            System.out.println("[LOG SYSTEM]: ALERTA DE STOCK BAJO para " + encontrado.getNombre());
                        }
                        
                    } else {
                        System.out.println("Error: No hay suficiente stock.");
                    }
                } else {
                    System.out.println("Error: Producto no encontrado.");
                }
                
            } else if(op == 4) {
                System.out.println("Saliendo...");
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        }
        sc.close();
    }
}