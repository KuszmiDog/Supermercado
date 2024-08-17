import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Humane {

    private String nombre;
    private String apellido;
    private int dni;

    public Humane(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public String toString() {
        return "Nombre: " + this.nombre + "\nApellido: " + this.apellido + "\nDNI: " + this.dni;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }
}

class Empleado extends Humane {

    private double sueldo;

    public Empleado(String nombre, String apellido, int dni, double sueldo) {
        super(nombre, apellido, dni);
        this.sueldo = sueldo;
    }

    public String toString() {
        return super.toString() + "\nSueldo: " + this.sueldo;
    }
}

class Caja {
    private Empleado empleado;
    private int nroCaja;

    public Caja(Empleado empleado, int nroCaja) {
        this.empleado = empleado;
        this.nroCaja = nroCaja;
    }

    public String toString() {
        return this.empleado.toString() + "\nNro de caja: " + this.nroCaja;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public int getNroCaja() {
        return nroCaja;
    }
}

class Cliente extends Humane {

    private boolean mayorista;

    public Cliente(String nombre, String apellido, int dni, boolean mayorista) {
        super(nombre, apellido, dni);
        this.mayorista = mayorista;
    }

    public boolean isMayorista() {
        return mayorista;
    }

    public String toString() {
        return super.toString() + "\nMayorista: " + this.mayorista;
    }
}

class Producto {
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }
}

class Transaccion{
    private Producto producto;

    public Transaccion(Producto producto) {
        this.producto = producto;
    }

    public double PagoProducto(){
        double precio_producto = producto.getPrecio();
        int cantidad = producto.getCantidad();
        double precioT = precio_producto*cantidad;
        return precioT;
    }

    public void info_transaccion(){
        String nombre_producto = producto.getNombre();
        System.out.println("Producto: "+nombre_producto+" |Precio U: "+producto.getPrecio()+"$"+" |Cantidad: "+producto.getCantidad());
    }
}

class ConceptosFundamentales {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Cliente cliente_ejemplo = new Cliente("Juan", "Perez", 12345678, true); //not used
        Empleado empleado_ejemplo = new Empleado("Romina", "Luchek", 43088672, 25000);
        Random random = new Random(); //used to generate caja's number


        System.out.println("| - - - - - - - - - - SUPERMERCADO: HOGWARMMING - - - - - - - - - - - - |");
        System.out.println("| - - - - - - - - - - - - - - BIENVENIDO! - - - - - - - - - - - - - - - |");
        System.out.println("| - (Para una mejor experiencia, expanda la terminal hacia arriba!) - - |");
        System.out.println("| - - - - - - - - -  OPRIMA ENTER PARA EMPEZAR! - - - - - - - - - - - - |");
        scanner.nextLine();
        System.out.println("Ingrese su nombre de pila, cliente: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese su apellido: ");
        String apellido = scanner.nextLine();
        System.out.println("Ingrese su DNI, sin puntos ni guiones:");
        int dni = scanner.nextInt();

        System.out.println("- - - - Se trata usted de un/a cliente mayorista? - - - - -");
        System.out.println("  - -   | Si: 1 | No: 0 | Info. C.Mayoristas: 2 |    - - ");

        boolean flag1 = true;
        boolean mayorista = true;
        while (flag1){
            int may_op = scanner.nextInt();
            scanner.nextLine();
            if(may_op == 1){
                mayorista = true;
                flag1 = false;
            } else if (may_op == 0) {
                mayorista = false;
                flag1 = false;
            } else if (may_op == 2) {
                System.out.println("En el caso de los clientes mayoristas acreditados,");
                System.out.println("Se otorga un 25% de descuento en el monto total a pagar\n");
                System.out.println("- - - - Se trata usted de un/a cliente mayorista? - - - - -");
                System.out.println("  - -   | Si: 1 | No: 0 | Info. C.Mayoristas: 2 |    - - ");
            } else {
                System.out.println("Opcion invalida! D:");
                System.out.println("- - - - Se trata usted de un/a cliente mayorista? - - - - -");
                System.out.println("  - -   | Si: 1 | No: 0 | Info. C.Mayoristas: 2 |    - - ");
            }
        }

        Cliente nuevo_cliente = new Cliente(nombre, apellido, dni, mayorista);
        System.out.println(".| Información de cliente actualizada! |.");
        System.out.println(" - - - - - - - - - - - - - - - - - - - -");
        System.out.println(nuevo_cliente);
        System.out.println(" - - - - - - - - - - - - - - - - - - - -");
        System.out.println("  .| Presione ENTER para continuar |.");
        scanner.nextLine();

        boolean flag2 = true;

        ArrayList<Transaccion> Factura = new ArrayList<>();
        double TotalPagar = 0;
        while(flag2){
            System.out.println("Ingrese el nombre del articulo a comprar: ");
            String nombre_producto = scanner.nextLine();
            System.out.println("Cuanto dinero cuesta x unidad?");
            double precio_producto = scanner.nextDouble();
            System.out.println("Cuantas unidades del producto comprará?");
            int cantidad_producto = scanner.nextInt();

            Producto nuevo_producto = new Producto(nombre_producto, precio_producto, cantidad_producto);
            Transaccion nueva_tran = new Transaccion(nuevo_producto);
            double pago_transaccion = nueva_tran.PagoProducto();

            TotalPagar = TotalPagar + pago_transaccion;
            Factura.add(nueva_tran);

            System.out.println("\n- - - - - - - - - - - - - - - - - - - - -");
            System.out.println(" Monto actual: "+TotalPagar+"$");
            System.out.println("- - - - - - - - - - - - - - - - - - - - -");
            System.out.println("- Desea ingresar en el carrito otro producto? ");
            System.out.println("  - -   | Si: 1 | No: 0 |  - - ");
            int may_op = scanner.nextInt();
            scanner.nextLine();
            if(may_op == 1){
                System.out.println("- Ingresando nuevo producto, presione ENTER! -");
                scanner.nextLine();
            } else if (may_op == 0) {
                flag2 = false;
            } else {
                System.out.println("Pero che! Opcion invalida!");
                System.out.println("- Desea ingresar en el carrito otro producto? ");
                System.out.println("  - -   | Si: 1 | No: 0 |  - - ");
            }
        }
        for (int i = 0; i < 10; i++) {  //clean screen re low cost
            System.out.println();
        }


        int n = random.nextInt(10);
        Caja caja_ejemplo = new Caja(empleado_ejemplo, n);
        System.out.println("| - - - - - - - FACTURA GENERADA - - - - - - - |");
        System.out.println("| Caja N°:["+caja_ejemplo.getNroCaja()+"]");
        System.out.println("| Empleado a cargo: ");
        System.out.println(empleado_ejemplo);
        System.out.println("-------- ARTICULOS DEL CARRITO ---------");
        for (Transaccion transaccion : Factura) {
            transaccion.info_transaccion();
        }
        System.out.println("----------------------------------------");

        if(nuevo_cliente.isMayorista()){
            double descuento = (TotalPagar*25)/100;
            TotalPagar = TotalPagar-descuento;
            System.out.println("Cliente: "+nuevo_cliente.getNombre()+", "+nuevo_cliente.getApellido());
            System.out.println("Monto a abonar: "+TotalPagar);
            System.out.println("\n| Presione ENTER para pagar |");
            scanner.nextLine();
        } else {
            System.out.println("Cliente: "+nuevo_cliente.getNombre()+", "+nuevo_cliente.getApellido());
            System.out.println("Monto a abonar: "+TotalPagar);
            System.out.println("\n| Presione ENTER para pagar |");
            scanner.nextLine();
        }
    }
}