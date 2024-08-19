//const numbers = new Array(1, 2, 3, 4, 5)
const numbers = [1, 2, 3, 4, 5]
numbers.push(10, 20, 30)
//numbers.splice(2, 2)
//numbers.splice(2, 2, 100, 200)
/*
function filterValues(arr, fnRef) {
    const result = []
    for (const element of arr) {
        if (fnRef(element))
            result.push(element)
    }
    return result
}
const isEven = function (element) {
    return element % 2 == 0
}
filterValues(numbers, isEven)

const names = ['anil', 'sunil', 'joydip']
const fileterByNameIncludingN = function (element) {
    return element.toLocaleLowerCase().includes('n')
}
console.log(filterValues(names, fileterByNameIncludingN))
*/
numbers
    .filter(
        function (element) {
            return element % 2 == 0
        }
    ).forEach(
        function (element) {
            console.log(element);
        }
    )
const names = ['anil', 'sunil', 'joydip']
names.filter(
    (name) => name.toLocaleLowerCase().includes('n')
).forEach(
    (name) => console.log(name)
)

numbers.sort(
    (a, b) => b - a
).forEach(n => console.log(n))

numbers.map(
    (n) => "value: " + (n * 2)
).forEach(n => console.log(n))


numbers.findIndex(n => n === 4)