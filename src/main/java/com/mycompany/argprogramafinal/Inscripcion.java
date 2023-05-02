/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.argprogramafinal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import static com.mycompany.argprogramafinal.ArgProgramaFinal.aprobado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author nes
 */
public class Inscripcion {


    
    Materia materia;
    
    Alumno alumno;

    Date fecha = new Date();

    public Inscripcion() {
    }

    public Inscripcion(Materia materia, Alumno alumno) {
        this.materia = materia;
        this.alumno = alumno;
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

    @Override
    public String toString() {
        return "Inscripcion{" + "materia=" + materia + ", alumno=" + alumno + ", fecha=" + fecha + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
//    public static void aprobado(Materia materia,Alumno alumno) {
//       
//        
//        if (alumno.getMateriasAprobadas().containsAll(materia.getCorrelativas())) {
//            
//            System.out.println("Aprobado");
//            
//        } else {
//            
//                        System.out.println("Desaprobado");
//        }
//
//    }
 

    
    
        // Guia para realizar inscripcion pidiendo alumno y materias 
     public static void realizadInscripcion() throws SQLException, JsonProcessingException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Que alumno quiere inscribir? (legajo)");
        int legajo = sc.nextInt();
        
        System.out.println("A que materia se quiere inscribir?");
        String nombre = sc.next();
        
        Conexion conexion = new Conexion();
        conexion.estableceConexion();
            
        Statement stmt = conexion.conectar.createStatement();
        
        ResultSet rs = stmt.executeQuery("SELECT * FROM alumnos WHERE legajo="+legajo+";");
        rs.next();
        
        Alumno alumno = new Alumno();
        
        alumno.setNombre(rs.getString("nombre"));
        alumno.setLegajo(rs.getInt("legajo"));
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        
        String jsonMaterias = mapper.writeValueAsString(rs.getString("materiasAprobadas"));
        ArrayList<String> listaMaterias = mapper.readValue(jsonMaterias, ArrayList.class);
        
        alumno.setMateriasAprobadas(listaMaterias);
        
        Materia materia = new Materia();
        
        ResultSet rsm = stmt.executeQuery("SELECT * FROM materias WHERE nombre=\""+nombre+"\";");
        rsm.next();
        
        materia.setNombre(rsm.getString("nombre"));
        
        String jsonCorrelativas = mapper.writeValueAsString(rsm.getString("correlativas"));
        ArrayList<String> listaMateriasCorrelativas = mapper.readValue(jsonCorrelativas, ArrayList.class);
        materia.setCorrelativas(listaMateriasCorrelativas);
        
        aprobado(alumno, materia);
        
        conexion.cerrarConnection();
    }
    
}
