/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisdegestdetranstur;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
/**
 * Clases y funciones que trabajan con consola, ingreso y validaciones
 *
 * @author bruch
 */

public class IngresoYValidacion {

    /**
     * Bandeja principal con el menu de opciones que se ve por consola, que pide
     * el ingreso de un entero con un menú de 8 opciones definidos con valores
     * enteros.
     *
     * @return Devuelve un valor entero entre 1 y 8 representando una opcion.
     */
    public static int menu(Scanner leer) {
        int opcion;
        System.out.println("SISTEMA DE GESTION DE TRANSPORTE\n");
        System.out.println("MENU");
        System.out.println("1- Agregar vehiculo");
        System.out.println("2- Mostrar todos los vehiculos");
        System.out.println("3- Realizar servicios turisticos");
        System.out.println("4- Buscar vehiculo por patente");
        System.out.println("5- Mostrar vehiculos con capacidad mayor a: ");
        System.out.println("6- Mostrar vehiculos por anio de fabricacion");
        System.out.println("7- Mostrar vehiculos ordenados por capacidad de pasajeros descendente ");
        System.out.println("8- Salir");
        opcion = ingreso(leer);
        return opcion;
    }

    /**
     * Lee lo ingresado por consola, realizando las validaciones
     * correspondientes dentro del rango de 1 al 8 en valor entero
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
                if (!esOpcionValida) {
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
     *
     * @param numero representa la opcion ingresada, por consola, del usuario.
     * @return devuelve true entre el 1 y el 8 si es correcto el ingreso
     * devuelve false si el valor ingresado no esta en rango
     */
    public static boolean esEnteroValido(int numero, int min, int max) {
        return numero >= min && numero <= max;

    }

    /**
     * Pide por consola con un mensaje recibido por parámetro a ingresar las opciones
     * SI o NO
     * 
     * @param leer Tipo Scanner. Herramienta para leer lo ingresado por consola.
     * @param mensaje Tipos String. Mensaje pre-armado que se mostrara por consola
     * para invitar al usuario a ingresar SI o NO
     * 
     * @return Devuelve true si lo ingresado es SI o false si lo ingresado es NO
     */
    public static boolean ingresarSiNo(Scanner leer, String mensaje){
        boolean esIngresoValido = false; // variable de control para salir del loop
        boolean resultado = false; // variable a devolver
        String ingreso; // ingreso del usuario a validar
        
        do{
            System.out.println(mensaje);
            ingreso = leer.nextLine().toUpperCase();

            if(ingreso.equals("SI")){
                resultado = true;
                esIngresoValido = true;

            }else if(ingreso.equals("NO")){
                resultado = false;
                esIngresoValido = true;                
            } else {
                System.out.println("Error de ingreso, Ingrese SI o NO");
            }
        }while(!esIngresoValido);
        
        return resultado;
    }
    
    
    /**
     * Ingresa una cadena de caracteres y la valida devolviendo la cantidad de caracteres
     * buscados en la cadena, limitados por el mínimo y el máximo enviados por
     * parámetro.
     *
     * @param leer Tipo Scanner
     * @param minLetras Tipo int. Cantidad mínima de caracteres del strig.
     * @param maxLetras Tipo int. Cantidad máxima de caracteres del string
     * @param mensajeIngreso Tipo String. Mensaje que invita al usuario a ingresar la cadena
     * @param mensajeError Tipo String. Mensaje de error si la cantidad de caracteres esta fuera de rango
     * 
     * @return devuelve un String con la cantidad de caracteres buscados
     */
    public static String ingresarCadena(Scanner leer, int minLetras, int maxLetras, String mensajeIngreso, String mensajeError) {
        String cadena;
        System.out.println(mensajeIngreso);
        cadena = leer.nextLine();
        // Valida el largo de la cadena
        while (cadena.length() < minLetras && cadena.length() > maxLetras) {
            System.out.println(mensajeError);
            cadena = leer.nextLine();
        }
        return cadena;
    }

    /**
     * Recibe un entero por consola y lo valida entre los valores mínimo y
     * máximo.
     *
     * @param leer Scanner para leer lo ingresado por consola.
     * @param valorMin Tipo entero. Valor mínimo del entero a validar.
     * @param valorMax Tipo entero. Valor máximo del entero a validar
     * @param mensajeIngreso Tipo String. Mensaje que se muestra en consola.
     * @param mensajeError Tipo String. Mensaje de error si el entero ingresado
     * se encuentra fuera de rango.
     *
     * @return Devuelve un entero validado en el rango mínimo y máximo
     */
    public static int ingresarEntero(Scanner leer, int valorMin, int valorMax, String mensajeIngreso, String mensajeError) {
        int ingreso = 0;
        boolean esIngresoValido = false;

        while (!esIngresoValido) {
            //Valida que el entero no tenga caracteres y que este dentro del rango
            try {
                System.out.println(mensajeIngreso);
                ingreso = leer.nextInt();
                esIngresoValido = esEnteroValido(ingreso, valorMin, valorMax);
                if (!esIngresoValido) {
                    System.out.println(mensajeError);
                    leer.next(); //Limpia el buffer
                }
            } catch (InputMismatchException e) {
                System.out.println("Error, ingrese un valor entero permitido: ");
            }
        }
        return ingreso;
    }

    /**
     * Pide por consola que se ingrese un tipo de combustible, tales son NAFTA,
     * DIESEL, ELECTRICO. Valida que sea un igreso correcto, de lo contrario
     * vuelve a pedir el ingreso
     *
     * @param leer tipo Scanner. Lee el ingreso del usuario por consola
     *
     * @return Devuelve un objeto TipoDeCombustible tipo Enum
     */
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

    public static Vehiculo nuevoVehiculo(Scanner leer, int opcion){
        Vehiculo nuevoVehiculo = null;
        String patente, marca;
        int capacidad, anio, anioActual = LocalDate.now().getYear();
        
        patente = ingresarCadena(leer, 3, 6, "Ingresa la patente, entre 3 y caracteres: ", "Error, reingresa la patente: ");
        marca = ingresarCadena(leer, 1, 10, "Ingresa la marca del vehiculo: ", "Error, reingresa la marca: ");
        
        capacidad = ingresarEntero(leer, 10, 50, "Ingresa la capacidad del vehiculo: ", "Error, reingrese la capacidad: ");
        anio = ingresarEntero(leer, 1990, anioActual, "Ingresa el anio del vehiculo", "Anio fuera de rango, reingrese: ");
        
        if(opcion == 1){
            int cantidadPisos = ingresarEntero(leer, 1, 2, "Ingrese cantidad de pisos\n1 piso\n2pisos\nIngrese: ", "Error, debe ingresar 1 o 2 pisos");
            nuevoVehiculo = new ColectivoTuristico(cantidadPisos, patente, marca, capacidad, anioActual);
            nuevoVehiculo = (ColectivoTuristico) nuevoVehiculo;
        } else if(opcion == 2){
            TipoDeCombustible combustible = ingresarTipoDeCombustible(leer);
            nuevoVehiculo = new LanchaTuristica(combustible, patente, marca, capacidad, anioActual);
            nuevoVehiculo = (LanchaTuristica) nuevoVehiculo;
        } else {
            boolean tieneAire = ingresarSiNo(leer, "El vehiculo tiene aire acondicionado?\nSi - No: ");
            nuevoVehiculo = new VanEjecutiva(tieneAire, patente, marca, capacidad, anioActual);
            nuevoVehiculo = (VanEjecutiva) nuevoVehiculo;
        }
        return nuevoVehiculo;
    }
}
