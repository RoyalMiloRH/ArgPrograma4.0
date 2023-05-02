/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.argprogramafinal;

import com.google.gson.Gson;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nes
 */
public class Alumno {
    
    private static Scanner sc = new Scanner(System.in).useDelimiter("\n");

    private static Conexion conexion = new Conexion();
    
    String nombre;
    int legajo;
    ArrayList<String> materiasAprobadas = new ArrayList<>();

    public Alumno(String nombre, int legajo) {
        this.nombre = nombre;
        this.legajo = legajo;
    }

    public Alumno() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    
    
    
        public static void crearAlumno() throws SQLException{
    
            
        Alumno alumno = new Alumno();
        
    
        System.out.println("Nombre del estudiante");
        String nombre = sc.next();
      
        alumno.setNombre(nombre);
        
          System.out.println("Que numero de legajo desea?");
          
          int legajo = sc.nextInt();
          
          alumno.setLegajo(legajo);

        System.out.println("Cuantas materias tienes aprobadas?");
  
        int numero = sc.nextInt();
   
        System.out.println("Nombre de tus materias aprobadas");
        ArrayList<String> materiasAprobadas = new ArrayList<>();

        String input;

            for (int i = 0; i < numero; i++) {
                System.out.println("Elige entre: Matematica, Fisica y Quimica");
                input = sc.next();
                materiasAprobadas.add(input);
            }
        
        String materiasAprobadasJson = new Gson().toJson(materiasAprobadas);

        conexion.estableceConexion();

        Statement stmt = conexion.conectar.createStatement();
        stmt.executeUpdate("INSERT INTO alumnos VALUES(\"" + nombre + "\",\"" + legajo + "\",'" + materiasAprobadasJson + "');");
        
        conexion.cerrarConnection();
        
    }


    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", legajo=" + legajo + ", materiasAprobadas=" + materiasAprobadas + '}';
    }
    
    
    
    
    
}
