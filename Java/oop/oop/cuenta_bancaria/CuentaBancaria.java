import java.util.Random;

// Crea una clase CuentaBancaria
public class CuentaBancaria{

    // Los usuarios no deberían poder establecer ninguno de los atributos de la clase.

    // La clase debe tener los siguientes atributos: saldo de cuenta corriente (double), saldo de ahorros (double)
    private double saldoCuentaCorriente;
    private double saldoAhorros;

    // Crea un miembro de clase (estático) que tenga la cantidad de cuentas creadas hasta el momento.
    private static int cantidadCuentas = 0;
    // Crea un miembro de clase (estático) que rastree la cantidad total de dinero almacenada en cada cuenta creada.
    private static double dineroTotalCuentas = 0;

    // BONUS NINJA: agrega el siguiente atributo de clase: número de cuenta. El tipo depende de ti, puede ser String o Long u otro tipo.
    private long numeroCuenta;

    // BONUS NINJA: Crea un método privado que devuelva un número de cuenta aleatorio de diez dígitos. 
    private long getRandomNumeroCuenta(){
        Random r = new Random();
        String string10 = "";
        for (int i = 0; i < 10; i++){
            string10 +=  Integer.toString(r.nextInt(10));
        }
        return new Long(string10);
    }

    // BONUS NINJA: en el constructor, llama al método privado de arriba para que cada usuario tenga una cuenta aleatoria de diez dígitos.
    public CuentaBancaria(){
        // En el constructor, asegúrate de incrementar el número de cuentas.
        cantidadCuentas++;

        this.saldoCuentaCorriente = 0;
        this.saldoAhorros = 0;
        this.numeroCuenta = getRandomNumeroCuenta();
    }

    // Crea un método getter para el saldo de la cuenta corriente del usuario.
    public double getSaldoCuentaCorriente(){
        return this.saldoCuentaCorriente;
    }

    // Crea un método getter para el saldo de la cuenta de ahorros del usuario.
    public double getSaldoAhorros(){
        return this.saldoAhorros;
    }

    // Crea un método que le permita a un usuario depositar dinero en la cuenta corriente o en la cuenta de ahorros, asegúrate de agregarlo al monto total almacenado. 
    public void aumentarSaldo(){
        String cuentaADepositar;
        int cantidadADepositar;
        System.out.println("Elige la cuenta a la que vas depositar");
        while (true) {
            System.out.println("c = corriente | a = ahorros");
            String r1 = System.console().readLine().trim(); 
            if (r1.equals("c") || r1.equals("a")){
                cuentaADepositar = r1;
                break;
            }
        }
        System.out.println("Elige el monto que vas depositar");
        while (true) {
            try{
                cantidadADepositar = Integer.parseInt(System.console().readLine().trim());
                break;
            }catch(Exception e){
                System.out.println("Elige un monto correcto (int)");
            }
        }
        if ( cuentaADepositar.equals("c") ){
            this.saldoCuentaCorriente += cantidadADepositar;
        }else if( cuentaADepositar.equals("a") ){
            this.saldoAhorros +=cantidadADepositar;
        }
        this.dineroTotalCuentas += cantidadADepositar;
        System.out.println("Operacion exitosa");
    }

    // Crea un método para retirar dinero de uno de los saldos. No les permitas retirar dinero si no hay fondos suficientes.
    public void retirarSaldo(){
        String cuentaARetirar;
        int cantidadARetirar;
        System.out.println("Elige la cuenta a la que vas retirar");
        while (true) {
            System.out.println("c = corriente | a = ahorros");
            String r1 = System.console().readLine().trim(); 
            if (r1.equals("c") || r1.equals("a")){
                cuentaARetirar = r1;
                break;
            }
        }
        System.out.println("Elige el monto que vas retirar");
        while (true) {
            try{
                cantidadARetirar = Integer.parseInt(System.console().readLine().trim());
                break;
            }catch(Exception e){
                System.out.println("Elige un monto correcto (int)");
            }
        }
        if ( cuentaARetirar.equals("c") ){
            if (this.saldoCuentaCorriente > cantidadARetirar){
                System.out.println("Operacion exitosa, se ha retirado "+ cantidadARetirar+" de la cuenta corriente");
                this.saldoCuentaCorriente -= cantidadARetirar;
                this.dineroTotalCuentas -= cantidadARetirar;
            }else{
                System.out.println("Operacion fallida, saldo insuficiente para retirar "+ cantidadARetirar+" de la cuenta corriente");
            }
        }else if( cuentaARetirar.equals("a") ){
            if (this.saldoAhorros > cantidadARetirar){
                System.out.println("Operacion exitosa, se ha retirado "+ cantidadARetirar+" de la cuenta de ahorros");
                this.saldoAhorros -=cantidadARetirar;
                this.dineroTotalCuentas -= cantidadARetirar;
            }else{
                System.out.println("Operacion fallida, saldo insuficiente para retirar "+ cantidadARetirar+" de la cuenta de ahorros");
            }
        }
    }

    // Crea un método para ver el dinero total de la cuenta corriente y de ahorros.
    public double getTotalCuenta(){
        return this.saldoCuentaCorriente + this.saldoAhorros;
    }

    public long getNumeroCuenta(){
        return numeroCuenta;
    }

    public static int getCantidadCuentas(){
        return cantidadCuentas;
    }

    public static double getDineroTotalCuentas(){
        return dineroTotalCuentas;
    }
}