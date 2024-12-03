import java.io.*;
import java.util.*;

public class ActualizarProducto {

    public static void main(String[] args) {
        String ruta1 = "D:/Fundamentos de Programacion/ExamenPracticoConPlazo/";
        File archivo = new File(ruta1 + "reporte_inventario.txt");


        Scanner scanner = new Scanner(System.in);


        System.out.print("Ingrese el ID del producto que desea actualizar: ");
        String idProducto = scanner.nextLine();


        List<String> lineas = new ArrayList<>();
        String linea;
        boolean productoEncontrado = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));


            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");


                if (partes[0].equals(idProducto)) {
                    productoEncontrado = true;


                    System.out.print("Ingrese el nuevo nombre del producto: ");
                    String nuevoNombre = scanner.nextLine();

                    System.out.print("Ingrese la nueva categoría del producto: ");
                    String nuevaCategoria = scanner.nextLine();

                    System.out.print("Ingrese el nuevo precio del producto: ");
                    double nuevoPrecio = scanner.nextDouble();


                    System.out.print("Ingrese la nueva cantidad del producto: ");
                    int nuevaCantidad = scanner.nextInt();
                    scanner.nextLine();

                    String productoActualizado = idProducto + "," + nuevoNombre + "," + nuevaCategoria + "," + nuevoPrecio + "," + nuevaCantidad;
                    lineas.add(productoActualizado);
                } else {

                    lineas.add(linea);
                }
            }
            br.close();


            if (productoEncontrado) {

                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
                for (String l : lineas) {
                    bw.write(l);
                    bw.newLine();
                }
                bw.close();
                System.out.println("Producto actualizado correctamente.");
            } else {
                System.out.println("No se encontró un producto con el ID: " + idProducto);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
