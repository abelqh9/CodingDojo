console.log("1 - Imprimir impares 1-20");
for (let  i=1; i<=20; i++) {
    if (i%2!==0) console.log(i);
}

console.log(" ");
console.log("2 - Disminuir múltiplos de 3");
for (let  i=100; i>0; i--) {
    if (i%3===0) console.log(i);
}

console.log(" ");
console.log("3 - Imprime la secuencia");
for (let i = 4; i >= -3.5; i -= 1.5) {
    console.log(i);
}

console.log(" ");
console.log("4 - Sigma");
let cadena = "", sum = 0
for (let i = 1; i <= 100; i++) {
    cadena += i===100 ? i :`${i} + `
    sum+=i
}
console.log(cadena);
console.log(sum);

console.log(" ");
console.log("5 - Factorial");
let cadena2 = "", sum2 = 1;
for (let i = 1; i <= 12; i++) {
    cadena2 += (i === 12 ? i :`${i} * `)
    sum2 *= i
}
console.log(cadena2);
console.log(sum2);