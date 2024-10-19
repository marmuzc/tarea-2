package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class InformeReunion {
    private Reunion reunion; // Para obtener los datos de la reunión

    public InformeReunion(Reunion reunion) {
        this.reunion = reunion;
    }

    public void generarInformeTxt(String nombreArchivo, String enlaceSala) { // enlaceSala por si es presencial o virtual
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // Formato de fecha y hora

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write("=== Informe de la Reunión ===\n");
            writer.write("Fecha: " + reunion.getFecha()); // Formatear la fecha
            writer.write("Hora Prevista: " + reunion.getHoraPrevista()); // Formatear la hora prevista
            writer.write("Hora de Inicio: " + (reunion.getHorarioInicio() != null ? reunion.getHorarioInicio() : "No iniciada") + "\n"); // Formatear la hora de inicio
            writer.write("Hora de Fin: " + (reunion.getHoraFin() != null ? reunion.getHoraFin() : "No finalizada") + "\n"); // Formatear la hora de fin
            writer.write("Duración Total: " + (reunion.calcularTiempoReal() > 0 ? reunion.calcularTiempoReal() + " minutos" : "No disponible") + "\n");
            writer.write("Duración Prevista: " + reunion.getDuracionPrevista().toMinutes() + " minutos\n");
            writer.write("Porcentaje de Asistencia: " + reunion.obtenerPorcentajeAsistencia() + "%\n");
            writer.write("Enlace/Sala: " + enlaceSala + "\n");
            writer.write("Notas: " + (reunion.getNota() != null ? reunion.getNota() : "No hay notas disponibles") + "\n");

            writer.write("\n=== Asistentes ===\n");
            List<Asistencia> asistentes = reunion.obtenerAsistencias(); // Asumiendo que devuelve una lista de Asistencia
            for (Asistencia asistencia : asistentes) {
                writer.write(asistencia.getEmpleado().toString() + "\n"); // Obtener el empleado de la asistencia
            }

            writer.write("\n=== Retrasados ===\n");
            List<Retraso> retrasados = reunion.obtenerRetrasos(); // Asumiendo que devuelve una lista de Retraso
            for (Retraso retraso : retrasados) {
                writer.write(retraso.getEmpleado().toString() + "\n"); // Obtener el empleado de la lista de retrasados
            }

            writer.write("\n=== Ausentes ===\n");
            List<Empleado> ausentes = reunion.obtenerAusencias(); // Obtener los ausentes
            for (Empleado ausente : ausentes) {
                writer.write(ausente.toString() + "\n"); // Imprimir ausente
            }

            writer.write("\n=== Nota ===\n");
            writer.write(reunion.getNota() != null ? reunion.getNota().toString() : "No hay notas disponibles\n"); // Verificar si hay nota

            System.out.println("Informe guardado en: " + nombreArchivo);

        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}
