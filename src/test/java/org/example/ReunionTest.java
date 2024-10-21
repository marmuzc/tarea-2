package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de prueba para la clase Reunion.
 * Contiene pruebas unitarias para los métodos de la clase Reunion.
 */
class ReunionTest {

    Date fechaReunion = new Date();
    Instant horaPrevista = Instant.now().plus(Duration.ofHours(1)); // Hora prevista de la reunión (1 hora después del momento actual)
    Duration duracionPrevista = Duration.ofHours(2); // Duración prevista de la reunión: 2 horas
    Empleado organizador = new Empleado("120", "Perez", "Juan", "@gmail.com");
    Empleado empleado =  new Empleado("1", "Perez", "Juan", "jperez@gmail.com");
    Empleado empleado2 = new Empleado("3", "Lopez", "Carlos", "clopez@gmail.com");
    Empleado empleado3 = new Empleado("4", "Gomez", "Maria", "margome@gmail.com");
    ListaInvitacion invitacion;
    Nota nota = new Nota("Reunión de prueba: revisar el plan de marketing");
    tipoReunion tipo = tipoReunion.OTRO;
    Reunion reunion = new ReunionEjemplo(fechaReunion, horaPrevista, duracionPrevista, organizador);

    class ReunionEjemplo extends Reunion {
        public ReunionEjemplo(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador) {
            super(fecha, horaPrevista, duracionPrevista, organizador);
        }
    }

    /**
     * Prueba que verifica el establecimiento y obtención del tipo de reunión.
     * Se asegura de que el tipo de reunión sea el mismo que se estableció.
     */
    @Test
    void testSetGetTipoReunion() {
        reunion.setTipo(tipo);
        assertEquals(tipo, reunion.getTipo(), "El tipo de reunión debería ser otro");
        System.out.println("testSetGetTipoReunion: El tipo de reunión es " + reunion.getTipo());
    }

    /**
     * Prueba que verifica la obtención del organizador de la reunión.
     * Se asegura de que el organizador sea el mismo que se estableció en la reunión.
     */
    @Test
    void getOrganizador() {
        assertEquals(organizador, reunion.getOrganizador(), "El organizador debería ser el mismo que se estableció en la reunión");
        System.out.println("getOrganizador: El organizador es " + reunion.getOrganizador());
    }

    /**
     * Prueba que verifica el establecimiento y obtención de la nota de la reunión.
     * Se asegura de que la nota sea la misma que se estableció en la reunión.
     */
    @Test
    void getSetNota() {
        reunion.setNota(nota);
        assertEquals(nota, reunion.getNota(), "La nota debería ser la misma que se estableció en la reunión");
        System.out.println("getNota: La nota es " + reunion.getNota());
    }

    /**
     * Prueba que verifica el registro de asistencia de un empleado.
     * Se asegura de que la asistencia se registre correctamente.
     */
    @Test
    void testMarcarAsistencia() {
        reunion.invitacion.agregarEmpleados(empleado);
        reunion.iniciar();
        Instant horaLlegada = Instant.now();
        reunion.marcarAsistencia(empleado, horaLlegada);
        assertEquals(1, reunion.obtenerAsistencias().size(), "Debería haber una asistencia registrada");
        System.out.println("testMarcarAsistencia: Asistencia registrada para " + empleado.getNombre() + " " + empleado.getApellidos());
        assertEquals(empleado, reunion.obtenerAsistencias().get(0).getEmpleado(), "El empleado registrado debería ser el mismo");
        System.out.println("testMarcarAsistencia: El empleado registrado es " + reunion.obtenerAsistencias().get(0).getEmpleado().getNombre() + " " + reunion.obtenerAsistencias().get(0).getEmpleado().getApellidos());
    }

    /**
     * Prueba que verifica la obtención de ausencias en la reunión.
     * Se asegura de que las ausencias se obtengan correctamente.
     */
    @Test
    @DisplayName("Test de obtener ausencias")
    void testObtenerAusencias() {
        reunion.invitacion.agregarEmpleados(empleado);
        reunion.invitacion.agregarEmpleados(empleado2);
        reunion.iniciar();
        Instant horaLlegada = Instant.now();
        reunion.marcarAsistencia(empleado, horaLlegada);
        assertEquals(1, reunion.obtenerAusencias().size(), "Debería haber un empleado ausente");
        assertEquals(empleado2, reunion.obtenerAusencias().get(0), "El empleado ausente debería ser Carlos Lopez");
        System.out.println("testObtenerAusencias: El empleado ausente es " + reunion.obtenerAusencias().get(0).getNombre() + " " + reunion.obtenerAusencias().get(0).getApellidos());
    }

