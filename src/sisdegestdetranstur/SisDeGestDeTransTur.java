/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sisdegestdetranstur;

import java.util.ArrayList;

/**
 * Sistema de gestion de transporte
 * @author bruches
 */
public class SisDeGestDeTransTur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Vehiculo> listaDeVehiculos = new ArrayList<>();
        int opcion;
        //MENU
        do {
            opcion = IngresoYValidacion.menu();
            System.out.println(opcion);
            switch (opcion) {
                case 1:
                    
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    throw new AssertionError();
            }
        } while (opcion != 8);
    }


}
