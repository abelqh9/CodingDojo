class Ninja{
    constructor(name){
        this.name = name;
        this.health = 100;
        this.velocity = 3;
        this.strength = 3;

    }

    sayName() {
        return console.log(this.name);
    }

    showStats() {
        return console.log(`health: ${this.health}/ velocity: ${this.velocity}/ strength: ${this.strength}`);
    }

    drinkShake() {
        return this.health += 10;
    }
}


const ninja1 = new Ninja("Hyabusa");
ninja1.sayName();
ninja1.showStats();