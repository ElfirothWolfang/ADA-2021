/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ficherosProperties;

import java.io.Serializable;

/**
 *
 * @author Alumno Tarde
 */
public class Persona implements Serializable{
    String m_nombre;
    String m_apellidos;
    String m_NIF;
    int m_edad;
    
    public Persona() {
        
    }
    
    public Persona (String pi_nombre, String pi_apellidos, String pi_NIF, int pi_edad) {
        this.m_nombre = pi_nombre;
        this.m_apellidos = pi_apellidos;
        this.m_NIF = pi_NIF;
        this.m_edad = pi_edad;
    }

    public String getNombre() {
        return m_nombre;
    }

    public String getApellidos() {
        return m_apellidos;
    }

    public String getNIF() {
        return m_NIF;
    }

    public int getEdad() {
        return m_edad;
    }

    public void setNombre(String pi_nombre) {
        m_nombre = pi_nombre;
    }

    public void setApellidos(String pi_apellidos) {
        m_apellidos = pi_apellidos;
    }

    public void setNIF(String pi_NIF) {
        m_NIF = pi_NIF;
    }

    public void setEdad(int pi_edad) {
        m_edad = pi_edad;
    }
    
    
}   

