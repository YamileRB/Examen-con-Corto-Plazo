import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class ProductoMasCaro {

    public static void main(String[] args) {

        String ruta1 = "D:/Fundamentos de Programacion/ExamenPracticoConPlazo/";
        String nombreArchivo = "reporte_inventario.txt";

        List<Producto> productos = new ArrayList<>();
        cargarProductos(ruta1 + nombreArchivo, productos);

        Producto productoCaro = obtenerProductoMasCaro(productos);

        if (productoCaro != null) {
            System.out.println("El producto más caro es:");
            mostrarProducto(productoCaro);
        } else {
            System.out.println("No se encontraron productos.");
        }
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

    public static Producto obtenerProductoMasCaro(List<Producto> productos) {
        if (productos.isEmpty()) {
            return null;
        }

        Producto productoCaro = productos.get(0);
        for (Producto p : productos) {
            if (p.getPrecio() > productoCaro.getPrecio()) {
                productoCaro = p;
            }
        }
        return productoCaro;
    }

    public static void mostrarProducto(Producto p) {

        DecimalFormat formato = new DecimalFormat("#,###.00");


        System.out.println("ID: " + p.getIdProducto() + ", Nombre: " + p.getNombreProducto() +
                ", Categoría: " + p.getCategoria() + ", Precio: " + formato.format(p.getPrecio()) +
                ", Cantidad: " + p.getCantidad());
    }
}
