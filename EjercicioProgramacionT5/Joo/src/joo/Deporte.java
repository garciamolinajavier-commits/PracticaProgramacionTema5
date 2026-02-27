/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package joo;

/**
 *
 * @author javic
 */
public abstract class Deporte {

    // Atributos
    protected String nombre;
    protected String tipo; // "individual" o "por equipos"
    protected int maxParticipantesPorPrueba;
    protected Prueba[] pruebas;
    protected int numPruebas;
    private static final int MAX_PRUEBAS = 20;

    // Constructor por defecto
    public Deporte() {
        this.nombre = "Sin nombre";
        this.tipo = "individual";
        this.maxParticipantesPorPrueba = 10;
        this.pruebas = new Prueba[MAX_PRUEBAS];
        this.numPruebas = 0;
    }

    // Constructor por parámetros
    public Deporte(String nombre, String tipo, int maxParticipantesPorPrueba) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.maxParticipantesPorPrueba = maxParticipantesPorPrueba;
        this.pruebas = new Prueba[MAX_PRUEBAS];
        this.numPruebas = 0;
    }

    // Constructor de copia
    public Deporte(Deporte otro) {
        this.nombre = otro.nombre;
        this.tipo = otro.tipo;
        this.maxParticipantesPorPrueba = otro.maxParticipantesPorPrueba;
        this.pruebas = new Prueba[MAX_PRUEBAS];
        this.numPruebas = otro.numPruebas;
        for (int i = 0; i < otro.numPruebas; i++) {
            this.pruebas[i] = otro.pruebas[i];
        }
    }

    // Getters
    public String getNombre() {
        return this.nombre;
    }

    public String getTipo() {
        return this.tipo;
    }

    public int getMaxParticipantesPorPrueba() {
        return this.maxParticipantesPorPrueba;
    }

    public int getNumPruebas() {
        return this.numPruebas;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMaxParticipantesPorPrueba(int max) {
        this.maxParticipantesPorPrueba = max;
    }

    // Métodos personalizados

    // Agregar una prueba al deporte
    public boolean agregarPrueba(Prueba prueba) {
        if (numPruebas >= MAX_PRUEBAS) {
            System.out.println("No se pueden añadir más pruebas al deporte " + nombre + ".");
            return false;
        }
        pruebas[numPruebas] = prueba;
        numPruebas++;
        System.out.println("Prueba '" + prueba.getNombre() + "' añadida al deporte " + nombre + ".");
        return true;
    }

    // Buscar prueba por nombre
    public Prueba buscarPrueba(String nombrePrueba) {
        for (int i = 0; i < numPruebas; i++) {
            if (pruebas[i].getNombre().equals(nombrePrueba)) {
                return pruebas[i];
            }
        }
        return null;
    }

    // Mostrar todas las pruebas del deporte
    public void mostrarPruebas() {
        System.out.println("=== Pruebas del deporte: " + nombre + " ===");
        if (numPruebas == 0) {
            System.out.println("No hay pruebas registradas.");
        }
        for (int i = 0; i < numPruebas; i++) {
            System.out.println("  " + pruebas[i].toString());
        }
    }

    // Método abstracto que cada tipo de deporte implementa
    public abstract void mostrarInformacion();

    // toString
    @Override
    public String toString() {
        return "Deporte: " + nombre + ", Tipo: " + tipo + ", Max participantes/prueba: " + maxParticipantesPorPrueba + ", Pruebas: " + numPruebas;
    }
}