    /**
     * Prueba que verifica la obtención de retrasos en la reunión.
     * Se asegura de que los retrasos se obtengan correctamente.
     */
    @Test
    @DisplayName("Test de obtener retrasos")
    void testObtenerRetrasos() {
        reunion.invitacion.agregarEmpleados(empleado);
        reunion.invitacion.agregarEmpleados(empleado2);
        reunion.invitacion.agregarEmpleados(empleado3);

        reunion.iniciar();
        Instant horaLlegadaEmpleado = Instant.now();
        Instant horaLlegadaEmpleado2 = Instant.now().plus(Duration.ofMinutes(30));  // 30 minutos de retraso
        Instant horaLlegadaEmpleado3 = Instant.now().plus(Duration.ofMinutes(45));  // 45 minutos de retraso
        reunion.marcarAsistencia(empleado, horaLlegadaEmpleado);
        reunion.marcarAsistencia(empleado2, horaLlegadaEmpleado2);
        reunion.marcarAsistencia(empleado3, horaLlegadaEmpleado3);
        assertEquals(2, reunion.obtenerRetrasos().size(), "Debería haber 2 empleados con retraso");
        assertTrue(reunion.obtenerRetrasos().stream().anyMatch(retraso -> retraso.getEmpleado().equals(empleado2)), "El empleado 2 debería estar en la lista de retrasos");
        assertTrue(reunion.obtenerRetrasos().stream().anyMatch(retraso -> retraso.getEmpleado().equals(empleado3)), "El empleado 3 debería estar en la lista de retrasos");

        System.out.println("testObtenerRetrasos: Los retrasos fueron registrados correctamente.");
        System.out.println("los retrasados fueron " + reunion.obtenerRetrasos().get(0).getEmpleado().getNombre() + " " + reunion.obtenerRetrasos().get(0).getEmpleado().getApellidos() + " y " + reunion.obtenerRetrasos().get(1).getEmpleado().getNombre() + " " + reunion.obtenerRetrasos().get(1).getEmpleado().getApellidos());
    }

    /**
     * Prueba que verifica la obtención del total de asistencia en la reunión.
     * Se asegura de que el total de asistencia sea correcto.
     */
    @Test
    @DisplayName("Test de obtener total de asistencia")
    void obtenerTotalAsistencia() {
        reunion.invitacion.agregarEmpleados(empleado);
        reunion.invitacion.agregarEmpleados(empleado2);
        reunion.invitacion.agregarEmpleados(empleado3);
        reunion.iniciar();
        Instant horaLlegadaEmpleado = Instant.now();
        Instant horaLlegadaEmpleado2 = Instant.now().plus(Duration.ofMinutes(30));  // 30 minutos de retraso
        Instant horaLlegadaEmpleado3 = Instant.now().plus(Duration.ofMinutes(45));  // 45 minutos de retraso
        reunion.marcarAsistencia(empleado, horaLlegadaEmpleado);
        reunion.marcarAsistencia(empleado2, horaLlegadaEmpleado2);
        reunion.marcarAsistencia(empleado3, horaLlegadaEmpleado3);
        assertEquals(3, reunion.obtenerTotalAsistencia(), "Deberían todos estar asistentes aun si llegaron tarde");
        System.out.println("obtenerTotalAsistencia: El total de asistentes es " + reunion.obtenerTotalAsistencia());
    }

