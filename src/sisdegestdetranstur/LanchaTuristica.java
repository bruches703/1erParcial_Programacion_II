/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisdegestdetranstur;

/**
 *
 * @author bruch
 */
public class LanchaTuristica extends Vehiculo {
    private final TipoDeCombustible tipoDeCombustible;

    public LanchaTuristica(TipoDeCombustible tipoDeCombustible, String patente, String marca, int capacidadPasajeros, int anioFabricacion) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        this.tipoDeCombustible = tipoDeCombustible;
    }

    public TipoDeCombustible getTipoDeCombustible() {
        return tipoDeCombustible;
    }
    
    @Override
    public void mostrarInformacion() {
        System.out.printf("Colectivo | Patente: %-8s | Marca: %-10s | Capacidad: %-3d pas. | Año: %-4d | %-9s\n", 
                this.patente, this.marca, this.capacidadPasajeros, this.anioFabricacion, this.tipoDeCombustible);
    }
    
}
