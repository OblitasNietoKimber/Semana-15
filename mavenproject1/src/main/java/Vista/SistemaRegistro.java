/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Controlador.GestionLenguaje;
import Modelo.LenguajeProgramacion;
import java.util.Scanner;
/**
 *
 * @author Cliente
 */

public class SistemaRegistro {
    private static final GestionLenguaje gestionLenguaje = new GestionLenguaje();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("----------------------------------------------------");
            System.out.println(" Menu de Gestion de Lenguajes de Programacion ");
            System.out.println("----------------------------------------------------");
            System.out.println("1. Agregar Lenguaje");
            System.out.println("2. Buscar Lenguaje");
            System.out.println("3. Eliminar Lenguaje");
            System.out.println("4. Mostrar Lenguajes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            System.out.println("\n----------------------------------------------------");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el nombre del lenguaje: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el ano de creacion: ");
                    int anio = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Ingrese la caracteristica principal: ");
                    String caracteristica = scanner.nextLine();
                    System.out.print("Ingrese la utilizacion: ");
                    String utilizacion = scanner.nextLine();
                    gestionLenguaje.agregarLenguaje(anio, caracteristica, nombre, utilizacion);
                    System.out.println("Lenguaje agregado con exito.");
                }
                case 2 -> {
                    System.out.print("Ingrese el nombre del lenguaje a buscar: ");
                    String nombre = scanner.nextLine();
                    LenguajeProgramacion lenguaje = gestionLenguaje.buscarLenguaje(nombre);
                    if (lenguaje != null) {
                        System.out.println("Lenguaje encontrado: " + lenguaje);
                    } else {
                        System.out.println("Lenguaje no encontrado.");
                    }
                }
                case 3 -> {
                    System.out.print("Ingrese el nombre del lenguaje a eliminar: ");
                    String nombre = scanner.nextLine();
                    if (gestionLenguaje.eliminarLenguaje(nombre)) {
                        System.out.println("Lenguaje eliminado con exito.");
                    } else {
                        System.out.println("Lenguaje no encontrado.");
                    }
                }
                case 4 -> {
                    System.out.println("\nLista de lenguajes registrados:");
                    gestionLenguaje.imprimirLenguajes();
                }
                case 5 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción invalida. Intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}

