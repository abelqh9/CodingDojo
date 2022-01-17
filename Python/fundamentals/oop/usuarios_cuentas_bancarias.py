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

class Usuario:

    # BONUS SENSEI: permite que un usuario tenga varias cuentas; actualiza métodos para que el usuario tenga que especificar en qué cuenta está retirando o hacia cuál están depositando

    # Actualizar el método __init__ de la clase Usuario
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.cuentas = {"principal": CuentaBancaria(2, 0)}
    
    # Actualizar el método hacer_depósito de la clase Usuario
    def hacer_deposito(self, cuenta, amount):
        self.cuentas[cuenta].deposito(amount)

    # Actualizar el método hacer_retiro de la clase Usuario
    def hacer_retiro(self, cuenta, amount):
        self.cuentas[cuenta].retiro(amount)

    # Actualizar el método mostrar_balance_usuario de la clase Usuario
    def mostrar_balance_usuario(self, cuenta):
        self.cuentas[cuenta].mostrar_info_cuenta()
    
    def transferir_dinero(self, other_user, other_user_cuenta, cuenta, amount):
        # print(self.cuentas[cuenta])
        self.cuentas[cuenta].retiro(amount)
        other_user.cuentas[other_user_cuenta].deposito(amount)

    def crear_cuenta(self, nombre_cuenta, interes, balance):
        self.cuentas[nombre_cuenta] = CuentaBancaria(interes, balance)


print("se creó el usuario 1:")
user_1 = Usuario("Bryan", "correoBryan@gmail.com")
print("cuenta principal - usuario 1:")
user_1.mostrar_balance_usuario("principal")

print("el usuario 1 creó una cuenta secundaria")
user_1.crear_cuenta("secundaria", 2, 1000)
print("cuenta secundaria - usuario 1:")
user_1.mostrar_balance_usuario("secundaria")

print("el usuario 1 hizo un retiro de la cuenta secundaria")
user_1.hacer_retiro("secundaria", 200)
print("cuenta secundaria - usuario 1:")
user_1.mostrar_balance_usuario("secundaria")

print("el usuario 1 hizo un deposito a la cuenta principal")
user_1.hacer_deposito("principal", 100)
print("cuenta secundaria - usuario 1:")
user_1.mostrar_balance_usuario("principal")

print("se creó el usuario 2")
user_2 = Usuario("Abel", "correoAbel@gmail.com")
print("cuenta principal - usuario 2:")
user_2.mostrar_balance_usuario("principal")

print("el usuario 1 tranfirió dinero de su cuenta secundaria a la cuenta principal del usuario 2")
user_1.transferir_dinero(user_2, "principal", "secundaria", 300)
print("cuenta principal - usuario 2:")
user_2.mostrar_balance_usuario("principal")