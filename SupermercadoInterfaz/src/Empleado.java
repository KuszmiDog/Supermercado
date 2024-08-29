public class Empleado extends Persona{
    private int cant_horas;
    private int sueldo;

    public Empleado(String nombre, String apellido, String DNI, int cant_horas, int sueldo){
        super(nombre, apellido, DNI);
        this.cant_horas = cant_horas;
        this.sueldo = sueldo;
    }

    public int getCant_horas() {
        return cant_horas;
    }

    public int getSueldo() {
        return sueldo;
    }
}