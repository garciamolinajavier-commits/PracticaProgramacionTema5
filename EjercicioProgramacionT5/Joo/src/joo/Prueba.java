/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joo;
public class Prueba {

    // Atributos
    private String nombre;
    private String fechaCelebracion;
    private Participante[] participantes;
    private int numParticipantes;
    private int maxParticipantes;
    private String resultadoFinal;
    private Medalla[] medallas;
    private int numMedallas;
    private boolean esIndividual; // true = individual, false = por equipos

    // Constructor por defecto
    public Prueba() {
        this.nombre = "Sin nombre";
        this.fechaCelebracion = "Sin fecha";
        this.maxParticipantes = 10;
        this.participantes = new Participante[this.maxParticipantes];
        this.numParticipantes = 0;
        this.resultadoFinal = null;
        this.medallas = new Medalla[3];
        this.numMedallas = 0;
        this.esIndividual = true;
    }

    // Constructor por parámetros
    public Prueba(String nombre, String fechaCelebracion, int maxParticipantes, boolean esIndividual) {
        this.nombre = nombre;
        this.fechaCelebracion = fechaCelebracion;
        this.maxParticipantes = maxParticipantes;
        this.participantes = new Participante[maxParticipantes];
        this.numParticipantes = 0;
        this.resultadoFinal = null;
        this.medallas = new Medalla[3];
        this.numMedallas = 0;
        this.esIndividual = esIndividual;
    }

    // Constructor de copia
    public Prueba(Prueba otra) {
        this.nombre = otra.nombre;
        this.fechaCelebracion = otra.fechaCelebracion;
        this.maxParticipantes = otra.maxParticipantes;
        this.participantes = new Participante[otra.maxParticipantes];
        this.numParticipantes = otra.numParticipantes;
        for (int i = 0; i < otra.numParticipantes; i++) {
            this.participantes[i] = otra.participantes[i];
        }
        this.resultadoFinal = otra.resultadoFinal;
        this.medallas = new Medalla[3];
        this.numMedallas = otra.numMedallas;
        for (int i = 0; i < otra.numMedallas; i++) {
            this.medallas[i] = otra.medallas[i];
        }
        this.esIndividual = otra.esIndividual;
    }

    // Getters
    public String getNombre() {
        return this.nombre;
    }

    public String getFechaCelebracion() {
        return this.fechaCelebracion;
    }

    public int getNumParticipantes() {
        return this.numParticipantes;
    }

    public int getMaxParticipantes() {
        return this.maxParticipantes;
    }

    public String getResultadoFinal() {
        return this.resultadoFinal;
    }

    public int getNumMedallas() {
        return this.numMedallas;
    }

    public boolean isEsIndividual() {
        return this.esIndividual;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaCelebracion(String fechaCelebracion) {
        this.fechaCelebracion = fechaCelebracion;
    }

    public void setResultadoFinal(String resultadoFinal) {
        this.resultadoFinal = resultadoFinal;
    }

    public void setEsIndividual(boolean esIndividual) {
        this.esIndividual = esIndividual;
    }

    // Métodos personalizados

    // Registrar participante con todas las restricciones
    public boolean registrarParticipante(Participante p) {
        // Restricción: no puede inscribirse dos veces
        for (int i = 0; i < numParticipantes; i++) {
            if (participantes[i].getIdOlimpico().equals(p.getIdOlimpico())) {
                System.out.println("Error: " + p.getNombre() + " ya está inscrito en la prueba " + nombre + ".");
                return false;
            }
        }
        // Restricción: no superar el máximo de participantes
        if (numParticipantes >= maxParticipantes) {
            System.out.println("Error: La prueba " + nombre + " ha alcanzado el máximo de participantes.");
            return false;
        }
        // Restricción: modalidad compatible
        if (esIndividual && !(p instanceof DeportistaIndividual)) {
            System.out.println("Error: Solo deportistas individuales pueden participar en " + nombre + ".");
            return false;
        }
        if (!esIndividual && !(p instanceof Equipo)) {
            System.out.println("Error: Solo equipos pueden participar en " + nombre + ".");
            return false;
        }

        participantes[numParticipantes] = p;
        numParticipantes++;
        System.out.println(p.getNombre() + " inscrito en la prueba " + nombre + ".");
        return true;
    }

    // Registrar resultado final
    public void registrarResultado(String resultado) {
        this.resultadoFinal = resultado;
        System.out.println("Resultado registrado en " + nombre + ": " + resultado);
    }

    // Asignar medalla con todas las restricciones
    public boolean asignarMedalla(String tipo, Participante participante) {
        // Restricción: debe estar registrado el resultado
        if (resultadoFinal == null) {
            System.out.println("Error: No se puede asignar medalla sin resultado final en " + nombre + ".");
            return false;
        }
        // Restricción: solo 3 medallas por prueba
        if (numMedallas >= 3) {
            System.out.println("Error: Ya se han otorgado las 3 medallas en la prueba " + nombre + ".");
            return false;
        }
        // Verificar que el tipo sea válido
        if (!tipo.equals("Oro") && !tipo.equals("Plata") && !tipo.equals("Bronce")) {
            System.out.println("Error: Tipo de medalla no válido. Use Oro, Plata o Bronce.");
            return false;
        }

        Medalla medalla = new Medalla(tipo, nombre, participante);
        medallas[numMedallas] = medalla;
        numMedallas++;
        participante.recibirMedalla();

        System.out.println("Medalla de " + tipo + " asignada a " + participante.getNombre() + " en " + nombre + ".");
        return true;
    }

    // Mostrar clasificación final
    public void mostrarClasificacion() {
        System.out.println("=== CLASIFICACIÓN FINAL: " + nombre + " (" + fechaCelebracion + ") ===");
        if (resultadoFinal == null) {
            System.out.println("Aún no hay resultado registrado.");
        } else {
            System.out.println("Resultado: " + resultadoFinal);
        }
        System.out.println("Participantes inscritos: " + numParticipantes);
        for (int i = 0; i < numParticipantes; i++) {
            System.out.println("  " + (i + 1) + ". " + participantes[i].getNombre() + " (" + participantes[i].getPais() + ")");
        }
        System.out.println("Medallas asignadas:");
        if (numMedallas == 0) {
            System.out.println("  Ninguna aún.");
        }
        for (int i = 0; i < numMedallas; i++) {
            System.out.println("  " + medallas[i].toString());
        }
    }

    // toString
    @Override
    public String toString() {
        return "Prueba: " + nombre + ", Fecha: " + fechaCelebracion + ", Participantes: " + numParticipantes + "/" + maxParticipantes;
    }
}