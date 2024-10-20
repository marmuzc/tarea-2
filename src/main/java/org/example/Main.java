package org.example;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Crear una instancia de Reunion
        Date fechaReunion = new Date();
        Instant horaPrevista = Instant.now().plus(Duration.ofHours(1)); // Hora prevista de la reunión (1 hora después del momento actual)
        Duration duracionPrevista = Duration.ofHours(2); // Duración prevista de la reunión: 2 horas
        Empleado organizador = new Empleado("120", "Perez", "Juan", "@gmail.com");
        String sala = "Sala 101";
        tipoReunion tipo = tipoReunion.OTRO; //Tipo de la reunión (Puede ser TECNICA, MARKETING, OTRO, etc.)

        ReunionPresencial reunion = new ReunionPresencial(fechaReunion, horaPrevista, duracionPrevista, tipo, sala, organizador);

        // Crear empleados
        Empleado empleado1 = new Empleado("121", "Wato", "Ana", "anawato@gmail.com");  // Retrasada
        Empleado empleado2 = new Empleado("122", "Sds", "Carlos", "carlos@gmail.com"); // Retrasado
        Empleado empleado3 = new Empleado("123", "Dsd", "Luisa", "luisa@gmail.com");   // Retrasada
        Empleado empleado4 = new Empleado("124", "Tav", "David", "david@gmail.com");   // A tiempo
        Empleado empleado5 = new Empleado("125", "Fer", "Laura", "laura@gmail.com");   // Ausente
        Empleado empleado6 = new Empleado("126", "tobi", "tobi", "tobi@gmail.com");   // Ausente

        // Crear un departamento
        Departamento departamento = new Departamento("MARKETING");

        // Agregar empleados a un departamento
        departamento.addEmpleados(empleado1);
        departamento.addEmpleados(empleado2);

        // Agregar el departamento a la lista de invitación de la reunión
        reunion.invitacion.agregarDepartamentos(departamento.getEmpleados());

        // Agregar empleados a la lista de invitación de la reunión
        reunion.invitacion.agregarEmpleados(empleado3);
        reunion.invitacion.agregarEmpleados(empleado4);
        reunion.invitacion.agregarEmpleados(empleado5); // Laura será la ausente
        reunion.invitacion.agregarEmpleados(empleado6); // Tobi será el ausente

        // Enviar la invitación a todos los empleados (simulación)
        reunion.invitacion.sendInvitacion();

        // Iniciar la reunión
        reunion.iniciar();
        System.out.println("La reunión ha comenzado.");

        // Simular la llegada de empleados con diferentes horarios
        Instant llegadaAna = Instant.now().plus(Duration.ofMinutes(5));  // Ana llega 5 minutos tarde
        Instant llegadaCarlos = Instant.now().plus(Duration.ofMinutes(10)); // Carlos llega 10 minutos tarde
        Instant llegadaLuisa = Instant.now().plus(Duration.ofMinutes(65)); // Luisa llega 65 minutos tarde
        Instant llegadaDavid = reunion.getHorarioInicio(); // David llega a tiempo

        // Marcar la asistencia de cada empleado
        reunion.marcarAsistencia(empleado1, llegadaAna);   // Ana llega tarde
        reunion.marcarAsistencia(empleado2, llegadaCarlos); // Carlos llega tarde
        reunion.marcarAsistencia(empleado3, llegadaLuisa);  // Luisa llega muy tarde
        reunion.marcarAsistencia(empleado4, llegadaDavid);  // David llega a tiempo

        // Laura no llega, ella será registrada como ausente automáticamente
        // Tobi no llega, él será registrado como ausente automáticamente

        // Finalizar la reunión
        reunion.finalizar();
        System.out.println("La reunión ha finalizado.");

        // Obtener y mostrar las asistencias
        List<Asistencia> asistencias = reunion.obtenerAsistencias();
        System.out.println("\nAsistencias registradas:");
        for (Asistencia asistencia : asistencias) {
            Instant hora = asistencia.getHoraLlegada();
        
            // Convertir Instant a ZonedDateTime en una zona horaria específica
            ZonedDateTime horaAjustada = hora.atZone(ZoneId.systemDefault());
            
            // Formatear para mostrar la hora, el día, el mes y el año
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
            String horaFormateada = horaAjustada.format(formatter);

            System.out.println("Empleado: " + asistencia.getEmpleado().getNombre() + " - Hora de llegada: " + horaFormateada);
        }

        // Obtener y mostrar las ausencias
        List<Empleado> ausentes = reunion.obtenerAusencias();
        System.out.println("\nEmpleados ausentes:");
        for (Empleado ausente : ausentes) {
            System.out.println("Empleado: " + ausente.getNombre());
        }

        // Obtener y mostrar los retrasos
        List<Retraso> retrasos = reunion.obtenerRetrasos();
        System.out.println("\nRetrasos registrados:");
        for (Retraso retraso : retrasos) {
            Instant hora = retraso.getHoraLlegada();
        
            // Convertir Instant a ZonedDateTime en una zona horaria específica
            ZonedDateTime horaAjustada = hora.atZone(ZoneId.systemDefault());
            
            // Formatear para mostrar la hora, el día, el mes y el año
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
            String horaFormateada = horaAjustada.format(formatter);
            System.out.println("Empleado: " + retraso.getEmpleado().getNombre() + " - Hora de llegada: " + horaFormateada);
        }

        // Mostrar el porcentaje de asistencia
        float porcentajeAsistencia = reunion.obtenerPorcentajeAsistencia();
        System.out.println("\nPorcentaje de asistencia: " + porcentajeAsistencia + "%");

        // Duración real
        float duracionReal = reunion.calcularTiempoReal();
        System.out.println("\nDuración real de la reunión: " + duracionReal + " minutos");

        //Imprimir la información de la reunión
        System.out.println("\nInformación de la reunión:");
        System.out.println(reunion.toString());

        //Crear informe de reunión
        InformeReunion informe = new InformeReunion(reunion);
        informe.generarInformeTxt("InformeReunion.txt", sala);
    }
}
