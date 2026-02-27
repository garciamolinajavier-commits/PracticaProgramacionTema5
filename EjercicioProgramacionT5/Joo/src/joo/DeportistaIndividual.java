/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package joo;

/**
 *
 * @author javic
 */
public class DeportistaIndividual extends Participante {

    // Atributos propios
    private String especialidad;

    // Constructor por defecto
    public DeportistaIndividual() {
        super();
        this.especialidad = "Sin especialidad";
    }

    // Constructor por parámetros
    public DeportistaIndividual(String nombre, String pais, int edad, String idOlimpico, String especialidad) {
        super(nombre, pais, edad, idOlimpico);
        this.especialidad = especialidad;
    }

    // Constructor de copia
    public DeportistaIndividual(DeportistaIndividual otro) {
        super(otro);
        this.especialidad = otro.especialidad;
    }

    // Getter
    public String getEspecialidad() {
        return this.especialidad;
    }

    // Setter
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    // Método mostrarInformacion sobrescrito
    @Override
    public void mostrarInformacion() {
        System.out.println("=== DEPORTISTA INDIVIDUAL ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("País: " + pais);
        System.out.println("Edad: " + edad);
        System.out.println("ID Olímpico: " + idOlimpico);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Total medallas: " + totalMedallas);
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + ", Especialidad: " + especialidad;
    }
}
