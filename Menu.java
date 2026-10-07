import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<ObjServicio> cola = new LinkedList<>();
        Stack<ObjServicio> pila = new Stack<>();
        Metodos m = new Metodos();
        boolean continuar = true;
        while (continuar) {
            System.out.println("Bienvenidos al parcial de Nacho lee 3 (Colas)");
            System.out.println("^_^ Padre, Hijo y espritud santo ^_^\n");
            System.out.println("Bienvenido al centro de Transporte Nacho Lee ^_^");
            System.out.println("¿En que te podemos ayuar hoy?");
            System.out.println("1| Crear solicitud de transporte -> ");
            System.out.println("2| Mostrar Todos los Pedidos ");
            System.out.println("3| Atender Turno ");
            System.out.println("4| Mostrar Pedidos Pendientes");
            System.out.println("5| Mostrar Pedidos Atendidos");
            System.out.println("6| Apilar los pendientes");
            System.out.println("7| motrar arreglo de atendidos");
            System.out.println("8| Salir ");
            int opt = m.ValidarEentero(sc);
            switch (opt) {
                case 1:
                    cola = m.LlenarCola(cola, m, sc);
                    break;
                case 2:
                    System.out.println("\n " + m.MostrarTodosTurnos(cola, 1));
                    break;
                case 3:
                    cola = m.Atender(cola);
                    break;
                case 4:
                    System.out.println("\n " + m.MostrarTodosTurnos(cola, 2));
                    break;
                case 5:
                    System.out.println("\n " + m.MostrarTodosTurnos(cola, 3));

                    break;
                case 6:
                   System.out.println("Pagina en mantenimiento X_X");
                    break;
                case 7:
                    ObjServicio[] a = m.ArregloAtendidos(cola);
                    m.MostrarArreglo(a);
                    break;
                case 8:
                    System.out.println("Hasta luego");
                    continuar = false;
                    break;

                default:
                    System.out.println("esta opcion no existe");
                    break;
            }
        }
    }
}
