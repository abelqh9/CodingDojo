public class TestCuentaBancaria{
    public static void main(String[] args){
        CuentaBancaria cuenta1 =  new CuentaBancaria();
        CuentaBancaria cuenta2 =  new CuentaBancaria();
        CuentaBancaria cuenta3 =  new CuentaBancaria();

        // System.out.println(CuentaBancaria.getCantidadCuentas());

        // System.out.println(cuenta1.getNumeroCuenta());
        // System.out.println(cuenta2.getNumeroCuenta());
        // System.out.println(cuenta3.getNumeroCuenta());

        System.out.println(CuentaBancaria.getDineroTotalCuentas());

        cuenta1.aumentarSaldo();
        cuenta1.aumentarSaldo();
        cuenta2.aumentarSaldo();
        // cuenta2.aumentarSaldo();
        // cuenta3.aumentarSaldo();

        System.out.println(cuenta1.getTotalCuenta());
        System.out.println(cuenta2.getTotalCuenta());
        cuenta1.retirarSaldo();

        System.out.println(CuentaBancaria.getDineroTotalCuentas());

    }
}