class Usuario:
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.balance_cuenta = 0
    
    def hacer_deposito(self, amount):
        self.balance_cuenta += amount
        return self

    # Agrega un método hacer_retiro a la clase Usuario
    def hacer_retiro(self, amount):
        self.balance_cuenta -= amount
        return self

    # Agrega un método mostrar_balance_usuario a la clase Usuario
    def mostrar_balance_usuario(self):
        print(f"usuario: {self.name} - balance: ${self.balance_cuenta}")
        return self
    
    # BONUS
    def transferir_dinero(self, other_user, amount):
        self.balance_cuenta -= amount
        other_user.balance_cuenta += amount
        return self

# Crea 3 instancias de la clase Usuario
usuario_1 = Usuario("Bryan", "BryanCorreo@gmail.com")
usuario_2 = Usuario("Leo", "LeoCorreo@gmail.com")
usuario_3 = Usuario("Abel", "AbelCorreo@gmail.com")

# Haz que el primer usuario haga 3 depósitos y 1 giro, y luego muestra sus balances
usuario_1.hacer_deposito(200).hacer_deposito(400).hacer_deposito(600).hacer_retiro(500).mostrar_balance_usuario()

# Haz que el segundo usuario haga 2 depósitos y 2 giros, y luego muestra sus balances
usuario_2.hacer_deposito(500).hacer_deposito(500).hacer_retiro(250).hacer_retiro(250).mostrar_balance_usuario()

# Haz que el tercer usuario haga 1 depósito y 3 giros, y luego muestra sus balances
usuario_3.hacer_deposito(1000).hacer_retiro(300).hacer_retiro(300).hacer_retiro(300).mostrar_balance_usuario()

# BONUS: Agrega un método transferir_dinero; haz que el primer usuario transfiera dinero al tercer usuario y luego imprime los balances de ambos usuarios
usuario_1.transferir_dinero(usuario_3, 200).mostrar_balance_usuario()
usuario_3.mostrar_balance_usuario()