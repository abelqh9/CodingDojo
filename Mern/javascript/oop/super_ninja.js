class Ninja{
    constructor(name, health = 100, velocity = 3, strength = 3){
        this.name = name;
        this.health = health;
        this.velocity = velocity;
        this.strength = strength;

    }

    sayName() {
        return console.log(this.name);
    }

    showStats() {
        return console.log(`Name: ${this.name}, Health: ${this.health}, Velocity: ${this.velocity}, Strength: ${this.strength}`);
    }

    drinkSake() {
        return this.health += 10;
    }
}

class Sensei extends Ninja{
    constructor(name){
        super(name, 200, 10, 10);
        this.wisdom = 10;
    }

    speakWisdom(){
        super.drinkSake();
        console.log("Lo que un programador puede hacer en un mes, dos programadores pueden hacerlo en dos meses.");
    }
}

// ejemplo de salida
const superSensei = new Sensei("Master Splinter");
superSensei.speakWisdom();
// -> "Lo que un programador puede hacer en un mes, dos programadores pueden hacerlo en dos meses."
superSensei.showStats();
// -> "Nombre: Master Splinter, Salud: 210, Velocidad: 10, Fuerza: 10"