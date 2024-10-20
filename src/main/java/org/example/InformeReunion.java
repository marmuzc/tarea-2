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

    public void generarInformeTxt(String nombreArchivo, String enlaceSala) {
        // Validar si el nombre del archivo es nulo o vacío antes de hacer cualquier cosa
        if (nombreArchivo == null || nombreArchivo.isEmpty()) {
            throw new IllegalArgumentException("El nombre del archivo no puede estar vacío.");
        }

        // Asignar un valor por defecto si el enlace o sala es nulo
        if (enlaceSala == null) {
            enlaceSala = "No asignado";
        }

        // Mover la creación del archivo al bloque try-catch, después de la validación
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Escribir el contenido del informe
            writer.write("=== Informe de la Reunión ===\n");
            writer.write("Fecha: " + reunion.getFecha() + "\n");
            writer.write("Hora Prevista: " + reunion.getHoraPrevista() + "\n");
            writer.write("Hora de Inicio: " + (reunion.getHorarioInicio() != null ? reunion.getHorarioInicio() : "No iniciada") + "\n");
            writer.write("Hora de Fin: " + (reunion.getHoraFin() != null ? reunion.getHoraFin() : "No finalizada") + "\n");
            writer.write("Tipo de Reunión: " + reunion.getTipo() + "\n");
            writer.write("Organizador: " + reunion.getOrganizador().toString() + "\n");
            writer.write("Duración Total: " + (reunion.calcularTiempoReal() > 0 ? reunion.calcularTiempoReal() + " minutos" : "No disponible") + "\n");
            writer.write("Duración Prevista: " + reunion.getDuracionPrevista().toMinutes() + " minutos\n");
            writer.write("Porcentaje de Asistencia: " + reunion.obtenerPorcentajeAsistencia() + "%\n");
            writer.write("Enlace/Sala: " + enlaceSala + "\n");
            writer.write("Notas: " + (reunion.getNota() != null ? reunion.getNota() : "No hay notas disponibles") + "\n");

            // Asistentes
            writer.write("\n=== Asistentes ===\n");
            List<Asistencia> asistentes = reunion.obtenerAsistencias();
            for (Asistencia asistencia : asistentes) {
                writer.write(asistencia.getEmpleado().toString() + "\n");
            }

            // Retrasados
            writer.write("\n=== Retrasados ===\n");
            List<Retraso> retrasados = reunion.obtenerRetrasos();
            for (Retraso retraso : retrasados) {
                writer.write(retraso.getEmpleado().toString() + "\n");
            }

            // Ausentes
            writer.write("\n=== Ausentes ===\n");
            List<Empleado> ausentes = reunion.obtenerAusencias();
            for (Empleado ausente : ausentes) {
                writer.write(ausente.toString() + "\n");
            }

            // Nota
            writer.write("\n=== Nota ===\n");
            writer.write(reunion.getNota() != null ? reunion.getNota().toString() : "No hay notas disponibles\n");

            System.out.println("Informe guardado en: " + nombreArchivo);

        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}