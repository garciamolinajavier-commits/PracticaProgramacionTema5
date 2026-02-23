/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joo;

/**
 *
 * @author EAG
 */
public class Deportes {
    private String nombre;
    private String tipo;
    private int numMaximo;
    private Prueba[] pruebas;

    public Deportes(String nombre, String tipo, int numMaximo, Prueba[] pruebas) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.numMaximo = numMaximo;
        this.pruebas = pruebas;
    }
    
    public Deportes(){
        this.nombre = "";
        this.tipo = "";
        this.numMaximo = 0;
        this.pruebas = pruebas;
    }
}
