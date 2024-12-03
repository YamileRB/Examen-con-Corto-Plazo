import java.io.*;
import java.util.*;

public class CantidadProductosCategoria {

    public static void main(String[] args) {

        String ruta = "D:/Fundamentos de Programacion/ExamenPracticoConPlazo/";
        String nombreArchivo = "reporte_inventario.txt";


        List<Producto> productos = new ArrayList<>();
        cargarProductos(ruta + nombreArchivo, productos);


        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la categoría de la cual desea ver la cantidad de productos: ");
        String categoriaBusqueda = scanner.nextLine().trim();


        contarProductosPorCategoria(categoriaBusqueda, productos);

        scanner.close();
    }


    public static void cargarProductos(String rutaArchivo, List<Producto> productos) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");
                if (datos.length == 5) {
                    String idProducto = datos[0].trim();
                    String nombreProducto = datos[1].trim();
                    String categoria = datos[2].trim();
                    double precio = Double.parseDouble(datos[3].replace(".", "").replace(",", "."));
                    int cantidad = Integer.parseInt(datos[4].trim());

                    Producto producto = new Producto(idProducto, nombreProducto, categoria, precio, cantidad);
                    productos.add(producto);
                } else {
                    System.out.println("Línea inválida: " + linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void contarProductosPorCategoria(String categoriaBusqueda, List<Producto> productos) {
        int cantidad = 0;


        for (Producto p : productos) {
            if (p.getCategoria().equalsIgnoreCase(categoriaBusqueda)) {
                cantidad += 1;
            }
        }


        if (cantidad > 0) {
            System.out.println("Cantidad de productos en la categoría '" + categoriaBusqueda + "': " + cantidad);
        } else {
            System.out.println("No se encontraron productos en la categoría '" + categoriaBusqueda + "'.");
        }
    }
}
