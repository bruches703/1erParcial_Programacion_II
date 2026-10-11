/*aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisdegestdetranstur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author bruch
 */
public class ServiciosTuristicos {

    public static void servicioTuristico(List<Vehiculo> listaVehiculos, Scanner leer) {
        boolean esValido = false;
        List<Vehiculo> listaDeDisponibles = new ArrayList<>();
        if (listaVehiculos.isEmpty()) {
            System.out.println("No hay vehiculos para contratar");
            return;
        }

        do {
            System.out.println("Ingrese vehiculo que desea contratar: ");
            System.out.println("1- Colectivo\n2- Lancha\n3- Van\nIngrese opcion: ");
            String opcion = leer.nextLine().trim().toUpperCase();
            switch (opcion) {
                case "1", "COLECTIVO" -> {
                    listaDeDisponibles = vehiculosParaContratar(listaVehiculos, "COLECTIVO");
                    esValido = true;
                }
                case "2", "LANCHA" -> {
                    listaDeDisponibles = vehiculosParaContratar(listaVehiculos, "LANCHA");
                    esValido = true;
                }
                case "3", "VAN" -> {
                    listaDeDisponibles = vehiculosParaContratar(listaVehiculos, "VAN");
                    esValido = true;
                }
            
            }
        } while (!esValido);

        if (!listaDeDisponibles.isEmpty()) {
            mostrarSevicio(leer, listaDeDisponibles);
        }

    }

    public static void mostrarSevicio(Scanner leer, List<Vehiculo> listaDeDisponibles) {
        boolean hayVehiculosApto = false;
        System.out.println("Punto de partida: ");
        String partida = leer.nextLine();
        System.out.println("Ingrese destino: ");
        String destino = leer.nextLine();
        int cantidadPersonas = IngresoYValidacion.ingresarEntero(leer, 1, 60, "Ingrese la cantidad de pasajeros: ", "Error de ingreso, el valor no puede ser negativo ni mayor a" + 60);
        
        for (int i = 0; i < listaDeDisponibles.size(); i++) {
            Vehiculo vehiculoAuxiliar = listaDeDisponibles.get(i);
            boolean vehiculoDisponible = (vehiculoAuxiliar.getCapacidadPasajeros() >= cantidadPersonas) && vehiculoAuxiliar.isEstaDisponible();
            if ( vehiculoDisponible) {

                if (!hayVehiculosApto) {
                    System.out.println("Datos de la contratacion: ");
                    System.out.println("Punto de partida: " + partida + "Destino: " + destino + "\nPasajeros: " + cantidadPersonas);
                    System.out.println("Vehiculo contratado");
                    hayVehiculosApto = true;
                    System.out.println();
                    
                    boolean esSi = IngresoYValidacion.ingresarSiNo(leer, "Desea contratar? Si - NO: " );
                    if(esSi){
                        System.out.println("Datos del vehiculo");
                        listaDeDisponibles.get(i).mostrarInformacion();
                        listaDeDisponibles.get(i).setEstaDisponible(false);
                        return;
                    } else{
                        System.out.println("Servicio cancelado, volviendo al menu");
                        return;
                    }
                }
                

            }

        }
        if (!hayVehiculosApto) {
            System.out.println("No hay vehiculos con suficiente capadidad");
        }
    }

    public static List<Vehiculo> vehiculosParaContratar(List<Vehiculo> listaVehiculos, String tipoVehiculo) {
        List<Vehiculo> vehiculosDisponibles = new ArrayList<>();
        if (listaVehiculos.isEmpty()) {
            return vehiculosDisponibles;
        }

        
        for (Vehiculo vehiculo : listaVehiculos) {
        
        if (vehiculo.getTipoVehiculo().equalsIgnoreCase(tipoVehiculo) && vehiculo.isEstaDisponible()) {
            vehiculosDisponibles.add(vehiculo);
        }
    }
        return vehiculosDisponibles;
    }

}
