/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.argprogramafinal;

import com.fasterxml.jackson.core.JsonProcessingException;

import static com.mycompany.argprogramafinal.Alumno.crearAlumno;
import static com.mycompany.argprogramafinal.Inscripcion.realizadInscripcion;
import static com.mycompany.argprogramafinal.Materia.crearMateria;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author nes
 */


public class ArgProgramaFinal {

    
    public static void main(String[] args) throws SQLException, JsonProcessingException {


//
//           System.out.println("Para Ingresar coloque su numero de legajo");
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
//        
//        conexion.estableceConexion();
//        
//        
//      
//        conexion.cerrarConnection();
//         
//            int dato = sc.nextInt();
//
//            conexion.estableceConexion();
//
//            Statement stmt = conexion.conectar.createStatement();
//
//            ResultSet rs = stmt.executeQuery("SELECT legajo FROM alumnos ");
//           
//         
//            System.out.println(rs);
//           
//
//           if (rs.next() == ) {
//
//                System.out.println("funciono");
//
//        } else {
//
//                System.out.println("Nada");
//
//        }
//        conexion.cerrarConnection();

      Scanner sn = new Scanner(System.in);

      boolean salir = false;
      int opcion;

      while(!salir){


         System.out.println("1.- Agregar Materia");
         System.out.println("2.- Agregar Alumno");
         System.out.println("3.- Inscribir alumno.");
         System.out.println("4.- Salir");
         

         try{

            System.out.println("Seleccione la opcion deseada: ");
            opcion = sn.nextInt();

            switch (opcion){
            case 1:
             crearMateria();
               break;
            case 2:
             crearAlumno();
               break;

            case 3: 
                
             realizadInscripcion();
               break;

            case 4:
               salir=true;
               break;   
            default:   
               System.out.println("Las opciones son entre 1 y 4");

            }
         }
         catch(InputMismatchException e){
            System.out.println("Debes seleccionar un numero de opcion");
            sn.next();
         }
      }

      System.out.println("Hasta Luego! ");


    }
   
    public static void Inscripcionnueva() throws SQLException, JsonProcessingException {
        
        Inscripcion inscripcion = new Inscripcion();
        
       inscripcion.aprobado();
        
       
       

    }

        public static void aprobado(Alumno alumno, Materia materia) {
    
            if (alumno.getMateriasAprobadas().retainAll(materia.getCorrelativas())) {
            
            System.out.println("Aprobado");
            
        } else {
            
                        System.out.println("Desaprobado");
        }
    
    
    }
}

    

   // guia para traerdatos 
    //Creo el hashmap de las materias para poder trabajar dentro del codigo
//    public static void traerDatos() throws SQLException, JsonProcessingException {
//
//        Materia materia = new Materia();
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
//        
//        HashMap<String, ArrayList<String>> hmMaterias = new HashMap<>();
//
//        conexion.estableceConexion();
//        Statement stmt = conexion.conectar.createStatement();
//
//        ResultSet rs = stmt.executeQuery("SELECT * FROM materias_final");
//
//        while (rs.next()) {
//
//            materia = new Materia(rs.getString("nombre"));
//
//            String jsonText = objectMapper.writeValueAsString(rs.getString("correlativas"));
//
//            ArrayList<String> nombreCorrelativas = objectMapper.readValue(jsonText, ArrayList.class);
//
//            materia.setCorrelativas(nombreCorrelativas);
//
//            hmMaterias.put(materia.getNombre(), materia.getCorrelativas());
//
//        }
//        conexion.cerrarConnection();
//        
//        System.out.println(hmMaterias);
//
//    }
    
//    
//        public static void traerDatos() throws SQLException, JsonProcessingException {
//
//            HashMap hm = new HashMap<>();
////        Materia materia = new Materia();
//
//            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
//
////        HashMap<String, ArrayList<String>> hmMaterias = new HashMap<>();
//            System.out.println("Para Ingresar coloque su numero de legajo");
//
//            String input = sc.next();
//            
//            conexion.estableceConexion();
//            Statement stmt = conexion.conectar.createStatement();
//
//            ResultSet rs = stmt.executeQuery("SELECT * FROM alumno WHERE legajo=\"" + input + "\"");
//
//            System.out.println("Para Ingresar coloque su numero de legajo");
//
//            String input = sc.next();
//
//            while (input == rs.getInt("legajo")) {
//
//            hm.put(rs.getInt("legajo"), rs.getString("nombre"));
//
////            materia = new Materia(rs.getString("nombre"));
////
////            String jsonText = objectMapper.writeValueAsString(rs.getString("correlativas"));
////
////            ArrayList<String> nombreCorrelativas = objectMapper.readValue(jsonText, ArrayList.class);
////
////            materia.setCorrelativas(nombreCorrelativas);
////
////            hmMaterias.put(materia.getNombre(), materia.getCorrelativas());
//
//            System.out.println(hm);
//
//        }
//        conexion.cerrarConnection();
//        
////        System.out.println(hmMaterias);
//
//    }



//
//       String regex = "([0-9]{5})*$";
//
//        String string = ;
//        
        
//  System.out.println("Para Ingresar coloque su numero de legajo");
//
//            int dato = sc.nextInt();
//
//            conexion.estableceConexion();
//
//            Statement stmt = conexion.conectar.createStatement();
//
//            ResultSet rs = stmt.executeQuery("SELECT * FROM alumno WHERE legajo=\"" + dato + "\"");
//            rs.next();
//            
//
//
//            if (rs.getBoolean(dato)) {
//
//                System.out.println("funciono");
//
//        } else {
//
//                System.out.println("Nada");
//
//        }
//        conexion.cerrarConnection();

