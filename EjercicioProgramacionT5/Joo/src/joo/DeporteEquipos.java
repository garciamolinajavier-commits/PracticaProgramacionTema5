/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package joo;

/**
 *
 * @author javic
 */
public class DeporteEquipos extends Deporte {

    // Constructor por defecto
    public DeporteEquipos() {
        super();
        this.tipo = "por equipos";
    }

    // Constructor por parámetros
    public DeporteEquipos(String nombre, int maxParticipantesPorPrueba) {
        super(nombre, "por equipos", maxParticipantesPorPrueba);
    }

    // Constructor de copia
    public DeporteEquipos(DeporteEquipos otro) {
        super(otro);
    }

    // Mostrar información sobrescrito
    @Override
    public void mostrarInformacion() {
        System.out.println("=== DEPORTE POR EQUIPOS ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Tipo: " + tipo);
        System.out.println("Máximo equipos por prueba: " + maxParticipantesPorPrueba);
        System.out.println("Número de pruebas: " + numPruebas);
    }

    // toString
    @Override
    public String toString() {
        return "[Por Equipos] " + super.toString();
    }
}
