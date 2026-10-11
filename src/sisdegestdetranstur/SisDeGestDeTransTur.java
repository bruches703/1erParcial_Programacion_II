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
        listaDeVehiculos.add(new ColectivoTuristico(2, "ABC123", "FORD", 25, 2020, "COLECTIVO"));
        listaDeVehiculos.add(new VanEjecutiva(true, "AB123CD", "honda", 15, 2000, "VAN"));
        listaDeVehiculos.add(new LanchaTuristica(TiposDeMotor.DIESEL, "IR123LO", "yate cojo", 40, 2010, "LANCHA"));
        listaDeVehiculos.add(new ColectivoTuristico(1, "AE456FG", "Mercedes", 45, 2018, "COLECTIVO"));
        listaDeVehiculos.add(new VanEjecutiva(false, "JK789LM", "Toyota", 18, 2015, "VAN"));
        listaDeVehiculos.add(new LanchaTuristica(TiposDeMotor.NAFTA, "ST321UV", "Yamaha", 18, 2022, "LANCHA"));
        listaDeVehiculos.add(new ColectivoTuristico(2, "AF999ZZ", "Scania", 50, 2023, "COLECTIVO"));
        listaDeVehiculos.add(new VanEjecutiva(true, "AC111BB", "Mercedes", 14, 2019, "VAN"));
        listaDeVehiculos.add(new LanchaTuristica(TiposDeMotor.DIESEL, "XY888WZ", "Mercury", 22, 2012, "LANCHA"));
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
                    Vehiculo nuevoVehiculo = IngresoYValidacion.nuevoVehiculo(leer, opcNuevoVehiculo, listaDeVehiculos);
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
                        ImprecionPorConsola.mostrarCuadroDeInformacion(listaDeVehiculos);
                    }

                }
                case 3 -> {
                    // Realizar servicio turistico
                    ServiciosTuristicos.servicioTuristico(listaDeVehiculos, leer);
                }
                case 4 -> {
                    // Buscar vehiculo por patente
                    Buscadores.buscarUnaPatente(leer, listaDeVehiculos);
                }
                case 5 -> {
                    // Mostrar vehiculos con capacidad mayor a...}
                    String mensajeIngreso = "Ingrese la capacidad que busca: ";
                    String mensajeError = "Error, debe ingresar un numero positivo";
                    int capacidadIngresada = IngresoYValidacion.ingresarUnEnteroPositivo(leer, mensajeIngreso, mensajeError);
                    ImprecionPorConsola.mostrarVehiculosConMayorCapacidad(listaDeVehiculos, capacidadIngresada);                
                } 
                case 6 -> {
                    // Mostrar vehiculos por año de fabricacioón
                    ImprecionPorConsola.mostrarPorAnio(listaDeVehiculos);
                }
                case 7 -> {
                    //Mostrar vehiculos ordenados por capacidad de pasajeros descendente
                    ImprecionPorConsola.mostrarPorCapacidadDes(listaDeVehiculos);
                            
                }
                case 8 -> 
                    //Salir
                    System.out.println("Saliendo del programa");
                default -> throw new AssertionError();
            }
            pausarPantalla(leer);
        } while (opcion != 8);
    }


    public static void pausarPantalla(Scanner leer) {
        System.out.println("Presione ENTER para continuar...");
        leer.nextLine();
    }
}
