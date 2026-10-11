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
    public static void mostrarVehiculos(List<Vehiculo> listaVehiculos){
        for (Vehiculo vehiculo : listaVehiculos) {
            vehiculo.mostrarInformacion();
        }
    }
}
