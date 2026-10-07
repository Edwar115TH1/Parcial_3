
import java.util.Queue;
import java.util.Scanner;


public class Metodos {

    public Queue<ObjServicio> LlenarCola(Queue<ObjServicio> cola, Metodos m, Scanner sc) {
        boolean continuar = true;

        while (continuar) {
            ObjServicio o = new ObjServicio();
            o.setTurno(m.ValidarTurno(cola));
            System.out.println("Ingrese el documento del cliente: ");
            o.setIdcliente(sc.nextInt());                              //(m.MenuComida(sc));
            System.out.println("Ingrese el Origen del servicio (Ciudad) ");
            o.setOrigen(sc.next());
            System.out.println("Ingrese el Destino del servicio (Ciudad) ");
            o.setDestino(sc.next());
            System.out.println("Tipo de mercancia: 1.Electrodomesticos | 2.Perecederos | 3.Refacciones");
            o.setTipo_Mercancia(sc.nextInt());
            System.out.println("Ingrese el peso de la mercancía en KGs: ");
            o.setPeso(sc.nextInt());
            System.out.println("Seleccione la prioridad del servicio: | 1.Normal | 2.Prioritaria | 3.Urgente");
            o.setPrioridad(sc.nextInt());
            o.setEstado(1);
            o.setVehiculo_Asignado(m.AsignarVehiculo(cola, o.getPeso()));
            sc.nextLine();
                System.out.println("¿Desea Agregar mas servicios 1 si , 2 no? ");
            int opt = sc.nextInt();
            if (opt == 2) {
                System.out.println("Vuelva Pronto ^_^");
                continuar = false;
            }
            cola.offer(o);

        }
        return cola;

    }

    public String AsignarVehiculo(Queue<ObjServicio> cola, int peso){
        String Mensaje = "";
        for (ObjServicio o : cola) {
            
            if (o.getPeso() <= 100000 && o.getPeso() >=80001 ) {
                Mensaje = "Tractomula A";
            }if (o.getPeso() <= 80000 && o.getPeso() >=30001 ) {
                Mensaje ="Tractomula B";
            }if (o.getPeso() <= 30000 && o.getPeso() >=10001 ) {
                Mensaje = "Camión Mediano";
            }if(o.getPeso() <= 10000 && o.getPeso() >=10 ){
                Mensaje = "Camión Pequeño";
            }
            if (o.getPeso() <100000 ) {
                Mensaje = "No tenemos vehiculos disponibles para esa capacidad (Peso)";
            }
        }
        return Mensaje;
    }

    public int ValidarTurno(Queue<ObjServicio> cola) {
        int turno = 0;
        if (cola.isEmpty()) {
            turno = 1;
        } else {
            turno = cola.size() + 1;
        }
        return turno;
    }

    public int MenuDespacho(Scanner sc) {
    System.out.println("Bienvenido/a. ¿Que vehiculo desea asignar?");
        System.out.println("1) TractoMula A (Capacidad 100.000 Kgs)");
        System.out.println("2) TractoMula B (Capacidad 80.000 Kgs)");
        System.out.println("3) Camión Mediano (Capacidad 30.000 Kgs)");
        System.out.println("4) Camión pequeño (Capacidad 10.000 Kgs) ");
        return sc.nextInt();

    }

