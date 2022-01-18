class Pirate:

    def __init__( self , name ):
        self.name = name
        self.strength = 15
        self.speed = 3
        self.health = 100

    def show_stats( self ):
        print(f"\nName: {self.name}\nStrength: {self.strength}\nSpeed: {self.speed}\nHealth: {self.health}\n")

    def attack ( self , ninja ):
        ninja.health -= self.strength
        print(f"Pirate {self.name} attacks ninja {ninja.name}")
        if (ninja.health <= 0):
            print("--- The ninja have been defeated ---")
            print("\n--- GAME OVER ---\n")
            ninja.defeat_words()
        else:
            ninja.show_stats()
            ninja.angry_words()
        return self

    def angry_words(self):
        print("dammed ninja!! ⋋_⋌\n")

    def defeat_words(self):
        print("- Pirate: I have been defeated this time but i will train very hard to defeat you in the next fight (πーπ)\n")