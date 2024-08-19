// function sample() {
//     console.log(this.x);
//     this.x = 100
//     console.log(this.x);
//     console.log(x);//undefined
//     var x
//     x = 10;
//     console.log(x);//10
//     for (var i = 0; i < 1; i++) {
//         var _x
//         _x = 20
//         console.log(_x);//20
//     }
//     console.log(x);//10
// }
// new sample()


function sample() {
    console.log(this.x);
    this.x = 100
    console.log(this.x);
    //console.log(x);//undefined
    let x
    x = 10;
    console.log(x);//10
    for (var i = 0; i < 1; i++) {
        let x
        x = 20
        console.log(x);//20
    }
    console.log(x);//10

    declared()
    //declaration syntax
    function declared() {
        console.log('declared');
    }
    declared()

    //expressed()
    //expression syntax
    var expressed = function () {
        console.log('expressed');
    }
    expressed()
}
new sample()

const x = 100
//x = 200
const ref = { id: 1 }
//ref = {}
ref.location = 'bangalore'
console.log(ref);
//ref.name=