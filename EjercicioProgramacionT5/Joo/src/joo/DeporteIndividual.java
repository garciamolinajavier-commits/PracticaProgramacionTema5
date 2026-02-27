/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package joo;

/**
 *
 * @author javic
 */
public class DeporteIndividual extends Deporte {

    // Constructor por defecto
    public DeporteIndividual() {
        super();
        this.tipo = "individual";
    }

    // Constructor por parámetros
    public DeporteIndividual(String nombre, int maxParticipantesPorPrueba) {
        super(nombre, "individual", maxParticipantesPorPrueba);
    }

    // Constructor de copia
    public DeporteIndividual(DeporteIndividual otro) {
        super(otro);
    }

    // Mostrar información sobrescrito
    @Override
    public void mostrarInformacion() {
        System.out.println("=== DEPORTE INDIVIDUAL ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Tipo: " + tipo);
        System.out.println("Máximo participantes por prueba: " + maxParticipantesPorPrueba);
        System.out.println("Número de pruebas: " + numPruebas);
    }

    // toString
    @Override
    public String toString() {
        return "[Individual] " + super.toString();
    }
}
