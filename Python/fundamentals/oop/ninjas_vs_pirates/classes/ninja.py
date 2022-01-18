class Ninja:

    def __init__( self , name ):
        self.name = name
        self.strength = 10
        self.speed = 5
        self.health = 100
    
    def show_stats( self ):
        print(f"\nName: {self.name}\nStrength: {self.strength}\nSpeed: {self.speed}\nHealth: {self.health}\n")

    def attack( self , pirate ):
        pirate.health -= self.strength
        print(f"Ninja {self.name} attacks pirate {pirate.name}")
        if (pirate.health <= 0):
            print("--- The pirate have been defeated ---")
            print("\n--- GAME OVER ---\n")
            pirate.defeat_words()
        else:
            pirate.show_stats()
            pirate.angry_words()
        return self

    def angry_words(self):
        print("Dammed pirate!! ⋋_⋌\n")

    def defeat_words(self):
        print("- Ninja: I have been defeated this time but i will train very hard to defeat you in the next fight (πーπ)\n")
