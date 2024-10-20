package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class InformeReunionTest {

    private InformeReunion informeReunion;
    private ReunionPresencial reunionPresencial;
    private String sala;
    private String nombreArchivo;

    @BeforeEach
    void setUp() {
        Date fechaReunion = new Date();
        Instant horaPrevista = Instant.now().plus(Duration.ofHours(1)); // Hora prevista de la reunión (1 hora después del momento actual)
        Duration duracionPrevista = Duration.ofHours(2); // Duración prevista de la reunión: 2 horas
        Empleado organizador = new Empleado("12", "Pérez", "Tobias", "toperez@gmail.com");

        sala = "Sala 1";
        nombreArchivo = "informe.txt";

        // Inicializar el objeto que se va a probar antes de cada test
        reunionPresencial = new ReunionPresencial(fechaReunion, horaPrevista, duracionPrevista, tipoReunion.MARKETING, sala, organizador);
        informeReunion = new InformeReunion(reunionPresencial);
    }

    @Test
    @DisplayName("Generar informe en formato TXT cuando todo está correcto")
    public void generarInformeTxt() {
        informeReunion.generarInformeTxt(nombreArchivo, sala);

        // Verificar que el archivo realmente se haya creado
        File file = new File(nombreArchivo);
        assertTrue(file.exists(), "El archivo de informe debería existir");

        // Imprimir el estado del archivo
        System.out.println("Test: Generar informe en formato TXT - El archivo de informe se ha creado correctamente.");
    }

    @AfterEach
    void tearDown() {
        // Eliminar el archivo generado después de cada prueba
        File file = new File(nombreArchivo);
        if (file.exists()) {
            file.delete();
            System.out.println("El archivo de informe ha sido eliminado después del test.");
        }
    }

    @Test
    @DisplayName("Generar informe con enlace/sala nulo (si no se agrega enlace/sala)")
    public void generarInformeTxtEnlaceSalaNull() {
        // Act: generar informe con enlace de sala nulo
        informeReunion.generarInformeTxt(nombreArchivo, null);

        // Assert: verificar que el archivo se ha creado
        File file = new File(nombreArchivo);
        assertTrue(file.exists(), "El archivo de informe debería existir, incluso con enlace de sala nulo.");

        // Imprimir el estado del archivo
        System.out.println("Test: Generar informe con enlace de sala nulo - Archivo creado con valor por defecto para enlace de sala.");
    }


    @Test
    @DisplayName("Generar informe con enlace de sala vacío (se usa valor por defecto)")
    public void generarInformeTxtSinEnlaceSala() {
        // Act: generar informe con enlace de sala vacío
        informeReunion.generarInformeTxt(nombreArchivo, "");

        // Assert: verificar que el archivo se ha creado
        File file = new File(nombreArchivo);
        assertTrue(file.exists(), "El archivo de informe debería existir, incluso con enlace de sala vacío.");

        // Imprimir el estado del archivo
        System.out.println("Test: Generar informe con enlace de sala vacío - Archivo creado con valor por defecto para enlace de sala.");
    }


    @Test
    @DisplayName("No generar informe si el nombre del archivo está vacío")
    public void generarInformeTxtSinNombre() {
        // Eliminar cualquier archivo existente antes de ejecutar el test
        File file = new File(nombreArchivo);
        if (file.exists()) {
            file.delete();
        }

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            informeReunion.generarInformeTxt("", sala);
        });

        assertEquals("El nombre del archivo no puede estar vacío.", exception.getMessage());

        // Verificar que no se haya creado ningún archivo después de lanzar la excepción
        assertFalse(file.exists(), "No se debería haber creado ningún archivo con nombre vacío.");
        System.out.println("Test: No generar informe si el nombre del archivo está vacío - Prueba completada con éxito.");
    }

}
