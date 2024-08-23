import { useState, useEffect, useContext } from 'preact/hooks'
import ListItem from './ListItem'
import ColorContext, { ColorContextType } from './color-context'

const ProductList = () => {

    const [products, setProducts] = useState([])
    const [errorInfo, setErrorInfo] = useState('')
    const [loadingComplete, setLoadingComplete] = useState(false)

    const { colorName, changeColorHandler } = useContext(ColorContext)

    const [color, setColor] = useState('grey')
    const changeColor = (colorName: string) => {
        setColor(colorName)
    }

    const initialConextData: ColorContextType = {
        colorName: color,
        changeColorHandler: changeColor
    }

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
            <div style={{ backgroundColor: colorName }}>
                <h2>All Products</h2>
                <br />
                <ul>
                    {
                        products.map(
                            (p) => <ListItem product={p} key={p.id} />
                        )
                    }
                </ul>
            </div>
        )
    }

    return (
        <ColorContext.Provider value={initialConextData}>
            {
                design
            }
            <br />
            <button type='button' onClick={() => changeColorHandler('blue')}>Change PL color</button>
        </ColorContext.Provider>
    )
}

export default ProductList