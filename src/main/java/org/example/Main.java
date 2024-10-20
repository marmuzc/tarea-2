package org.example;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Crear una instancia de ReunionPresencial
        Date fechaReunion = new Date();
        Instant horaPrevista = Instant.now().plus(Duration.ofHours(1)); // Hora prevista de la reunión (1 hora después del momento actual)
        Duration duracionPrevista = Duration.ofHours(2); // Duración prevista de la reunión: 2 horas
        Empleado organizador = new Empleado("120", "Perez", "Juan", "@gmail.com");
        String sala = "Sala 101";
        tipoReunion tipo = tipoReunion.OTRO; // Tipo de la reunión (puede ser TECNICA, MARKETING, OTRO, etc.)

        // Crear la reunión presencial
        ReunionPresencial reunion = new ReunionPresencial(fechaReunion, horaPrevista, duracionPrevista, tipo, sala, organizador);

        // Crear empleados
        Empleado empleado1 = new Empleado("121", "Wato", "Ana", "anawato@gmail.com");
        Empleado empleado2 = new Empleado("122", "Sds", "Carlos", "carlos@gmail.com");
        Empleado empleado3 = new Empleado("123", "Dsd", "Luisa", "luisa@gmail.com");
        Empleado empleado4 = new Empleado("124", "Tav", "David", "david@gmail.com");
        Empleado empleado5 = new Empleado("125", "Fer", "Laura", "laura@gmail.com");
        Empleado empleado6 = new Empleado("126", "Tobi", "Tobi", "tobi@gmail.com");

        // Agregar empleados a la invitación de la reunión
        reunion.invitacion.agregarEmpleados(empleado1);
        reunion.invitacion.agregarEmpleados(empleado2);
        reunion.invitacion.agregarEmpleados(empleado3);
        reunion.invitacion.agregarEmpleados(empleado4);
        reunion.invitacion.agregarEmpleados(empleado5);
        reunion.invitacion.agregarEmpleados(empleado6);

        // Enviar la invitación a todos los empleados (simulación)
        reunion.invitacion.sendInvitacion();

        // Iniciar la reunión
        reunion.iniciar();
        System.out.println("La reunión ha comenzado.");

        // Simular la llegada de empleados con diferentes horarios
        Instant llegadaAna = Instant.now().plus(Duration.ofMinutes(5));
        Instant llegadaCarlos = Instant.now().plus(Duration.ofMinutes(10));
        Instant llegadaLuisa = Instant.now().plus(Duration.ofMinutes(65));
        Instant llegadaDavid = reunion.getHorarioInicio();

        // Marcar la asistencia de cada empleado
        reunion.marcarAsistencia(empleado1, llegadaAna);
        reunion.marcarAsistencia(empleado2, llegadaCarlos);
        reunion.marcarAsistencia(empleado3, llegadaLuisa);
        reunion.marcarAsistencia(empleado4, llegadaDavid);

        // Finalizar la reunión
        reunion.finalizar();
        System.out.println("La reunión ha finalizado.");

        // Imprimir la información de la reunión
        System.out.println("\nInformación de la reunión:");
        System.out.println(reunion.toString());

        // Obtener y mostrar las asistencias, ausencias y retrasos
        List<Asistencia> asistencias = reunion.obtenerAsistencias();
        System.out.println("\nAsistencias registradas:");
        for (Asistencia asistencia : asistencias) {
            System.out.println("Empleado: " + asistencia.getEmpleado().getNombre() + " - Hora de llegada: " + asistencia.getHoraLlegada());
        }

        List<Empleado> ausentes = reunion.obtenerAusencias();
        System.out.println("\nEmpleados ausentes:");
        for (Empleado ausente : ausentes) {
            System.out.println("Empleado: " + ausente.getNombre());
        }

        List<Retraso> retrasos = reunion.obtenerRetrasos();
        System.out.println("\nRetrasos registrados:");
        for (Retraso retraso : retrasos) {
            System.out.println("Empleado: " + retraso.getEmpleado().getNombre() + " - Hora de llegada: " + retraso.getHoraLlegada());
        }

        // Mostrar el porcentaje de asistencia
        float porcentajeAsistencia = reunion.obtenerPorcentajeAsistencia();
        System.out.println("\nPorcentaje de asistencia: " + porcentajeAsistencia + "%");

        // Duración real
        float duracionReal = reunion.calcularTiempoReal();
        System.out.println("\nDuración real de la reunión: " + duracionReal + " minutos");

        // Crear informe de reunión
        InformeReunion informe = new InformeReunion(reunion);
        informe.generarInformeTxt("InformeReunion.txt", "https://meet.google.com/abc-xyz");
    }
}
