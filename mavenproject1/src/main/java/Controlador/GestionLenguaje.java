/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.LenguajeProgramacion;

/**
 *
 * @author Cliente
 */
public class GestionLenguaje {
    private LenguajeProgramacion[] arregloLenguajes;
    private int contadorLenguajes;
    private static final int FACTOR_CRECIMIENTO = 2;

    // Constructor
    public GestionLenguaje() {
        arregloLenguajes = new LenguajeProgramacion[FACTOR_CRECIMIENTO];
        contadorLenguajes = 0;
    }

    // Método para agregar un lenguaje
    public void agregarLenguaje(int anioCreacion, String caracteristicaPrincipal, String nombre, String utilizacion) {
        if (contadorLenguajes == arregloLenguajes.length) {
            expandirArreglo();
        }
        arregloLenguajes[contadorLenguajes++] = new LenguajeProgramacion(anioCreacion, caracteristicaPrincipal, nombre, utilizacion);
    }
        // Método  para expandir el arreglo
    private void expandirArreglo() {
        LenguajeProgramacion[] nuevoArreglo = new LenguajeProgramacion[arregloLenguajes.length + FACTOR_CRECIMIENTO];
        System.arraycopy(arregloLenguajes, 0, nuevoArreglo, 0, arregloLenguajes.length);
        arregloLenguajes = nuevoArreglo;
    }

    // Método para buscar un lenguaje por nombre
    public LenguajeProgramacion buscarLenguaje(String nombre) {
        for (int i = 0; i < contadorLenguajes; i++) {
            if (arregloLenguajes[i].getNombre().equalsIgnoreCase(nombre)) {
                return arregloLenguajes[i];
            }
        }
        return null;
    }

    // Método para eliminar un lenguaje por nombre
    public boolean eliminarLenguaje(String nombre) {
        for (int i = 0; i < contadorLenguajes; i++) {
            if (arregloLenguajes[i].getNombre().equalsIgnoreCase(nombre)) {
                arregloLenguajes[i] = arregloLenguajes[--contadorLenguajes];
                arregloLenguajes[contadorLenguajes] = null;
                return true;
            }
        }
        return false;
    }

    // Método para imprimir los lenguajes
    public void imprimirLenguajes() {
        for (int i = 0; i < contadorLenguajes; i++) {
            System.out.println(arregloLenguajes[i]);
        }
    }       
    
}

