import { useState, useEffect } from 'preact/hooks'

const ProductList = () => {

    const [products, setProducts] = useState([])
    const [errorInfo, setErrorInfo] = useState('')
    const [loadingComplete, setLoadingComplete] = useState(false)

    const getData = async () => {
        try {
            const resp = await fetch('http://localhost:3001/products')
            if (resp.ok) {
                const data = await resp.json()
                setProducts(data)
                setErrorInfo('')
                setLoadingComplete(true)
            } else {
                setProducts([])
                setErrorInfo(resp.statusText)
                setLoadingComplete(true)
            }
        } catch (error) {
            setProducts([])
            setErrorInfo(error.message)
            setLoadingComplete(true)
        }
    }

    useEffect(
        () => {
            getData()
        },
        []
    )

    let design;
    if (!loadingComplete) {
        design = <span>Loading...</span>
    } else if (errorInfo !== '') {
        design = <span>{errorInfo}</span>
    } else if (!products || products.length === 0) {
        design = <span>No records</span>
    } else {
        design = (
            <ul>
                {
                    products.map(
                        (p) => <li>{p.productName}</li>
                    )
                }
            </ul>
        )
    }

    return design
}

export default ProductList