import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;


public class informeReunion {
    // Fecha y hora de la reunión
    private Date fecha;
    private Instant horaPrevista;
    private Instant horarioInicio;
    private Instant horaFin;
    private Duration duracionPrevista;

    // Lista de participantes y notas
    private List<Empleado> participantes;
    private List<Nota> notas;

    // Constructor
    public informeReunion(Date fecha, Instant horaPrevista, Instant horarioInicio, Instant horaFin, Duration duracionPrevista) {
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.horarioInicio = horarioInicio;
        this.horaFin = horaFin;
        this.duracionPrevista = duracionPrevista;
        this.participantes = new ArrayList<>();
        this.notas = new ArrayList<>();
    }

    public void agregarParticipante(Empleado empleado) {
        this.participantes.add(empleado);
    }

    public void agregarNota(Nota nota) {
        this.notas.add(nota);
    }

    public Duration getDuracionReunion() {
        if (horarioInicio != null && horaFin != null) {
            return Duration.between(horarioInicio, horaFin);
        }
        return null;
    }

    public Date getFecha() {
        return fecha;
    }

    public Instant getHoraPrevista() {
        return horaPrevista;
    }

    public Instant getHorarioInicio() {
        return horarioInicio;
    }

    public Instant getHoraFin() {
        return horaFin;
    }

    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }

    public List<Empleado> getParticipantes() {
        return participantes;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void generarInformeTxt(String nombreArchivo, String tipoReunion, String enlaceSala) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write("=== Informe de la Reunión ===\n");
            writer.write("Fecha: " + fecha + "\n");
            writer.write("Hora Prevista: " + horaPrevista + "\n");
            writer.write("Hora de Inicio: " + (horarioInicio != null ? horarioInicio : "No iniciada") + "\n");
            writer.write("Hora de Fin: " + (horaFin != null ? horaFin : "No finalizada") + "\n");
            writer.write("Duración Total: " + (getDuracionReunion() != null ? getDuracionReunion().toMinutes() + " minutos" : "No disponible") + "\n");
            writer.write("Duración Prevista: " + duracionPrevista.toMinutes() + " minutos\n");
            writer.write("Tipo de Reunión: " + tipoReunion + "\n");
            writer.write("Enlace/Sala: " + enlaceSala + "\n");

            // Agregar la lista de participantes
            writer.write("\n=== Participantes ===\n");
            for (Empleado participante : participantes) {
                writer.write(participante.toString() + "\n");
            }

            // Agregar las notas
            writer.write("\n=== Notas ===\n");
            for (Nota nota : notas) {
                writer.write(nota.toString() + "\n");
            }

            System.out.println("Informe guardado en: " + nombreArchivo);

        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}
