function add(a: number, b: number): number {
    return a + b
}
function subtract(a: number, b: number): number {
    return a - b
}

console.log(add(12, 3))
console.log(subtract(12, 3));

class Person {
    constructor(public id: number, public name: string) {

    }
    print() {
        return this.id + " " + this.name
    }
}