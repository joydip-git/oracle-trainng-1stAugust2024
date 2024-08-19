var strValue = 'oracle'
var numValue = 12
var fractionalValue = 12.34
var boolValue = true

function add(a, b) {
    return a + b
}
console.log(add(12, 3))

var objRef = {
    //value properties
    id: 1,
    name: 'anil',
    isManager: true,
    salary: 1000,
    //functional property
    print: function () {
        return this.id + " " + this.name + " " + this.salary + " " + (this.isManager ? " manager" : " not a manager");
    }
}
//using dot (.) operator
console.log(objRef.name)
//using inexer ([])
console.log(objRef['salary']);

//invoke method
console.log(objRef.print());
//console.log(objRef['print']());

console.log(typeof strValue);
console.log(typeof numValue);
console.log(typeof fractionalValue);
console.log(typeof boolValue);
console.log(typeof add);
console.log(typeof objRef);

if (numValue > 0) {
    console.log(numValue);
} else
    console.log('negative');