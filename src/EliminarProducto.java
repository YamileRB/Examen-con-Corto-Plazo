import java.io.*;
import java.util.*;

public class EliminarProducto {

    public static void main(String[] args) {

        String ruta1 = "D:/Fundamentos de Programacion/ExamenPracticoConPlazo/";
        File archivo = new File(ruta1 + "reporte_inventario.txt");


        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del producto que desea eliminar: ");
        String idAEliminar = scanner.nextLine().trim();

        try {

            BufferedReader br = new BufferedReader(new FileReader(archivo));
            List<String> lineas = new ArrayList<>();
            String linea;


            boolean productoEncontrado = false;
            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");
                if (datos.length > 0 && datos[0].trim().equals(idAEliminar)) {
                    productoEncontrado = true;
                    continue;
                }

                lineas.add(linea);
            }
            br.close();


            if (productoEncontrado) {
                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
                for (String l : lineas) {
                    bw.write(l);
                    bw.newLine();
                }
                bw.close();
                System.out.println("Producto con ID " + idAEliminar + " eliminado correctamente.");
            } else {
                System.out.println("No se encontró un producto con el ID " + idAEliminar + ".");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
