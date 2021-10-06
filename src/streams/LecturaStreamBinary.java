package streams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Alumno Tarde
 */
public class LecturaStreamBinary {
    
    public static String BinToHex(int x) {
        String r = "";
        if (x >= 0 && x <= 16) {
            if (x >= 0 && x <= 9) {
                r = r + x;
            } else if (x == 10) {
                r = r + "A";
            } else if (x == 11) {
                r = r + "B";
            } else if (x == 12) {
                r = r + "C";
            } else if (x == 13) {
                r = r + "D";
            } else if (x == 14) {
                r = r + "E";
            } else if (x == 15) {
                r = r + "F";
            }
        }
        return r;
    }

    public static void main(String args[]) throws FileNotFoundException {

        int byteLeido = 0;
        FileInputStream is = null;
        try {
            is = new FileInputStream("Hola.txt");
            int contador = 0;
            while ((byteLeido = is.read()) != -1) {
                int a = byteLeido % 16;
                int b = byteLeido / 16;
                System.out.print(BinToHex(a) + BinToHex(b) + " ");
                contador++;
                if (contador >= 10) {
                   System.out.print("\r\n");
                   contador = 0;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El fichero no se ha encontrado");
        } catch (IOException ex) {
            System.out.println("Error de lectura.");
        } finally {
            try {
                is.close();
            } catch (IOException ex) {
                System.out.println("Error al cerrar el fichero");
            }
        }
    }

}
