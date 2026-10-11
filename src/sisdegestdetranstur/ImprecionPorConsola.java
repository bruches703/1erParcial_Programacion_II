/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisdegestdetranstur;

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
}
