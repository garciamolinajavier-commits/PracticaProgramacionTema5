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
public abstract class Participantes {
    protected String nombre;
    protected String pais;
    protected int edad;
    protected int numIdentificativo;
    protected int numeroMedallas;

    public Participantes(String nombre, String pais, int edad, int numIdentificativo, int numeroMedallas) {
        this.nombre = nombre;
        this.pais = pais;
        this.edad = edad;
        this.numIdentificativo = numIdentificativo;
        this.numeroMedallas = numeroMedallas;
    }
    
    public Participantes(){
        this.nombre = "";
        this.pais = "";
        this.edad = 0;
        this.numIdentificativo = 0;
        this.numeroMedallas = 0;
    }
    public Participantes (Participantes ParticipantesCopia){
        this.nombre = ParticipantesCopia.nombre;
        this.pais = ParticipantesCopia.pais;
        this.edad = ParticipantesCopia.edad;
        this.numIdentificativo = ParticipantesCopia.numIdentificativo;
        this.numeroMedallas = ParticipantesCopia.numeroMedallas;
    }
    
}
