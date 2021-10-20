/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficherosProperties;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno Tarde
 */
public class Main {
    
    public static void main (String [] args) {
        var persona1 = new Persona("Pedro", "Pelaéz Peréz", "81367890J", 21);
        var persona2 = new Persona("Julio", "Juliéz Julianéz", "53359870L", 30);
        var persona3 = new Persona("Vicente", "Vicentéz Victoréz", "86563212N", 50);
        var persona4 = new Persona("Marciano", "Marcianéz, Marianéz", "81124832X", 72);
        var persona5 = new Persona("Rubén", "Ruíz Rubenéz", "19265920L", 41);
        var persona6 = new Persona("Marcos", "Marquéz Murcianéz", "12738290Y", 18);
        var persona7 = new Persona("Laura", "Lauréz Anéz", "81237238A", 99);
        
        var prop = new Properties();
        try {
            prop.load(Files.newInputStream(Path.of("configPersona.properties")));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("No se pudo abrir el fichero de properties");
        }
        
        String fileName = prop.getProperty("filePath");
        
        boolean errores = false;
        
        try (var fos = new ObjectOutputStream(new BufferedOutputStream((Files.newOutputStream(Path.of(fileName), CREATE))));){
            
            fos.writeObject(persona1);
            fos.writeObject(persona2);
            fos.writeObject(persona3);
            fos.writeObject(persona4);
            fos.writeObject(persona5);
            fos.writeObject(persona6);
            fos.writeObject(persona7);
            
            fos.flush();
                
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error en escritura de fichero");
            errores = true;
        }
        
        if (errores == false) {
            try (var fis = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(Path.of(fileName))))){
                while(true) {
                    try{
                        System.out.println(((Persona) fis.readObject()).getNombre());
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        System.err.println("No se ha podido leer la clase");
                        break;
                    } catch (EOFException ex) {
                      System.out.println("¡¡¡Fin de fichero!!!");
                      break;
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("No se ha podido leer el fichero");
            }
                
        }
                
        
        
    }
    
}