    /**
     * Prueba que verifica la obtención del porcentaje de asistencia en la reunión.
     * Se asegura de que el porcentaje de asistencia sea correcto.
     */
    @Test
    @DisplayName("Test de obtener porcentaje de asistencia")
    void obtenerPorcentajeAsistencia() {
        reunion.invitacion.agregarEmpleados(empleado);
        reunion.invitacion.agregarEmpleados(empleado2);
        reunion.invitacion.agregarEmpleados(empleado3);

        reunion.iniciar();

        Instant horaLlegadaEmpleado = Instant.now();
        Instant horaLlegadaEmpleado2 = Instant.now().plus(Duration.ofMinutes(30));
        reunion.marcarAsistencia(empleado, horaLlegadaEmpleado);
        reunion.marcarAsistencia(empleado2, horaLlegadaEmpleado2);

        float porcentajeEsperado = 66.67f;
        float porcentajeCalculado = reunion.obtenerPorcentajeAsistencia();
        float tolerancia = 0.01f;

        assertEquals(porcentajeEsperado, porcentajeCalculado, tolerancia, "El porcentaje de asistencia debería ser aproximadamente 66.67%");
        System.out.println("obtenerPorcentajeAsistencia: El porcentaje de asistencia es " + porcentajeCalculado + "%");
    }

    /**
     * Prueba que verifica el cálculo del tiempo real de la reunión.
     * Se asegura de que el tiempo real de la reunión sea correcto.
     */
    @Test
    @DisplayName("Test de calcular tiempo real")
    void calcularTiempoReal() {
        reunion.iniciar();
        Instant horaInicio = Instant.now();
        Instant horaFin = horaInicio.plus(Duration.ofMinutes(45));
        reunion.setHoraFin(horaFin);

        float duracionEsperada = 45.0f;
        float duracionCalculada = reunion.calcularTiempoReal();
        float tolerancia = 0.01f;

        assertEquals(duracionEsperada, duracionCalculada, tolerancia, "La duración real de la reunión debería ser de 45 minutos");
        System.out.println("calcularTiempoReal: La duración real de la reunión es de " + duracionCalculada + " minutos");
    }

    /**
     * Prueba que verifica el inicio de la reunión.
     * Se asegura de que la hora de inicio se registre correctamente.
     */
    @Test
    @DisplayName("Test de iniciar reunión")
    void iniciar() {
        reunion.iniciar();
        assertNotNull(reunion.getHorarioInicio(), "La hora de inicio debería haber sido registrada");
        System.out.println("iniciar: La reunión ha iniciado a las " + reunion.getHorarioInicio());
    }

    /**
     * Prueba que verifica la finalización de la reunión.
     * Se asegura de que la hora de fin se registre correctamente.
     */
    @Test
    @DisplayName("Test de finalizar reunión")
    void finalizar() {
        reunion.iniciar();
        reunion.finalizar();
        assertNotNull(reunion.getHoraFin(), "La hora de fin debería haber sido registrada");
        System.out.println("finalizar: La reunión ha finalizado a las " + reunion.getHoraFin());
    }

    /**
     * Prueba que verifica la obtención de la fecha de la reunión.
     * Se asegura de que la fecha sea la misma que se estableció en la reunión.
     */
    @Test
    @DisplayName("Test de obtener fecha")
    void getFecha() {
        assertEquals(fechaReunion, reunion.getFecha(), "La fecha de la reunión debería ser la misma que se estableció");
        System.out.println("getFecha: La fecha de la reunión es " + reunion.getFecha());
    }

    /**
     * Prueba que verifica el establecimiento de la fecha de la reunión.
     * Se asegura de que la fecha sea la misma que se estableció en la reunión.
     */
    @Test
    @DisplayName("Test de establecer fecha")
    void setFecha() {
        Date nuevaFecha = new Date();
        reunion.setFecha(nuevaFecha);
        assertEquals(nuevaFecha, reunion.getFecha(), "La fecha de la reunión debería haber cambiado");
        System.out.println("setFecha: La nueva fecha de la reunión es " + reunion.getFecha());
    }

    /**
     * Prueba que verifica la obtención de la hora prevista de la reunión.
     * Se asegura de que la hora prevista sea la misma que se estableció en la reunión.
     */
    @Test
    @DisplayName("Test de obtener hora prevista")
    void getHoraPrevista() {
        assertEquals(horaPrevista, reunion.getHoraPrevista(), "La hora prevista de la reunión debería ser la misma que se estableció");
        System.out.println("getHoraPrevista: La hora prevista de la reunión es " + reunion.getHoraPrevista());
    }

