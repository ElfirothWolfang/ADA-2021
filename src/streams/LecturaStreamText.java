/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package streams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Alumno Tarde
 */
public class LecturaStreamText {
    
    public static void main (String args []) throws FileNotFoundException {
        
        int caracter = 0;
        FileReader fr = null;
        try {
            fr = new FileReader("Hola.txt", StandardCharsets.UTF_8);
            while ((caracter = fr.read()) != -1){
                System.out.print((char) caracter);
            }
        }catch (FileNotFoundException ex) {
            System.out.println("El fichero no se ha encontrado");
        } catch(IOException ex) {
            System.out.println("Error de lectura.");
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                System.out.println("Error al cerrar el fichero");
            }
        }
    }
    
}
