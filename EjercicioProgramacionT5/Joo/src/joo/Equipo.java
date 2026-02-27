/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joo;

public class Equipo extends Participante {

    // Atributos propios
    private String nombreEquipo;
    private DeportistaIndividual[] miembros;
    private int numMiembros;
    private static final int MAX_MIEMBROS = 20;

    // Constructor por defecto
    public Equipo() {
        super();
        this.nombreEquipo = "Equipo sin nombre";
        this.miembros = new DeportistaIndividual[MAX_MIEMBROS];
        this.numMiembros = 0;
    }

    // Constructor por parámetros
    public Equipo(String nombreEquipo, String pais, String idOlimpico) {
        super(nombreEquipo, pais, 0, idOlimpico);
        this.nombreEquipo = nombreEquipo;
        this.miembros = new DeportistaIndividual[MAX_MIEMBROS];
        this.numMiembros = 0;
    }

    // Constructor de copia
    public Equipo(Equipo otro) {
        super(otro);
        this.nombreEquipo = otro.nombreEquipo;
        this.miembros = new DeportistaIndividual[MAX_MIEMBROS];
        this.numMiembros = otro.numMiembros;
        for (int i = 0; i < otro.numMiembros; i++) {
            this.miembros[i] = otro.miembros[i];
        }
    }

    // Getters
    public String getNombreEquipo() {
        return this.nombreEquipo;
    }

    public int getNumMiembros() {
        return this.numMiembros;
    }

    // Setters
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    // Métodos personalizados

    // Añadir miembro: todos deben ser del mismo país
    public boolean agregarMiembro(DeportistaIndividual deportista) {
        if (numMiembros >= MAX_MIEMBROS) {
            System.out.println("El equipo " + nombreEquipo + " está lleno.");
            return false;
        }
        if (!deportista.getPais().equals(this.pais)) {
            System.out.println("Error: " + deportista.getNombre() + " no es del mismo país que el equipo (" + this.pais + ").");
            return false;
        }
        miembros[numMiembros] = deportista;
        numMiembros++;
        System.out.println(deportista.getNombre() + " añadido al equipo " + nombreEquipo + ".");
        return true;
    }

    // Si el equipo recibe medalla, todos los miembros la reciben también
    @Override
    public void recibirMedalla() {
        this.totalMedallas++;
        for (int i = 0; i < numMiembros; i++) {
            miembros[i].recibirMedalla();
        }
    }

    // Mostrar información sobrescrito
    @Override
    public void mostrarInformacion() {
        System.out.println("=== EQUIPO ===");
        System.out.println("Nombre del equipo: " + nombreEquipo);
        System.out.println("País: " + pais);
        System.out.println("ID Olímpico: " + idOlimpico);
        System.out.println("Número de miembros: " + numMiembros);
        System.out.println("Total medallas del equipo: " + totalMedallas);
        System.out.println("Miembros:");
        for (int i = 0; i < numMiembros; i++) {
            System.out.println("  - " + miembros[i].getNombre());
        }
    }

    // toString
    @Override
    public String toString() {
        return "Equipo: " + nombreEquipo + ", País: " + pais + ", Miembros: " + numMiembros + ", Medallas: " + totalMedallas;
    }
}