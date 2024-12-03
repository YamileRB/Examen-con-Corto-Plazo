import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;


        do {
            System.out.println("Menú de opciones:");
            System.out.println("1. Leer Inventario");
            System.out.println("2. Agregar Producto");
            System.out.println("3. Actualizar Producto");
            System.out.println("4. Eliminar Producto");
            System.out.println("5. Buscar Producto por Categoría");
            System.out.println("6. Generar Reporte");
            System.out.println("7. Cantidad de Productos por Categoría");
            System.out.println("8. Producto Más Caro");
            System.out.println("9. Salir");
            System.out.print("Elija una opción: ");


            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    LeerInventario.main(null);
                    break;
                case 2:
                    AgregarProducto.main(null);
                    break;
                case 3:
                    ActualizarProducto.main(null);
                    break;
                case 4:
                    EliminarProducto.main(null);
                    break;
                case 5:
                    BuscarPorCategoria.main(null);
                    break;
                case 6:
                    GenerarReporte.main(null);
                    break;
                case 7:
                    CantidadProductosCategoria.main(null);
                    break;
                case 8:
                    ProductoMasCaro.main(null);
                    break;
                case 9:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida, por favor ingrese una opción válida.");
            }


            if (opcion != 9) {
                System.out.println("Presione Enter para continuar...");
                scanner.nextLine();
            }
        } while (opcion != 9);


    }
}
