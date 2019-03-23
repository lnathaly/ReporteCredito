/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reportecredito;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laura
 */
public class Inicio {
       List<Persona> listaPersona = new ArrayList<>();

public List<Persona> crearPersonas() throws FileNotFoundException{
    
   Scanner entrada = new Scanner(System.in);
   int cedula = 0, opc=1, opc2=2;
   String nombre, apellido, correo;
   
   try(FileOutputStream fos=new FileOutputStream("info.txt")){
   while (opc == 1){
    System.out.print("Ingrese la cedula de la persona: ");
    cedula = entrada.nextInt();
    System.out.print("Ingresa nombre de la persona: ");
    nombre = entrada.nextLine();
    entrada.nextLine();
    System.out.print("Ingresa apellido de la persona: ");
    apellido = entrada.nextLine();
    System.out.print("Ingresa el correo de la persona: ");
    correo = entrada.nextLine();
    opc2=2;
    
   while(opc2 == 2){
       
      System.out.print("Ingrese codigo del reporte: ");
    int codigo = entrada.nextInt();
    System.out.print("Ingresa nombre de la empresa: ");
    String nombreE = entrada.nextLine();
    entrada.nextLine();
    System.out.print("Descripcion del reporte: ");
    String descripcion = entrada.nextLine();
    System.out.print("Estado del reporte: ");
    boolean estado = entrada.nextBoolean();
    System.out.print("Estado del reporte: ");
    double valor = entrada.nextDouble();
       
     System.out.print("Digite 2 para ingresar otro reporte: ");
     opc2 = entrada.nextInt();
   String pers= (cedula+","+nombre +","+apellido+","+ correo+"*"+codigo+"*"+nombreE +"*"+ descripcion +"*"+ estado +"*"+ valor);
    PrintWriter fw=new PrintWriter("info.txt");
            fw.println(pers);

            fw.close();
    
   }
   
   System.out.print("Digite 1 para ingresar otra persona: ");
   opc = entrada.nextInt();
   
   }
  
   
    
        }catch(IOException e){
 
        }
    
   return listaPersona;
    
}

public List<Persona> leerArchivo(String archivo) throws Exception {
        String cadena;
        FileReader f;
        BufferedReader b;
        try {
            f = new FileReader(archivo);
            b = new BufferedReader(f);
            while ((cadena = b.readLine()) != null) {
                List<Reporte> listaReporte = new ArrayList<>();
                String[] personaVector = cadena.split(",");
                Persona persona = new Persona(Integer.parseInt(personaVector[0]), personaVector[1], personaVector[2], personaVector[3]);
                listaPersona.add(persona);
                String[] reportes = personaVector[4].split("%");
                int longitud = reportes.length;

                for (int i = 0; i < longitud; i++) {

                    String[] repor = reportes[i].split("-");
                    Reporte reporte = new Reporte(Integer.parseInt(repor[0]), repor[1], repor[2], Boolean.valueOf(repor[3]), Integer.parseInt(repor[4]));
                    listaReporte.add(reporte);
                    persona.setReport(listaReporte);

                }

                persona.setReport(listaReporte);
            }
            b.close();
            return listaPersona;

        } catch (FileNotFoundException ex) {
            System.err.print("No se puede encontra el archivo");
            throw new FileNotFoundException("No se puede encontra el archivo");
        } catch (IOException ex) {
            System.err.print("Error al leer el archivo");
            throw new IOException("Error al leer el archivo");
        }

    }

    public void imprimepersona(List<Persona> list) {

        try {
            listaPersona = list;
        } catch (Exception ex) {
            System.err.print("Error al leer el archivo");
        }
        for (Persona x : listaPersona) {
            System.out.println(" Nombre: " + x.getNombre() + " Apellido: " + x.getApellido() + " correo: " + x.getCorreo());
            for (Reporte r : x.getReport()) {
                if (r.isEstado() == false) {
                    System.out.println(" codigo: " + r.getCodigo() + " Empresa: " + r.getEmpresa() + " Descricion: " + r.getDescripcion() + " Valor: " + r.getValor());
                }
            }

        }
    }
    
}
