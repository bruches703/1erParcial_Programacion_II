/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisdegestdetranstur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase encargada de generar una contratación de un vehículo para un servicio 
 * turistico. Contiene metodos que piden el ingreso de informacion para reservar
 * un tipo de vehículo especifico y muestra la reserva por consola.
 * 
 * @author bruch
 */
public class ServiciosTuristicos {

    /**
     * Pide al usuario que ingrese por consola la eleccion del tipo de vehículo 
     * que desea contratar (COLECTIVO, LANCHA O LANCHA), pide que ingrese la 
     * informacion sobre el servicio y busca un vehículo que este disponible y 
     * que tenga la capacidad que busca.
     * 
     * @param listaVehiculos Tipo lista de Vehiculo. Lista de vehiculos a buscar disposición.
     * @param leer utilitario para leer lo ingresado por consola
     */
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
                    listaDeDisponibles = vehiculosParaContratar(listaVehiculos, "COLECTIVO"); //Crea una lista solo de colectivos
                    esValido = true;
                }
                case "2", "LANCHA" -> {
                    listaDeDisponibles = vehiculosParaContratar(listaVehiculos, "LANCHA");//Crea una lista solo de lanchas
                    esValido = true;
                }
                case "3", "VAN" -> {
                    listaDeDisponibles = vehiculosParaContratar(listaVehiculos, "VAN");//Crea una lista solo de vans
                    esValido = true;
                }
            
            }
        } while (!esValido);

        if (!listaDeDisponibles.isEmpty()) {
            mostrarSevicio(leer, listaDeDisponibles);
        }

    }

    /**
     * Pide y valida la informacion entregada por el usuario para contratar un servicio
     * y, si la reserva se realizo correctamente, lo muestra por consola.
     * @param leer utilidad para leer lo ingresado por consola
     * @param listaDeDisponibles Tipo lista de Vehiculo. Lista de vehiculos a buscar disposición.
     */
    public static void mostrarSevicio(Scanner leer, List<Vehiculo> listaDeDisponibles) {
        boolean hayVehiculoApto = false;
        
        System.out.println("Punto de partida: ");
        String partida = leer.nextLine();
        System.out.println("Ingrese destino: ");
        String destino = leer.nextLine();
        
        int cantidadPersonas = IngresoYValidacion.ingresarEntero(leer, 1, 60, "Ingrese la cantidad de pasajeros: ", "Error de ingreso, el valor no puede ser negativo ni mayor a" + 60);
        
        for (int i = 0; i < listaDeDisponibles.size(); i++) {
            Vehiculo vehiculoAuxiliar = listaDeDisponibles.get(i); //toma el vehiculo en el indice actual
            
            //verifica que este disponible y que su capacidad este en el rango
            boolean vehiculoDisponible = (vehiculoAuxiliar.getCapacidadPasajeros() >= cantidadPersonas) && vehiculoAuxiliar.isEstaDisponible(); 
            if ( vehiculoDisponible) {

                if (!hayVehiculoApto) {
                    //Ingreso del resto de los datos.
                    System.out.println("Datos de la contratacion: ");
                    System.out.println("Punto de partida: " + partida + "Destino: " + destino + "\nPasajeros: " + cantidadPersonas);
                    System.out.println("Vehiculo contratado");
                    hayVehiculoApto = true;
                    System.out.println();
                    
                    boolean esSi = IngresoYValidacion.ingresarSiNo(leer, "Desea contratar? Si - NO: " );
                    if(esSi){
                        //Si se confirma la contratación, se pone al vehiculo como "no disponible"
                        System.out.println("Datos del vehiculo");
                        ImprecionPorConsola.mostrarCabeceraDeCuadro();
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
        if (!hayVehiculoApto) {
            System.out.println("No hay vehiculos con suficiente capadidad");
        }
    }

    /**
     * Se encarga de crear una lista auxilar de vehículos para contratar de un solo tipo,
     * Colectivo, Van o yate, que viene establecido por parámetro.
     * 
     * @param listaVehiculos Tipo lista de Vehiculo. Lista de vehiculos a buscar disposición.
     * @param tipoVehiculo Tipo String. Representa el tipo de vehiculo (COLECTIVO, VAN o LANCHA)
     *
     * @return devuelve una lista de vehículos de un tipo especifico o una lista vacáa si no
     * hay el tipo de vehículos indicado.
     */
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
