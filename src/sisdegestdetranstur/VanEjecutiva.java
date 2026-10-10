/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisdegestdetranstur;

/**
 *
 * @author bruch
 */
public class VanEjecutiva extends Vehiculo{
    private boolean tieneAireAcondicionado;

    /**
     * Constructor del objeto VanEjecutiva
     * @param tieneAireAcondicionado
     * @param patente
     * @param marca
     * @param capacidadPasajeros
     * @param anioFabricacion 
     */
    public VanEjecutiva(boolean tieneAireAcondicionado, String patente, String marca, int capacidadPasajeros, int anioFabricacion) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        this.tieneAireAcondicionado = tieneAireAcondicionado;
    }
   
    @Override
    public void mostrarInformacion() {
        String tieneAire;
        if(this.tieneAireAcondicionado){
            tieneAire = "SI";
        } else {
            tieneAire = "NO";
        }
        
        System.out.printf("Colectivo | Patente: %-8s | Marca: %-10s | Capacidad: %-3d pas. | Año: %-4d | %-2s\n", 
                this.patente, this.marca, this.capacidadPasajeros, this.anioFabricacion, tieneAire);
    }
}
