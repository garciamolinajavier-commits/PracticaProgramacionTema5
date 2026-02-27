/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package joo;

/**
 *
 * @author javic
 */
public abstract class Participante {

    // Atributos
    protected String nombre;
    protected String pais;
    protected int edad;
    protected String idOlimpico;
    protected int totalMedallas;

    // Constructor por defecto
    public Participante() {
        this.nombre = "Desconocido";
        this.pais = "Desconocido";
        this.edad = 0;
        this.idOlimpico = "000";
        this.totalMedallas = 0;
    }

    // Constructor por parámetros
    public Participante(String nombre, String pais, int edad, String idOlimpico) {
        this.nombre = nombre;
        this.pais = pais;
        this.edad = edad;
        this.idOlimpico = idOlimpico;
        this.totalMedallas = 0;
    }

    // Constructor de copia
    public Participante(Participante otro) {
        this.nombre = otro.nombre;
        this.pais = otro.pais;
        this.edad = otro.edad;
        this.idOlimpico = otro.idOlimpico;
        this.totalMedallas = otro.totalMedallas;
    }

    // Getters
    public String getNombre() {
        return this.nombre;
    }

    public String getPais() {
        return this.pais;
    }

    public int getEdad() {
        return this.edad;
    }

    public String getIdOlimpico() {
        return this.idOlimpico;
    }

    public int getTotalMedallas() {
        return this.totalMedallas;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setIdOlimpico(String idOlimpico) {
        this.idOlimpico = idOlimpico;
    }

    public void setTotalMedallas(int totalMedallas) {
        this.totalMedallas = totalMedallas;
    }

    // Métodos personalizados
    public void recibirMedalla() {
        this.totalMedallas++;
    }

    public int calcularTotalMedallas() {
        return this.totalMedallas;
    }

    // Método abstracto: cada tipo de participante muestra su información de forma distinta
    public abstract void mostrarInformacion();

    // toString
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", País: " + pais + ", Edad: " + edad
                + ", ID Olímpico: " + idOlimpico + ", Medallas: " + totalMedallas;
    }
}
