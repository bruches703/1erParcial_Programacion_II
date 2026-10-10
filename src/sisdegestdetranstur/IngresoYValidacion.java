/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisdegestdetranstur;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author bruch
 */
public class IngresoYValidacion {
        public static int menu(){
        Scanner leer = new Scanner(System.in);
        int opcion;
        System.out.println("SISTEMA DE GESTION DE TRANSPORTE\n");
        System.out.println("MENU");
        System.out.println("1- Agregar vehiculo");
        System.out.println("2- Mostrar todos los vehiculos");
        System.out.println("3- Realizar servicios turisticos");
        System.out.println("4- Buscar vehiculo por patente");
        System.out.println("5- Mostrar vehiculos con capacidad mayor a: ");
        System.out.println("6- Mostrar vehiculos por anio de fabricacion");
        System.out.println("7Mostrar vehiculos ordaados por capacidad de pasajeros descendente ");
        System.out.println("8- Salir");
        opcion = ingreso(leer);        
        return opcion;
    }
    
   /**
    * Lee lo ingresado por consola, realizando las validaciones correspondientes
    * dentro del rango de 1 al 8 en valor entero
    * 
    * @param leer utilidad para leer lo ingresado por consola
    * @return devuelve la opcion escogida por el usuario
    */
    public static int ingreso(Scanner leer) {
        boolean esOpcionValida = false;
        int opcion = -1;
        System.out.println("Ingrese opcion: ");

        while (!esOpcionValida) {
            try {
                opcion = leer.nextInt();
                esOpcionValida = esEnteroValido(opcion, 1, 8);// Si la opcion ingresada es valida, entre 1 y 8, saldra del loop
                if(!esOpcionValida){
                    System.out.println("Error, debe ingresar un entero entre 1 y 8.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error, reingrese un numero entero: ");
                leer.next(); //limpia el buffer

            }
        }

        return opcion;
    }
    
    /**
     * Valida un entero si esta dentro del rango.
     * @param numero representa la opcion ingresada, por consola, del usuario.
     * @return 
     *      devuelve true entre el 1 y el 8 si es correcto el ingreso
     *      devuelve false si el valor ingresado no esta en rango
     */
    public static boolean esEnteroValido(int numero, int min, int max){       
        return numero >= min && numero <= max;
        
    }
        
    /**
     * Ingresa una cadena de caracteres y la valida devolviendo un valor deseado
     * @param leer Tipo Scanner
     * @param minLetras Tipo int. Cantidad minima de caracteres del strig.
     * @param maxLetras
     * @param mensajeIngreso
     * @param mensajeError
     * @return 
     */
    public static String ingresarCadena(Scanner leer, int minLetras, int maxLetras, String mensajeIngreso, String mensajeError){
        String cadena;
        System.out.println(mensajeIngreso);
        cadena = leer.nextLine();
        while(cadena.length() > minLetras && cadena.length() < maxLetras){
            System.out.println(mensajeError);
            cadena = leer.nextLine();
        }
        return cadena;
    }
    
    public static int ingresarEntero(Scanner leer, int valorMin, int valorMax, String mensajeIngreso, String mensajeError){
        int ingreso = 0;
        boolean esIngresoValido = false;
        while (!esIngresoValido) {
            try {
                System.out.println(mensajeIngreso);
                ingreso = leer.nextInt();
                esIngresoValido = esEnteroValido(ingreso, valorMin, valorMax);
                if (!esIngresoValido) {
                    System.out.println(mensajeError);
                }

            } catch (InputMismatchException e) {
                System.out.println("Error, ingrese un valor entero permitido: ");
            }
        }
        return ingreso;
    }
    
    public static TipoDeCombustible ingresarTipoDeCombustible(Scanner leer) {
        String tipoCombustible;
        TipoDeCombustible combustible = null;
        boolean flag = true;

        do {
            System.out.println("Combustibles:");
            System.out.println("Nafta.\nDiesel.\nElectrico.");
            System.out.println("Ingrese el tipo de combustible: ");
            tipoCombustible = leer.nextLine().trim().toUpperCase();

            try {
                combustible = TipoDeCombustible.valueOf(tipoCombustible);
                flag = false;
            } catch (IllegalArgumentException e) {
                System.out.println("Error, el combustible ingresado no existe. Reingrese.");
            }

        } while (flag);
        return combustible;
    }


}
