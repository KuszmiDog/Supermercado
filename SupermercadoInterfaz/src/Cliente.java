class Cliente extends Persona {
    private boolean Mayorista;
    private int NroSocio;

    public Cliente(String nombre, String apellido, String DNI, boolean Mayorista, int NroSocio){
        super(nombre, apellido, DNI);
        this.Mayorista = Mayorista;
        this.NroSocio = NroSocio;
    }
}