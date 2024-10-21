package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * La clase {@code InformeReunion} genera un informe detallado sobre una reunión 
 * con los datos de asistencia, tiempos, notas y estado general de la misma.
 */
public class InformeReunion {

    /** La reunión asociada para la cual se generará el informe. */
    private Reunion reunion;

    /**
     * Crea una nueva instancia de {@code InformeReunion} con la reunión proporcionada.
     *
     * @param reunion La reunión cuyos datos se utilizarán en el informe.
     */
    public InformeReunion(Reunion reunion) {
        this.reunion = reunion;
    }

    /**
     * Genera un informe en formato de texto con los detalles de la reunión y lo guarda en un archivo.
     *
     * @param nombreArchivo El nombre del archivo donde se guardará el informe.
     * @param enlaceSala    El enlace o sala física/virtual donde se realizó la reunión.
     */
    public void generarInformeTxt(String nombreArchivo, String enlaceSala) {

        /**
         * Valida si el nombre del archivo es nulo o está vacío.
         * Si el nombre del archivo no es válido, lanza una excepción.
         *
         * @param nombreArchivo El nombre del archivo a validar.
         * @throws IllegalArgumentException Si el nombre del archivo es nulo o vacío.
         */
        if (nombreArchivo == null || nombreArchivo.isEmpty()) {
            throw new IllegalArgumentException("El nombre del archivo no puede estar vacío.");
        }

        /**
         * Asigna un valor por defecto al enlace de la sala si es nulo.
         * Si el valor de enlaceSala es nulo, se asigna el texto "No asignado".
         *
         * @param enlaceSala El enlace o sala que puede ser nulo.
         *                   Si es nulo, se asigna el valor por defecto.
         */
        if (enlaceSala == null) {
            enlaceSala = "No asignado";
        }


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write(toString()); // Usamos el método toString para evitar duplicar código
            writer.write("Enlace/Sala: " + enlaceSala + "\n");

            System.out.println("Informe guardado en: " + nombreArchivo);

        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    /**
     * Convierte un {@code Instant} a {@code LocalDateTime} usando la zona horaria por defecto del sistema.
     *
     * @param instant El instante de tiempo a convertir.
     * @return Una instancia de {@code LocalDateTime}.
     */
    private LocalDateTime convertirInstant(Instant instant) {
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    /**
     * Devuelve una representación en forma de cadena con los detalles de la reunión.
     *
     * @return Una cadena con información detallada de la reunión.
     */

         /**
     * Convierte un {@code Date} a {@code LocalDateTime} usando la zona horaria del sistema.
     *
     * @param date El objeto {@code Date} a convertir.
     * @return Una instancia de {@code LocalDateTime}.
     */
    private LocalDateTime convertirDate(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * Devuelve una representación en forma de cadena con los detalles de la reunión.
     *
     * @return Una cadena con información detallada de la reunión.
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss yyyy-MM-dd");
        StringBuilder sb = new StringBuilder();

        sb.append("=== Informe de la Reunión ===\n");
        sb.append("Fecha: ").append(convertirDate(reunion.getFecha()).format(formatter)).append("\n");
        sb.append("Hora Prevista: ").append(convertirInstant(reunion.getHoraPrevista()).format(formatter)).append("\n");
        sb.append("Hora de Inicio: ").append(
                reunion.getHorarioInicio() != null ? 
                convertirInstant(reunion.getHorarioInicio()).format(formatter) : "No iniciada").append("\n");
        sb.append("Hora de Fin: ").append(
                reunion.getHoraFin() != null ? 
                convertirInstant(reunion.getHoraFin()).format(formatter) : "No finalizada").append("\n");
        sb.append("Duración Total: ").append(
                reunion.calcularTiempoReal() > 0 ? reunion.calcularTiempoReal() + " minutos" : "No disponible").append("\n");
        sb.append("Duración Prevista: ").append(reunion.getDuracionPrevista().toMinutes()).append(" minutos\n");
        sb.append("Porcentaje de Asistencia: ").append(reunion.obtenerPorcentajeAsistencia()).append("%\n");
        sb.append("Notas: ").append(reunion.getNota() != null ? reunion.getNota() : "No hay notas disponibles").append("\n");

        sb.append("\n=== Asistentes ===\n");
        for (Asistencia asistencia : reunion.obtenerAsistencias()) {
            sb.append(asistencia.getEmpleado()).append("\n");
        }

        sb.append("\n=== Retrasados ===\n");
        for (Retraso retraso : reunion.obtenerRetrasos()) {
            sb.append(retraso.getEmpleado()).append("\n");
        }

        sb.append("\n=== Ausentes ===\n");
        for (Empleado ausente : reunion.obtenerAusencias()) {
            sb.append(ausente).append("\n");
        }

        sb.append("\n=== Nota ===\n");
        sb.append(reunion.getNota() != null ? reunion.getNota().toString() : "No hay notas disponibles\n");

        return sb.toString();
    }
}
