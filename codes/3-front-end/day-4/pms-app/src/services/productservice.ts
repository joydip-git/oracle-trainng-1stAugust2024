import { Product } from "../models/product"
import { products } from "../repository/products"

export const getProducts = () => {
    return [...products]
}
export const getProduct = (id: number) => {

}
export const addProduct = (product: Product) => {

}
export const updateProduct = (id: number, product: Product) => {

}
export const deleteProduct = (id: number) => {

}