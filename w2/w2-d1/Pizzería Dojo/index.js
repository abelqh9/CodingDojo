function pizzaOven(tipoCorteza, tipoSalsa, quesos, salsas) {
    let pizza = {tipoCorteza, tipoSalsa, quesos, salsas}
    return pizza
}

console.log(pizzaOven("estilo Chicago", "tradicional", ["mozzarella"], ["pepperoni", "salchicha"]));
console.log(pizzaOven("lanzada a mano", "marinara", ["mozzarella", "feta"], ["champiñones", "aceitunas", "cebollas"]));
console.log(pizzaOven("pizza hawaiana", "tradicional", ["mozzarella"], ["piña", "jamon"]));
console.log(pizzaOven("pizza pepperoni", "tradicional", ["mozzarella"], ["pepperoni"]));