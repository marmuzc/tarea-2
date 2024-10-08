public class Departamento {
    private String nombre;

    public Departamento(String nombre){
        this.nombre = nombre;
    }

    private int obtenerCantidadEmpleados(){
        return 0;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = getNombre();
    }

}
