/*aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisdegestdetranstur;

import java.util.List;
import java.util.Scanner;
/**
 *
 * @author bruch
 */
public class ServiciosTuristicos {

    public static void servicioTuristico(List<Vehiculo> listaVehiculos, Scanner leer) {
        boolean esValido = false;
        List<Vehiculo> listaDeDisponibles = null;
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
                    listaDeDisponibles =  vehiculosParaContratar(listaVehiculos, "COLECTIVO");
                    esValido = true;
                }
                case "2", "LANCHA" -> {
                    listaDeDisponibles = vehiculosParaContratar(listaVehiculos, "LANCHA");
                    esValido = true;
                }
                case "3", "VAM" -> {
                    listaDeDisponibles = vehiculosParaContratar(listaVehiculos, "VAN");
                    System.out.println("Valor ingresado. Reingrese...");
                }
            }
        } while (!esValido);

        if (!listaDeDisponibles.isEmpty()) {
            int cantidad = IngresoYValidacion.ingresarEntero(leer, 1, 60, "Ingrese la cantidad de pasajeros: ", "Error de ingreso, el valor no puede ser negativo ni mayor a" + 60);
            for (Vehiculo vehiculo : listaVehiculos) {
                if (vehiculo.capacidadPasajeros >= cantidad) {
                    System.out.println("Vehiculo contratado. Datos del vehiculo");
                    vehiculo.mostrarInformacion();
                } else {
                    System.out.println("No hay vehiculos con la capacidad para este viaje");
                }
            }
        }

    }

    public static List<Vehiculo> vehiculosParaContratar(List<Vehiculo> listaVehiculos, String opcion) {
        if (listaVehiculos.isEmpty()) {
            return null;
        }

        List<Vehiculo> vehiculosDisponibles = null;
        for (Vehiculo vehiculoDisponible : listaVehiculos) {
            if (vehiculoDisponible.tipoVehiculo.equals(opcion)) {
                vehiculosDisponibles.add(vehiculoDisponible);
            }
        }
        return vehiculosDisponibles;
    }
}
