public class Persona{
    private String Nombre;
    private String Apellido;
    private String DNI; //I'd preffer to define DNI as String because we're not mean to operate with it.

    public Persona(String nombre, String apellido, String DNI) {
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.DNI = DNI;
    }
}
