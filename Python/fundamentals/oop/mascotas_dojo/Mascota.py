class Mascota:
    def __init__(self, name ,tipo ,golosinas):
        self.name = name
        self.tipo = tipo
        self.golosinas = golosinas
        self.salud = 100
        self.energía = 100

    def dormir(self):
        self.energía += 25

    def comer(self):
        self.energía += 5
        self.salud += 10

    def jugar(self):
        self.salud += 5

    def ruido(self):
        print(f"{self.name} hizo ruido")

    def estado(self):
        print(f"Estado de {self.name} | salud: {self.salud} | energía: {self.energía}")