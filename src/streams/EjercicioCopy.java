/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno Tarde
 */
public class EjercicioCopy {
    
    public static void main (String [] args) {
       int byteLeido = 0;
       int byteAEscribir;
       FileInputStream fis = null;
       FileOutputStream fos = null;
       
        try {
            fis = new FileInputStream(args[0]);
            fos = new FileOutputStream(args[1],true);
            
            while ((byteLeido = fis.read()) != -1) {
                byteAEscribir = byteLeido;
                fos.write(byteAEscribir);
            }
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(EjercicioCopy.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al abrir el archivo");
        } catch (IOException ex) {
            //Logger.getLogger(EjercicioCopy.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al leer o escribir archivo");
        } finally {
           try {
               fis.close();
               fos.close();
           } catch (IOException ex) {
               //Logger.getLogger(EjercicioCopy.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("Error al cerrar archivos");
           }
            
        }
       
    }
}
