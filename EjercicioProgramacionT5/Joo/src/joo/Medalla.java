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
public class Medalla {

    // Contador estático del total de medallas otorgadas en los Juegos
    public static int totalMedallasOtorgadas = 0;

    // Atributos
    private String tipo; // "Oro", "Plata", "Bronce"
    private String nombrePrueba;
    private Participante participante;

    // Constructor por defecto
    public Medalla() {
        this.tipo = "Sin tipo";
        this.nombrePrueba = "Sin prueba";
        this.participante = null;
    }

    // Constructor por parámetros
    public Medalla(String tipo, String nombrePrueba, Participante participante) {
        this.tipo = tipo;
        this.nombrePrueba = nombrePrueba;
        this.participante = participante;
        totalMedallasOtorgadas++;
    }

    // Constructor de copia
    public Medalla(Medalla otra) {
        this.tipo = otra.tipo;
        this.nombrePrueba = otra.nombrePrueba;
        this.participante = otra.participante;
    }

    // Getters
    public String getTipo() {
        return this.tipo;
    }

    public String getNombrePrueba() {
        return this.nombrePrueba;
    }

    public Participante getParticipante() {
        return this.participante;
    }

    public static int getTotalMedallasOtorgadas() {
        return totalMedallasOtorgadas;
    }

    // Setters
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNombrePrueba(String nombrePrueba) {
        this.nombrePrueba = nombrePrueba;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    // toString
    @Override
    public String toString() {
        return "Medalla de " + tipo + " en " + nombrePrueba + " para " + participante.getNombre();
    }
}