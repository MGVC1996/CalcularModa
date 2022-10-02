/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package spv.calcularmoda;

import java.util.Random;

/**
 *
 * @author Gilme
 */
public class CalcularModa {

    public static int[] Generar_Datos(int Cantidad) {
        Random NumeroAleatorio = new Random();
        int[] Vector_de_Datos = new int[Cantidad];
        for (int i = 0; i < Vector_de_Datos.length; i++) {
            Vector_de_Datos[i] = NumeroAleatorio.nextInt(20);
        }
        return Vector_de_Datos;
    }

    public static int[] Generar_Vector_de_Frecuencias(int[] Vector_de_Datos) {
        int contador_de_frecuencias = 0;
        int[] Vector_de_frecuencias = new int[Vector_de_Datos.length];

        for (int i = 0; i < Vector_de_frecuencias.length; i++) {
            for (int j = 0; j < Vector_de_frecuencias.length; j++) {
                if (Vector_de_Datos[i] == Vector_de_Datos[j]) {
                    contador_de_frecuencias++;
                }
            }
            Vector_de_frecuencias[i] = contador_de_frecuencias;
            contador_de_frecuencias = 0;
        }
        return Vector_de_frecuencias;
    }

    public static Boolean Frecuencias_se_Repiten_en_Todo_el_Vector(int[] Vector_de_Frecuencias) {
        int contador = 0;
        for (int i = 0; i < Vector_de_Frecuencias.length; i++) {
            if (Vector_de_Frecuencias[0] == Vector_de_Frecuencias[i]) {
                contador++;
            }
        }
        if (contador == Vector_de_Frecuencias.length) {
            return true;
        } else {
            return false;
        }
    }

    public static int[] Obtener_Vector_de_Modas(int[] Vector_de_Datos, int[] Vector_de_Frecuencias) {
        int mayor = Vector_de_Frecuencias[0];
        for (int i = 0; i < Vector_de_Frecuencias.length; i++) {
            if (Vector_de_Frecuencias[i] > mayor) {
                mayor = Vector_de_Frecuencias[i];
            }
        }

        int[] vector_de_modas = new int[Vector_de_Datos.length];
        for (int i = 0; i < vector_de_modas.length; i++) {
            if (Vector_de_Frecuencias[i] == mayor) {
                vector_de_modas[i] = Vector_de_Datos[i];
            } else {
                vector_de_modas[i] = -1;
            }
        }
        return vector_de_modas;
    }

    public static int[] Ordenar_de_Mayor_a_Menor(int Vector[]) {

        int aux;

        for (int i = 0; i < Vector.length - 1; i++) {
            for (int j = 0; j < Vector.length - 1; j++) {
                if (Vector[j] > Vector[j + 1]) {
                    aux = Vector[j];
                    Vector[j] = Vector[j + 1];
                    Vector[j + 1] = aux;
                }
            }
        }

        return Vector;
    }

    public static void main(String[] args) {
        // Paso 1
        int[] Datos = Generar_Datos(2);
        for (int i = 0; i < Datos.length; i++) {
            System.out.print("[" + Datos[i] + "]");
        }
        System.out.println("");
        //Paso 2
        int[] Vector_de_Frecuencias = Generar_Vector_de_Frecuencias(Datos);
        //Paso 3
        if (Frecuencias_se_Repiten_en_Todo_el_Vector(Vector_de_Frecuencias)) {
            System.out.println("No Hay Moda.");
        } else {
            //Paso 4 y 5
            int[] vector_de_modas = Ordenar_de_Mayor_a_Menor(Obtener_Vector_de_Modas(Datos, Vector_de_Frecuencias));
            // Paso 6

            String Respuesta = "";

            for (int i = 0; i < vector_de_modas.length; i++) {
                //Paso 7
                if (vector_de_modas[i] != -1) {
                    //´Paso 8
                    if (i != vector_de_modas.length - 1) {
                        if (vector_de_modas[i] != vector_de_modas[i + 1]) {
                            Respuesta = Respuesta + "[" + vector_de_modas[i] + "]";
                        }
                    } else {
                        if (vector_de_modas[i] != vector_de_modas[0]) {
                            Respuesta = Respuesta + "[" + vector_de_modas[i] + "]";
                        }
                    }
                }
            }
 
            
            System.out.println("Respuesta : "+ Respuesta);
        }

    }
}
