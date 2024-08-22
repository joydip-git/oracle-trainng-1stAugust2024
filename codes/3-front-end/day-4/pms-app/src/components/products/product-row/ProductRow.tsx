import { Product } from '../../../models/product'
import "./ProductRow.css";

type ProductRowProps = {
    productInfo: Product
}
const ProductRow = ({ productInfo }: Readonly<ProductRowProps>) => {
    return (
        <tr>
            <td>
                <img src={productInfo.imageUrl} alt="NA" title={productInfo.productName} className='img-style' />
            </td>
            <td>
                {productInfo.productName}
            </td>
            <td>
                {productInfo.price}
            </td>
            <td>
                {productInfo.starRating}
            </td>
            <td>
                <button type="button" className='btn btn-danger btn-border-style'>Delete</button>
            </td>
        </tr>
    )
}

export default ProductRow