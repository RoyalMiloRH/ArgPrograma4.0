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
public class Materia {
    
    private static Scanner sc = new Scanner(System.in).useDelimiter("\n");

    private static Conexion conexion = new Conexion();
    
    
    String nombre;
    
    ArrayList<String> correlativas = new ArrayList<>();
    
    public Materia(String nombre) {
        this.nombre = nombre;
    }

    public Materia() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getCorrelativas() {
        return correlativas;
    }

    public void setCorrelativas(ArrayList<String> correlativas) {
        this.correlativas = correlativas;
    }

    

    public static void crearMateria() throws SQLException{
    
        Materia materia = new Materia();

     // Deposito un valor a nombre
        System.out.println("Que nombre quiere que tenga la materia?");
        String nombre = sc.next();
      // se va a la clase materia nombre
        materia.setNombre(nombre);

        System.out.println("Cuantas correlativas tiene?");
   //   Deposito un valor en numero para usarlo con correlativas
        int numero = sc.nextInt();
   //  agrego el nombre de la correlativa que se va como array a las correlativas
        System.out.println("Que materias desea agregar a las correlativas?");
        ArrayList<String> correlativas = new ArrayList<>();

        String input;

        for (int i = 0; i < numero; i++) {
            input = sc.next();
            correlativas.add(input);
        }
        
        String correlativasJson = new Gson().toJson(correlativas);

        conexion.estableceConexion();

        Statement stmt = conexion.conectar.createStatement();
        stmt.executeUpdate("INSERT INTO materias VALUES(\"" + nombre + "\",'" + correlativasJson + "');");
        
        conexion.cerrarConnection();
        
    }
    
    
    @Override
    public String toString() {
        return "Materia{" + "nombre=" + nombre + ", correlativas=" + correlativas + '}';
    }
    
    
    
}
