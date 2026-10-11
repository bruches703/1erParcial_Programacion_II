/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisdegestdetranstur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static sisdegestdetranstur.IngresoYValidacion.ingreso;

/**
 * Clase encargada de mostrar por consola la mayoria de la informacion pedida y
 * el propio menú.
 * @author bruch
 */
public class ImprecionPorConsola {

    /**
     * Bandeja principal con el menu de opciones que se ve por consola, que pide
     * el ingreso de un entero con un menú de 8 opciones definidos con valores
     * enteros.
     *
     * @param leer Tipo Scanner. Utilitario para leer lo ingresado por consola.
     * @return Devuelve un valor entero entre 1 y 8 representando una opcion.
     */
    public static int menu(Scanner leer) {
        int opcion;
        System.out.println("SISTEMA DE GESTION DE TRANSPORTE\n");
        System.out.println("MENU");
        System.out.println("1- Agregar vehiculo");
        System.out.println("2- Mostrar todos los vehiculos");
        System.out.println("3- Realizar servicios turisticos");
        System.out.println("4- Buscar vehiculo por patente");
        System.out.println("5- Mostrar vehiculos con capacidad mayor a: ");
        System.out.println("6- Mostrar vehiculos por anio de fabricacion");
        System.out.println("7- Mostrar vehiculos ordenados por capacidad de pasajeros descendente ");
        System.out.println("8- Salir");
        opcion = ingreso(leer);
        return opcion;
    }
    
    /**
     * Muestra por consola una lista organizada de los vehiculos ingresados por
     * consola.
     * @param listaVehiculos Tipo lista de vehiculos. Lista con los vehiculos a imprimir por pantalla.
     */
    public static void mostrarVehiculos(List<Vehiculo> listaVehiculos) {
        for (Vehiculo vehiculo : listaVehiculos) {
            vehiculo.mostrarInformacion();
        }
    }
    
    /**
     * Imprime por consola la cabecera de un cuadro para mostrar informacion un
     * poco mas organizada.
     */
    public static void mostrarCabeceraDeCuadro() {
        System.out.println(" Vehiculo |  Patente  |   Marca    |  Cant. de pasajeros   | Año fab.  | Dato especifico ");
        System.out.println("----------|-----------|------------|-----------------------|------------|---------------------");
    }

    /**
     * Imprime por consola un cuadro completo, con cabecera y una lista organizada
     * de la lista ingresada por parametro.
     * 
     * @param listaDeVehiculos tipo lista de Vehiculos. Lista de vehiculos a mostrar en consola.
     */
    public static void mostrarCuadroDeInformacion(List<Vehiculo> listaDeVehiculos) {
        mostrarCabeceraDeCuadro();
        ImprecionPorConsola.mostrarVehiculos(listaDeVehiculos);
    }
    
    
    /**
     * Imrprime por consola una lista organizada de los vehículos que superen
     * la capacidad de pasajeros ingresada por parámetro.
     * 
     * @param listaVehiculos tipo lista de Vehiculo. Lista de vehículos a imprimirse.
     * @param capacidad Tipo entero. Capacidad que condiciona a mostrar los vehículos.
     */
    public static void mostrarVehiculosConMayorCapacidad(List<Vehiculo> listaVehiculos, int capacidad){
        if(listaVehiculos.isEmpty()){
            System.out.println("La lista esta vacia");
            return;
        }
        boolean flag = true;
        for (Vehiculo vehiculo : listaVehiculos) {
            if(vehiculo.getCapacidadPasajeros() > capacidad){
                if(flag){
                    mostrarCabeceraDeCuadro();
                    flag = false;
                }
                vehiculo.mostrarInformacion();
            }    
        }
        if(flag){
            System.out.println("No hay vehiculos con esa capacidad.");
        }
    }
    
    /**
     * Metodo que se encarga de crear una lista auxiliar para no modificar la lista
     * original. Ordena esta lista auxiliar por año y la imprime por pantalla. Si
     * la lista está vacía, imprimer la leyenda "La lista esta vacia".
     * 
     * @param listaVehiculos Tipo lista de Vehiculo. Lista que se copia para imprimir.
     */
    public static void mostrarPorAnio(List<Vehiculo> listaVehiculos) {
        if (listaVehiculos.isEmpty()) {
            System.out.println("La lista esta vacia.");
            return;
        }

        List<Vehiculo> listaOrdenada = new ArrayList(listaVehiculos); //Para no modificar la lista original
        Vehiculo aux;
        //Ordenamiento por metodo del burbujeo
        for (int i = 0; i < listaOrdenada.size() - 1; i++) {
            for (int j = i; j < listaOrdenada.size(); j++) {
                if (listaOrdenada.get(i).getAnioFabricacion() > listaOrdenada.get(j).getAnioFabricacion()) {
                    aux = listaOrdenada.get(i);
                    listaOrdenada.set(i, listaOrdenada.get(j));
                    listaOrdenada.set(j, aux);

                }
            }
        }
        mostrarCuadroDeInformacion(listaOrdenada);
    }
    
    /**
     * Metodo que se encarga de crear una lista auxiliar para no modificar la lista
     * original. Ordena esta lista auxiliar capacidad de manera descendente y 
     * la imprime por pantalla. Si la lista está vacía, imprimer la leyenda 
     * "La lista esta vacia".
     * 
     * @param listaVehiculos Tipo lista de Vehiculo. Lista que se copia para imprimir.
     */
    public static void mostrarPorCapacidadDesendente(List<Vehiculo> listaVehiculos){
        if (listaVehiculos.isEmpty()) {
            System.out.println("La lista esta vacia.");
            return;
        }
        
        List<Vehiculo> listaOrdenada = new ArrayList(listaVehiculos); //Para no modificar la lista original
        Vehiculo aux;
        //Ordenamiento por metodo del burbujeo
        for (int i = 0; i < listaOrdenada.size() - 1; i++) {
            for (int j = i; j < listaOrdenada.size(); j++) {
                if (listaOrdenada.get(i).getCapacidadPasajeros() < listaOrdenada.get(j).getCapacidadPasajeros()) {
                    aux = listaOrdenada.get(i);
                    listaOrdenada.set(i, listaOrdenada.get(j));
                    listaOrdenada.set(j, aux);

                }
            }
        }
        mostrarCuadroDeInformacion(listaOrdenada);
    }

}
