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

    public VanEjecutiva(boolean tieneAireAcondicionado, String patente, String marca, int capacidadPasajeros, int anioFabricacion, String tipoVehiculo) {
        super(patente, marca, capacidadPasajeros, anioFabricacion, tipoVehiculo);
        this.tieneAireAcondicionado = tieneAireAcondicionado;
    }



    // Getters y Setters
    public boolean isTieneAireAcondicionado() {
        return tieneAireAcondicionado;
    }

    public void setTieneAireAcondicionado(boolean tieneAireAcondicionado) {
        this.tieneAireAcondicionado = tieneAireAcondicionado;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
    
    

    @Override
    public void mostrarInformacion() {
        String tieneAire;
        if(this.tieneAireAcondicionado){
            tieneAire = "TIENE AIRE";
        } else {
            tieneAire = "NO TIENE AIRE";
        }
        
        System.out.printf(" Van ejec.|  %-8s | %-10s | Capacidad: %-3d pas.   | Año: %-4d | %-2s\n", 
                this.patente, this.marca, this.capacidadPasajeros, this.anioFabricacion, tieneAire);
    }
}
