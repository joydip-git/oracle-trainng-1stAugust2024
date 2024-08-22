import { useState } from "react"
import { Product } from "../../../models/product"
import { getProducts } from "../../../services/productservice"
import ProductRow from "../product-row/ProductRow"
import './ProductList.css'

const ProductList = () => {
    const [productRecords, setProductRecords] = useState<Product[]>(getProducts())
    return (
        <>
            <h2 className="header-style">
                LIST OF PRODUCTS
            </h2>
            <br />
            <table className="table table-hover table-font-style">
                <thead>
                    <tr>
                        <th>Image</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Rating</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody className="table-dark">
                    {
                        productRecords.map(
                            (p) => {
                                return <ProductRow productInfo={p} key={p.id} />
                            }
                        )
                    }
                </tbody>
            </table>
        </>
    )
}

export default ProductList