/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trabajofinal;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.protobuf.TextFormat.ParseException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import top.jfunc.json.impl.JSONArray;
import top.jfunc.json.impl.JSONObject;

/**
 *
 * @author Alejandro
 */
public class TrabajoFinal {
private static Scanner sc = new Scanner(System.in).useDelimiter("\n");
 private static Conexion conexion = new Conexion();
  
    public static void main(String[] args) throws SQLException, JsonProcessingException, java.text.ParseException {
       

    int opcion;
//creo el menu
    do {
        System.out.println("Menu principal:");
        System.out.println("1. Agregar alumno");
        System.out.println("2. Agregar materia");
        System.out.println("3. Agregar inscripcion");
        System.out.println("4. Salir");
        System.out.print("Ingrese una opcion: ");
      
        opcion = sc.nextInt();

        switch (opcion) {
            case 1:
              sc.nextLine();
              //ingresa datos en una tabla alumnos 
                System.out.println("\n");
                agregarAlumno();
                break;
            case 2:
                sc.nextLine();
                 System.out.println("\n");
                agregarMateria();
                break;
            case 3:
                 sc.nextLine();
                 System.out.println("\n");
                agregarInscripcion();
                break;
            case 4:
                 sc.nextLine();
                System.out.println("Saliendo del programa...");
                break;
            default:
                System.out.println("Opcion no valida, intente de nuevo.");
                break;
        }

        System.out.println();
    } while (opcion != 4);
}


    
//En agregar alumnos ingreso los datos del alumno a una tabla
//para crear la tabla alumnos en esta use:
//    CREATE TABLE alumnos (
//    
//    nombre VARCHAR(20),
//    legajo INT,
//    materias_aprobadas JSON,
public static void agregarAlumno() throws SQLException{
    
     Alumno alumno = new Alumno();

         System.out.println("Ingrese el nombre del alumno: ");
         String nombre=sc.nextLine();
        System.out.println("Ingrese el legajo del alumno (debe tener 5 dígitos): ");
String legajoStr = sc.nextLine();



while (legajoStr.length() != 5 || !legajoStr.matches("\\d+")) {
    System.out.println("El legajo ingresado no tiene 5 dígitos o no es un número válido. Intente nuevamente: ");
    legajoStr = sc.nextLine();
}

int legajo = Integer.parseInt(legajoStr);

        
           System.out.println("Ingresar la cantidad de materias aprobadas");

        int cantidad = sc.nextInt();

        System.out.println("Ingrese el nombre de las materias Aprobadas");
        ArrayList<String> Aprobadas = new ArrayList<>();

       String materia;

        for (int i = 0; i < cantidad; i++) {
            materia = sc.next();
            Aprobadas.add(materia);
        }
        
        String MateriasAprobadasJson = new Gson().toJson(Aprobadas);
         conexion.estableceConexion();
         PreparedStatement pstmt = conexion.conectar.prepareStatement("INSERT INTO alumnos VALUES(?, ?, ?)");
     pstmt.setString(1, nombre);
     pstmt.setInt(2, legajo);
     pstmt.setString(3, MateriasAprobadasJson);
     pstmt.executeUpdate();
        conexion.cerrarConnection();
    }




//En agregar Materia ingreso los datos de la materia a inscribirse en una tabla
//para crear la tabla materias en esta use:
//    CREATE TABLE materias_final (
//    
//    nombre VARCHAR(20),  
//    correlativas JSON,


