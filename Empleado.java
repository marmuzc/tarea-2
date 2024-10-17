public class Empleado implements Invitable {
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;

    //probando nuevo metodo de Asitencia
    private boolean invitado;
    
    public Empleado(String id, String apellidos, String nombre, String correo) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
        this.invitado = false; //En un inicio, el Empleado no está invitado
    }

    @Override
    public void invitar(Invitacion invitacion) {
        this.invitado = true; //Si el Empleado recibe una invitación, este queda invitado
        System.out.println("Invitando a: " + nombre + " " + apellidos + " a la reunión con hora: " + invitacion.getHora());
    }

    //Metodo para saber si el Empleado fue invitado
    public boolean esInvitado() {
        return invitado;
    }
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
