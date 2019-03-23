/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reportecredito;

import java.util.List;

/**
 *
 * @author Laura
 */
public class Principal {

    public static void main(String[] args) throws Exception {

        Inicio ini = new Inicio();

        List<Persona> listaPersona;
        listaPersona = ini.leerArchivo("info.txt");
        ini.imprimepersona(listaPersona);

    }
}
