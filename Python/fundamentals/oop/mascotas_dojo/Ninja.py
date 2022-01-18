from Mascota import Mascota

class Ninja:
    def __init__(self, nombre, apellido, premios, comida_mascota, mascota):
        self.nombre = nombre
        self.apellido = apellido
        self.premios = premios
        self.comida_mascota = comida_mascota
        self.mascota = mascota

    def caminar(self):
        print(f"{self.nombre} sale a caminar y lleva a su mascota con él")
        self.mascota.jugar()
        return self

    def alimentar(self):
        print(f"{self.nombre} come y también alimenta a su mascota")
        self.mascota.comer()
        return self

    def bañar(self):
        print(f"{self.nombre} se baña y baña a su mascota")
        self.mascota.ruido()
        return self

# Crea una instancia de un Ninja y asígnale una instancia de mascota al atributo de mascota.
Abel = Ninja("Abel", "Quezada", "black belt", "croquetas", Mascota("Kanon", "perro", "croquetas especiales"))

# Haz que el ninja alimente, pasee y bañe a su mascota.
Abel.mascota.estado()
Abel.alimentar().caminar().bañar()
Abel.mascota.estado()