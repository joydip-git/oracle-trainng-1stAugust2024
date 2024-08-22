const subtract = async (a, b) => a - b
const divide = async function (a, b) {

    setTimeout(
        async () => {
            let subRes = 0;
            try {
                subRes = await subtract(a, b)
                console.log(subRes);
            } catch (error) {
                console.log(error);
            }
        },
        0
    )

    console.log('continuing with divide');

    const res = a / b
    if (res === Infinity)
        throw new Error('can not divide by zero')

    return res
}

const add = (a, b) => a + b

async function callDivide() {
    try {
        // const divPromise = divide(12, 3)
        // const data = await divPromise
        const data = await divide(12, 3)
        console.log(data);
    } catch (error) {
        console.log(error);
    }
}
callDivide()


const addRes = add(12, 3)
console.log(addRes);