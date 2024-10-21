package org.example;

/**
 * La clase {@code Empleado} representa a un empleado con identificador, 
 * nombre, apellidos y correo. Implementa la interfaz {@code Invitable} 
 * para poder recibir invitaciones.
 */
public class Empleado implements Invitable {

    /** Identificador único del empleado. */
    private String id;

    /** Apellidos del empleado. */
    private String apellidos;

    /** Nombre del empleado. */
    private String nombre;

    /** Correo electrónico del empleado. */
    private String correo;

    /**
     * Crea una nueva instancia de {@code Empleado} con los datos proporcionados.
     *
     * @param id         Identificador del empleado.
     * @param apellidos  Apellidos del empleado.
     * @param nombre     Nombre del empleado.
     * @param correo     Correo electrónico del empleado.
     */
    public Empleado(String id, String apellidos, String nombre, String correo) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
    }

    /** @return El identificador del empleado. */
    public String getId() {
        return id;
    }

    /** 
     * Establece un nuevo identificador para el empleado.
     * @param id El nuevo identificador.
     */
    public void setId(String id) {
        this.id = id;
    }

    /** @return Los apellidos del empleado. */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del empleado.
     * @param apellidos Los nuevos apellidos.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /** @return El nombre del empleado. */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     * @param nombre El nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** @return El correo del empleado. */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del empleado.
     * @param correo El nuevo correo.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Implementación del método {@code invitar} de la interfaz {@code Invitable}.
     * Muestra un mensaje indicando que se ha enviado una invitación al empleado.
     */
    @Override
    public void invitar() {
        System.out.println("Invitando a: " + nombre + " " + apellidos + " a la reunión");
    }

    /**
     * Devuelve una representación en forma de cadena de la instancia {@code Empleado}.
     * 
     * @return Una cadena con el formato: {@code Empleado{id='...', nombre='...', apellidos='...', correo='...'}}.
     */
    @Override
    public String toString() {
        return String.format(
            "Empleado {id='%s', nombre='%s', apellidos='%s', correo='%s'}",
            id, nombre, apellidos, correo
        );
    }
}
