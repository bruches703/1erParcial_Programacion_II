/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sisdegestdetranstur;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Sistema de gestion de transporte
 * @author bruches
 */
public class SisDeGestDeTransTur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        List<Vehiculo> listaDeVehiculos = new ArrayList<>();
        int opcion;
        //MENU
        do {
            opcion = IngresoYValidacion.menu(leer);
            switch (opcion) {
                case 1 -> {
                    // Agregar vehiculos
                    String mensaje = "Escoja tipo de vehiculo:\n1-Colectivo\n2-Lancha\n3-Van\nIngrese opcion: ";
                    String mensajeError = "Error de ingreso. Ingrese opcion 1, 2 o 3";
                    int opcNuevoVehiculo = IngresoYValidacion.ingresarEntero(leer, 1, 3, mensaje, mensajeError);
                    leer.nextLine(); // Limpiar el buffer para que lo residual no guarde
                    Vehiculo nuevoVehiculo = IngresoYValidacion.nuevoVehiculo(leer, opcNuevoVehiculo);
                    if (nuevoVehiculo != null){
                        listaDeVehiculos.add(nuevoVehiculo);
                        System.out.println("El nuevo vehiculo se ingreso correctamente");
                    }
                    
                }
                case 2 -> {
                    // Mostrar todos los vehiculos
                    if (listaDeVehiculos.isEmpty()) {
                        System.out.println("\nLista vacia");
                    } else {
                        IngresoYValidacion.mostrarVehiculos(listaDeVehiculos);
                    }
                    System.out.println("Presione una tecla para continuar...");
                    //Para congelar la pantalla y pedir que precione enter para continuar, se agrega dos
                    //leer.nextLine porque queda el buffer queda con datos pendientes y utiliza el primero
                    leer.nextLine();
                    leer.nextLine();
                }
                case 3 -> {
                    // Realizar servicio turistico
                }
                case 4 -> {
                    // Buscar vehiculo por patente
                }
                case 5 -> {
                    // Mostrar vehiculos con capacidad mayor a...
                }
                case 6 -> {
                    // Mostrar vehiculos por año de fabricacioón
                }
                case 7 -> {
                    //Mostrar vehiculos ordenados por capacidad de pasajeros descendente
                }
                case 8 -> 
                    //Salir
                    System.out.println("Saliendo del programa");
                default -> throw new AssertionError();
            }
        } while (opcion != 8);
    }


}
