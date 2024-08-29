public class Cajero extends Empleado implements Informes{
    private int nro_caja;

    public Cajero(String nombre, String apellido, String DNI, int cant_horas, int sueldo, int nro_caja) {
        super(nombre, apellido, DNI, cant_horas, sueldo);
        this.nro_caja = nro_caja;
    }
    
    @Override
    public double verSueldo(Empleado empleado) {
        return empleado.getSueldo();
    }

    @Override
    public double verParticularidades(Empleado empleado) {
        return 0; //no applications yet.
    }
}
