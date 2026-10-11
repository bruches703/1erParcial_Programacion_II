/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisdegestdetranstur;

/**
 * Clase abstracta de vehiculo.
 * 
 * @author bruch
 */
public abstract class Vehiculo {
    protected String patente;
    protected String marca;
    protected int capacidadPasajeros;
    protected int anioFabricacion;
    
    /* NOTA: Se agregan estos dos atributos para poder generar una simulacion de servicio mas limpia y prolija, enfocado a una "reserva de vehiculo". Asi no solo se condiciona 
*/
    protected boolean estaDisponible;
    protected String tipoVehiculo;

    public Vehiculo(String patente, String marca, int capacidadPasajeros, int anioFabricacion, String tipoVehiculo) {
        this.patente = patente;
        this.marca = marca;
        this.capacidadPasajeros = capacidadPasajeros;
        this.anioFabricacion = anioFabricacion;
        this.tipoVehiculo = tipoVehiculo;
        this.estaDisponible = true;
    }
    

    // -----------Getters y Setters-------------
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

    public boolean isEstaDisponible() {
        return estaDisponible;
    }

    public void setEstaDisponible(boolean estaDisponible) {
        this.estaDisponible = estaDisponible;
    }
    
    
    //---------------------------------------------
    
    public abstract void mostrarInformacion();
    
}
