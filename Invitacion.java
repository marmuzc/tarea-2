import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Invitacion {
    private Instant hora; // Hora de la invitación

    private List<Invitable> invitados; //Asociacion con Invitable

    public Invitacion(Instant hora) {
        this.hora = hora; // Hora de invitación
        this.invitados = new ArrayList<>();
    }
    
    public void agregarEmpleados(Invitable empleado) {
        invitados.add(empleado);
    }
    public void agregarDepartamentos(List<Invitable> departamento) {
        invitados.addAll(departamento);
    }

    public void sendInvitacion() { //Metodo para enviar la invitacion a todos los invitados
        for (Invitable invitado : invitados) {
            invitado.invitar();
        }
    }

    public boolean esInvitado(Empleado empleado) {
        return invitados.contains(empleado); //Devuelve un valor de verdad que indica si ese empleado está o no invitado
    }
    
    //Getters y Setters de hora
    public Instant getHora() {
        return hora;
    }

    public void setHora(Instant hora){ //No definitivo
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Invitacion{" +
                ", hora=" + hora +
                '}';
    }
}
