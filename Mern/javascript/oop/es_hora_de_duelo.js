class Card{
    constructor(name, cost){
        this.name = name;
        this.cost = cost;
    }
}

class Unit extends Card{
    constructor(name, cost, power, res){
        super(name, cost);
        this.power = power;
        this.res = res;
    }

    attack( target ){
        if (target instanceof Unit) {
            target.res -= this.power;
        }else{
            throw new Error( "Target must be a unit!" );
        }
    }

    show(){
        console.log(this);
    }

}

class Effect extends Card{
    constructor(name, cost, text, stat, magnitude){
        super(name, cost);
        this.text = text;
        this.stat = stat;
        this.magnitude = magnitude;
    }

    play( target ){
        if (target instanceof Unit) {
            target[this.stat] = target[this.stat] + this.magnitude;
        }else{
            throw new Error( "Target must be a unit!" );
        }
    }
}

// UNITS


// Effects
let algoritmo_dificil = new Effect("Algoritmo Difícil", 2, "aumentar la resistencia del objetivo en 3", "res", 3),
rechazo_de_promesa_no_manejado = new Effect("Rechazo de promesa no manejado", 2, "reducir la resistencia del objetivo en 2", "res", -2),
programación_en_pareja = new Effect("Programación en pareja", 3, "aumentar el poder del objetivo en 2", "power", 2)

// TURNO 1
let ninja_cinturon_rojo = new Unit("Ninja Cinturón Rojo", 3, 3, 4);
algoritmo_dificil.play(ninja_cinturon_rojo);

// TURNO 2
let ninja_cinturon_negro = new Unit("Ninja Cinturón Negro", 4, 5, 4);
rechazo_de_promesa_no_manejado.play(ninja_cinturon_negro);

// TURNO 3
programación_en_pareja.play(ninja_cinturon_rojo);
ninja_cinturon_rojo.attack(ninja_cinturon_negro);

ninja_cinturon_rojo.show();
ninja_cinturon_negro.show();