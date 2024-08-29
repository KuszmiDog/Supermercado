public class Supervisor extends Empleado implements Jefe, Informes{
    private String sector;
    private int PersonasACargo;

    public Supervisor(String nombre, String apellido, String DNI, int cant_horas, int sueldo, String sector, int personasACargo) {
        super(nombre, apellido, DNI, cant_horas, sueldo);
        this.sector = sector;
        PersonasACargo = personasACargo;
    }

    double sueldoCalculado = 0;


    @Override
    public double verSueldo(Empleado empleado) {
        return empleado.getSueldo();
    }

    @Override
    public double verParticularidades(Empleado empleado) {
        return 0; //no applications yet.
    }

    @Override //i'll calculate the total amount doing SUELDO times HORAS-TRABAJO
    public double calcularSueldo(Empleado empleado) {
        sueldoCalculado = (empleado.getSueldo()*empleado.getCant_horas());
        return sueldoCalculado;
    }
}
