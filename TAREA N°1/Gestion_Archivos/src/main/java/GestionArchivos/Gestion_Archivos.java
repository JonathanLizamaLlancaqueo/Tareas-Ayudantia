/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionArchivos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author JonathanLizama
 */
public class Gestion_Archivos {

      public static void main(String[] arg) {

            // Realice una prueba en el Main , porque en las pruebas unitarias me arrojaba error y no logre solucionarlo.
            System.out.println("---------------------TEXTO ORIGINAL------------------------");
            System.out.println(leerArchivoTexto("C:\\Users\\Jeremias\\Desktop\\textoAyudantia.txt"));
            System.out.println("----------------PALABRA INGRESADA AL FINAL DEL ARCHIVO------------------");
            System.out.println(agregarTextoArchivo("C:\\Users\\Jeremias\\Desktop\\textoAyudantia.txt"));

      }

      /**
       * Función que lee un archivo de texto txt.
       *
       * @param ruta direccion del archivo.txt
       * @return texto contenido en el archivo txt.
       *
       */
      public static String leerArchivoTexto(String ruta) {
            Path directorio = Paths.get(ruta);
            String texto = "";
            try {
                  texto = new String(Files.readAllBytes(directorio));
            } catch (IOException e) {
                  System.out.println(e);
                  System.out.println("El archivo no pudo ser leido | verifique la ruta introducida");

            }
            return texto;
      }

      /**
       * Función que agrega texto al final de un archivo txt.
       *
       * @param ruta direccion del archivo.txt
       * @return leerArchivoTexto(ruta) ,devuelve todo el contenido del archivo + frase
       * introducida en el metodo agregarTextoArchivo();.
       *
       */
      public static String agregarTextoArchivo(String ruta) {
            PrintWriter frase;
            try {
                  FileWriter arch = new FileWriter(ruta, true);
                  frase = new PrintWriter(arch);
                  frase.println("The first man who stepped on the moon.");
                  frase.close();
            } catch (IOException e) {
                  System.out.println(e);
                  System.out.println("Error al agregar texto al archivo");
            }
            return leerArchivoTexto(ruta);

      }

}
