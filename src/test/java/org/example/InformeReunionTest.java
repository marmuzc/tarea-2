package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    void setUp() throws ParseException {
        // Crear una fecha utilizando SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = sdf.parse("2021-09-30");

        // Crear un Instant para la hora prevista
        Instant horaPrevista = Instant.parse("2021-09-30T09:00:00Z");

        // Crear una duración utilizando Duration
        Duration duracionPrevista = Duration.ofMinutes(60);

        sala = "Sala 1";
        nombreArchivo = "informe.txt";

        // Inicializar el objeto que se va a probar antes de cada test
        reunionPresencial = new ReunionPresencial(fecha, horaPrevista, duracionPrevista, sala);
        informeReunion = new InformeReunion(reunionPresencial);
    }

    @Test
    public void generarInformeTxt() {
        // Act: ejecutar el método para generar el informe
        informeReunion.generarInformeTxt(nombreArchivo, sala);

        // Verificar que el archivo realmente se haya creado
        File file = new File(nombreArchivo);
        assertTrue(file.exists(), "El archivo de informe debería existir");
    }

    @AfterEach
    void tearDown() {
        // Eliminar el archivo generado después de cada prueba
        File file = new File(nombreArchivo);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void generarInformeTxtSinNombre() throws Exception {
        // Act: intentar generar el informe con un nombre de archivo vacío
        informeReunion.generarInformeTxt("", sala);

        // Verificar que no se haya creado ningún archivo
        File file = new File(""); // El archivo no debería existir
        assertFalse(file.exists(), "No se debería haber creado ningún archivo con nombre vacío");
    }

    @Test
    public void generarInformeTxtSinEnlaceSala() throws Exception {
        // Act: intentar generar el informe con un enlace de sala vacío
        informeReunion.generarInformeTxt(nombreArchivo, "");

        // Verificar que el archivo realmente se haya creado
        File file = new File(nombreArchivo);
        assertTrue(file.exists(), "El archivo de informe debería existir");
    }

    @Test
    public void generarInformeTxtEnlaceSalaNull() throws Exception {

    }
}
