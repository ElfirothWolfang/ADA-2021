/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Alumno Tarde
 */
public class CuentaLetras {
    
    public static void main (String [] args) {
       Scanner sc = new Scanner(System.in);
       String letra = sc.next();
       int byteLeido = 0;
       FileReader fr = null;
       int cantidadLetra = 0;
       
        try {
            fr = new FileReader("LetrasAContar.txt");
            while ((byteLeido = fr.read()) != -1) {
                int letraActual = (char) byteLeido;
                if(letraActual == letra.charAt(0)){
                    cantidadLetra++;
                }
            }
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(EjercicioCopy.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al abrir el archivo");
        } catch (IOException ex) {
            //Logger.getLogger(EjercicioCopy.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al leer o escribir archivo");
        } finally {
           try {
               fr.close();
           } catch (IOException ex) {
               //Logger.getLogger(EjercicioCopy.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("Error al cerrar archivos");
           }
            
        }
        
        System.out.println(letra + " " + cantidadLetra);
        
    }
    
}