    /**
     * Prueba que verifica el establecimiento de la hora prevista de la reunión.
     * Se asegura de que la hora prevista sea la misma que se estableció en la reunión.
     */
    @Test
    @DisplayName("Test de establecer hora prevista")
    void setHoraPrevista() {
        Instant nuevaHoraPrevista = Instant.now().plus(Duration.ofHours(2));
        reunion.setHoraPrevista(nuevaHoraPrevista);
        assertEquals(nuevaHoraPrevista, reunion.getHoraPrevista(), "La hora prevista de la reunión debería haber cambiado");
        System.out.println("setHoraPrevista: La nueva hora prevista de la reunión es " + reunion.getHoraPrevista());
    }

    /**
     * Prueba que verifica la obtención de la duración prevista de la reunión.
     * Se asegura de que la duración prevista sea la misma que se estableció en la reunión.
     */
    @Test
    @DisplayName("Test de obtener duración prevista")
    void getDuracionPrevista() {
        assertEquals(duracionPrevista, reunion.getDuracionPrevista(), "La duración prevista de la reunión debería ser la misma que se estableció");
        System.out.println("getDuracionPrevista: La duración prevista de la reunión es " + reunion.getDuracionPrevista());
    }

    /**
     * Prueba que verifica el establecimiento de la duración prevista de la reunión.
     * Se asegura de que la duración prevista sea la misma que se estableció en la reunión.
     */
    @Test
    @DisplayName("Test de establecer duración prevista")
    void setDuracionPrevista() {
        Duration nuevaDuracionPrevista = Duration.ofHours(3);
        reunion.setDuracionPrevista(nuevaDuracionPrevista);
        assertEquals(nuevaDuracionPrevista, reunion.getDuracionPrevista(), "La duración prevista de la reunión debería haber cambiado");
        System.out.println("setDuracionPrevista: La nueva duración prevista de la reunión es " + reunion.getDuracionPrevista());
    }

    /**
     * Prueba que verifica la obtención de la hora de inicio de la reunión.
     * Se asegura de que la hora de inicio se registre correctamente.
     */
    @Test
    @DisplayName("Test de obtener hora de inicio")
    void getHorarioInicio() {
        reunion.iniciar();
        assertNotNull(reunion.getHorarioInicio(), "La hora de inicio debería haber sido registrada");
        System.out.println("getHorarioInicio: La hora de inicio de la reunión es " + reunion.getHorarioInicio());
    }

    /**
     * Prueba que verifica el establecimiento de la hora de inicio de la reunión.
     * Se asegura de que la hora de inicio se registre correctamente.
     */
    @Test
    @DisplayName("Test de establecer hora de inicio")
    void setHorarioInicio() {
        Instant nuevaHoraInicio = Instant.now();
        reunion.setHorarioInicio(nuevaHoraInicio);
        assertEquals(nuevaHoraInicio, reunion.getHorarioInicio(), "La hora de inicio de la reunión debería haber cambiado");
        System.out.println("setHorarioInicio: La nueva hora de inicio de la reunión es " + reunion.getHorarioInicio());
    }

    /**
     * Prueba que verifica la obtención de la hora de fin de la reunión.
     * Se asegura de que la hora de fin se registre correctamente.
     */
    @Test
    @DisplayName("Test de obtener hora de fin")
    void getHoraFin() {
        reunion.iniciar();
        reunion.finalizar();
        assertNotNull(reunion.getHoraFin(), "La hora de fin debería haber sido registrada");
        System.out.println("getHoraFin: La hora de fin de la reunión es " + reunion.getHoraFin());
    }

    /**
     * Prueba que verifica el establecimiento de la hora de fin de la reunión.
     * Se asegura de que la hora de fin se registre correctamente.
     */
    @Test
    @DisplayName("Test de establecer hora de fin")
    void setHoraFin() {
        Instant nuevaHoraFin = Instant.now();
        reunion.setHoraFin(nuevaHoraFin);
        assertEquals(nuevaHoraFin, reunion.getHoraFin(), "La hora de fin de la reunión debería haber cambiado");
        System.out.println("setHoraFin: La nueva hora de fin de la reunión es " + reunion.getHoraFin());
    }
}