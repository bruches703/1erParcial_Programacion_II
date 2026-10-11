/*
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
public class Buscadores {
    
    public static int buscarPorCapacidad(List<Vehiculo> listaVehiculos, int capacidad, int indice) {

        for (int i = indice; i < listaVehiculos.size(); i++) {
            if (listaVehiculos.get(i).getCapacidadPasajeros() >= capacidad) {
                return i;
            }
        }

        return -1;
    }

    public static boolean estaLaPatenteEnLista(String patente, List<Vehiculo> listaVehiuculos) {
        for (Vehiculo vehiculo : listaVehiuculos) {
            if (vehiculo.getPatente().equals(patente)) {
                return true;
            }
        }
        return false;
    }

    public static int buscarPosicionDePatente(List<Vehiculo> listaVehiuculos, String patente){
        for (int i = 0; i < listaVehiuculos.size(); i++) {
            if(listaVehiuculos.get(i).getPatente().equalsIgnoreCase(patente)){
                return i;
            }
        }
        return -1;
    }
    public static int buscarPorTipoDeVehiculo(List<Vehiculo> listaVehiculos, String tipo, int indice) {
        
        for (int i = indice; i < listaVehiculos.size(); i++) {
            if (listaVehiculos.get(i).getTipoVehiculo().equalsIgnoreCase(tipo)) {
                return i;
            }
        }

        return -1;
    }
        
    
    public static void buscarUnaPatente(Scanner leer, List<Vehiculo> listaVehiculos) {
        System.out.println("Ingresar patente con formato -AA123AA- o -AAA123-\nIngrese: ");
        String patente = leer.nextLine().trim().toUpperCase();
        int indice;
        if (IngresoYValidacion.esPatenteValida(patente)) {
            indice = buscarPosicionDePatente(listaVehiculos, patente);
        }else{
            System.out.println("Error de formato. Corrabore la patente y vuelva a ingresar");
            return;
        }

        if (indice == -1) {
            System.out.println("No se encontro la patente ingresada");
        } else {
            System.out.println("Vehiculo encontrado: ");
            ImprecionPorConsola.mostrarCabeceraDeCuadro();
            listaVehiculos.get(indice).mostrarInformacion();
        }

        
        
    }
}

