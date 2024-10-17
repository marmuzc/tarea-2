import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class informeReunion {
    private Reunion reunion; //pa obtener los datos de la reunion

    public informeReunion(Reunion reunion) {
        this.reunion = reunion;
    }

    public void generarInformeTxt(String nombreArchivo, String enlaceSala) { //enlace sala porq no se como ver si es presencial o virtual
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); //formato de fecha y hora

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write("=== Informe de la Reunión ===\n");
            writer.write("Fecha: " + reunion.getFecha() + "\n");
            writer.write("Hora Prevista: " + reunion.getHoraPrevista() + "\n");
            writer.write("Hora de Inicio: " + (reunion.getHorarioInicio() != null ? reunion.getHorarioInicio() : "No iniciada") + "\n");
            writer.write("Hora de Fin: " + (reunion.getHoraFin() != null ? reunion.getHoraFin() : "No finalizada") + "\n");
            writer.write("Duración Total: " + (reunion.calcularTiempoReal() > 0 ? reunion.calcularTiempoReal() + " minutos" : "No disponible") + "\n");
            writer.write("Duración Prevista: " + reunion.getDuracionPrevista().toMinutes() + " minutos\n");
            writer.write("Porcentaje de Asistencia: " + reunion.obtenerPorcentajeAsistencia() + "%\n");
            writer.write("Enlace/Sala: " + enlaceSala + "\n");

            writer.write("\n=== Asistentes ===\n");
            List<Empleado> asistentes = reunion.obtenerAsistencias();
            for (Empleado participante : asistentes) {
                writer.write(participante.toString() + "\n");
            }

            writer.write("\n=== Retrasados ===\n");
            List<Empleado> retrasados = reunion.obtenerRetrasos();
            for (Empleado retrasado : retrasados) {
                writer.write(retrasado.toString() + "\n");
            }

            writer.write("\n===  Ausentes ===\n");
            List<Empleado> ausentes = reunion.obtenerAusencias();
            for (Empleado ausente : ausentes) {
                writer.write(ausente.toString() + "\n");
            }

            writer.write("\n=== Nota ===\n");
            writer.write(reunion.getNota().toString() + "\n");

            System.out.println("Informe guardado en: " + nombreArchivo);

        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}
