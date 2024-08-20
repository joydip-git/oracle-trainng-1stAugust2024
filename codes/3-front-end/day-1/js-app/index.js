//console object is NOT a JS API, it is a browser API
console.log('hello...');

window.addEventListener(
    'DOMContentLoaded',
    function () {
        const headerElement = document.getElementById('mainHeader');
        headerElement.addEventListener(
            'mouseover',
            function () {
                window.alert('mouse over')
            }
        )
    }
)

