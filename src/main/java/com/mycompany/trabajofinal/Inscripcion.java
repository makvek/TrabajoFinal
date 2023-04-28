/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajofinal;

import java.util.Date;

/**
 *
 * @author Alejandro
 */
public class Inscripcion {
    
    
    Materia materia;
    
    Alumno alumno;

    Date fecha;
    
    boolean aprobada;

    public Inscripcion(Materia materia, Alumno alumno, Date fecha, boolean aprobada) {
        this.materia = materia;
        this.alumno = alumno;
        this.fecha = fecha;
        this.aprobada = aprobada;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isAprobada() {
        return aprobada;
    }

    public void setAprobada(boolean aprobada) {
        this.aprobada = aprobada;
    }

    
    
}
