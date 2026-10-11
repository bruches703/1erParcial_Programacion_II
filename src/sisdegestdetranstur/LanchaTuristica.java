/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisdegestdetranstur;

/**
 * Clase hija de la clase Vehiculo. Contiene los atributos de la superclase y
 * atributos propios, constructores, getters y setters, y el metodo abstracto
 * que muestra la informacion de cada objeto de este tipo.
 * 
 * @author bruch
 */
public class LanchaTuristica extends Vehiculo {
    private final TiposDeMotor tipoDemotor;

    public LanchaTuristica(TiposDeMotor tipoDemotor, String patente, String marca, int capacidadPasajeros, int anioFabricacion, String tipoVehiculo) {
        super(patente, marca, capacidadPasajeros, anioFabricacion, tipoVehiculo);
        this.tipoDemotor = tipoDemotor;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public TiposDeMotor getTipoDeCombustible() {
        return tipoDemotor;
    }
    
    @Override
    public void mostrarInformacion() {
        System.out.printf(" Lancha   |  %-8s | %-10s | Capacidad: %-3d pas.   | Año: %-4d | %-9s\n", 
                this.patente, this.marca, this.capacidadPasajeros, this.anioFabricacion, this.tipoDemotor);
    }
    
}
