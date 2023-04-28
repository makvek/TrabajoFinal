/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajofinal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class Alumno {
    
      
    String nombreAlu;
    int legajo;
    ArrayList<String> materiasAprobadas = new ArrayList<>();

    public Alumno(String nombre, int legajo) {
        this.nombreAlu = nombre;
        this.legajo = legajo;
    }

    public Alumno() {
    }

    public String getNombre() {
        return nombreAlu;
    }

    public void setNombre(String nombre) {
        this.nombreAlu = nombre;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public ArrayList<String> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void setMateriasAprobadas(ArrayList<String> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombreAlu + ", legajo=" + legajo + ", materiasAprobadas=" + materiasAprobadas + '}';
    }
    
    
    
    
    
}
