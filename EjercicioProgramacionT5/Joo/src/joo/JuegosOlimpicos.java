/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package joo;

/**
 *
 * @author javic
 */
public class JuegosOlimpicos {

    // Atributos
    private String nombreEvento;
    private int anio;
    private String ciudadSede;
    private Deporte[] deportes;
    private int numDeportes;
    private Participante[] participantes;
    private int numParticipantes;

    private static final int MAX_DEPORTES = 50;
    private static final int MAX_PARTICIPANTES = 500;

    // Constructor por defecto
    public JuegosOlimpicos() {
        this.nombreEvento = "Juegos Olímpicos de Invierno";
        this.anio = 2024;
        this.ciudadSede = "Sin sede";
        this.deportes = new Deporte[MAX_DEPORTES];
        this.numDeportes = 0;
        this.participantes = new Participante[MAX_PARTICIPANTES];
        this.numParticipantes = 0;
    }

    // Constructor por parámetros
    public JuegosOlimpicos(String nombreEvento, int anio, String ciudadSede) {
        this.nombreEvento = nombreEvento;
        this.anio = anio;
        this.ciudadSede = ciudadSede;
        this.deportes = new Deporte[MAX_DEPORTES];
        this.numDeportes = 0;
        this.participantes = new Participante[MAX_PARTICIPANTES];
        this.numParticipantes = 0;
    }

    // Constructor de copia
    public JuegosOlimpicos(JuegosOlimpicos otros) {
        this.nombreEvento = otros.nombreEvento;
        this.anio = otros.anio;
        this.ciudadSede = otros.ciudadSede;
        this.deportes = new Deporte[MAX_DEPORTES];
        this.numDeportes = otros.numDeportes;
        for (int i = 0; i < otros.numDeportes; i++) {
            this.deportes[i] = otros.deportes[i];
        }
        this.participantes = new Participante[MAX_PARTICIPANTES];
        this.numParticipantes = otros.numParticipantes;
        for (int i = 0; i < otros.numParticipantes; i++) {
            this.participantes[i] = otros.participantes[i];
        }
    }

    // Getters
    public String getNombreEvento() {
        return this.nombreEvento;
    }

    public int getAnio() {
        return this.anio;
    }

    public String getCiudadSede() {
        return this.ciudadSede;
    }

    public int getNumDeportes() {
        return this.numDeportes;
    }

    public int getNumParticipantes() {
        return this.numParticipantes;
    }

    // Setters
    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setCiudadSede(String ciudadSede) {
        this.ciudadSede = ciudadSede;
    }

    // Métodos personalizados

    // Registrar nuevo deporte
    public boolean registrarDeporte(Deporte deporte) {
        if (numDeportes >= MAX_DEPORTES) {
            System.out.println("No se pueden registrar más deportes.");
            return false;
        }
        deportes[numDeportes] = deporte;
        numDeportes++;
        System.out.println("Deporte '" + deporte.getNombre() + "' registrado en los Juegos.");
        return true;
    }

    // Registrar nuevo deportista individual
    public boolean registrarDeportista(DeportistaIndividual deportista) {
        if (numParticipantes >= MAX_PARTICIPANTES) {
            System.out.println("No se pueden registrar más participantes.");
            return false;
        }
        participantes[numParticipantes] = deportista;
        numParticipantes++;
        System.out.println("Deportista '" + deportista.getNombre() + "' registrado en los Juegos.");
        return true;
    }

    // Crear equipo y registrarlo
    public boolean crearEquipo(Equipo equipo) {
        if (numParticipantes >= MAX_PARTICIPANTES) {
            System.out.println("No se pueden registrar más participantes.");
            return false;
        }
        participantes[numParticipantes] = equipo;
        numParticipantes++;
        System.out.println("Equipo '" + equipo.getNombreEquipo() + "' registrado en los Juegos.");
        return true;
    }

    // Inscribir participante en una prueba de un deporte
    public boolean inscribirParticipante(String nombreDeporte, String nombrePrueba, Participante participante) {
        Deporte deporte = buscarDeporte(nombreDeporte);
        if (deporte == null) {
            System.out.println("Error: Deporte '" + nombreDeporte + "' no encontrado.");
            return false;
        }
        Prueba prueba = deporte.buscarPrueba(nombrePrueba);
        if (prueba == null) {
            System.out.println("Error: Prueba '" + nombrePrueba + "' no encontrada en " + nombreDeporte + ".");
            return false;
        }
        return prueba.registrarParticipante(participante);
    }

    // Buscar deporte por nombre
    public Deporte buscarDeporte(String nombre) {
        for (int i = 0; i < numDeportes; i++) {
            if (deportes[i].getNombre().equals(nombre)) {
                return deportes[i];
            }
        }
        return null;
    }

    // Buscar participante por nombre
    public Participante buscarParticipante(String nombre) {
        for (int i = 0; i < numParticipantes; i++) {
            if (participantes[i].getNombre().equals(nombre)) {
                return participantes[i];
            }
        }
        return null;
    }

    // Mostrar el medallero general por país
    public void mostrarMedallero() {
        System.out.println("=== MEDALLERO GENERAL POR PAÍS ===");

        // Recopilar países únicos
        String[] paises = new String[MAX_PARTICIPANTES];
        int[] medallas = new int[MAX_PARTICIPANTES];
        int numPaises = 0;

        for (int i = 0; i < numParticipantes; i++) {
            String pais = participantes[i].getPais();
            boolean encontrado = false;
            for (int j = 0; j < numPaises; j++) {
                if (paises[j].equals(pais)) {
                    medallas[j] += participantes[i].getTotalMedallas();
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                paises[numPaises] = pais;
                medallas[numPaises] = participantes[i].getTotalMedallas();
                numPaises++;
            }
        }

        // Ordenar por medallas (burbuja simple)
        for (int i = 0; i < numPaises - 1; i++) {
            for (int j = 0; j < numPaises - i - 1; j++) {
                if (medallas[j] < medallas[j + 1]) {
                    int tempM = medallas[j];
                    medallas[j] = medallas[j + 1];
                    medallas[j + 1] = tempM;
                    String tempP = paises[j];
                    paises[j] = paises[j + 1];
                    paises[j + 1] = tempP;
                }
            }
        }

        // Mostrar resultado
        for (int i = 0; i < numPaises; i++) {
            System.out.println((i + 1) + ". " + paises[i] + " - " + medallas[i] + " medallas");
        }
        System.out.println("Total de medallas otorgadas en los Juegos: " + Medalla.getTotalMedallasOtorgadas());
    }

    // Mostrar el participante con más medallas
    public void mostrarParticipanteMasMedallas() {
        if (numParticipantes == 0) {
            System.out.println("No hay participantes registrados.");
            return;
        }
        Participante mejor = participantes[0];
        for (int i = 1; i < numParticipantes; i++) {
            if (participantes[i].getTotalMedallas() > mejor.getTotalMedallas()) {
                mejor = participantes[i];
            }
        }
        System.out.println("=== PARTICIPANTE CON MÁS MEDALLAS ===");
        mejor.mostrarInformacion();
    }

    // toString
    @Override
    public String toString() {
        return "Evento: " + nombreEvento + ", Año: " + anio + ", Sede: " + ciudadSede
                + ", Deportes: " + numDeportes + ", Participantes: " + numParticipantes;
    }
}