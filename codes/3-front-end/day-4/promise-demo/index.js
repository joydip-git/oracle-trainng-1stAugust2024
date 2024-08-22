const divide = (a, b) => {
    const p = new Promise(
        //executor function
        (resolveFn, rejectFn) => {
            const res = a / b

            if (res === Infinity) {
                //throw new Error('can not divide by zero')
                const e = new Error('can not divide by zero')
                rejectFn(e)
            }

            //return res
            // setTimeout(
            //     () => {
            //         console.log(res);
            //     },
            //     3000
            // )
            resolveFn(res)
        }
    )
    return p
}

const add = (a, b) => a + b

const divPromise = divide(12, 3)
divPromise
    .then(
        (data) => {
            console.log(data);
        },
        (e) => { console.log(e); }
    )
// .catch(
//     (e) => { console.log(e); }
// )
// divPromise
//     .catch(       
//         (e) => { console.log(e); }
//     )

const addRes = add(12, 3)
console.log(addRes);