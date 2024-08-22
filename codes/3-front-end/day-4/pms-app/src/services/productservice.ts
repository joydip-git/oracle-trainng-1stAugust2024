//import axios from "axios"
import axiosInstance from "../config/axiosconfig"
import { Product } from "../models/product"
//import { products } from "../repository/products"

//const url = 'http://localhost:3001/products'

export const getProducts = () => {
    //return [...products]
    //return axios.get<Product[]>(url,{headers:{Authorization:'token'}})
    return axiosInstance.get<Product[]>('')
}
export const getProduct = (id: number) => {
}
export const addProduct = (product: Product) => {

}
export const updateProduct = (id: number, product: Product) => {

}
export const deleteProduct = (id: number) => {

}