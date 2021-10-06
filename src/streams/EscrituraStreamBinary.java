/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package streams;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno Tarde
 */
public class EscrituraStreamBinary {
    
    public static void main (String[] args) {
        FileOutputStream fos = null;
        byte byteAEscribir = 0x42;
        
        byte bufferDeLaMuerte [] = {0x43, 0x42, 0x41, 0x40, 0x39, 0x38, 0x21, 0x27};
        String cadena = "¡Hola Mundón!";
        
        try {
            fos = new FileOutputStream("misdatos.dat", true);
            fos.write(byteAEscribir);
            fos.write(bufferDeLaMuerte);
            fos.write(cadena.getBytes());
            //fos.write(cadena); //no funciona en la clase OutputSteam pero si en la writer
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(EscrituraStreamBinary.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error en la apertura del fichero.");
        } catch (IOException ex) {
            Logger.getLogger(EscrituraStreamBinary.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(fos != null) try {
                fos.close();
            } catch (IOException ex) {
                //Logger.getLogger(EscrituraStreamBinary.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Error en el cierre del fichero.");
            }
        }
    }
    
}