     public static void agregarMateria() throws SQLException{
    
        Materia materia = new Materia();

        System.out.println("Ingrese el nombre de la materia");
        String nombre = sc.next();
        materia.setNombre(nombre);

        System.out.println("Ingresar la cantidad de correlativas");

        int numero = sc.nextInt();

        System.out.println("Ingrese el nombre de las materias correlativas");
        ArrayList<String> correlativas = new ArrayList<>();

        String input;

        for (int i = 0; i < numero; i++) {
            input = sc.next();
            correlativas.add(input);
        }
        
        String correlativasJson = new Gson().toJson(correlativas);

        conexion.estableceConexion();
        Statement stmt = conexion.conectar.createStatement();
        stmt.executeUpdate("INSERT INTO materias_final VALUES(\"" + nombre + "\",'" + correlativasJson + "');");
        conexion.cerrarConnection();
        
    }
     
     
// Para agregar una inscrpcion cree una tabla con lo siguientes datos guardado en esta tabla   
//     CREATE TABLE inscripciones (
//    id INT NOT NULL AUTO_INCREMENT,
//    nombre VARCHAR(20),
//    legajo INT,
//    materia VARCHAR(20),
//    correlativas_pendientes JSON,
//    fecha_inscripcion DATE,
//    aprovacion_inscripcion varchar(10),
//    PRIMARY KEY (id)
//       );
     
     
     
     
 public static void agregarInscripcion() throws SQLException, java.text.ParseException{
     
     //Ingreso datos  del objeto alumno
     System.out.println("Datos del alumno \n");
     
      Alumno alumno = new Alumno();

         System.out.println("Ingrese el nombre del alumno: ");
         String nombreAlu=sc.nextLine();
         alumno.setNombre(nombreAlu);
        System.out.println("Ingrese el legajo del alumno (debe tener 5 dígitos): ");
        String legajoStr = sc.nextLine();

while (legajoStr.length() != 5 || !legajoStr.matches("\\d+")) {
    System.out.println("El legajo ingresado no tiene 5 dígitos o no es un número válido. Intente nuevamente: ");
    legajoStr = sc.nextLine();
}

int legajo = Integer.parseInt(legajoStr);
   //instanciar clase  alumno
        alumno.setLegajo(legajo);
           System.out.println("Ingresar la cantidad de materias aprobadas");

        int cantidad = sc.nextInt();
      
        System.out.println("Ingrese el nombre de las materias Aprobadas");
        ArrayList<String> Aprobadas = new ArrayList<>();

       String materiaApr;

        for (int i = 0; i < cantidad; i++) {
            materiaApr = sc.next();
            Aprobadas.add(materiaApr);
        }
        alumno.setMateriasAprobadas(Aprobadas);
        String MateriasAprobadasJson = new Gson().toJson(Aprobadas);
        //instanciar clase  materia
        Materia materia = new Materia();

        System.out.println("Ingrese el nombre de la materia a inscribirse");
        String nombre = sc.next();
        materia.setNombre(nombre);

        System.out.println("Ingresar la cantidad de correlativas que tiene");

        int numero = sc.nextInt();

        System.out.println("Ingrese el nombre de las materias correlativas");
        ArrayList<String> correlativas = new ArrayList<>();

        String input;

        for (int i = 0; i < numero; i++) {
            input = sc.next();
            correlativas.add(input);
        }
        materia.setCorrelativas(correlativas);
         
        
        String correlativasJson = new Gson().toJson(correlativas);
        
        
        
           
      
        //Ingresar datos de la incripcion
        sc.nextLine();
        System.out.println("Ingrese la fecha de la inscripcion en (dd/mm/yyyy)");
        String fechaString=sc.nextLine();
        SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
        Date fecha=null;
        fecha=formatter.parse(fechaString);
      
        
        

       
        //creo un array para compara las correlativas y las aprobadas asi al final agrego una lista de materias que faltan para inscripcion
        
        List<String>correlativasPendientes=new ArrayList<>();
        for(String correlativa:materia.getCorrelativas()){
            if(!alumno.getMateriasAprobadas().contains(correlativa)){
                correlativasPendientes.add(correlativa);
            }
            
        }
        //en aprobada me da true si no debo mateias y false si me falta aprobar correlativas
         boolean aprobada = correlativasPendientes.isEmpty();
        
        Inscripcion inscripcion=new Inscripcion(materia,alumno,fecha,aprobada);
        
       
        //Datos de la inscripcion
        System.out.println("\n");
        System.out.println("------------------------------------------------\n");
        System.out.println("Informacion de la inscripcion ");
        System.out.println("Alumno: "+inscripcion.getAlumno().nombreAlu);
        System.out.println("Legajo: "+inscripcion.getAlumno().legajo);
        System.out.println("Materia: "+inscripcion.getMateria().getNombre());
        //listo las correlativas pendientes si no aparece ninguna aparece ninguna o las materias que adeudo;
        if(correlativasPendientes.isEmpty()){
            System.out.println("Correlativas pendientes:Ninguna ");
        }else{
            System.out.println("correlativas pendientes: "+correlativasPendientes);
        }
        String correlativasPendientesJson = new Gson().toJson(correlativasPendientes);
        System.out.println("Fecha: "+formatter.format(inscripcion.getFecha()));
        System.out.println("Aprobacion para inscripcion: "+inscripcion.isAprobada());
        conexion.estableceConexion();
        
PreparedStatement pstmt = conexion.conectar.prepareStatement("INSERT INTO inscripciones (nombre, legajo, materia, correlativas_pendientes, fecha_inscripcion ,aprovacion_inscripcion ) VALUES (?, ?, ?, ?, ?,?)");
pstmt.setString(1, inscripcion.getAlumno().nombreAlu);
pstmt.setInt(2, inscripcion.getAlumno().legajo);
pstmt.setString(3, inscripcion.getMateria().getNombre());
pstmt.setString(4, correlativasPendientesJson);
pstmt.setDate(5, new java.sql.Date(inscripcion.getFecha().getTime()));
pstmt.setString(6, inscripcion.isAprobada() ? "Aceptado" : "Rechazado");
pstmt.executeUpdate();
conexion.cerrarConnection();
 }
}

