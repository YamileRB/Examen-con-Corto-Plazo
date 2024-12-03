import java.io.BufferedReader;
import java.io.FileReader;

public class LeerInventario {
    public static void main(String[] args) {

        String ruta = "D:/Fundamentos de Programacion/ExamenPracticoConPlazo/";
        String nombreArchivo = "reporte_inventario.txt";

        try (FileReader fr = new FileReader(ruta + nombreArchivo)){

            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea=br.readLine())!=null){
                System.out.println(linea);
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }


    }

}
