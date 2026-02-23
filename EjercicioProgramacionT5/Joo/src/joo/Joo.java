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
public class Joo {

    private String nombreEvento;
    private int año;
    private String sede;
    private Deportes listaDeportes;
    private Participantes listaParticipantes;

    public Joo(String nombreEvento, int año, String sede, Deportes listaDeportes, Participantes listaParticipantes) {
        this.nombreEvento = nombreEvento;
        this.año = año;
        this.sede = sede;
        this.listaDeportes = listaDeportes;
        this.listaParticipantes = listaParticipantes;
    }
    
    public Joo(){
        this.nombreEvento = "";
        this.año = 0;
        this.sede = "";
    }
    public Joo(Joo JooCopiar){
        this.nombreEvento = JooCopiar.nombreEvento;
        this.año = JooCopiar.año;
        this.sede = JooCopiar.sede;
        this.listaDeportes = JooCopiar.listaDeportes;
        this.listaParticipantes = JooCopiar.listaParticipantes;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public int getAño() {
        return año;
    }

    public String getSede() {
        return sede;
    }

    public Deportes getListaDeportes() {
        return listaDeportes;
    }

    public Participantes getListaParticipantes() {
        return listaParticipantes;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public void setListaDeportes(Deportes listaDeportes) {
        this.listaDeportes = listaDeportes;
    }

    public void setListaParticipantes(Participantes listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }
    
}
