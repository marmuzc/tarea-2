package org.example;

/**
 * La clase {@code Nota} representa una nota con contenido textual.
 * Provee métodos para acceder al contenido de la nota.
 */
public class Nota {
    /** Contenido de la nota. */
    private String contenido;

    /**
     * Crea una nueva instancia de {@code Nota} con el contenido especificado.
     *
     * @param contenido El contenido de la nota.
     */
    public Nota(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Devuelve el contenido de la nota.
     *
     * @return El contenido de la nota.
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Devuelve una representación en forma de cadena de la instancia {@code Nota}.
     * 
     * @return Una cadena que representa la nota en el formato: 
     *         {@code Nota{contenido='valorContenido'}}.
     */
    @Override
    public String toString() {
        return String.format("Nota{contenido='%s'}", contenido);
    }
}
