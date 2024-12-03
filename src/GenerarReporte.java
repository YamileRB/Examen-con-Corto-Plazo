import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class GenerarReporte {

    public static void main(String[] args) {

        String ruta = "D:/Fundamentos de Programacion/ExamenPracticoConPlazo/";
        String nombreArchivo = "reporte_inventario.txt";

        List<Producto> productos = new ArrayList<>();
        cargarProductos(ruta + nombreArchivo, productos);

        double valorTotal = calcularValorTotalInventario(productos);

        generarReporteConValorTotal(ruta + "reporte_inventario_resumen.txt", productos, valorTotal);
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

    public static double calcularValorTotalInventario(List<Producto> productos) {
        double valorTotal = 0.0;
        for (Producto p : productos) {
            valorTotal += p.getPrecio() * p.getCantidad();
        }
        return valorTotal;
    }

    public static void generarReporteConValorTotal(String rutaReporte, List<Producto> productos, double valorTotal) {

        DecimalFormat formato = new DecimalFormat("#,###.00");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaReporte))) {

            bw.write("Reporte de Inventario\n");
            bw.write("----------------------\n");
            for (Producto p : productos) {
                double valorProducto = p.getPrecio() * p.getCantidad();
                bw.write("ID: " + p.getIdProducto() + ", Nombre: " + p.getNombreProducto() +
                        ", Categoría: " + p.getCategoria() + ", Precio: " + formato.format(p.getPrecio()) +
                        ", Cantidad: " + p.getCantidad() + ", Valor: " + formato.format(valorProducto) + "\n");
            }
            bw.write("----------------------\n");
            bw.write("Valor Total del Inventario: " + formato.format(valorTotal) + "\n");

            System.out.println("Reporte generado correctamente en: " + rutaReporte);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
