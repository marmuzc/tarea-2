public class Empleado implements Invitable {
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;
<<<<<<< HEAD

=======
    
>>>>>>> b9745ac9159419f66b7e4b6dea423abf34b0a614
    public Empleado(String id, String apellidos, String nombre, String correo) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
    }

<<<<<<< HEAD
=======
    //Getters y Setters de las propiedades
>>>>>>> b9745ac9159419f66b7e4b6dea423abf34b0a614
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    //Implementacion de Invitable
    @Override
    public void invitar() {
        System.out.println("Invitando a: " + nombre + " " + apellidos + " a la reunión");
    }
    

    @Override
    public void invitar(Invitacion invitacion) {
        System.out.println("Departamento " + nombre + " ha sido invitado a la reunión.");
    }

    @Override
    public String toString() {
        return "Empleado {" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
