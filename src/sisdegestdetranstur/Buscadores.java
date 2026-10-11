/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisdegestdetranstur;


import java.util.List;
import java.util.Scanner;

/**
 * Clase encargada de realizar busquedas especificas y por atributo de un objeto
 * o de varios objetos con la misma caracteristica.
 * 
 * @author bruch
 */
public class Buscadores {
    
    /**
     * Metodo encargado de buscar por capacidad indicada, busca desde el indice
     * indicado en los parametros y devuelve el indice del primero que coincide 
     * con la capacidad marcada. De no encontrar coincidencia devuelve -1.
     * 
     * @param listaVehiculos Tipo lista Vehiculo. Lista donde se busca el indice.
     * @param capacidad Tipo entero. Capacidad de pasajeros buscada entre los objetos de la lista.
     * @param indice Tipo entero. Índice donde comienza la busqueda en la lista.
     * 
     * @return Devuelve un entero que representa el índice de la lista donde se
     * encuentra el vehiculo. De no haber, retorna -1.
     */
    public static int buscarPorCapacidad(List<Vehiculo> listaVehiculos, int capacidad, int indice) {

        for (int i = indice; i < listaVehiculos.size(); i++) {
            if (listaVehiculos.get(i).getCapacidadPasajeros() >= capacidad) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Comprueba la presencia de una patente recibida por parametro. De encontrarla
     * devuelve TRUE, de no estar devuelve FALSE.}
     * 
     * @param patente Tipo String. Cadena de caracteres que representa la patente buscada
     * @param listaVehiuculos Tipo Lista de Vehiculos. Lista donde se busca la patente
     * 
     * @return Retorta un booleano. Si se encuentra la patente retorna TRUE, retorna
     * false de caso contrario
     */
    public static boolean estaLaPatenteEnLista(String patente, List<Vehiculo> listaVehiuculos) {
        for (Vehiculo vehiculo : listaVehiuculos) {
            if (vehiculo.getPatente().equals(patente)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Busca una patente, ingresada por parametro, en la lista de Vehiculos. De
     * encontrar la patente retorna el indice de la posición en la lista, si no
     * lo encuentra devuelve -1.
     * 
     * @param listaVehiuculos Tipo lista de vehiculos. Lista donde se busca la patente.
     * @param patente Tipo String. Cadena de caracteres con la patente a buscar en la lista.
     * 
     * @return devuelve un entero. Retornara el indice de la posición del objeto en la lista
     * si el atributo coincide, caso contrario retorna -1.
     */
    public static int buscarPosicionDePatente(List<Vehiculo> listaVehiuculos, String patente){
        for (int i = 0; i < listaVehiuculos.size(); i++) {
            if(listaVehiuculos.get(i).getPatente().equalsIgnoreCase(patente)){
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Busca por tipo de vehiculo, si es Colectivo, Lancha o Van. al encontrar el
     * primero en la lista retorna el indice de la posición de la lista. Caso contrario,
     * de no encontrar ningun vehiculo de esa caracteristica retorna -1.
     * 
     * @param listaVehiculos Tipo lista de vehiculos. Lista donde se busca el tipo de vehiculo.
     * @param tipo Tipo String. Debe representar "COLECTIVO", "LANCHA" o "VAN".
     * @param indice Tipo entero. Indice donde comienza la busqueda en la lista.
     * 
     * @return retorna un entero. De encontrar un vehiculo buscado, retorna el índice
     * donde se encuentra el vehiculo. Caso contrario, retorna -1.
     */
    public static int buscarPorTipoDeVehiculo(List<Vehiculo> listaVehiculos, String tipo, int indice) {
        
        for (int i = indice; i < listaVehiculos.size(); i++) {
            if (listaVehiculos.get(i).getTipoVehiculo().equalsIgnoreCase(tipo)) {
                return i;
            }
        }
        return -1;
    }
        
    /**
     * Busca una patente, ingresada por consola, de encontrarla la muestra por 
     * consola. Busca por índice y lo muestra en pantalla, caso contrario 
     * mostrara un mensaje de "No se encontro".
     * El formato de la patente se debe respetar de las siguientes formas:
     * 'AA123AA' o 'ABC123' en otros casos mostrara mensaje de error.
     * 
     * @param leer tipo Scanner. Utilitario para leer los ingresos por consola.
     * @param listaVehiculos tipo lista de Vehiculo. Lista de vehiculos a buscar la patente.
     */
    public static void buscarYMostrarUnaPatente(Scanner leer, List<Vehiculo> listaVehiculos) {
        System.out.println("Ingresar patente con formato -AA123AA- o -AAA123-\nIngrese: ");
        String patente = leer.nextLine().trim().toUpperCase();
        int indice;
        
        if (IngresoYValidacion.esPatenteValida(patente)) { // Corrabora el formato de la patente.
            indice = buscarPosicionDePatente(listaVehiculos, patente);
        }else{
            System.out.println("Error de formato. Corrabore la patente y vuelva a ingresar");
            return;
        }

        if (indice == -1) {
            System.out.println("No se encontro la patente ingresada");
        } else {
            System.out.println("Vehiculo encontrado: ");
            ImprecionPorConsola.mostrarCabeceraDeCuadro();
            listaVehiculos.get(indice).mostrarInformacion();
        }

    }
    

}

