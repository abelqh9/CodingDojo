class CuentaBancaria:

    def __init__(self, tasa_interés, balance = 0): 
        self.tasa_interés = tasa_interés/100
        self.balance = balance

    def deposito(self, amount):
        self.balance += amount
        return self

    def retiro(self, amount):
        if (self.balance >= amount):
            self.balance = self.balance - amount
        else:
            print("Fondos insuficientes: cobrando una tarifa de $5")
            self.balance -= 5
        return self

    def mostrar_info_cuenta(self):
        print(f"Balance: ${self.balance}")
        return self

    def generar_interes(self):
        if(self.balance>0):
            self.balance += self.balance*self.tasa_interés
        return self

# Crea 2 cuentas
cuenta_1=CuentaBancaria(2, 200)
cuenta_2=CuentaBancaria(1)

# Para la primera cuenta, haz 3 depósitos y 1 retiro, luego genera intereses y muestra la información de la cuenta, todo en una línea de código (es decir, encadenando)
cuenta_1.deposito(300).deposito(300).deposito(400).retiro(100).generar_interes().mostrar_info_cuenta()

# Para la segunda cuenta, haz 2 depósitos y 4 retiros, luego genera intereses y muestra la información de la cuenta, todo en una línea de código (es decir, encadenando)
cuenta_2.deposito(500).deposito(500).retiro(100).retiro(100).retiro(100).retiro(100).generar_interes().mostrar_info_cuenta()