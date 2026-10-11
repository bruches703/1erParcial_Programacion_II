/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisdegestdetranstur;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruch
 */
public class ImprecionPorConsola {

    public static void mostrarVehiculos(List<Vehiculo> listaVehiculos) {
        for (Vehiculo vehiculo : listaVehiculos) {
            vehiculo.mostrarInformacion();
        }
    }

    public static void mostrarCabeceraDeCuadro() {
        System.out.println(" Vehiculo |  Patente  |   Marca    |  Cant. de pasajeros   | Año fab.  | Dato especifico ");
        System.out.println("----------|-----------|------------|-----------------------|------------|---------------------");
    }

    public static void mostrarCuadroDeInformacion(List<Vehiculo> listaDeVehiculos) {
        mostrarCabeceraDeCuadro();
        ImprecionPorConsola.mostrarVehiculos(listaDeVehiculos);
    }
    
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
                    listaOrdenada.set(i, listaVehiculos.get(j));
                    listaOrdenada.set(j, aux);

                }
            }
        }
        mostrarCuadroDeInformacion(listaOrdenada);
    }
    
    public static void mostrarPorCapacidadDes(List<Vehiculo> listaVehiculos){
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
