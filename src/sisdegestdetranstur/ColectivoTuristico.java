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
    protected int cantidadPisos;
    
    /**
     * Constructor del objeto ColectivoTuristico
     * @param cantidadPisos
     * @param patente
     * @param marca
     * @param capacidadPasajeros
     * @param anioFabricacion
     * @param tipoVehiculo 
     */
    public ColectivoTuristico(int cantidadPisos, String patente, String marca, int capacidadPasajeros, int anioFabricacion, String tipoVehiculo) {
        super(patente, marca, capacidadPasajeros, anioFabricacion, tipoVehiculo);
        this.cantidadPisos = cantidadPisos;
    }
    

    
    // Setter y Getter
    public int getCantidadPisos() {
        return cantidadPisos;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public void setCantidadPisos(int cantidadPisos) {
        this.cantidadPisos = cantidadPisos;
    }


    @Override
    public void mostrarInformacion() {
        System.out.printf("Colectivo |  %-8s | %-10s | Capacidad: %-3d pas.   | Año: %-4d | Pisos: %-2d piso/s\n", 
                this.patente, this.marca, this.capacidadPasajeros, this.anioFabricacion, this.cantidadPisos);
    }
         
    
    
}
