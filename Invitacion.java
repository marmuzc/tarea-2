import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Invitacion {
    private Instant hora;
    private List<Invitable> invitados;

    private List<Invitable> invitados; //Asociacion con Invitable

    public Invitacion(Instant hora) {
<<<<<<< HEAD
        this.hora = hora;
        this.invitados = new ArrayList<>();
=======
        this.hora = hora; // Hora de invitación
        this.invitados = new ArrayList<>();
    }
    
    public void agregarEmpleados(Invitable empleado) {
        invitados.add(empleado);
    }
    public void agregarDepartamentos(List<Invitable> departamento) {
        invitados.addAll(departamento);
>>>>>>> b9745ac9159419f66b7e4b6dea423abf34b0a614
    }

    public void sendInvitacion() { //Metodo para enviar la invitacion a todos los invitados
        for (Invitable invitado : invitados) {
            invitado.invitar();
        }
    }

    public int totalInvitaciones() { //prototipo creado
        return invitados.size(); // El tamaño de la lista de invitados es el total de invitaciones enviadas
    }

    public List<Invitable> getInvitados() { //prototipo creado
        return invitados;
    }


    public boolean esInvitado(Empleado empleado) {
        return invitados.contains(empleado); //Devuelve un valor de verdad que indica si ese empleado está o no invitado
    }
    
    //Getters y Setters de hora
    public Instant getHora() {
        return hora;
    }

    public void setHora(Instant hora) {
        this.hora = hora;
    }

    public void agregarInvitado(Invitable invitado) {
        invitados.add(invitado);
        invitado.invitar(this);
    }

    @Override
    public String toString() {
        return "Invitacion{" +
                "hora=" + hora +
<<<<<<< HEAD
                ", invitados=" + invitados +
=======
                ", total de invitados=" + invitados.size() +
>>>>>>> test-new-logic
                '}';
    }
}