    public String MostrarTodosTurnos(Queue<ObjServicio> cola, int opt) {
        switch (opt) {
            case 1:
                for (ObjServicio o : cola) {
                    System.out.println("Cliente ID: " +   o.getIdcliente());
                    System.out.println("Origen: " + o.getOrigen());
                    System.out.println("Destino: " + o.getDestino());
                    System.out.println("Tipo de Mercancia: " +  o.getTipo_Mercancia());
                    System.out.println("Peso Mercancia:" + o.getPeso());
                    System.out.println("Vehiculo asignado: "+ o.getVehiculo_Asignado());
                    if (o.getEstado() == 1) {
                        System.out.println("Estado: Pendiente");
                    } else {
                        System.out.println("Estado: Atendido");
                    }
                    System.out.println("----------------------------------------- \n");

                }

                break;
            case 2:
                for (ObjServicio o : cola) {
                    if (o.getEstado() == 1) {
                    System.out.println("Cliente ID: " +   o.getIdcliente());
                    System.out.println("Origen: " + o.getOrigen());
                    System.out.println("Destino: " + o.getDestino());
                    System.out.println("Tipo de Mercancia: " +  o.getTipo_Mercancia());
                    System.out.println("Peso Mercancia:" + o.getPeso());
                    System.out.println("Vehiculo asignado: "+ o.getVehiculo_Asignado());
                    if (o.getEstado() == 1) {
                            System.out.println("Estado: Pendiente");
                        }
                    }else {
                            System.out.println("No hay turnos Pendientes");
                        }
                        System.out.println("----------------------------------------- \n");
                }
                break;

            case 3:
                for (ObjServicio o : cola) {
                    if (o.getEstado() != 1) {
                    System.out.println("Cliente ID: " +   o.getIdcliente());
                    System.out.println("Origen: " + o.getOrigen());
                    System.out.println("Destino: " + o.getDestino());
                    System.out.println("Tipo de Mercancia: " +  o.getTipo_Mercancia());
                    System.out.println("Peso Mercancia:" + o.getPeso());
                    System.out.println("Vehiculo asignado: "+ o.getVehiculo_Asignado());
                        if (o.getEstado() == 1) {
                            System.out.println("Estado: Pendiente");
                        }
                    }else {
                            System.out.println("Aún no se han atendido turnos hoy X_X");
                            System.out.println("A trabajaaaar!!!!!! >_<");
                        }
                        System.out.println("----------------------------------------- \n");
                }
                break;
            default:
                System.out.println("Por favor eliga una opción valida"); // en teoria este mensaje nunca debería salir xD
        }
        return "Datos mostrados correctamente";
    }


    public Queue<ObjServicio> Atender(Queue<ObjServicio> cola) {
        for (ObjServicio o : cola) {
            if (o.getEstado() == 1) {
                System.out.println("El siguiente turno es " + o.getTurno());
                o.setEstado(2);
                break;
            }
        }
        System.out.println("\n Turno atendido correctamente ^_^");
        return cola;
    }

    public int ValidarEentero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println(
                    "Por favor tenga en cuenta que se le esta pidiendo un dato numerico ojala en el rango de 1 a 8 ");
            sc.next();
        }
        return sc.nextInt();
    }


    public ObjServicio[] ArregloAtendidos(Queue<ObjServicio> c) {
        ObjServicio[] arreglo = new ObjServicio[Dimension(c)];
        int i = 0;
        for (ObjServicio o : c) {
            if (o.getEstado() != 1) {
                arreglo[i] = o;
                i++;
            }
        }
        return arreglo;
    }

    private static int Dimension(Queue<ObjServicio> c) {
        int cont = 0;
        for (ObjServicio o : c) {
            if (o.getEstado() != 1) {
                cont++;
            }
        }
        return cont;
    }

    public void MostrarArreglo(ObjServicio[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("Cliente ID: "  + a[i].getIdcliente());
            System.out.println("Origen"        + a[i].getOrigen());
            System.out.println("Cantidad: "    + a[i].getDestino());
            System.out.println("Tipo de mercancia: "      + a[i].getTipo_Mercancia());
                if (a[i].getEstado() == 1) {
                System.out.println("Estado: Pendiente");
                } else {
                System.out.println("Estado: Atendido");
                }
        }
    }

    public int ValidarTipoMerca(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println(
                    "Por favor tenga en cuenta que se le esta pidiendo un dato numerico ojala en el rango de 1 a 3 ");
            sc.next();
        }
        return sc.nextInt();
    }

}
