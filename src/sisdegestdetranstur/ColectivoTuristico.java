/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisdegestdetranstur;

/**
 *
 * @author bruch
 */
public class ColectivoTuristico extends Vehiculo{
    private int cantidadPisos;

    public ColectivoTuristico(int cantidadPisos, String patente, String marca, int capacidadPasajeros, int anioFabricacion) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        this.cantidadPisos = cantidadPisos;
    }
    
    // Setter y Getter
    public int getCantidadPisos() {
        return cantidadPisos;
    }

    public void setCantidadPisos(int cantidadPisos) {
        this.cantidadPisos = cantidadPisos;
    }


    @Override
    public void mostrarInformacion() {
        System.out.printf("Colectivo | Patente: %-8s | Marca: %-10s | Capacidad: %-3d pas. | Año: %-4d | Pisos: %-2d piso/s\n", 
                this.patente, this.marca, this.capacidadPasajeros, this.anioFabricacion, this.cantidadPisos);
    }
         
    
    
}
